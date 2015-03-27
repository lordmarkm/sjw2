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
        RestaurantBranch branch1 = new RestaurantBranch("BR1", new Address("Pasig City", 1605, "#13 Emerald Bldg.", "Emerald Ave"));
        RestaurantBranch branch2 = new RestaurantBranch("BR2", new Address("Mandaluyong City", 1615, "#65 Manda Bldg.", "Rizal Street"));
        RestaurantBranch branch3 = new RestaurantBranch("BR3", new Address("New York City", 10024, "199 Lafayette St.", "1st Street"));
        RestaurantBranch branch4 = new RestaurantBranch("BR4", new Address("Dumaguete City", 6200, "Grnd. Floor Red Bldg.", "San Juan St"));
        RestaurantBranch branch5 = new RestaurantBranch("BR5", new Address("Beijing", 1234, "#5 Chuenjude Bldg.", "Wangfujing Ave."));

        return Lists.newArrayList(branch1, branch2, branch3, branch4, branch5);
    }
}
