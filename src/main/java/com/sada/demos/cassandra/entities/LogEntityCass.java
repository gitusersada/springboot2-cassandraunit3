package com.sada.demos.cassandra.entities;

import java.util.Date;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table(value = "logs")
public class LogEntityCass {

	@PrimaryKeyColumn(name = "id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	private String id;

	@Column(value = "query")
	private String query;

	@Column(value = "date")
	private Date date;

	public LogEntityCass() {
		super();
	}

	public LogEntityCass(String query, Date date) {
		super();
		this.query = query;
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "LogEntityCass [id=" + id + ", query=" + query + ", date=" + date + "]";
	}
}
