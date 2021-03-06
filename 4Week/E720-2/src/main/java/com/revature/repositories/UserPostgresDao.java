package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.exceptions.InternalErrorException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;

public class UserPostgresDao implements UserDao {
	
	private ConnectionFactory cf = ConnectionFactory.getConnectionFactory();

	@Override
	public User findUserByUsernameAndPassword(String username, String password) throws UserNotFoundException, InternalErrorException {
		Connection conn = cf.getConnection();
		try {
			String sql = "select * from entertainment720.users where \"username\" = ? and \"password\" = ? ;";
			PreparedStatement getUser = conn.prepareStatement(sql);
			getUser.setString(1, username);
			getUser.setString(2, password);
			
			ResultSet res = getUser.executeQuery();
			if(res.next()) {
				User u = new User();
				u.setUserId(res.getInt("user_id"));
				u.setFirstName(res.getString("first_name"));
				u.setLastName(res.getString("last_name"));
				u.setUsername(res.getString("username"));
				u.setPassword(res.getString("password"));
				return u;
			}else {
				throw new UserNotFoundException();
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new InternalErrorException();
		} finally {
			cf.releaseConnection(conn);
		}
	}

	@Override
	public List<User> findAll() {
		Connection conn = cf.getConnection();
		try {
			String sql = "select * from entertainment720.users;";
			PreparedStatement getUser = conn.prepareStatement(sql);
			
			
			ResultSet res = getUser.executeQuery();
			List<User> allUsers = new ArrayList<User>();
			while(res.next()) {
				User u = new User();
				u.setUserId(res.getInt("user_id"));
				u.setFirstName(res.getString("first_name"));
				u.setLastName(res.getString("last_name"));
				u.setUsername(res.getString("username"));
				u.setPassword(res.getString("password"));
				allUsers.add(u);
			}
			return allUsers;
		}catch(SQLException e) {
			e.printStackTrace();
			throw new InternalErrorException();
		} finally {
			cf.releaseConnection(conn);
		}
	}
	
	
	
	
	
	

}
