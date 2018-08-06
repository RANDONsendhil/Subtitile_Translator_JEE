package com.connexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mesInterfaces.InterfaceTraductionDao;

import classMetier.MetierTextOriginal;
import classMetier.MetierTextTranslated;
import tablesDeTraduction.TableTranslatedSubtitles;
 

public class DaoTraduction implements InterfaceTraductionDao  {
private DaoFactory daoFactory;								 
	 
	public DaoTraduction(DaoFactory daoFactory) {
		 this.daoFactory = daoFactory;
	}
	
	public ArrayList<String> afficher() {
		 
		ArrayList <String> translated = new ArrayList<String>();
		
		
		 
		  Connection connexion=null;	
		  Statement statement =null;
		  ResultSet result =null;
			 
			  
		
		try {
			
			connexion = daoFactory.getConnection();
			statement = connexion.createStatement();
			result = statement.executeQuery("SELECT text FROM translated;");
			
			while(result.next()){
				
				
			 
				String text = result.getString("text");
	//	 String idText = result.getString("idText");
				
				TableTranslatedSubtitles tabTrSub = new TableTranslatedSubtitles();
				
		//	 tabTrSub.setTextId(idText);
				tabTrSub.setTranslatedSubtitles(translated);
				 
			 
			 
				translated.add(text);
				
			}
	 
			
			
		} catch (SQLException e) {
		 e.printStackTrace();
			 
		} finally{
		    try {
		    	result.close();
		    	statement.close();
		    	connexion.close();
		    } catch (SQLException e) {
		      
		        e.printStackTrace();
		    }
		}
		
		return translated;
 
	}

	public void ajouterTraduction(TableTranslatedSubtitles tab) { 
	 
		 try {
			
			 Connection connexion=null;	
			 
			 
			 connexion = daoFactory.getConnection(); 
			PreparedStatement ps = connexion.prepareStatement("INSERT INTO translated(idText,text) VALUES(?,?);");
			ps.setString(1, tab.getTextID());
			 ps.setString(2, tab.gettranslatedSubtitles());
			ps.executeUpdate();
		 
		} catch (SQLException e) {
			
			e.printStackTrace();
 
	}
		 
	} 	 
	
	 
	 
		public void update(TableTranslatedSubtitles tab) {
			try {
				
				 Connection connexion=null;	
				 
				 
				 connexion = daoFactory.getConnection(); 
				PreparedStatement ps = connexion.prepareStatement("UPDATE translated SET text = ? WHERE idText ='TestTextID';");

				 
				  ps.setString(1, tab.gettranslatedSubtitles());
				 
				ps.executeUpdate();
				 
				
			} catch (SQLException e) {
				
				e.printStackTrace();
	 
		}
			 
		} 	 
	
}