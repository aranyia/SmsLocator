package com.aa.smslocator.backend;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.aa.smslocator.backend.persistence.entity.SmsEntity;
import com.googlecode.objectify.ObjectifyService;

public class ContextInitializer implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg) {
	}

	@Override
	public void contextInitialized(ServletContextEvent arg) {
		ObjectifyService.register(SmsEntity.class);
	}
}
