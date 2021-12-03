public class Alugado {

    private String dataAlugado;
    private String dataDevolucao;
    private int codigo_filme;

    public Alugado(String dataAlugado, String dataDevolucao,int codigo_filme) {
        this.dataAlugado = dataAlugado;
        this.dataDevolucao = dataDevolucao;
        this.codigo_filme = codigo_filme;
    }

    public String getDataAlugado() {
        return dataAlugado;
    }

    public void setDataAlugado(String dataAlugado) {
        this.dataAlugado = dataAlugado;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public int getCodigo_filme() {
        return codigo_filme;
    }

    public void setCodigo_filme(int codigo_filme) {
        this.codigo_filme = codigo_filme;
    }
}
