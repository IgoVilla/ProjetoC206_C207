import java.sql.SQLException;
import java.util.ArrayList;

public class FilmeDAO extends ConnectionDAO {
    boolean aprovado = false;

    //DAO -DATA ACCESS OBJECT
    public boolean inserirFilme(Filme filme) {
        connectToDB();
        String sql = "INSERT INTO filme (nome, genero,disponivel, codigo) values(?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, filme.getNome());
            pst.setString(2, filme.getGenero());
            pst.setBoolean(3, filme.isDisponivel());
            pst.setInt(4, filme.getCodigo());

            pst.execute();
            aprovado = true;
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            aprovado = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }

        return aprovado;
    }
    public boolean atualizarFilme(int id,boolean alug) {
        connectToDB();
        String sql = "UPDATE filme SET disponivel=? where codigo=?";

        try {
            pst = con.prepareStatement(sql);
            pst.setBoolean(1, alug);
            pst.setInt(2, id);
            pst.execute();
            aprovado = true;

        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            aprovado = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return aprovado;
    }
    public ArrayList<Filme> buscaFilmes() {
        ArrayList<Filme> listaFilmes = new ArrayList<>();

        connectToDB();

        String sql = "SELECT * FROM filme";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Filme filmeAux = new Filme();
                filmeAux.setNome(rs.getString("nome"));
                filmeAux.setGenero(rs.getString("genero"));
                filmeAux.setCodigo(rs.getInt("codigo"));
                filmeAux.setDisponivel((rs.getBoolean("disponivel")));

                    listaFilmes.add(filmeAux);
            }
            aprovado = true;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            aprovado = false;
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        return listaFilmes;
    }



}
