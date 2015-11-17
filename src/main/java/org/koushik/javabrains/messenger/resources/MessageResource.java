package org.koushik.javabrains.messenger.resources;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.koushik.javabrains.messenger.model.Message;
import org.koushik.javabrains.messenger.resources.beans.MessageFilterBean;
import org.koushik.javabrains.messenger.service.MessageService;

@Path("/messages")
public class MessageResource {
	private MessageService msgService = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getAllMessages(@BeanParam MessageFilterBean filterBean){
		if(filterBean.getYear() > 0){
			return msgService.getAllMessagesForYear(filterBean.getYear());
		}
		if(filterBean.getStart() >= 0 && filterBean.getSize() > 0){
			return msgService.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
		}
		return msgService.getAllMessages();
	}
	
	
	@POST 
	public Response addMessage(Message message,@Context UriInfo uriInfo) throws URISyntaxException{
		/**
		 * 
		 * Added the uri => location
		 * 
		 * */
		System.out.println();
		Message newMessage = msgService.addMessage(message);
		String newId = String.valueOf(newMessage.getId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri)
		.entity(newMessage)
		.build();
	}
	
	
	@PUT
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageId") long id,Message msg){
		msg.setId(id);
		return msgService.updateMessage(msg);
	}
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId")long messageId){
		return msgService.getMessage(messageId);
	} 
	
	@DELETE
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void removeMessage(@PathParam("messageId")long messageId){
		msgService.removeMessage(messageId);
	}
	
	// sending the response using the 
	//response builder
	
	
	/*
	 * Add comments via another instance
	 * 
	 * DELEGATION
	 * 
	 * Parent Resource
	 * */
	@Path("/{messageId}/comments")
	public CommentResource getCommentResourcetest(){
		return new CommentResource();
	}
}
