package workorder.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import workorder.entities.Workorder;

@Service
public class WorkorderDAO {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public List<Workorder> findAll() {
		return (List<Workorder>) hibernateTemplate.find("FROM Workorder");
	}
	
	public void addOrder(Workorder workorder) {
		hibernateTemplate.save(workorder);
	}

}
