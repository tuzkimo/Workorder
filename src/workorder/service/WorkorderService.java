package workorder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import workorder.dao.WorkorderDAO;
import workorder.entities.Workorder;

@Service
public class WorkorderService {

	@Autowired
	private WorkorderDAO workorderDAO;
	
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public List<Workorder> findAll() {
		return workorderDAO.findAll();
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void addOrder(Workorder workorder) {
		workorderDAO.addOrder(workorder);
	}
	
}
