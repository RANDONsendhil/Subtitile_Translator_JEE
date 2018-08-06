package com.mesInterfaces;

import javax.servlet.http.HttpServletRequest;

public interface InterfaceGestion {
	 
	  void ajouter( HttpServletRequest request);
	  void supprimer( HttpServletRequest request);
	  void afficher( HttpServletRequest request);
	

}
