package org.koushik.javabrains.messenger.resources;
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
import javax.ws.rs.core.MediaType;

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
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message addMessage(Message msg){
		return msgService.addMessage(msg);
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
