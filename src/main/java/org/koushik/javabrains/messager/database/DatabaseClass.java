package org.koushik.javabrains.messager.database;

import java.util.HashMap;
import java.util.Map;

import org.koushik.javabrains.messenger.model.Message;
import org.koushik.javabrains.messenger.model.Profile;

public class DatabaseClass {
	
	private static Map<Long,Message> messageMap = new HashMap<>();
	private static Map<String,Profile> profileMap = new HashMap<>();
	
	public static Map<Long,Message> getMessage(){
		return messageMap;
	}
	public static Map<String,Profile> getProfile(){
		return profileMap;
	}
}
