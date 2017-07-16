package com.govansnv.fuel.test;

import static org.junit.Assert.assertNotNull;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.govansnv.fuel.config.AppConfig;
import com.govansnv.fuel.service.PurchaseOrderService;
import com.govansnv.fuel.service.TicketContainerService;
import com.govansnv.fuel.util.TicketGeneratorUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
@WebAppConfiguration
public class TicketContainerTest {
	static Log log = LogFactory.getLog(TicketContainerTest.class.getName());
	
	@Autowired
	TicketContainerService service;
	
	@Autowired
	PurchaseOrderService purchaseOrderService;
	
	@Test
	public void testGenerateTicket() {
		TicketGeneratorUtil generator = new TicketGeneratorUtil();
		long result = generator.generateTicketNumber(service);
		System.out.println("result ::"+ result);
		assertNotNull(result);
	}
}
