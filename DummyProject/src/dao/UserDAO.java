package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.DatabaseConnection;
import userBean.UserBean;

public class UserDAO {
	public ArrayList<UserBean> getUsers() {
		ArrayList<UserBean> users = new ArrayList<>();
		DatabaseConnection dbCon = new DatabaseConnection();
		Connection con = dbCon.handleConnection();
		
		Statement stmt = null;
		
		try {
			stmt = con.createStatement();
			String sql;
	        sql = "SELECT * FROM users";
	        ResultSet rs = stmt.executeQuery(sql);
	        while(rs.next()) {
	        	UserBean user = new UserBean();
	        	user.setId(rs.getInt("id"));
	        	user.setFirstName(rs.getString("firstName"));
	        	user.setLastName(rs.getString("lastName"));
	        	user.setUsername(rs.getString("username"));
	        	user.setPassword(rs.getString("password"));
	        	users.add(user);
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}
}
