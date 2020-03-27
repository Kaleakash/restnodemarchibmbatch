package com;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

//import com.sun.jersey.spi.container.servlet.ServletContainer;



@Path("obj")
public class Demo {

	
	@GET
	@Path("hello")
	public String sayHello() {
		System.out.println("I Came Here - sayHello");
		return "Welcome to JAX_RS Service - sayHello";
	}
	
	@GET
	public String sayHi() {
		System.out.println("I came here- sayHi");
		return "Welcome to JAX_Rs Service - sayHi";
	}
	
	@GET
	@Path("html")
	@Produces(value=MediaType.TEXT_HTML)
	public String sayHTML() {
		return "<h1>Welcome to HTML Message</h1>";
	}
	@GET
	@Path("xml")
	@Produces(value=MediaType.TEXT_XML)
	public String sayXml() {
		return "<h1>Welcome to XML Message</h1>";
	}
	@GET
	@Path("plain")
	@Produces(value=MediaType.TEXT_PLAIN)
	public String sayPlain() {
		return "<h1>Welcome to XML Message</h1>";
	}

	//http://localhost:8080/JAX_RS_Demo/rest/obj/queryParam?name=Vijay
	@GET
	@Path("queryParam")
	@Produces(value=MediaType.TEXT_PLAIN)
	public String queryParamInfo(@QueryParam("name") String fname) {
		return "Welcome "+fname;
	}
	
	
	//http://localhost:8080/JAX_RS_Demo/rest/obj/empInfo?id=100&name=Ravi&salary=14000
	@GET
	@Path("empInfo")
	@Produces(value=MediaType.TEXT_PLAIN)
	public String empInfo(@QueryParam("id") int id, 
			@QueryParam("name")String name, 
			@QueryParam("salary") float salary) {
		salary = salary+2000;
		return "Name is "+name+" Your salary is "+salary;
	}
	
	//http://localhost:8080/JAX_RS_Demo/rest/obj/pathParam/Ravi
	@GET
	@Path("pathParam/{name}")
	@Produces(value=MediaType.TEXT_PLAIN)
	public String pathInfo(@PathParam("name") String fname) {
		return "Welcome to PathParam "+fname;
	}
	
	@GET
	@Path("empPath/{id}/{name}/{salary}")
	@Produces(value=MediaType.TEXT_PLAIN)
	public String empPathInfo(@PathParam("id") int id, 
			@PathParam("name") String name,
			@PathParam("salary") float salary) {
		salary = salary+1000;
	return "Your id is "+id+", Your Name is "+name+" Your gross salary "+salary;
	}
	
	@POST
	public void postMethodInfo() {
		System.out.println("Post Method called....");
	}
	
	@DELETE
	public void deleteMethodInfo() {
		System.out.println("Delete method called....");
	}
	
	@PUT
	public void putMethodInfo() {
		System.out.println("PUt method called...");
	}
}
