package control;

import dao.CategoriaDAO;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CCategoria;

/**
 * Servlet implementation class CadCategoria
 */
@WebServlet("/CadCategoria")
public class CadCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadCategoria() {
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
		String nome = request.getParameter("catNome");
		String descricao = request.getParameter("catDescricao");
		
		CCategoria categoria = new CCategoria();
                categoria.setNome(nome);
                categoria.setDescricao(descricao);
		
		try {
			CategoriaDAO dao = new CategoriaDAO();
			dao.Cadastra(categoria);
			
			 PrintWriter out = response.getWriter();
	            
	            out.println("<html>");
	            out.println("<body>");
	            out.println("   <script>alert(\"Categoria cadastrada com sucesso\")location'cadastros.html'</script>");
	            out.println("</body>");
	            out.println("</html>");
	            
		} catch (Exception e) {
			System.out.println("Erro ao cadastrar categoria: " + e.getMessage());
		}
	}

}
