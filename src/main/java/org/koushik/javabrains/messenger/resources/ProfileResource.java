package org.koushik.javabrains.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.koushik.javabrains.messenger.model.Profile;
import org.koushik.javabrains.messenger.service.ProfileService;

@Path("/profiles")
public class ProfileResource {

	 ProfileService profileService = new ProfileService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Profile> getAllProfiles(){
		System.out.println("In Progiles get method"); 
		return profileService.getAllProfile();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{profileName}")
	public Profile getProfile(@PathParam("profileName")String profileName){
		return profileService.getProfile(profileName);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Profile addProfile(Profile profileName){
		return profileService.addProfile(profileName);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{profileName}")
	
	public Profile updateProfile(@PathParam("profileName")String profileName,Profile profile){
		profile.setProfileName(profileName);
		return profileService.updateProfile(profile);
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{profileName}")
	public void removeAllProfiles(@PathParam("profileName")String profileName){
		profileService.removeProfile(profileName);
	}
}
