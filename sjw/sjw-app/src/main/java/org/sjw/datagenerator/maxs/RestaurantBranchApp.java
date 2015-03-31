package org.sjw.datagenerator.maxs;

import java.io.IOException;
import java.util.List;

import org.sjw.data.config.SjwDataConfig;
import org.sjw.data.model.Address;
import org.sjw.data.model.maxs.RestaurantBranch;
import org.sjw.marklogic.client.XMLWriter;
import org.sjw.marklogic.config.SjwMarklogicConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.google.common.collect.Lists;

public class RestaurantBranchApp {

    public static void main(String[] args) throws IOException {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(
                SjwMarklogicConfig.class,
                SjwDataConfig.class);

        XMLWriter xmlWriter = ctx.getBean(XMLWriter.class);

        List<RestaurantBranch> branches = getBranches();
        for (RestaurantBranch branch : branches) {
            xmlWriter.writeObjectAsXml("restaurants/restaurant" + branch.getCode(), branch, "Restaurants");
        }
    }

    public static List<RestaurantBranch> getBranches() {
        RestaurantBranch branch1 = new RestaurantBranch("BR1", "Emerald Ave. Branch", new Address("Pasig City", 1605, "#13 Emerald Bldg.", "Emerald Ave"));
        RestaurantBranch branch2 = new RestaurantBranch("BR2", "White Plains Branch", new Address("Quezon City", 1615, "#65 Camp Aguinaldo.", "White Plains Ave"));
        RestaurantBranch branch3 = new RestaurantBranch("BR3", "Ermita Branch", new Address("Manila", 10024, "199 Santa Cruz", "Ermita"));
        RestaurantBranch branch4 = new RestaurantBranch("BR4", "SM Fairview Branch", new Address("Quezon City", 6200, "SM Fairview", "Quirino Highway"));
        RestaurantBranch branch5 = new RestaurantBranch("BR5", "SM Aura Branch", new Address("Taguig", 1234, "5th Floor, SM Aura", "McKinley Parkway"));

        branch1.getAddress().setLatitude("14.585234").setLongitude("121.061526"); //Emerald Ave
        branch2.getAddress().setLatitude("14.600563").setLongitude("121.063533"); //Camp Aguinaldo?
        branch3.getAddress().setLatitude("14.590011").setLongitude("120.982884"); //SM City Manila
        branch4.getAddress().setLatitude("14.733937").setLongitude("121.058462"); //SM fairview
        branch5.getAddress().setLatitude("14.545922").setLongitude("121.053786"); //SM Aura

        //Weight here
        return Lists.newArrayList(branch1, branch1, branch2, branch2, branch2, branch3, branch3, branch3, branch3, branch4, branch4, branch5);
    }
}
