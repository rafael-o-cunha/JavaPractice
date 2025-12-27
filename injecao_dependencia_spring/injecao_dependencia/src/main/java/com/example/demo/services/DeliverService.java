package com.example.demo.services;

import org.springframework.stereotype.Service;

@Service
public class DeliverService {
	
	public double fee(String state) {
		if("SP".equals(state)) {
			return 10.0;
		}
		return 20.0;
	}
}
