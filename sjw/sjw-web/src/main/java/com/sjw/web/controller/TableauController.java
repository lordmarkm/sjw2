package com.sjw.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.sjw.tableau.model.View;
import com.sjw.tableau.model.Workbook;
import com.sjw.tableau.service.ViewService;
import com.sjw.tableau.service.WorkbookService;

@Controller
@RequestMapping("/tableau")
public class TableauController {

    @Autowired
    private WorkbookService workbookservice;
    @Autowired
    private ViewService viewservice;

    private static Logger LOG = LoggerFactory.getLogger(TableauController.class);
    private RestTemplate template = new RestTemplate();
    private final String tabUrl = "http://192.168.242.49/trusted?username=reader";
//    private final String tabUrl = "http://localhost:8080/tableau";

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<GenericHttpResponse> get() {
        TabTrustedServerRequest request = new TabTrustedServerRequest("reader");
        LOG.debug("Doing post");
        String response = template.postForObject(tabUrl, null, String.class);
        LOG.debug("Got response. resp={}", response);
        return new ResponseEntity<>(new GenericHttpResponse(null, response), HttpStatus.OK);
    }

    @RequestMapping(value = "/workbooks", method = RequestMethod.GET)
    public ResponseEntity<List<Workbook>> workbooks() {
        return new ResponseEntity<>(workbookservice.findAll(), HttpStatus.OK);
    }
    @RequestMapping(value = "/views", method = RequestMethod.GET)
    public ResponseEntity<List<View>> views() {
        return new ResponseEntity<>(viewservice.findAll(), HttpStatus.OK);
    }
}
