package com.govansnv.fuel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.govansnv.fuel.dao.TicketContainerDao;
import com.govansnv.fuel.model.TicketContainer;
import com.govansnv.fuel.service.TicketContainerService;

@Service("ticketContainerService")
public class TicketContainerServiceImpl implements TicketContainerService {

	@Autowired
	TicketContainerDao ticketContainerDao;

	public List getAllTicketContainers() {
		return ticketContainerDao.getAll();
	}

	public synchronized TicketContainer updateTicketConatiner(TicketContainer ticketContainer) {
		ticketContainerDao.updateTicketContainer(ticketContainer);
		return ticketContainer;
	}
}
