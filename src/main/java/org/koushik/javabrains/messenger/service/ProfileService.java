package org.koushik.javabrains.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.koushik.javabrains.messager.database.DatabaseClass;
import org.koushik.javabrains.messenger.model.Profile;

public class ProfileService {
	private Map<String,Profile> profiles = DatabaseClass.getProfile();
	public ProfileService(){
		profiles.put("Koushik", new Profile(1L,"Koushik","Koushik","Kothagal"));
	}
	
	public Profile getProfile(String profileName){
		return profiles.get(profileName);
	}
	
	public List<Profile> getAllProfile(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile addProfile(Profile profile){
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile){
		if(profiles.size()<=0){
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName){
		return profiles.remove(profileName);
		
	}
}
