package org.koushik.javabrains.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("injections")
public class InjectDemoResource {
	 
	@GET
	@Path("/annotations")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public String getValues(@HeaderParam("name")String param){
		System.out.println(param);
		return "These values are generated from annoatations"+" header Param: "+param;
		}
	@GET
	@Path("context")
	public String getParamsUsingContext(@Context UriInfo uriInfo){
		String path = uriInfo.getAbsolutePath().toString();
		return "Path:"+path;
	}  
}
