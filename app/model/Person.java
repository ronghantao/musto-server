package model;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

import entity.User;

public class Person{
	public Integer uid;
	public String name;
	public Integer gender;
	public String idNumber;
	public String portraitUri;
	public String mobile;
	public String email;
	public String birthday;
	public String originProvince;
	public String originCity;
	
	public void init(User u){
		this.uid = u.id;
		this.name = u.name;
		this.gender = u.gender;
		this.idNumber = u.idNumber;
		this.portraitUri = u.portraitUri;
		this.mobile = u.mobile;
		this.email = u.email;
		this.birthday = u.birthday;
		this.originProvince = u.originProvince;
		this.originCity = u.originCity;
	}
	
	public String getJson(){
		Map<String, Object> obj = new HashMap<String, Object>();
		for(Field field :this.getClass().getFields()){
			try{
				obj.put(field.getName(), field.get(this));
			}catch(Exception e){
				
			}
		}
		return new Gson().toJson(obj);
	}
}
