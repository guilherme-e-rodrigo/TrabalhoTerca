package control;

import dao.CategoriaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;

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
                String acao = request.getParameter("acao");
                if(acao.equals("Cadastrar")){
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
                } else if(acao.equals("Excluir")){
                    try {
                    System.out.println("Chegou no metodo Excluir");
                    int id = Integer.valueOf(request.getParameter("id_editar"));
                    System.out.println("você clicou no botao excluir");
                    System.out.println("id do item: " + id);

                    CategoriaDAO dao = new CategoriaDAO();
                        dao.remove(id);
                    //redirecionamento automatico 
                        RequestDispatcher rd = request.getRequestDispatcher("GerenciarCategoria.jsp");

                    rd.forward(request, response);
                    } catch (Exception e) {
                        System.out.println("Erro Aqui : "+e.getLocalizedMessage());
                    }
                }
	}

}
