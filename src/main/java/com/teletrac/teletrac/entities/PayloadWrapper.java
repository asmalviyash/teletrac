package com.teletrac.teletrac.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


import lombok.Data;

@Data
public class PayloadWrapper {
	
	private String recordType;
	private String deviceId;
	//@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ssZ")
	@DateTimeFormat(pattern="yyyy-MM-ddTHH:mm:ss")
	private Date eventDateTime;
	private Integer fieldA;
	private String fieldB;
	private Double fieldC;
	
	
	public PayloadWrapper(Payload p) {
		super();
		recordType = p.getRecordType();
		deviceId = p.getDeviceId();
		eventDateTime = p.getEventDateTime();
		fieldA = p.getFieldA();
		fieldB = p.getFieldB();
		fieldC = p.getFieldC();
	}

	public PayloadWrapper() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
