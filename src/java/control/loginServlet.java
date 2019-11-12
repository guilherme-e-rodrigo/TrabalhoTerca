package control;

import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.tagext.TryCatchFinally;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import model.CUser;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CUser myUser;   
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() 
    {
        super();
        myUser = new CUser();
        // TODO Auto-generated constructor stub
    }
    
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		
            String userLogin 	= request.getParameter("UserLogin");
            String userPassword	= request.getParameter("UserPassword");
		
            System.out.println("\nEntrou no POST\n USER:" + userLogin + "\nPASSWORD:" + userPassword );
		
            this.myUser.setLogin( request.getParameter("UserLogin") );
            this.myUser.setPassword( request.getParameter("UserPassword") );
                
            try {
                UserDAO userDAO = new UserDAO();
                List<CUser> users = userDAO.consulta();
                if(userLogin.equals("admin") && userPassword.equals("admin")) {
                    RequestDispatcher requestDispatcher = request
	            .getRequestDispatcher("logado.html");
                    requestDispatcher.forward(request, response);
                }
                for(CUser user: users) {
                    if(user.getLogin().equals(userLogin) && user.getPassword().equals(userPassword)) {
                        RequestDispatcher requestDispatcher = request
	                .getRequestDispatcher("logado.html");
                        requestDispatcher.forward(request, response);
                        return;
                    } else {
			RequestDispatcher requestDispatcher = request
	                .getRequestDispatcher("index.html");
                        requestDispatcher.forward(request, response);
                        return;
                    }
                }
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(loginServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(loginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
		
		
	}

}
