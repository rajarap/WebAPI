package com.http.Mappers;

import com.google.gson.annotations.SerializedName;

public class TC_04_PostRegisterUserSuccess_Mapper 
{

	@SerializedName("token")
	public String token;
	
	public String getToken() {
		return token;
	}

}
