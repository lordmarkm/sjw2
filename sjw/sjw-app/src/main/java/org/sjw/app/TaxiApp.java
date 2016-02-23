package org.sjw.app;

import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.apache.commons.lang3.RandomStringUtils;
import org.sjw.data.config.SjwDataConfig;
import org.sjw.marklogic.client.JSONWriter;
import org.sjw.marklogic.client.Taxi;
import org.sjw.marklogic.client.XMLWriter;
import org.sjw.marklogic.config.SjwMarklogicConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.google.common.collect.Lists;
import com.marklogic.client.document.XMLDocumentManager;

public class TaxiApp {

    public static void main(String[] args) throws IOException, JAXBException {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(
                SjwMarklogicConfig.class,
                SjwDataConfig.class);

        List<String> uris = Lists.newArrayList();
        XMLWriter xmlWriter = ctx.getBean(XMLWriter.class);
        JSONWriter jsonWriter = ctx.getBean(JSONWriter.class);

        int count = 105;
        while (count++ < 155) {
            Taxi taxi = new Taxi();
            taxi.setOperator("Jason Taxi");
            taxi.setPlateNo(RandomStringUtils.randomAlphabetic(3).toUpperCase() + RandomStringUtils.randomNumeric(3));

            String uri = "taxs/taxi" + count;
            xmlWriter.writeObjectAsXml(uri, taxi, "Taxis");
//            jsonWriter.writeObjectAsJson(uri, taxi);
            uris.add(uri);
        }

        XMLDocumentManager docMgr = ctx.getBean(XMLDocumentManager.class);
        for (String uri : uris) {
            System.out.println(docMgr.readAs(uri, Taxi.class));
        }
    }

}
