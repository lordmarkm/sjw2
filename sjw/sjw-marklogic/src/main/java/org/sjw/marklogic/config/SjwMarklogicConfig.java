package org.sjw.marklogic.config;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.DatabaseClientFactory;
import com.marklogic.client.DatabaseClientFactory.Authentication;
import com.marklogic.client.document.JSONDocumentManager;
import com.marklogic.client.document.XMLDocumentManager;

@Configuration
@PropertySource("db.properties")
@ComponentScan("org.sjw.marklogic")
public class SjwMarklogicConfig {

    private static Logger LOG = LoggerFactory.getLogger(SjwMarklogicConfig.class);

    @Autowired
    private Environment env;

    @Bean
    public DatabaseClient databaseClient() {
        LOG.debug("Creating database client.");
        return DatabaseClientFactory.newClient(
                env.getProperty("db.host"),
                env.getProperty("db.port", Integer.class),
                env.getProperty("db.writer_user"),
                env.getProperty("db.writer_password"),
                Authentication.valueOf(env.getProperty("db.authentication_type").toUpperCase()));
    }

    @Bean
    public XMLDocumentManager docMgr() {
        //Create a manager for XML documents
        return databaseClient().newXMLDocumentManager();
    }
    @Bean
    public JSONDocumentManager jsonDocMgr() {
        return databaseClient().newJSONDocumentManager();
    }
    @Bean
    public ObjectMapper jsonMapper() {
        return new ObjectMapper();
    }
}
