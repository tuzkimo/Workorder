package workorder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import workorder.dao.ProjectDAO;
import workorder.entities.Project;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectDAO projectDAO;
	
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public List<Project> findAll() {
		return projectDAO.findAll();
	}

	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public Project getProjectById(Long id) {
		return projectDAO.getProjectById(id);
	}
	
}
