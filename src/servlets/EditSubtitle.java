package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connexion.DaoFactory;
import com.connexion.DaoTraduction;
import com.mesInterfaces.InterfaceTraductionDao;

import classMetier.MetierTextTranslated;
import tablesDeTraduction.TableTranslatedSubtitles;
import tablesDeTraduction.TablesdeOriginalSubtitles;

@WebServlet("/EditSubtitle")
public class EditSubtitle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String FILE_NAME = "/WEB-INF/shape.srt";
	//password_presentation
	private InterfaceTraductionDao  DaoTraduction;
 
	public void init() throws ServletException {

        DaoFactory daoFactory = DaoFactory.getInstance();

        this.DaoTraduction = daoFactory.getTraductionDao();
    }
	 
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		System.out.println(context.getRealPath(FILE_NAME));
		TablesdeOriginalSubtitles tabOS = new TablesdeOriginalSubtitles(context.getRealPath(FILE_NAME));
		request.setAttribute("subtitles", tabOS.getSubtitles());
		
		
 
		this.getServletContext().getRequestDispatcher("/WEB-INF/edit_subtitle.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context = getServletContext();
		TablesdeOriginalSubtitles tabOS = new TablesdeOriginalSubtitles(context.getRealPath(FILE_NAME));
	
		System.out.println(context.getRealPath(FILE_NAME));
		TablesdeOriginalSubtitles subtitles = new TablesdeOriginalSubtitles(context.getRealPath(FILE_NAME));
 
		int textTraduireSize = subtitles.getoriginalTextSize();
		String[] addLine = new String[textTraduireSize];
		
		TableTranslatedSubtitles tTS = new TableTranslatedSubtitles();
		 
		ArrayList <String> list = new ArrayList<String>();
		
		 for(int i =0; i<addLine.length; i++){
			
			addLine[i] = request.getParameter("line"+i);
			 
			
			tTS.addTranslatedSubtitles(addLine[i]);
			
			list.add(tTS.gettranslatedSubtitles());
			
			 
			  
			}
	 
		 	
		 
		 
		 
			  
					 tTS.setTranslatedSubtitles(list);
					// DaoTraduction.ajouterTraduction(tTS);
					 
				 
				 
					DaoTraduction.update(tTS);
					System.out.println("check affiche "+DaoTraduction.afficher());
					 
				 
				 
   
		
	
					request.setAttribute("subtitles", tabOS.getSubtitles());
	 
		this.getServletContext().getRequestDispatcher("/WEB-INF/edit_subtitle.jsp").forward(request, response);
			
		} 
		
	 
	 

}
