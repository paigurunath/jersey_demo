package com.howtodoinjava.jersey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.carpool.dao.TableDataOperations;
import com.carpool.model.User;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@Path("/carpool")
public class JerseyService
{
    @GET
    public String getMsg()
    {
         return "Hello World !! - Jersey 2, you rock the world darling";
    }
    
    @POST
    @Path("/insertUser")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateEmployeeById(String e) 
    {
       /* Employee updatedEmployee = new Employee();
         
        if(e.getName() == null) {
            return Response.status(400).entity("Please provide the employee name !!").build();
        }
         
        updatedEmployee.setId(id);
        updatedEmployee.setName(e.getName());
         */
    	try {
    		System.out.println(e);
        	
        	ObjectMapper mapper = new ObjectMapper();
            JsonNode actualObj = mapper.readTree(e);
            
            HashMap<Integer, String> hm = new HashMap<Integer, String>();
    		
    		hm.put(new Integer(1), actualObj.get("username").toString());
    		hm.put(new Integer(2), actualObj.get("password").toString());
    		hm.put(new Integer(3), actualObj.get("mobile").toString());
    		hm.put(new Integer(4), actualObj.get("email").toString());
    		hm.put(new Integer(5), actualObj.get("address").toString());
    		
            TableDataOperations tdo = new TableDataOperations();
            tdo.insertDataTable(hm);
            
            return Response.ok().entity(new ObjectMapper().writeValueAsString(actualObj)).build();
            
		} catch (Exception e2) {
			System.out.println(e2);
		}
    	return null;
    }
 
	@GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllEmployees() 
    {
		System.out.println("request recieved");
		TableDataOperations tdo = new TableDataOperations();
		List<User> userList = tdo.viewData();
		//Map<String, Book> books = RestResourceUtils.getBookMap();
		Gson gson = new Gson();
	    String jsonString = gson.toJson(userList);
	    //return Response.status(Response.Status.OK).entity(jsonString).build();
        //return list;
		//return Response.ok().entity(new ObjectMapper().writeValueAsString(userList)).build();
       return Response.ok().entity(jsonString).build();
    }
}
