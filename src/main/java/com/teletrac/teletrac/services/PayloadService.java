package com.teletrac.teletrac.services;

import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.teletrac.teletrac.dao.PayloadDao;
import com.teletrac.teletrac.entities.Payload;
import com.teletrac.teletrac.entities.PayloadWrapper;

@Service
public class PayloadService {

	@Autowired
	private PayloadDao payloadDao;

	public PayloadService() {

	}

	public String getDeviceId() {
		return payloadDao.findAll().stream().max(Comparator.comparing(Payload::getId)).get().getDeviceId();
	}

	public PayloadWrapper addPayload(PayloadWrapper payloadWrapper) {
		Payload payload = new Payload(payloadWrapper);
		payloadDao.save(payload);
		return payloadWrapper;
	}

	public PayloadWrapper getPayload() {
		Payload latestPayload = payloadDao.findAll().stream().max(Comparator.comparing(Payload::getId)).get();
		return new PayloadWrapper(latestPayload);
	}

}
