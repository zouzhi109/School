package util;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcTemplateUtil {
	
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/wangbaguanli";
	private static final String username = "root";
	private static final String password = "zouzhi";
	
	public static JdbcTemplate createJdbcTemplate() {
		try {
			Class.forName(driver);
			return new JdbcTemplate(new DriverManagerDataSource(url, username, password));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("mysql驱动加载失败");
		}
		return null;
	}
	
	public static void main(String[] args){
		System.out.println(JdbcTemplateUtil.createJdbcTemplate());
	}
	
}
