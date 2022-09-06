import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<ContaBancaria> contas = new ArrayList<>();
    static int opcao = 0;

    public static void main(String[] args) {
        menuInicial();
    }

    private static void menuInicial() {
        System.out.print("""
                ---- MENU INICIAL ----
                1 - Login
                2 - Cadastrar conta
                3 - Excluir conta
                4 - Encerrar sessão
                >\s""");
        opcao = sc.nextInt();

        switch (opcao) {
            case 1 -> login();
            case 2 -> cadastrarConta();
            case 3 -> excluirConta();
            case 4 -> {
                System.out.print("\nEncerrando...\n");
                System.exit(0);
            }
            default -> {
                System.out.print("\nOpção inválida! Tente novamente: \n");
                menuInicial();
            }
        }
    }

    private static void login() {
        System.out.print("\nNúmero da conta\n> ");
        int numeroConta = sc.nextInt();

        System.out.print("\nSenha\n> ");
        int senha = sc.nextInt();

        for()
    }

    private static ContaBancaria coletarDados() {
        System.out.print("\n\n> ");
        int agencia = sc.nextInt();

        System.out.print("\nNome\n> ");
        int numero = sc.nextInt();

        System.out.print("\nEndereço\n> ");
        int senha = sc.nextInt();

        return new ContaBancaria(agencia, numero, senha, idPessoa, saldo);
    }

    private static void cadastrarConta() {

        }

    }

    private static void excluirConta() {

    }

    private static void menuConta() {
        System.out.print("\n---- MENU ----" +
                "\n1 - Sacar" +
                "\n2 - Depositar" +
                "\n3 - Transferir" +
                "\n4 - Ver dados" +
                "\n5 - Sair" +
                "\n> ");
        int opcao = sc.nextInt();

        switch (opcao) {
            case 1 -> ContaBancaria.sacar();
            case 2 -> ContaBancaria.depositar();
            case 3 -> ContaBancaria.transferir();
            case 4 -> ContaBancaria.verDados();
            case 5 -> login();
            default -> {
                System.out.print("\nOpção inválida! Tente novamente:\n");
                menuConta();
            }
        }
    }


}
