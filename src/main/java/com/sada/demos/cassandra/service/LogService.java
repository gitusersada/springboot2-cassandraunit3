package com.sada.demos.cassandra.service;

import java.util.List;

import com.sada.demos.cassandra.controller.Log;

public interface LogService {

	/**
	 * Get the log list from DB cassandra
	 * <p>
	 * 
	 * @return The log list
	 */
	List<Log> findAll();

	/**
	 * Get the log with the given id from DB cassandra
	 * <p>
	 *
	 * @return The log
	 *
	 * */
	Log findOne(String id);

}