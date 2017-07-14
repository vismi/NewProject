package com.servlet.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Queryget {
ResultSet rs;
	Queryget(Connection con) throws Exception{
	Statement stmt = con.createStatement();
	rs = stmt.executeQuery("select * from Emp");
}
	ResultSet ret() {
		return rs;
	}
}
