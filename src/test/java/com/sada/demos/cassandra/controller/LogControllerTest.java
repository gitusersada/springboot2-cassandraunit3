package com.sada.demos.cassandra.controller;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import com.sada.demos.cassandra.DemoApplication;
import com.sada.demos.cassandra.controller.Log;
import com.sada.demos.cassandra.test.AbstractEmbeddedCassandraTest;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.cassandraunit.spring.CassandraDataSet;

@ContextConfiguration(classes=DemoApplication.class)
@CassandraDataSet(keyspace = "mykeyspace", value = {"dataset.cql"})
public class LogControllerTest extends AbstractEmbeddedCassandraTest {

    @Test
    public void testFindOne() throws Exception {
    	System.out.println("Welcome to "+getWelcomeMsg());
        ResponseEntity<Log> response = getRestTemplate().getForEntity("/logs/{id}", Log.class, 1);

        assertThat(response.getStatusCode()     , is(HttpStatus.OK));
        assertThat(response.getBody().getQuery(), is("cinema"));
    }
}