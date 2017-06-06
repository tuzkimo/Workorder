package workorder.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import workorder.entities.Project;

@Service
public class ProjectDAO {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public List<Project> findAll() {
		return (List<Project>) hibernateTemplate.find("FROM Project");
	}
	
	public Project getProjectById(Long id) {
		return hibernateTemplate.get(Project.class, id);
	}
	
}
