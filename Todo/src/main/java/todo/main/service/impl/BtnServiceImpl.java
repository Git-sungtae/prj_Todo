package todo.main.service.impl;

import todo.main.dao.MainDao;
import todo.main.service.BtnService;

public class BtnServiceImpl implements BtnService{
	@Override
	public String changeTypeRight(String id, String type) {
		MainDao mainDao = new MainDao();
		String jsonString = "";
		if (mainDao.changeTypeRight(id, type) > 0) {
			JsonStringServiceImple jss = new JsonStringServiceImple();
			jsonString = jss.getJsonById(id, mainDao);
		}
		
		return jsonString;
		
	}

	@Override
	public String changeTypeLeft(String id, String type) {
		MainDao mainDao = new MainDao();
		String jsonString = "";
		System.out.println("Service impl id " + id);
		System.out.println("Service impl type " + type);
		if (mainDao.changeTypeLeft(id, type) > 0) {
			JsonStringServiceImple jss = new JsonStringServiceImple();
			jsonString = jss.getJsonById(id, mainDao);
		}
		
		return jsonString;
		
	}

}
