package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.ConexaoBD;
import model.CArmazem;

public class ArmazemDAO {
    
    private Connection con;

    public ArmazemDAO() throws ClassNotFoundException {
            this.con = new ConexaoBD().getConnection();
            System.out.println("Conectado!");
    }
    
    public void edita(CArmazem armazem) throws SQLException{
        String sql = "update armazem set nome = ?, localizacao = ?, capacidade = ? where id = ?;";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, armazem.getNome());
        st.setString(2, armazem.getLocalizacao());
        st.setInt(3, armazem.getCapacidade());
        st.setInt(5, armazem.getId());
        st.execute();
        con.close();
    }

    public void Cadastra(CArmazem armazem) throws SQLException {

        String sql = "insert into armazem (nome, localizacao, capacidade) values (?, ?, ?);";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, armazem.getNome());
        st.setString(2, armazem.getLocalizacao());
        st.setInt(3, armazem.getCapacidade());
        st.execute();
        con.close();
        
    }
    
    public List<CArmazem> consulta() throws SQLException {
        
            List<CArmazem> armazens = new ArrayList();
            PreparedStatement st = con.prepareStatement("select * from armazem order by id;");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CArmazem armazem = new CArmazem();
                armazem.setCapacidade(rs.getInt("capacidade"));
                armazem.setId(rs.getInt("id"));
                armazem.setLocalizacao(rs.getString("localizacao"));
                armazem.setNome(rs.getString("nome"));
                armazens.add(armazem);
            }
            rs.close();
            st.close();
            con.close();
            return armazens;
   }
       
    public void remove(int id) throws SQLException {
        try {
            PreparedStatement st = con.prepareStatement("delete from armazem where id = ?;");
            st.setInt(1, id);
            st.execute();
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        con.close();
    }
    
}
