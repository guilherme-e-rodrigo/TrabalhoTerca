package control;

import dao.ItemDAO;
import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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

import model.CArmazem;
import model.CItem;
import model.CUser;

/**
 * Servlet implementation class CadUser
 */
@WebServlet("/CadUser")
public class CadUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadUser() {
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
                String acao = request.getParameter("acao");
                if(acao.equals("Cadastrar")){
		CUser usuario = new CUser();
		String login = request.getParameter("cLogin");
		String nome = request.getParameter("cNome");
		String senha = request.getParameter("cSenha");
		String cpf = request.getParameter("cCpf");
		usuario.setCpf(cpf);
		usuario.setPassword(senha);
                System.out.println("Senha : "+senha);
		usuario.setNome(nome);
		usuario.setLogin(login);
		try {
            UserDAO dao = new UserDAO();
            dao.Cadastra(usuario);
            
            PrintWriter out = response.getWriter();
            
            out.println("<html>");
            out.println("<body>");
            out.println("   <script>alert(\"Usuario cadastrado com sucesso\")location'cadastros.html'</script>");
            out.println("</body>");
            out.println("</html>");
            
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar armazem: " + e.getMessage());
        }
        } else if (acao.equals("Excluir")){
        	try {
                System.out.println("Chegou no metodo Excluir");
                    int id = Integer.valueOf(request.getParameter("id_editar"));
                    System.out.println("você clicou no botao excluir");
                    System.out.println("id do item: " + id);

                    UserDAO dao = new UserDAO();
                        dao.remove(id);
                    //redirecionamento automatico 
                    RequestDispatcher rd = request.getRequestDispatcher("GerenciarUsuario.jsp");

                    rd.forward(request, response);
                    } catch (Exception e) {
                        System.out.println("Erro Aqui : "+e.getLocalizedMessage());
                    }
	}   else if (acao.equals("Editar")) {
                
                    try {
                        int id = Integer.valueOf(request.getParameter("id_editar"));
                        System.out.println("Você clicou no botão editar, id do Item: " + id);
                        CUser user = new CUser();
                        UserDAO dao = new UserDAO();
                        List<CUser> users;
                        users = dao.consulta();
                        for (CUser u : users) {
                            if (id == u.getId()) {
                                user = u;
                            }
                        }
                        
                        
                        System.out.println("dados do item: " + user.getId()+ " / ");
                        request.setAttribute("user", user);
                        RequestDispatcher rd = request.getRequestDispatcher("editarUser.jsp");
                        rd.forward(request, response);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(CadCategoria.class.getName()).log(Level.SEVERE, null, ex);
                        }   catch (SQLException ex) {
                        Logger.getLogger(CadCategoria.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (acao.equals("Alterar")){           
                    CUser user = new CUser();

                    int id = Integer.valueOf(request.getParameter("id"));

                        String nome = request.getParameter("Nome");
                        String cpf = request.getParameter("Cpf");
                        String login = request.getParameter("Login");
                        String senha = request.getParameter("Senha");
                        
                        user.setId(id);
                        user.setNome(nome);
                        user.setCpf(cpf);
                        user.setLogin(login);
                        user.setPassword(senha);
                        try {

                        UserDAO dao = new UserDAO();
                        dao.edita(user);
                                    RequestDispatcher rd = request.getRequestDispatcher("GerenciarUsuario.jsp");
                                    rd.forward(request, response);
                    } catch (Exception e) {
                            System.out.println("Erro aqui : "+e.getMessage());
                    }
                }
        }
}
