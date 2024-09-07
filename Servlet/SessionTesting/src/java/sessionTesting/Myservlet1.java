
package sessionTesting;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet(name = "Myservlet1", urlPatterns = {"/Myservlet1"})
public class Myservlet1 extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	response.setContentType("text/html;charset=UTF-8");
	try {
	    PrintWriter printWriter=response.getWriter();
	    HttpSession session	=request.getSession(true);
	    session.setAttribute("name", "pratik");
	    session.setAttribute("rollno", 1);
	    
	    printWriter.print("<a href=http://localhost:8080/SessionTesting/Myservlet2>second servlet</a>");
	    
	} catch (Exception e) {
	    e.printStackTrace();
	}
	
	
    }

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	processRequest(request, response);
    }

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	processRequest(request, response);
    }

 
    public String getServletInfo() {
	return "Short description";
    }// </editor-fold>

}
