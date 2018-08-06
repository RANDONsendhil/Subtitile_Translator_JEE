package com.connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mesInterfaces.InterfaceTraductionDao;

import classMetier.MetierTextTranslated;

 

public class DaoFactory {
	
String url;
String login;
String password;

public 	DaoFactory(){
	
}
public 	DaoFactory(String url, String login, String password){
	this.url = url;
	this.login = login;
	this.password =password;
	}

public static DaoFactory getInstance(){
	

	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		 
	}
 
	  DaoFactory instance = new DaoFactory("jdbc:mysql://localhost:3306/databasetranslated", "root",  "randon" );
	  return instance;
	  
} public Connection getConnection() throws SQLException{
	return DriverManager.getConnection(url,login,password);
	
}
 
public  InterfaceTraductionDao   getTraductionDao(){
	return new DaoTraduction(this);
}
}
