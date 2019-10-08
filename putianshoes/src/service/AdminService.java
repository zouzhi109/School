package service;

import java.util.List;

import dao.AdminDao;
import entity.AdminEntity;

public class AdminService {
	
	private AdminDao adminDao = new AdminDao();
	
	public List<AdminEntity> getAll(){
		return adminDao.findAll();
	}

}
