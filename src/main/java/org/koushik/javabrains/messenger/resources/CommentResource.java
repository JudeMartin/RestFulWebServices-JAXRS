package org.koushik.javabrains.messenger.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/comments")
public class CommentResource {
	@GET
	public String test(){
		return "new Sub Resource";
	} 
	
}
