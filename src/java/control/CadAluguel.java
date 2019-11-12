package control;

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

import model.CItem;

/**
 * Servlet implementation class CadItem
 */
@WebServlet("/CadAluguel")
public class CadAluguel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadAluguel() {
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
		int id_usuario = Integer.valueOf(request.getParameter("usuario"));
                int id_armazem = Integer.valueOf(request.getParameter("armazem"));
		String dataaluguel = request.getParameter("dataaluguel");
		Aluguel a = new Aluguel();
                a.setId_armazem(id_armazem);
                a.setId_usuario(id_usuario);
                a.setDataaluguel(dataaluguel);
		 try {
	            UserArmazemDAO dao = new UserArmazemDAO();
	            dao.Cadastra(a);
	            
	            PrintWriter out = response.getWriter();
	            
	            out.println("<html>");
	            out.println("<body>");
	            out.println("   <script>alert(\"Item cadastrado com sucesso\")location'cadastros.html'</script>");
	            out.println("</body>");
	            out.println("</html>");
	            RequestDispatcher rd = request.getRequestDispatcher("GerenciarAluguel.jsp");
	        } catch (Exception e) {
	            System.out.println("Erro ao cadastrar item: " + e.getMessage());
	        }
                } else if (acao.equals("Excluir")){
                    try {
                System.out.println("Chegou no metodo Excluir");
                    int id = Integer.valueOf(request.getParameter("id_editar"));
                    System.out.println("você clicou no botao excluir");
                    System.out.println("id do item: " + id);

                    UserArmazemDAO dao = new UserArmazemDAO();
                        dao.remove(id);
                    //redirecionamento automatico 
                    RequestDispatcher rd = request.getRequestDispatcher("GerenciarAluguel.jsp");

                    rd.forward(request, response);
                    } catch (Exception e) {
                        System.out.println("Erro Aqui : "+e.getLocalizedMessage());
                    }
                } else if (acao.equals("Editar")) {
                
                    try {
                        int id = Integer.valueOf(request.getParameter("id_editar"));
                        System.out.println("Você clicou no botão editar, id do Item: " + id);
                        Aluguel a = new Aluguel();
                        UserArmazemDAO dao = new UserArmazemDAO();
                        List<Aluguel> alugueis;
                        alugueis = dao.consulta();
                        for (Aluguel i : alugueis) {
                            if (id == i.getId_aluguel()) {
                                a = i;
                            }
                        }
                        
                        
                        System.out.println("dados do item: " + a.getId_aluguel()+ " / ");
                        request.setAttribute("aluguel", a);
                        RequestDispatcher rd = request.getRequestDispatcher("EditarAluguel.jsp");
                        rd.forward(request, response);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(CadCategoria.class.getName()).log(Level.SEVERE, null, ex);
                        }   catch (SQLException ex) {
                        Logger.getLogger(CadCategoria.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (acao.equals("Alterar")){           
                    Aluguel a = new Aluguel();

                    int id = Integer.valueOf(request.getParameter("id"));

                        int id_usuario = Integer.valueOf(request.getParameter("usuario"));
                        int id_armazem = Integer.valueOf(request.getParameter("armazem"));
                        String dataAluguel = request.getParameter("dataaluguel");
                       a.setId_aluguel(id);
                       a.setId_armazem(id_armazem);
                       a.setId_usuario(id_usuario);
                       a.setDataaluguel(dataAluguel);
                        try {

                        UserArmazemDAO dao = new UserArmazemDAO();
                        dao.edita(a);
                                    RequestDispatcher rd = request.getRequestDispatcher("GerenciarAluguel.jsp");
                                    rd.forward(request, response);
                    } catch (Exception e) {
                            System.out.println("Erro aqui : "+e.getMessage());
                    }
                }
	}

}
