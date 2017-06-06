package workorder.action;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import workorder.entities.Project;
import workorder.entities.Workorder;
import workorder.service.ProjectService;
import workorder.service.WorkorderService;

import com.opensymphony.xwork2.ActionSupport;

@Service
public class WorkorderAction extends ActionSupport {
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private WorkorderService workorderService;
	
	private Long projectId;
	
	private List<Project> projects;
	
	private Workorder workorder;
	private List<Workorder> workorders;
	
	private String msg;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		projects = projectService.findAll();
		return SUCCESS;
	}
	
	public String list() throws Exception {
		workorders = workorderService.findAll();
		
		if (msg != null) {
			msg = new String(msg.getBytes("ISO-8859-1"), "UTF-8");
		}
		
		return SUCCESS;
	}
	
	public String addOrder() throws Exception {
		if (projectId != null && !projectId.equals("")) {
			return SUCCESS;
		}
		return INPUT;
	}
	
	public String addSave() throws Exception {
		try {
			Project project = projectService.getProjectById(projectId);
			workorder.setProject(project);
			workorder.setOrderdate(new Date());
			workorderService.addOrder(workorder);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg = "保存失败";
			return INPUT;
		}
		return SUCCESS;
	}
	
	public List<Project> getProjects() {
		return projects;
	}

	public List<Workorder> getWorkorders() {
		return workorders;
	}
	
	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	
	public Workorder getWorkorder() {
		return workorder;
	}

	public void setWorkorder(Workorder workorder) {
		this.workorder = workorder;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
