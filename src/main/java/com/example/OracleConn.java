package com.example;
import java.sql.*;  
import java.sql.Connection;
import java.sql.SQLException;
import java.lang.Object;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import oracle.jdbc.pool.OracleDataSource;
@Controller


class OracleConn{
	String jdbcUrl="jdbc:oracle:thin:@HP:1521:xe";
	String userid="citi";
	String password="citi";
	Connection conn;
	ResultSet rs;
	OracleDataSource ds;
	 public Connection getConnection(){
			
			System.out.println("inside oracleconn");
	        try {
	        	int flag=0;
	        	Class.forName("oracle.jdbc.driver.OracleDriver");
	        	conn=DriverManager.getConnection("jdbc:oracle:thin:citi/citi@HP:1521:xe");
	        	
	        	ds = new OracleDataSource();
		        ds.setURL(jdbcUrl);
	        	conn=ds.getConnection(userid,password);
	        
			}
	        catch (ClassNotFoundException ce) {

				ce.printStackTrace();
				conn=null;
				return conn;
				}
	        catch (SQLException e) {

				System.out.println("Connection Failed! Check output console");
				e.printStackTrace();
				conn=null;
				return conn;

			}
	        if(conn!=null)
	        {
	        	System.out.println("Connection made");
	        	return conn;
	        }
	        else
	        {
	        	conn=null;
				return conn;
	        }
}
	
	
	public void saveHistory(Connection conn,String user,String stockName,Double nse,Double bse,String higher,Double diff,String dt)
	{
		
		try{
		PreparedStatement pstmt=null;
		System.out.println("Savehist======..");
		pstmt=conn.prepareStatement("insert into history(username,companyName,nse,bse,higher,diff,timeDate) values (?,?,?,?,?,?,?)");
		
		Timestamp ts = Timestamp.valueOf(dt);
		
		pstmt.setString(1, user);
		pstmt.setString(2, stockName);
		pstmt.setDouble(3,nse);
		pstmt.setDouble(4,bse);
		pstmt.setString(5, higher);
		pstmt.setTimestamp(7, ts);
		
		pstmt.setDouble(6, diff);
		
		pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return;
		}
	}
	
	public void displayHistory()
	{
		try{
			Statement stmt=conn.createStatement();  
			String q="select * from history";
			rs=stmt.executeQuery(q);  
			while(rs.next()){
			System.out.println(rs.getString(1)+"  "+rs.getString(2)+" "+rs.getDouble(3)+" "+rs.getDouble(4)+" "+rs.getString(5)+" "+rs.getDouble(6)+" "+rs.getTimestamp(7));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return;
		}
	}
}
