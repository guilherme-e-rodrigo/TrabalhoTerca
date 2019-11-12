package control;

import dao.ArmazemDAO;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CArmazem;

/**
 * Servlet implementation class CadArmazem
 */
@WebServlet("/CadArmazem")
public class CadArmazem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadArmazem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String nome = request.getParameter("ArmazemNome");
		String localizacao = request.getParameter("ArmazemLocal");
		String capacidade = request.getParameter("ArmazemCapacidade");
		CArmazem armazem = new CArmazem();
		armazem.setCapacidade(Integer.valueOf(capacidade));
		armazem.setLocalizacao(localizacao);
		armazem.setNome(nome);
        try {
            ArmazemDAO dao = new ArmazemDAO();
            dao.Cadastra(armazem);
            
            PrintWriter out = response.getWriter();
            
            out.println("<html>");
            out.println("<body>");
            out.println("   <script>alert(\"Armazem cadastrado com sucesso\")location'cadastros.html'</script>");
            out.println("</body>");
            out.println("</html>");
            
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar armazem: " + e.getMessage());
        }
		/*RequestDispatcher requestDispatcher = request
                .getRequestDispatcher("cadastros.html");
        requestDispatcher.forward(request, response); */
		
	}

}
