package org.koushik.javabrains.messenger.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
/*
 * Child Resource 
 * 
 * */


@Path("/comments")
public class CommentResource {
	@GET
	public String test(){
		return "new Sub Resource";
	} 
	
	/**
	 * the message ID is available via delegation
	 **/
	
	@GET
	@Path("/{commentId}")
	public String test2(@PathParam("messageId") long messageID,@PathParam("commentId") long commentID){
		return "Comment with the specific Id " + commentID + " for message "+messageID;
	}
	
}
