package com.govansnv.fuel.util;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.govansnv.fuel.model.TicketContainer;
import com.govansnv.fuel.service.TicketContainerService;

@Component
public class TicketGeneratorUtil {
	static Log log = LogFactory.getLog(TicketGeneratorUtil.class.getName());

	public synchronized long generateTicketNumber(TicketContainerService ticketContainerService) {
		long seq = 0;
		List<TicketContainer> list = ticketContainerService.getAllTicketContainers();
		for (TicketContainer ticketContainer : list) {
			seq = ticketContainer.getSequence();
		}		
		TicketContainer con=   ticketContainerService.updateTicketConatiner(list.get(0));
		seq= con.getSequence();
		return seq;
	}

}
