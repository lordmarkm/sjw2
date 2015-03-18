package org.sjw.app;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.sjw.data.config.SjwDataConfig;
import org.sjw.data.model.Taxi;
import org.sjw.marklogic.client.JSONWriter;
import org.sjw.marklogic.client.XMLWriter;
import org.sjw.marklogic.config.SjwMarklogicConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TaxiApp {

    public static void main(String[] args) throws IOException {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(
                SjwMarklogicConfig.class,
                SjwDataConfig.class);

        XMLWriter xmlWriter = ctx.getBean(XMLWriter.class);
        JSONWriter jsonWriter = ctx.getBean(JSONWriter.class);

        int count = 1;
        while (count++ < 100) {
            Taxi taxi = new Taxi();
            taxi.setOperator("Love Taxi");
            taxi.setPlateNo(RandomStringUtils.randomAlphabetic(3).toUpperCase() + RandomStringUtils.randomNumeric(3));

            //xmlWriter.writeObjectAsXml("employees/employee" + count, employee, "Employees");
            jsonWriter.writeObjectAsJson("taxis/taxi" + count, taxi);
        }
    }

}
