package service;

import java.util.List;

import dao.AdminDao;
import dao.UserDao;
import entity.UserEntity;

public class UserService {
	
	private UserDao userDao = new UserDao();
	private AdminDao adminDao = new AdminDao();
	
	//查询所有
	//得到所有数据 存放于list 
	public List<UserEntity> getAll(){
		List<UserEntity> list = userDao.findAll();
		//对list中的数据进行遍历
		for (UserEntity userEntity:list) {
			//将每个user的a_id变为a_id所对应的name
			userEntity.setAdmin(adminDao.findById(userEntity.getaId()));
		}
		return list;
	}
	
	//通过id查询
	public UserEntity getById(int id) {
		return userDao.findById(id);
	}
	
	//通过姓名模糊查询
	public List<UserEntity> getLikeName(String name) {
		List<UserEntity> list = userDao.findLikeName(name);
		for (UserEntity userEntity:list) {
			userEntity.setAdmin(adminDao.findById(userEntity.getaId()));
		}
		return list;
	}
	
	//修改数据,调用dao层中封装的方法
	public void update(UserEntity user) {
		userDao.update(user);
	}
	
	//删除数据
	public void delete(int id) {
		userDao.delete(id);
	}
	
	public void insert(int idCard,String name,String sex,int tel,double price,int aId) {
		userDao.insert(idCard, name, sex, tel, price, aId);
	}

}
