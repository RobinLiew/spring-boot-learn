package com.robinliew.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.robinliew.domain.Contact;

/**
 * 这里使用Spring jdbcTemplate和H2数据库
 * @author RobinLiew
 *
 */
@Repository//使用该注解后，会在组件扫描的时候，它被发现并创建为Spring应用上下文中的bean
public class ContactRepository {
	/**
	 * 我们难道不需要在Spring应用上下文中声明JdbcTemplate bean吗?为了声明它，我们是不是还要声明一个H2 DataSource?
	 * 答案是不需要。
	 * 当Spring Boot 探测到Spring的JDBC模块和H2在类路径下的时候，自动配置就会发挥作用，将会自动配置JdbcTemplate bean和
	 * H2 DataSource bean。
	 */
	private JdbcTemplate jdbc;
	
	public List<Contact> findAll() {
		return jdbc.query("select id,firstName,lastName,phoneNumber,emailAddress"+
				"from contacts order by lastName", new RowMapper<Contact>(){

					@Override
					public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
						Contact contact=new Contact();
						contact.setId(rs.getLong(1));
						contact.setFirstName(rs.getString(2));
						contact.setLastTime(rs.getString(3));
						contact.setPhoneNumber(rs.getString(4));
						contact.setEmailAddress(rs.getString(5));
						return contact;
					}
			
		});
	}

	public void save(Contact contact) {
		jdbc.batchUpdate("insert into contacts "+
				"(firstName,lastName,phoneNumber,emailAddress)"+
				"values(?,?,?,?)",
				contact.getFirstName(),contact.getPhoneNumber(),
				contact.getPhoneNumber(),contact.getEmailAddress());
	}
	
}
