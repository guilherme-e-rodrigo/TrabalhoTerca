package control;

import dao.ItemDAO;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CItem;

/**
 * Servlet implementation class CadItem
 */
@WebServlet("/CadItem")
public class CadItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadItem() {
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
		
		String nome = request.getParameter("Nome");
		String descricao = request.getParameter("Descricao");
		String medidas = request.getParameter("Medidas");
		String armazenamento = request.getParameter("Armazenamento");
		CItem item = new CItem();
                item.setNome(nome);
                item.setDescricao(descricao);
                item.setMedidas(medidas);
                item.setForma_armazenamento(armazenamento);
		int idCategoria = Integer.valueOf(request.getParameter("id_Categoria"));
		 try {
	            ItemDAO dao = new ItemDAO();
	            dao.Cadastra(item);
	            
	            PrintWriter out = response.getWriter();
	            
	            out.println("<html>");
	            out.println("<body>");
	            out.println("   <script>alert(\"Item cadastrado com sucesso\")location'cadastros.html'</script>");
	            out.println("</body>");
	            out.println("</html>");
	            
	        } catch (Exception e) {
	            System.out.println("Erro ao cadastrar item: " + e.getMessage());
	        }
	}

}
