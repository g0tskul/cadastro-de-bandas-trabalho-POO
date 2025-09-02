// VIEW
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        BandaController controller = new BandaController();
        controller.carregarBackup();
        Scanner sc = new Scanner(System.in);


        while (true) {
            System.out.println("\n*+*+* MENU *+*+*");
            System.out.println("Seja bem-vindo/a ao Cadastro de Bandas!");
            System.out.println("1→ Cadastrar sua banda");
            System.out.println("2→ Adicionar um membro sua banda");
            System.out.println("3→ Listar bandas");
            System.out.println("4→ Mostrar resultado");
            System.out.println("5→ Sair do Sistema");
            System.out.print("Qual será a sua opção? ");
            int op = sc.nextInt(); sc.nextLine();


            if (op == 1) {
                System.out.print("*ID da banda: ");
                String id = sc.nextLine();
                System.out.print("*Nome da banda: ");
                String nome = sc.nextLine();
                System.out.print("*Gênero musical: ");
                String genero = sc.nextLine();
                System.out.print("Cidade: ");
                String cidade = sc.nextLine();
                System.out.print("*Ano de formação: ");
                int ano = sc.nextInt(); sc.nextLine();
                controller.cadastrarBanda(new Banda(id, nome, genero, cidade, ano));


            } else if (op == 2) {
                System.out.print("*ID da banda: ");
                String idBanda = sc.nextLine();
                System.out.print("*ID do membro: ");
                String idM = sc.nextLine();
                System.out.print("*Nome do membro: ");
                String nome = sc.nextLine();
                System.out.print("*Função: ");
                String funcao = sc.nextLine();
                System.out.print("*Contato: ");
                String contato = sc.nextLine();
                controller.adicionarMembro(idBanda, new Membro(idM, nome, funcao, contato));


            } else if (op == 3) {
                controller.listarBandas();


            } else if (op == 4) {
                controller.gerarRelatorio();
                System.out.println("relatorio_bandas.txt");


            } else if (op == 5) {
                break;


            } else {
                System.out.println("Opção inválida.");
            }
        }


        sc.close();
    }
}





