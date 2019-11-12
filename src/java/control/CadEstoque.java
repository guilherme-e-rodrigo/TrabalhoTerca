package control;

import dao.EstoqueDAO;
import model.Aluguel;
import dao.ItemDAO;
import dao.UserArmazemDAO;
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
import model.CEstoque;

import model.CItem;

/**
 * Servlet implementation class CadItem
 */
@WebServlet("/CadEstoque")
public class CadEstoque extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadEstoque() {
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
		int id_item = Integer.valueOf(request.getParameter("item"));
                String operacao = request.getParameter("operacao");
		Float qtd = Float.valueOf(request.getParameter("quantidade"));
                String motivo = request.getParameter("motivo");
		CEstoque estoque = new CEstoque();
                estoque.setId_item(id_item);
                estoque.setMotivo(motivo);
                estoque.setOperacao(operacao);
                estoque.setQtd(qtd);
		 try {
	            EstoqueDAO dao = new EstoqueDAO();
	            dao.Cadastra(estoque);
	            
	            PrintWriter out = response.getWriter();
	            
	            out.println("<html>");
	            out.println("<body>");
	            out.println("   <script>alert(\"Item cadastrado com sucesso\")location'CadEstoque.jsp'</script>");
	            out.println("</body>");
	            out.println("</html>");
	            RequestDispatcher rd = request.getRequestDispatcher("CadEstoque.jsp");
	        } catch (Exception e) {
	            System.out.println("Erro ao cadastrar item: " + e.getMessage());
	        }
                } else if (acao.equals("Excluir")){
                    try {
                System.out.println("Chegou no metodo Excluir");
                    int id = Integer.valueOf(request.getParameter("id_editar"));
                    System.out.println("você clicou no botao excluir");
                    System.out.println("id do item: " + id);

                    EstoqueDAO dao = new EstoqueDAO();
                        dao.remove(id);
                    //redirecionamento automatico 
                    RequestDispatcher rd = request.getRequestDispatcher("GerenciarEstoque.jsp");

                    rd.forward(request, response);
                    } catch (Exception e) {
                        System.out.println("Erro Aqui : "+e.getLocalizedMessage());
                    }
                } else if (acao.equals("Editar")) {
                
                    try {
                        int id = Integer.valueOf(request.getParameter("id_editar"));
                        System.out.println("Você clicou no botão editar, id do Item: " + id);
                        CEstoque estoque = new CEstoque();
                        EstoqueDAO dao = new EstoqueDAO();
                        List<CEstoque> itens;
                        itens = dao.consulta();
                        for (CEstoque i : itens) {
                            if (id == i.getId()) {
                                estoque = i;
                            }
                        }
                        System.out.println("chegou");
                        request.setAttribute("estoque", estoque);
                        System.out.println("setou attributo");
                        RequestDispatcher rd = request.getRequestDispatcher("editarEstoque.jsp");
                        rd.forward(request, response);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(CadCategoria.class.getName()).log(Level.SEVERE, null, ex);
                        }   catch (SQLException ex) {
                        Logger.getLogger(CadCategoria.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (acao.equals("Alterar")){           
                    CEstoque e = new CEstoque();

                    int id = Integer.valueOf(request.getParameter("id"));

                        int id_item = Integer.valueOf(request.getParameter("id_item"));
                        String motivo = request.getParameter("motivo");
                        String operacao = request.getParameter("operacao");
                        Float qtd = Float.valueOf(request.getParameter("quantidade"));
                       
                        e.setId(id);
                        e.setId_item(id_item);
                        e.setMotivo(motivo);
                        e.setOperacao(operacao);
                        e.setQtd(qtd);
                        try {

                        EstoqueDAO dao = new EstoqueDAO();
                        dao.edita(e);
                                    RequestDispatcher rd = request.getRequestDispatcher("GerenciarEstoque.jsp");
                                    rd.forward(request, response);
                    } catch (Exception error) {
                            System.out.println("Erro aqui : "+error.getMessage());
                    }
                }
	}

}
