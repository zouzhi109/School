package dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import entity.UserEntity;
import util.JdbcTemplateUtil;

public class UserDao {
	
	private JdbcTemplate jdbcTemplate = JdbcTemplateUtil.createJdbcTemplate();
	
	//查找全部，拿到数据后存放在List里
	public List<UserEntity> findAll(){
		//return jdbcTemplate.query("select * from user", new BeanPropertyRowMapper<>(UserEntity.class));
		return jdbcTemplate.query("select * from user", new BeanPropertyRowMapper<>(UserEntity.class));
	}
	
	//通过id查找，精确查找，一条数据
	public UserEntity findById(int id){
		List<UserEntity> list = jdbcTemplate.query("select * from user where id=?", new BeanPropertyRowMapper<>(UserEntity.class),id);
		//确认是否有需要查找的id，如果有返回数据，如果没有返回null
		return list.size()>0?list.get(0):null;
	}
	
	//通过姓名查找，模糊查找，多条数据，存放于List
	public List<UserEntity> findLikeName(String name){
		return jdbcTemplate.query("select * from user where name like '%' ? '%'", new BeanPropertyRowMapper<>(UserEntity.class),name);	
	}
	
	//修改用户信息,传入完整的用户信息
	public int update(UserEntity user) {
		return jdbcTemplate.update("update user set idCard=?, name=?, sex=?, tel=?, price=?, a_id=? where id=?",user.getIdCard(),user.getName(),user.getSex(),user.getTel(),user.getPrice(),user.getaId(),user.getId());
	}
	
	//删除一条数据
	public int delete(int id) {
		return jdbcTemplate.update("delete from user where id = ?",id);
	}
	
	//插入一条数据
	public int insert(int idCard,String name,String sex,int tel,double price,int aId) {
		return jdbcTemplate.update("insert into user(idCard,name,sex,tel,price,a_id)values(?,?,?,?,?,?)",idCard,name,sex,tel,price,aId);
	}
	
	/*public static void main(String[] args) {
		UserDao userDao = new UserDao();
		System.out.println(userDao.findLikeName("亚"));
		userDao.insert(3422,"塞拉斯", "男", 012, 32, 3);
		userDao.findAll().forEach(System.out::println);
	}*/

}
