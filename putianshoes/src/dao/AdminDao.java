package dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import entity.AdminEntity;
import util.JdbcTemplateUtil;

public class AdminDao {
	
	private JdbcTemplate jdbcTemplate = JdbcTemplateUtil.createJdbcTemplate();
	
	public List<AdminEntity> findAll(){
		return jdbcTemplate.query("select * from admin", new BeanPropertyRowMapper<>(AdminEntity.class));
	}
	
	public AdminEntity findById(int id) {
		List<AdminEntity> list = jdbcTemplate.query("select * from admin where id=?", new BeanPropertyRowMapper<>(AdminEntity.class),id);
		return list.size()>0?list.get(0):null;
	}
	
	public List<AdminEntity> findLikeName(String name){
		return jdbcTemplate.query("select * from admin where name like '%' ? '%'", new BeanPropertyRowMapper<>(AdminEntity.class));
	}

}
