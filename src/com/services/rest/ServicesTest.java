package com.services.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;


@Path("/saludos")
public class ServicesTest {

	@Produces(MediaType.TEXT_PLAIN)
	@GET
	public String  getMsg() {
		return "Hola mexico desde venezuela vladimir ceballos ";
 
	}

	
}
