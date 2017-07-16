package com.govansnv.fuel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * This is our model class and it corresponds to Driver table in database
 */
@Entity
@Table(name="ticket_container")
public class TicketContainer {
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="sequence")
	private long sequence;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getSequence() {
		return sequence;
	}

	public void setSequence(long sequence) {
		this.sequence = sequence;
	}	
}