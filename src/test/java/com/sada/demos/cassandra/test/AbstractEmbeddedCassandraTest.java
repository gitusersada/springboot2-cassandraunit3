package com.sada.demos.cassandra.test;

import org.cassandraunit.spring.CassandraUnitDependencyInjectionTestExecutionListener;
import org.cassandraunit.spring.EmbeddedCassandra;
//import org.cassandraunit.spring.CassandraUnitDependencyInjectionTestExecutionListener;
//import org.cassandraunit.spring.EmbeddedCassandra;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.util.UriTemplateHandler;

import javax.annotation.PostConstruct;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@TestExecutionListeners(listeners = { CassandraUnitDependencyInjectionTestExecutionListener.class,
		DependencyInjectionTestExecutionListener.class })
@EmbeddedCassandra(timeout = 60000)
public class AbstractEmbeddedCassandraTest {

	@Value("${local.server.port}")
	protected int port;

	@Value("${test.url}")
	protected String url;

	@Value("${app.test.welcome}")
	public String welcomeMsg; 
	
	@Autowired
	protected TestRestTemplate restTemplate;

	@PostConstruct
	public void init() {

		UriTemplateHandler handler = new DefaultUriBuilderFactory(UriComponentsBuilder.fromUriString(getUrl() + ":" + getPort()));
		getRestTemplate().setUriTemplateHandler(handler);
	}

	public int getPort() {
		return port;
	}

	public String getUrl() {
		return url;
	}

	public String getWelcomeMsg() {
		return welcomeMsg;
	}

	public TestRestTemplate getRestTemplate() {
		return restTemplate;
	}
	
	
}
