package com.example.Task2.Services;

import java.text.DateFormat.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Task2.Entity.UserEntity;
import com.example.Task2.Repository.MyRepo;

@Service
public class MyServices extends JSONObject{
	@Autowired
	private MyRepo repository;
	public UserEntity save(UserEntity user) {
		return repository.save(user);
	}
	public UserEntity userById(int id) {
		return repository.findById(id).orElse(null);
	}
	public void myFuncn(int id,JSONArray jsonArray) {
		UserEntity myuser=repository.findById(id).orElse(null);
		JSONObject obj=new JSONObject();
		obj.put("name", myuser.getName());
		List<UserEntity> allChildren=repository.findAllByParentid(id);
		boolean flag=false;
		JSONArray newJsonArray=new JSONArray();
		for(UserEntity user:allChildren) {
			if(flag==false) {
				obj.put("subclass", newJsonArray);
				flag=true;
			}
			myFuncn(user.getId(), newJsonArray);
			
		}
		jsonArray.put(obj);
	}
	public List<Object> getChildrenTreeById(int id){
		JSONArray jsonArray=new JSONArray();
		myFuncn(id,jsonArray);
		List<Object> res=jsonArray.toList();
		return res;
	}
	public void newFuncn(JSONArray jsonArray,List<UserEntity> children) {

		for(UserEntity user:children) {
			JSONArray newJsonArray=new JSONArray();
			JSONObject obj=new JSONObject();
			List<UserEntity> allChildren=repository.findAllByParentid(user.getId());
			obj.put("Name",user.getName());
			if(allChildren.size()>0) {
				obj.put("Sub Classes", newJsonArray);
			}
			jsonArray.put(obj);
			newFuncn(newJsonArray, allChildren);	
		}
	}
	public List<Object> getChildrenTree(int id) {
		JSONArray jsonArray=new JSONArray();
		List<UserEntity> allChildren=repository.findAllByParentid(id);
		newFuncn(jsonArray, allChildren);
		List<Object> res=jsonArray.toList();
		return res;
	}
}
	