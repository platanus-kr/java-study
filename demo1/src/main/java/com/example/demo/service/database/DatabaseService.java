package com.example.demo.service.database;

import java.util.List;

public interface DatabaseService {

	public String saveName(String name);
	
	
	
	public List<String> selectAll();
	
	public String selectOne(String id);
	
	public boolean create(String id, String data);
	
	public boolean update(String id, String data);
	
}
