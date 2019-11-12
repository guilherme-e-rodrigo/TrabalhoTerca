package control;

import dao.ArmazemDAO;
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
                
                String acao = request.getParameter("acao"); //busca o value do botao clicado
        
        
                if (acao.equals("Cadastrar")) {
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
		
	}else if (acao.equals("Excluir")){
            try {
                    int id = Integer.valueOf(request.getParameter("id_editar"));

                    ArmazemDAO dao = new ArmazemDAO();
                        dao.remove(id);
                    //redirecionamento automatico 
                    RequestDispatcher rd = request.getRequestDispatcher("GerenciarArmazem.jsp");

                    rd.forward(request, response);
                    } catch (Exception e) {
                        System.out.println("Erro Aqui : "+e.getLocalizedMessage());
                    }
        } else if (acao.equals("Editar")) {
                
                    try {
                        int id = Integer.valueOf(request.getParameter("id_editar"));
                        System.out.println("Você clicou no botão editar, id do armazem: " + id);
                        CArmazem armazem = new CArmazem();
                        ArmazemDAO dao = new ArmazemDAO();
                        List<CArmazem> armazens;
                        armazens = dao.consulta();
                        for (CArmazem a : armazens) {
                            if (id == a.getId()) {
                                armazem = a;
                            }
                        }
                        
                        
                        System.out.println("dados do documento: " + armazem.getId()+ " / ");
                        request.setAttribute("armazem", armazem);
                        RequestDispatcher rd = request.getRequestDispatcher("editarArmazem.jsp");
                        rd.forward(request, response);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(CadArmazem.class.getName()).log(Level.SEVERE, null, ex);
                        }   catch (SQLException ex) {
                        Logger.getLogger(CadArmazem.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (acao.equals("Alterar")){           
                    CArmazem armazem = new CArmazem();

                    int id = Integer.valueOf(request.getParameter("id"));

                        String nome = request.getParameter("Nome");
                        int capacidade = Integer.valueOf(request.getParameter("Capacidade"));
                        String localizacao = request.getParameter("Localizacao");
                        armazem.setId(id);
                        armazem.setNome(nome);
                        armazem.setCapacidade(capacidade);
                        armazem.setLocalizacao(localizacao);
                        try {

                        ArmazemDAO dao = new ArmazemDAO();
                        dao.edita(armazem);
                                    RequestDispatcher rd = request.getRequestDispatcher("GerenciarArmazem.jsp");
                                    rd.forward(request, response);
                    } catch (Exception e) {
                            System.out.println("Erro aqui : "+e.getMessage());
                    }

            
        }
        }

}
