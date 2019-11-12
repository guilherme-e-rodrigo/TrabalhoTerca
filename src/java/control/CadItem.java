package control;

import dao.CategoriaDAO;
import dao.ItemDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CCategoria;

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
		 String acao = request.getParameter("acao"); //busca o value do botao clicado
        
        
                if (acao.equals("Cadastrar")) {
		String nome = request.getParameter("Nome");
		String descricao = request.getParameter("Descricao");
		String medidas = request.getParameter("Medidas");
		String armazenamento = request.getParameter("Armazenamento");
		CItem item = new CItem();
                item.setNome(nome);
                item.setDescricao(descricao);
                item.setMedidas(medidas);
                item.setForma_armazenamento(armazenamento);
		int idCategoria = Integer.valueOf(request.getParameter("categoria"))    ;
                item.setId_categoria(idCategoria);
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
                } else if (acao.equals("Excluir")){
                    try {
                System.out.println("Chegou no metodo Excluir");
                    int id = Integer.valueOf(request.getParameter("id_editar"));
                    System.out.println("você clicou no botao excluir");
                    System.out.println("id do item: " + id);

                    ItemDAO dao = new ItemDAO();
                        dao.remove(id);
                    //redirecionamento automatico 
                    RequestDispatcher rd = request.getRequestDispatcher("GerenciarItem.jsp");

                    rd.forward(request, response);
                    } catch (Exception e) {
                        System.out.println("Erro Aqui : "+e.getLocalizedMessage());
                    }
                } else if (acao.equals("Editar")) {
                
                    try {
                        int id = Integer.valueOf(request.getParameter("id_editar"));
                        System.out.println("Você clicou no botão editar, id do Item: " + id);
                        CItem item = new CItem();
                        ItemDAO dao = new ItemDAO();
                        List<CItem> itens;
                        itens = dao.consulta();
                        for (CItem i : itens) {
                            if (id == i.getId()) {
                                item = i;
                            }
                        }
                        
                        
                        System.out.println("dados do item: " + item.getId()+ " / ");
                        request.setAttribute("item", item);
                        RequestDispatcher rd = request.getRequestDispatcher("editarItem.jsp");
                        rd.forward(request, response);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(CadCategoria.class.getName()).log(Level.SEVERE, null, ex);
                        }   catch (SQLException ex) {
                        Logger.getLogger(CadCategoria.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (acao.equals("Alterar")){           
                    CItem item = new CItem();

                    int id = Integer.valueOf(request.getParameter("id"));

                        String nome = request.getParameter("Nome");
                        String descricao = request.getParameter("Descricao");
                        String Medida = request.getParameter("Medida");
                        String Armazenamento = request.getParameter("Armazenamento");
                        int idCategoria = Integer.valueOf(request.getParameter("categoria"));
                        item.setId_categoria(idCategoria);
                        item.setId(id);
                        item.setNome(nome);
                        item.setDescricao(descricao);
                        item.setMedidas(Medida);
                        item.setForma_armazenamento(Armazenamento);
                        try {

                        ItemDAO dao = new ItemDAO();
                        dao.edita(item);
                                    RequestDispatcher rd = request.getRequestDispatcher("GerenciarItem.jsp");
                                    rd.forward(request, response);
                    } catch (Exception e) {
                            System.out.println("Erro aqui : "+e.getMessage());
                    }
                }
	}

}
