package dao;

import model.Aluguel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.ConexaoBD;
import model.CArmazem;

public class UserArmazemDAO {
    
    private Connection con;

    public UserArmazemDAO() throws ClassNotFoundException {
            this.con = new ConexaoBD().getConnection();
            System.out.println("Conectado!");
    }
    
    public void edita(Aluguel aluguel) throws SQLException{
        String sql = "update usuario_armazem set id_usuario = ?, id_armazem = ?, dataaluguel = ? where id = ?;";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, aluguel.getId_usuario());
        System.out.println("ID user : "+aluguel.getId_usuario());
        st.setInt(2, aluguel.getId_armazem());
        System.out.println("ID Armazem : "+aluguel.getId_armazem());
        System.out.println("ID aluguel : "+aluguel.getId_aluguel());
        st.setString(3, aluguel.getDataaluguel());
        st.setInt(4, aluguel.getId_aluguel());
        st.execute();
        con.close();
    }

    public void Cadastra(Aluguel aluguel) throws SQLException {

        String sql = "insert into usuario_armazem (id_usuario, id_armazem, dataaluguel) values (?, ?, ?);";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, aluguel.getId_usuario());
        st.setInt(2, aluguel.getId_armazem());
        st.setString(3, aluguel.getDataaluguel());
        st.execute();
        con.close();
        
    }
    
    public List<Aluguel> consulta() throws SQLException {
        
            List<Aluguel> aluguel = new ArrayList();
            PreparedStatement st = con.prepareStatement("select * from usuario_armazem order by id;");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Aluguel alugueis = new Aluguel();
                alugueis.setId_aluguel(rs.getInt("id"));
                alugueis.setId_usuario(rs.getInt("id_usuario"));
                alugueis.setId_armazem(rs.getInt("id_armazem"));
                alugueis.setDataaluguel(rs.getString("dataaluguel"));
                aluguel.add(alugueis);
            }
            rs.close();
            st.close();
            con.close();
            return aluguel;
   }
       
    public void remove(int id) throws SQLException {
        try {
            PreparedStatement st = con.prepareStatement("delete from usuario_armazem where id = ?;");
            st.setInt(1, id);
            st.execute();
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        con.close();
    }
    
}
