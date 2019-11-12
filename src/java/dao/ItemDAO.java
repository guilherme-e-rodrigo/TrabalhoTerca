package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.ConexaoBD;
import model.CItem;

public class ItemDAO {
    
    private Connection con;

    public ItemDAO() throws ClassNotFoundException {
            this.con = new ConexaoBD().getConnection();
            System.out.println("Conectado!");
    }
    
    public void edita(CItem item) throws SQLException{
        String sql = "update item set nome = ?, descricao = ?, medidas = ?, forma_armazenamento = ?, id_categoria = ? where id = ?;";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, item.getNome());
        st.setString(2, item.getDescricao());
        st.setString(3, item.getMedidas());
        st.setString(4, item.getForma_armazenamento());
        st.setInt(5, item.getId_categoria());
        st.setInt(6, item.getId());
        st.execute();
        con.close();
    }

    public void Cadastra(CItem item) throws SQLException {

        String sql = "insert into item (nome, descricao, medidas, forma_armazenamento, id_categoria) values (?, ?, ?, ?, ?);";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, item.getNome());
        st.setString(2, item.getDescricao());
        st.setString(3, item.getMedidas());
        st.setString(4, item.getForma_armazenamento());
        st.setInt(5, item.getId_categoria());
        st.execute();
        con.close();
        
    }
    
    public List<CItem> consulta() throws SQLException {
        
            List<CItem> itens = new ArrayList();
            PreparedStatement st = con.prepareStatement("select * from item order by id;");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CItem item = new CItem();
                item.setId(rs.getInt("id"));
                item.setDescricao(rs.getString("descricao"));
                item.setForma_armazenamento(rs.getString("forma_armazenamento"));
                item.setId_categoria(rs.getInt("id_categoria"));
                item.setMedidas(rs.getString("medidas"));
                item.setNome(rs.getString("nome"));
                itens.add(item);
            }
            rs.close();
            st.close();
            con.close();
            return itens;
   }
       
    public void remove(int id) throws SQLException {
        try {
            PreparedStatement st = con.prepareStatement("delete from item where id = ?;");
            st.setInt(1, id);
            st.execute();
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        con.close();
    }
    
}

