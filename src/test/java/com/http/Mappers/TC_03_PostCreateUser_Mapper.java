package com.http.Mappers;

import com.google.gson.annotations.SerializedName;

public class TC_03_PostCreateUser_Mapper 
{
	@SerializedName("name")
	public String name;
	
	@SerializedName("job")
	public String job;
	
	public String getName() {
		return name;
	}

	public String getJob() {
		return job;
	}

}
