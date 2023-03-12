package todo.main.service.impl;

import org.json.simple.JSONObject;

import todo.main.dao.MainDao;
import todo.main.service.JsonStringService;

public class JsonStringServiceImple implements JsonStringService {
	
	@Override
	public String getJsonByType(String type){
		MainDao mainDao = new MainDao();
		JSONObject json = mainDao.getTodosByType(type);
		//json객체를 string으로 변환
		return json.toJSONString();
	}

	@Override
	public String getJsonById(String id) {
		MainDao mainDao = new MainDao();
		JSONObject json = mainDao.getTodosById(id);
		//json객체를 string으로 변환
		return json.toJSONString();
	}
	
}
