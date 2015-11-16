package org.koushik.javabrains.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.koushik.javabrains.messager.database.DatabaseClass;
import org.koushik.javabrains.messenger.model.Comment;
import org.koushik.javabrains.messenger.model.Message;

public class CommentService {
	Map<Long, Message> messages = DatabaseClass.getMessage();
	
	public List<Comment> getAllComments(long messageId) {
		Map<Long,Comment> comment = messages.get(messageId).getComments();
		return new ArrayList<Comment>(comment.values());
	}
	
	public Comment getComment(long messageId,long commentId){
		Map<Long,Comment> comment = messages.get(messageId).getComments();
		return comment.get(commentId);
	}
	 
	public Comment addComment(long messageId,Comment comment){
		Map<Long,Comment> comments = messages.get(messageId).getComments();
		comment.setId(comments.size()+1);
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment updateComment(long messageId,Comment comment){
		Map<Long,Comment> comments = messages.get(messageId).getComments();
		if(comment.getId() <= 0){
			return null;
		}
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment removeComment(long messageId,long commentId){
		Map<Long,Comment> comments = messages.get(messageId).getComments();
		return comments.remove(commentId);
	}
	
}
