import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<ContaBancaria> contas = new ArrayList<>();
    static ArrayList<Pessoa> pessoas = new ArrayList<>();
    static int opcao = 0;

    public static void main(String[] args) {
        pessoas.add(new PessoaFisica(1, "Camilly", "Rua João Bosco, 123", "123.456.789-10", "Estudante", 0));
        pessoas.add(new PessoaFisica(2, "Taiany", "Rua Bosco João, 321", "109.876.543-21", "Estudante", 0));
        contas.add(new ContaBancaria(1, 1, 1234, 1, 100.0));
        menuInicial();
    }

    private static void menuInicial() {
        System.out.print("---- MENU INICIAL ----" +
                "\n1 - Login" +
                "\n2 - Cadastrar conta" +
                "\n3 - Excluir conta" +
                "\n4 - Cadastrar pessoa" +
                "\n5 - Excluir pessoa" +
                "\n6 - Encerrar sessão" +
                "\n> ");
        opcao = sc.nextInt();

        switch (opcao) {
            case 1 -> login();
            case 2 -> cadastrarConta();
            case 3 -> excluirConta();
            case 4 -> cadastrarPessoa();
            case 5 -> excluirPessoa();
            case 6 -> {
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

        for (ContaBancaria conta : contas) {
            if (conta.getNumero() == numeroConta) {
                if (conta.getSenha() == senha) {
                    ContaBancaria contaUsuario = conta;
                    menuConta(contaUsuario);
                } else {
                    System.out.print("\nSenha inválida! Tente novamente: ");
                    login();
                }
            } else {
                System.out.print("\nNúmero inválido! Tente novamente: ");
                login();
            }
        }
    }

    private static void cadastrarConta() {
        System.out.print("\nAgência\n> ");
        int agencia = sc.nextInt();

        System.out.print("\nNúmero\n> ");
        int numero = sc.nextInt();

        for (ContaBancaria conta : contas) {
            if (conta.getNumero() == numero) {
                System.out.print("\nNúmero já cadastrado! Tente novamente:");
                cadastrarConta();
            }
        }

        System.out.print("\nSenha\n> ");
        int senha = sc.nextInt();

        System.out.print("\nID do proprietário\n> ");
        int idPessoa = sc.nextInt();

        boolean verificaPessoa = false;

        for (Pessoa pessoa : pessoas) {
            if (pessoa.getId() == idPessoa) {
                verificaPessoa = true;
                break;
            }
        }

        if (!verificaPessoa) {
            System.out.print("\nID do proprietário inválido! Tente novamente:");
            cadastrarConta();
        }

        System.out.print("\nSaldo\n> ");
        double saldo = sc.nextDouble();

        contas.add(new ContaBancaria(agencia, numero, senha, idPessoa, saldo));
        System.out.print("\nConta cadastrada com sucesso!\n\n");
        menuInicial();
    }

    private static void excluirConta() {
        System.out.print("\nQual o número da conta que desejas excluir?\n> ");
        int numero = sc.nextInt();

        for (ContaBancaria conta : contas) {
            if (conta.getNumero() == numero) {
                contas.remove(conta);
                System.out.print("\nConta excluída com sucesso!\n\n");
                menuInicial();
            } else {
                System.out.print("\nNúmero inválido! Tente novamente:");
                excluirConta();
            }
        }
    }

    private static void cadastrarPessoa() {

    }

    private static void excluirPessoa() {

    }

    private static void menuConta(ContaBancaria contaUsuario) {
        System.out.print("\nBem-vindo novamente!\n" +
                "\n---- MENU CONTA ----" +
                "\n1 - Sacar" +
                "\n2 - Depositar" +
                "\n3 - Transferir" +
                "\n4 - Ver dados" +
                "\n5 - Sair" +
                "\n> ");
        opcao = sc.nextInt();

        switch (opcao) {
            case 1 -> sacar(contaUsuario);
            case 2 -> depositar(contaUsuario);
            case 3 -> transferir(contaUsuario);
            case 4 -> contaUsuario.toString();
            case 5 -> {
                System.out.print("\nSaindo...\n");
                menuInicial();
            }
            default -> {
                System.out.print("\nOpção inválida! Tente novamente:\n");
                menuConta(contaUsuario);
            }
        }
    }

    private static void sacar(ContaBancaria contaUsuario) {

    }

    private static void depositar(ContaBancaria contaUsuario) {

    }

    private static void transferir(ContaBancaria contaUsuario) {

    }
}