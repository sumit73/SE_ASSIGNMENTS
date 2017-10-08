package com.se.dao;

import com.se.bean.Login;
import com.se.bean.Register;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.faces.context.FacesContext;

import com.data.conn.*;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
public class LoginDao {

	public static boolean validateLgin(Login user) {
		
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = DataConnect.getConnection();
			
			String query = "select first_name from user where username = ? and password = ?";
			preparedStatement = (PreparedStatement) connection.prepareStatement(query);
			
			preparedStatement.setString(1,user.getLoginId());
			preparedStatement.setString(2, user.getPassword());
			
			
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()) {
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", rs.getString("first_name"));
				connection.close();
			
				return true;
			}
			
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			System.out.println(e.getMessage());
		}
		
		
		
		
		return false;
	}
	
}
