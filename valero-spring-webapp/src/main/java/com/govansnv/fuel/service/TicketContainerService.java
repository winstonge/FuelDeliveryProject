package com.govansnv.fuel.service;

import java.util.List;

import com.govansnv.fuel.model.TicketContainer;
import com.govansnv.fuel.model.Truck;

public interface TicketContainerService {
	
	public List getAllTicketContainers();
		
	public TicketContainer updateTicketConatiner(TicketContainer ticketConatiner);

}
