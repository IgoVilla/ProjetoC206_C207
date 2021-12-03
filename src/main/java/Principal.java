import java.util.*;

public class Principal {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int op = 1;
        boolean flag = true;
        Filme f = new Filme();
        ClienteDAO c2 = new ClienteDAO();
        AlugadoDAO a2 = new AlugadoDAO();
        ArrayList<Filme> f2 = new ArrayList<>();
        FilmeDAO f3 = new FilmeDAO();


        while (flag) {
            System.out.println("1 - Cadastro Cliente");
            System.out.println("2 - Locação Filme");
            System.out.println("3 - Devolução Filme");
            System.out.println("4 - Filmes Diponiveis");
            System.out.println("5 - Sair");

            op = scan.nextInt();
            scan.nextLine();

            switch (op) {
                case 1:
                    System.out.println("Nome:");
                    String nome = scan.nextLine();
                    System.out.println("CPF:");
                    String Cpf = scan.nextLine();
                    System.out.println("Endereço:");
                    String endereco = scan.nextLine();
                    Cliente c = new Cliente(nome, Cpf, endereco);
                    c2.inserirCliente(c);

                    break;

                case 2:
                    System.out.println("Data Locação:");
                    String dataAlugado = scan.nextLine();
                    System.out.println("Data Devolução:");
                    String dataDeVolucao = scan.nextLine();
                    boolean disponivel = false;
                    boolean alugado = true;
                    System.out.println("Código Filme:");
                    int codigo_filme = scan.nextInt();
                    f2 = f3.buscaFilmes();
                    for (int i = 0; i < f2.size(); i++) {
                        if (f2.get(i).getCodigo() == codigo_filme&&f2.get(i).isDisponivel()==true) {
                            System.out.println("Este filme está alugado!");
                            alugado = false;
                        }
                    }
                        if (alugado == true) {
                            Alugado a = new Alugado(dataAlugado, dataDeVolucao, codigo_filme);
                            a2.inserirAlugado(a);
                        }
                        break;

                        case 3:
                            System.out.println("Codigo Filme:");
                            int codigo = scan.nextInt();
                            a2.deletarAlugado(codigo);
                            System.out.println("Filme Devolvido!");
                            break;
                        case 4:
                            f2 = f3.buscaFilmes();
                            for (int i = 0; i < f2.size(); i++) {
                                if (f2.get(i).isDisponivel() != true) {
                                    System.out.println(f2.get(i).getNome());
                                    System.out.println(f2.get(i).getGenero());
                                    System.out.println(f2.get(i).getCodigo());
                                }

                            }
                            break;
                        case 5:
                            flag = false;

                            break;


                    }

            }
        }
    }




