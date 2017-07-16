package com.govansnv.fuel.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.govansnv.fuel.dao.AbstractDao;
import com.govansnv.fuel.dao.TicketContainerDao;
import com.govansnv.fuel.model.TicketContainer;

@Repository
public class TicketContainerDaoImpl  extends AbstractDao<Integer, TicketContainer> implements TicketContainerDao{

	private static Log log = LogFactory.getLog(TicketContainerDaoImpl.class.getName());
	
	public List<TicketContainer> getAll() {
		List<TicketContainer> list = getEntityManager().createQuery("SELECT d FROM TicketContainer d  ORDER BY 1 ASC")
				.getResultList();
		return list;
	}

	@Transactional
	public void updateTicketContainer(TicketContainer ticketContainer) {
		TicketContainer tr = (TicketContainer) getEntityManager().createQuery("SELECT d FROM TicketContainer d WHERE d.id = :Id")
				.setParameter("Id", ticketContainer.getId()).getSingleResult();
		if(tr!=null){
			long seq= tr.getSequence();
			tr.setSequence(seq + 1);
			ticketContainer.setSequence(tr.getSequence());
		}
		update(tr);
		log.info("ticketContainer sequence updated to "+ ticketContainer.getSequence());
	}

}

