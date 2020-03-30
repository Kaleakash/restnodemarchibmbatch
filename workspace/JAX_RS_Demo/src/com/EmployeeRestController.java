package com;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("employees")
public class EmployeeRestController {
	@GET
	@Produces(value=MediaType.APPLICATION_XML) // may xml or json 
	@Path("empXml")
	public Employee getEmployeeInfoXml() {
	Employee emp = new Employee();
	emp.setId(100);
	emp.setName("Ravi");
	emp.setSalary(14000);
	return emp;
	}
	
	@GET
	@Produces(value=MediaType.APPLICATION_JSON) // may xml or json 
	@Path("empJson")
	public Employee getEmployeeInfoJson() {
	Employee emp = new Employee();
	emp.setId(101);
	emp.setName("Ajay");
	emp.setSalary(16000);
	return emp;
	}
	
	@GET
	@Produces(value=MediaType.APPLICATION_JSON) // may xml or json 
	@Path("empsJson")
	public List<Employee> listOfRecords() {
		List<Employee> listOfRec = new ArrayList<>();
		Employee emp1 = new Employee();
		emp1.setId(1); emp1.setName("Seeta"); emp1.setSalary(12000);
		Employee emp2 = new Employee();
		emp2.setId(2); emp2.setName("Reeta"); emp2.setSalary(14000);
		Employee emp3 = new Employee();
		emp3.setId(3); emp3.setName("Meeta"); emp3.setSalary(16000);
		listOfRec.add(emp1); listOfRec.add(emp2); listOfRec.add(emp3);
		return listOfRec;
	}
	
	@POST
	@Consumes(value=MediaType.APPLICATION_JSON)
	@Produces(value=MediaType.TEXT_PLAIN)
	@Path("empPass")
	public String empPass(Employee emp) {
			System.out.println("Id is "+emp.getId());
			System.out.println("Name is "+emp.getName());
			System.out.println("salary is "+emp.getSalary());
			
			return "Welcome "+emp.getName();
	}
	
	
	@GET
	@Produces(value=MediaType.APPLICATION_JSON)
	@Path("empDb")
	public List<Employee> getEmployeeInfoFromDb() {
		EmployeeDao ed = new EmployeeDao();
		System.out.println("in rest method");
		return ed.getEmployeeDbInfo();
	}
	
	@POST
	@Consumes(value=MediaType.APPLICATION_JSON)
	@Produces(value=MediaType.TEXT_PLAIN)
	@Path("empStoreDb")
	public String empStoreDb(Employee emp) {
			EmployeeDao ed = new EmployeeDao();
			if(ed.storeEmployeeInfo(emp)>0) {
				return "Record stored successfully";
			}else {
				return "Record not store";
			}
	}
}
