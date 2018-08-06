package com.mesInterfaces;

import java.util.ArrayList;

import classMetier.MetierTextTranslated;
import tablesDeTraduction.TableTranslatedSubtitles;

 
public interface InterfaceTraductionDao{
public void ajouterTraduction (TableTranslatedSubtitles tTS);
public ArrayList<String> afficher();
public void update (TableTranslatedSubtitles tTS);
 
}	 

