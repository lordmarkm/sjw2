package org.sjw.marklogic.test;

import java.io.IOException;

import org.sjw.marklogic.client.XMLWriter;
import org.sjw.marklogic.config.SjwMarklogicConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) throws IOException {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SjwMarklogicConfig.class);
        XMLWriter xmlWriter = ctx.getBean(XMLWriter.class);
        xmlWriter.writeXml("hello/world", "<hello><world></world></hello>");
    }

}
