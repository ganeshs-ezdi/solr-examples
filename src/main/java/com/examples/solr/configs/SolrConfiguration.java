package com.examples.solr.configs;

import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SolrConfiguration {
	@Value("${solr.zookeeper.zkHosts}")
	private String zkHosts;
	
	@Bean
	public CloudSolrClient cloudSolrClient() {
		return new CloudSolrClient(zkHosts);
	}
}
