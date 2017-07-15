package com.examples.solr.controllers;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrResponse;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class HomeController {
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@Value("${solr.core}")
	private String core;
	
	@Autowired
	private CloudSolrClient cloudSolrClient;
	
	@RequestMapping("/hit")
	public boolean hit() throws Exception {
		log.info("Getting Docs");
		cloudSolrClient.setDefaultCollection(core);
		SolrResponse response = cloudSolrClient.query(createSolrQuery());
		log.info("{}", response);
		return true;
	}
	
	private SolrQuery createSolrQuery() {
		SolrQuery query = new SolrQuery();
		query.setQuery("*:*");
		query.setRows(0);
		return query;
	}
}
