package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.ConexaoBD;
import model.CCategoria;
import model.CUser;

public class CategoriaDAO {
    
    private Connection con;

    public CategoriaDAO() throws ClassNotFoundException {
            this.con = new ConexaoBD().getConnection();
            System.out.println("Conectado!");
    }
    
    public void edita(CCategoria categoria) throws SQLException{
        String sql = "update categoria set nome = ?, descricao = ? where id = ?;";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, categoria.getNome());
        st.setString(2, categoria.getDescricao());
        st.setInt(3, categoria.getId());
        st.execute();
        con.close();
    }

    public void Cadastra(CCategoria categoria) throws SQLException {

        String sql = "insert into categoria (nome, descricao) values (?, ?);";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, categoria.getNome());
        st.setString(2, categoria.getDescricao());
        st.execute();
        con.close();
        
    }
    
    public List<CCategoria> consulta() throws SQLException {
        
            List<CCategoria> categorias = new ArrayList();
            PreparedStatement st = con.prepareStatement("select * from categoria order by id;");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CCategoria categoria = new CCategoria();
                categoria.setId(rs.getInt("id"));
                categoria.setNome(rs.getString("nome"));
                categoria.setDescricao(rs.getString("descricao"));
                categorias.add(categoria);
            }
            rs.close();
            st.close();
            con.close();
            return categorias;
   }
       
    public void remove(int id) throws SQLException {
        try {
            PreparedStatement st = con.prepareStatement("delete from categoria where id = ?;");
            st.setInt(1, id);
            st.execute();
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        con.close();
    }
    
}
