package com.swj.spring.cloud.gateway.log.mongo;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClient;

import ch.qos.logback.core.UnsynchronizedAppenderBase;

public class MongoDBAppender<ILoggingEvent> extends UnsynchronizedAppenderBase<ILoggingEvent> {

	String host;

	@Override
	protected void append(ILoggingEvent eventObject) {
		// TODO Auto-generated method stub
		MongoClient client = new MongoClient("localhost", 27017);
		MongoTemplate mongoTemplate = new MongoTemplate(client, "logDB");
		// mongoTemplate.inse
		System.out.println(host + "||||" + eventObject.toString());
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

}
