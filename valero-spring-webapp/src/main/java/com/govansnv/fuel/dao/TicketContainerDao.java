package com.govansnv.fuel.dao;

import java.util.List;

import com.govansnv.fuel.model.TicketContainer;

public interface TicketContainerDao {
	
	// Retrieve all TicketContainer objects from the table
	public List<TicketContainer> getAll();

	// Update TicketContainer object in TicketContainer table
	public void updateTicketContainer(TicketContainer ticketContainer);
}
