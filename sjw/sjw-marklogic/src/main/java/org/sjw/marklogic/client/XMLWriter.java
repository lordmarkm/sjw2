package org.sjw.marklogic.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.bind.JAXB;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.marklogic.client.document.XMLDocumentManager;
import com.marklogic.client.io.DocumentMetadataHandle;
import com.marklogic.client.io.InputStreamHandle;

@Component
public class XMLWriter {

    private static Logger LOG = LoggerFactory.getLogger(XMLWriter.class);

    @Autowired
    private XMLDocumentManager docMgr;

    public void writeObjectAsXml(String docId, Object data) throws IOException {
        writeObjectAsXml(docId, data, (String[]) null);
    }

    public void writeObjectAsXml(String docId, Object data, String... collections) throws IOException {
        StringWriter stringWriter = new StringWriter();
        JAXB.marshal(data, stringWriter);
        writeXml(docId, stringWriter.toString(), collections);
    }

    public void writeXml(String docId, String data) throws IOException {
        writeXml(docId, data, (String[]) null);
    }

    public void writeXml(String docId, String data, String... collections) throws IOException {
        LOG.debug("Writing data to db. docId={}, data={}, collections={}", docId, data, collections);

        //Acquire the content
        InputStream docStream = IOUtils.toInputStream(data, "UTF-8");

        //Create a handle on the content
        InputStreamHandle handle = new InputStreamHandle(docStream);

        DocumentMetadataHandle metadata = null;
        if (null != collections) {
            metadata = new DocumentMetadataHandle();
            metadata.getCollections().addAll(collections);
        }

        //Write the document content
        docMgr.write(docId, metadata, handle);
    }
}
