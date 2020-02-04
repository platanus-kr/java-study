package com.example.demo.service.database;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class InMemoryDatabaseService implements DatabaseService {
	private Map<String, String> datas = new HashMap<>();
	
	public InMemoryDatabaseService() {
		datas.put("test", "1234");
	}
	
	@Override
	public String saveName(String name) {
		return "InMemory saved: " + name;
	}

	@Override
	public List<String> selectAll() {
		return new LinkedList<String>(datas.keySet());
	}

	@Override
	public String selectOne(String id) {
		return datas.get(id);
	}

	@Override
	public boolean create(String id, String data) {
		if (datas.containsKey(id)) {
			return false;
		}
		datas.put(id, data);
		return true;
	}

	@Override
	public boolean update(String id, String data) {
		datas.put(id, data);
		return true;
	}

}
