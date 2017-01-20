package com.example;
import java.io.PrintWriter;
import java.sql.*;

import javax.xml.ws.Response;

import org.json.JSONML;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
class HTMLController{
	public String username;
	OracleConn oconn=new OracleConn();
	
	 public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@RequestMapping(value="/connect")
	 public @ResponseBody Boolean getDataFromUI(@RequestBody User user){
		
		Connection conn=oconn.getConnection();
		//PrintWriter out = null;
		
		System.out.println("Entered into Controller");
		ResultSet rs;
		int flag=0;
		 try{
		 Statement stmt=conn.createStatement();
		 
			String q="select * from userdata";
			rs=stmt.executeQuery(q);  
			while(rs.next()){
				System.out.println(rs.getString(1)+"  "+rs.getString(2));
			if((rs.getString(1).equals(user.getUsername()))  && (rs.getString(2).equals(user.getPassword()))){
				
				flag=1;
				break;
			}
			else
			{
				flag=0;
			}
			}
			if(flag==1)
			{
				System.out.println("Authenticated");
				
				username = user.getUsername();
				System.out.println("%%%%%"+username);
				ArbitrageSystem ab=new ArbitrageSystem();
				ab.nameOfUser(username);
				return true;

			}
			else
			{
				System.out.println("Invalid User!!!!");
				return null;
			}
		}
	 
     
     catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return null;
     }
}
}


/*
app.controller('postserviceCtrl', function($scope, $http, $location) {
	$scope.name = null;
	$scope.password = null;
	$scope.lblMsg = null;
	$scope.postdata = function(username, password) {
		var data = {
			username : username,
			password : password
		};

		$http.post('/connect', JSON.stringify(data)).then(
				function(response) {
					if (response.data) {
						$scope.msg = "Post Data Submitted Successfully!";
						//window.location.hash = '#/home';
						$location.path('/home')
						
						$scope.name = null;
						$scope.password = null;
						$scope.lblMsg = null;
						$scope.msg = "Welcome Mr."+$scope.username;
					} else {
						$scope.msg = "Invalid User";
						window.location.hash = '#/invalid';
					}
				}, function(response) {
					$scope.msg = "Unsuccessful";
					$scope.statusval = response.status;
					$scope.statustext = response.statusText;
					$scope.headers = response.headers();
				});
	};
});*/

