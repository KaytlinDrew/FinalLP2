package pucp.gamesoft.rrhh.model;

import java.util.Date;
public class RoleHistory{
	private Date startDate;
	private Date endDate;
	private Role role;
	private Employee employee;
	private Department department;
	public RoleHistory(Department department, Employee employee, Date startDate, Date endDate){
		this.department = department;
		this.employee = employee;
		this.startDate = startDate;
		this.endDate = endDate;
	}
}