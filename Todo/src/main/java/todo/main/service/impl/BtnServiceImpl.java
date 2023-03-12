package todo.main.service.impl;

import todo.main.dao.MainDao;
import todo.main.service.BtnService;
import todo.main.service.JsonStringService;

public class BtnServiceImpl implements BtnService{
	@Override
	public String changeTypeRight(String id, String type) {
		MainDao mainDao = new MainDao();
		String jsonString = "";
		if (mainDao.changeTypeRight(id, type) > 0) {
			JsonStringService jss = new JsonStringServiceImple();
			jsonString = jss.getJsonById(id);
		}
		
		return jsonString;
		
	}

	@Override
	public String changeTypeLeft(String id, String type) {
		MainDao mainDao = new MainDao();
		String jsonString = "";
		if (mainDao.changeTypeLeft(id, type) > 0) {
			JsonStringService jss = new JsonStringServiceImple();
			jsonString = jss.getJsonById(id);
		}
		
		return jsonString;
		
	}

}
