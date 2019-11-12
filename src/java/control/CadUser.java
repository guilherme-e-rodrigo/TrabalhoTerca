package control;

import dao.ItemDAO;
import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CArmazem;
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
        } else if (acao.equals("Excluir"));
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
	}

}
