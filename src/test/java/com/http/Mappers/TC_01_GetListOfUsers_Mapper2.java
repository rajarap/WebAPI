package com.http.Mappers;

import com.google.gson.annotations.SerializedName;

public class TC_01_GetListOfUsers_Mapper2 
{
	@SerializedName("id")
	public int id;
	
	@SerializedName("first_name")
	public String first_name;
	
	@SerializedName("last_name")
	public String last_name;
	
	@SerializedName("avatar")
	public String avatar;
	
	public int getId() {
		return id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public String getAvatar() {
		return avatar;
	}
}
