package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.ConexaoBD;
import model.CUser;

public class UserDAO {
    
    private Connection con;

    public UserDAO() throws ClassNotFoundException {
            this.con = new ConexaoBD().getConnection();
            System.out.println("Conectado!");
    }
    
    public void edita(CUser user) throws SQLException{
        String sql = "update usuario set user_login = ?, user_password = ?, nome = ?, cpf = ? where id = ?;";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, user.getLogin());
        st.setString(2, user.getPassword());
        st.setString(3, user.getNome());
        st.setString(4, user.getCpf());
        st.setInt(5, user.getId());
        st.execute();
        con.close();
    }

    public void Cadastra(CUser user) throws SQLException {

        String sql = "insert into usuario (user_login, user_password, nome, cpf) values (?, ?, ?, ?);";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, user.getLogin());
        st.setString(2, user.getPassword());
        st.setString(3, user.getNome());
        st.setString(4, user.getCpf());
        st.execute();
        con.close();
        
    }
    
    public List<CUser> consulta() throws SQLException {
        
            List<CUser> users = new ArrayList();
            PreparedStatement st = con.prepareStatement("select * from usuario order by id;");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CUser user = new CUser();
                user.setId(rs.getInt("id"));
                user.setLogin(rs.getString("user_login"));
                user.setPassword(rs.getString("user_password"));
                user.setCpf(rs.getString("cpf"));
                user.setNome(rs.getString("nome"));
                users.add(user);
            }
            rs.close();
            st.close();
            con.close();
            return users;
   }
       
    public void remove(int id) throws SQLException {
        try {
            PreparedStatement st = con.prepareStatement("delete from usuario where id = ?;");
            st.setInt(1, id);
            st.execute();
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        con.close();
    }
    
}
