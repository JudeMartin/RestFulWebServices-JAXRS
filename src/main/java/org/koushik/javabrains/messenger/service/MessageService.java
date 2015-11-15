package org.koushik.javabrains.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.koushik.javabrains.messager.database.DatabaseClass;
import org.koushik.javabrains.messenger.model.Message; 
 
public class MessageService {
	
	private  Map<Long,Message> messages = DatabaseClass.getMessage();
	
	public MessageService(){
		messages.put(1L,new Message(1,"Hello World","Mj"));
		messages.put(2L,new Message(2,"Hello World - MJE","MJE"));
	}
	 
	public List<Message> getAllMessagesForYear(int year){
		 List<Message> messagesForyear = new ArrayList<>();
		 Calendar cal = Calendar.getInstance();
		for (Message message : messages.values()) {
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR) == year){
				messagesForyear.add(message);
			}
		} 
		return messagesForyear;
	}
	
	public List<Message> getAllMessagesPaginated(int start,int size){
			ArrayList<Message> list = new ArrayList<Message>(messages.values());
			if((start + size) > list.size()) return new ArrayList<Message>();
			return list.subList(start, start+size);
	}
	
	
	public List<Message> getAllMessages(){ 
		System.out.println(messages.values());
		return new ArrayList<Message>(messages.values());  
	}
	
	public Message getMessage(Long id){
		return messages.get(id);
	}
	
	public Message addMessage(Message msg){
		msg.setId(messages.size()+1);
		messages.put(msg.getId(),msg);
		return msg;
		
	}
	
	public Message removeMessage(Long id){
		return messages.remove(id);
	}
	
	public Message updateMessage(Message msg){
		if(msg.getId()<=0){
			return null;
		}
		messages.put(msg.getId(),msg);
		return msg;
	} 
}
