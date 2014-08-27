package model;

import com.google.gson.Gson;

public class Teacher extends Person{
	public String getJson(){
		String p = super.getJson();
		return new Gson().toJson(this);
	}
}
