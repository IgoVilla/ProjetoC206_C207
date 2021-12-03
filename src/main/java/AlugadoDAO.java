import java.sql.SQLException;

public class AlugadoDAO extends  ConnectionDAO {

        boolean aprovado = false;
        FilmeDAO filmeDA01 = new FilmeDAO();

        //DAO -DATA ACCESS OBJECT
        public boolean inserirAlugado(Alugado alugado) {
            connectToDB();
            String sql = "INSERT INTO alugado (data_Alugado, data_Devolucao,codigo_filme) values(?,?,?)";
            try {
                pst = con.prepareStatement(sql);
                pst.setString(1, alugado.getDataAlugado());
                pst.setString(2, alugado.getDataDevolucao());
                pst.setInt(3, alugado.getCodigo_filme());

                filmeDA01.atualizarFilme(alugado.getCodigo_filme(),true);

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
        public boolean deletarAlugado(int codigo) {
        connectToDB();
        String sql = "DELETE FROM alugado where codigo_filme=?";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, codigo);
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

}



