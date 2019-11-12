package dao;

import model.CEstoque;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.ConexaoBD;

public class EstoqueDAO {
    
    private Connection con;

    public EstoqueDAO() throws ClassNotFoundException {
            this.con = new ConexaoBD().getConnection();
            System.out.println("Conectado!");
    }
    
    public void edita(CEstoque estoque) throws SQLException{
        try {
            
        
        String sql = "update historico_itens set id_item = ?, operacao = ?, qtd= ?, motivo= ? where id = ?;";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, estoque.getId_item());
        st.setString(2, estoque.getOperacao());
        st.setFloat(3, estoque.getQtd());
        st.setString(4, estoque.getMotivo());
        st.setInt(5, estoque.getId());
        st.execute();
        con.close();
        } catch (Exception e) {
            System.out.println("Error : "+e.getLocalizedMessage());
        }
    }

    public void Cadastra(CEstoque estoque) throws SQLException {

        String sql = "insert into historico_itens (id_item, operacao, qtd, motivo) values (?, ?, ?, ?);";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, estoque.getId_item());
        st.setString(2, estoque.getOperacao());
        st.setFloat(3, estoque.getQtd());
        st.setString(4, estoque.getMotivo());
        st.execute();
        con.close();
        
    }
    
    public List<CEstoque> consulta() throws SQLException {
        
            List<CEstoque> itens = new ArrayList();
            PreparedStatement st = con.prepareStatement("select * from historico_itens order by id;");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CEstoque estoque = new CEstoque();
                estoque.setId_item(rs.getInt("id_item"));
                estoque.setOperacao(rs.getString("operacao"));
                estoque.setQtd(rs.getFloat("qtd"));
                estoque.setMotivo(rs.getString("motivo"));
                estoque.setId(rs.getInt("id"));
                itens.add(estoque);
            }
            rs.close();
            st.close();
            con.close();
            return itens;
   }
       
    public void remove(int id) throws SQLException {
        try {
            PreparedStatement st = con.prepareStatement("delete from historico_itens where id = ?;");
            st.setInt(1, id);
            st.execute();
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        con.close();
    }
    
}
