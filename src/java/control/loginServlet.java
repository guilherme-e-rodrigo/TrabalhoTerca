package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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
@WebServlet("loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CUser myUser;   
    public void init() {
    	try
    	{
    	Class.forName("com.mysql.cj.jdbc.Driver");

    	String url = "jdbc:mysql://localhost:3306/webstoragedb?useTimezone=true&serverTimezone=UTC"; //Nome da base de dados
    	String user = "root"; //nome do usuário do MySQL
    	String password = ""; //senha do MySQL



    	Connection con=DriverManager.getConnection(url,user,password);

    	Statement stmt=con.createStatement();
    	ResultSet rs=stmt.executeQuery("SELECT * FROM userinformation");
    	while(rs.next())
    	System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
    	con.close();
    	}
    	catch(Exception e)
    	{
    	System.out.println(e);
    	}
    }
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
		
//		System.out.println("\nEntrou no POST\n USER:" + myUser.getLogin() + "\nPASSWORD:" + myUser.getPassword() );
//		System.out.println(request.getContextPath());
		if(userLogin.equals("admin") && userPassword.equals("admin")) {
			RequestDispatcher requestDispatcher = request
	                .getRequestDispatcher("logado.html");
	        requestDispatcher.forward(request, response);
		} else {
			RequestDispatcher requestDispatcher = request
	                .getRequestDispatcher("index.html");
	        requestDispatcher.forward(request, response);
		}
		
		
	}

}
