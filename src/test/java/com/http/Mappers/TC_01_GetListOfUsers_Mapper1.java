package com.http.Mappers;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class TC_01_GetListOfUsers_Mapper1 
{
	@SerializedName("page")
	 public int page;
	 
	 @SerializedName("per_page")
	 public int per_page;
	 
	 @SerializedName("total")
	 public int total;
	 
	 @SerializedName("total_pages")
	 public int total_pages;
	 
	@SerializedName("data")
	 public List<TC_01_GetListOfUsers_Mapper2> mapper2; 
	 
	 
	 public int getPage() {
		return page;
	}

	public int getPer_page() {
		return per_page;
	}

	public int getTotal() {
		return total;
	}

	public int getTotal_pages() {
		return total_pages;
	}      
	
	 public List<TC_01_GetListOfUsers_Mapper2> getMapper2() {
		return mapper2;
	}
}

// class TC_01_GetListOfUsers_Mapper2 
//{
//	@SerializedName("id")
//	public int id;
//	
//	@SerializedName("first_name")
//	public String first_name;
//	
//	@SerializedName("last_name")
//	public String last_name;
//	
//	@SerializedName("avatar")
//	public String avatar;
//	
//	public int getId() {
//		return id;
//	}
//
//	public String getFirst_name() {
//		return first_name;
//	}
//
//	public String getLast_name() {
//		return last_name;
//	}
//
//	public String getAvatar() {
//		return avatar;
//	}
//}