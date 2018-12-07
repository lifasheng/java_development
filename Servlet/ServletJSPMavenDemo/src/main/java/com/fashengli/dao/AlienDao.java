package com.fashengli.dao;

import com.fashengli.model.Alien;
import java.sql.*;

public class AlienDao {
	public Alien getAlien(int aid) {
		final Alien a = new Alien();
		
		try {
			final String url = "jdbc:mysql://localhost:3306/servlet_test";
			final String user = "root"; // hardcode for test here, should not use root in prod.
			final String password = "root"; // hardcode for test here, should not do in prod.
			
			Class.forName("com.mysql.jdbc.Driver");
			final Connection con = DriverManager.getConnection(url, user, password);
			final Statement st = con.createStatement();
			final ResultSet rs = st.executeQuery("select * from alien where id=" + aid);
			if (rs.next()) {
				a.setId(rs.getInt("id"));
				a.setAname(rs.getString("aname"));
				a.setTech(rs.getString("tech"));
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return a;
	}
}
