package com.teletrac.teletrac.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Payload")
public class Payload {

	private String recordType;
	@Id
	@GeneratedValue
	private Long id;
	private String deviceId;
	//@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern="yyyy-MM-ddTHH:mm:ss")
	private Date eventDateTime;
	private Integer fieldA;
	private String fieldB;
	private Double fieldC;
	
	@CreatedDate
	private Date createDate;
	@LastModifiedDate
	private Date lastModifiedDate;

	public Payload(PayloadWrapper pr) {
		super();
		recordType = pr.getRecordType();
		deviceId = pr.getDeviceId();
		eventDateTime = pr.getEventDateTime();
		fieldA = pr.getFieldA();
		fieldB = pr.getFieldB();
		fieldC = pr.getFieldC();
		this.createDate = new Date();
		this.lastModifiedDate =  new Date();
	}

	public Payload() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
