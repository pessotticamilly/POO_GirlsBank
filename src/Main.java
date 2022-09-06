import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<ContaBancaria> contas = new ArrayList<>();
    static ArrayList<PessoaFisica> PessoasFisicas = new ArrayList<>();
    static int opcao = 0;

    public static void main(String[] args) {
        PessoasFisicas.add(new PessoaFisica(1, "Camilly", "Rua João Bosco, 123", "123.456.789-10", "Estudante", 0));
        PessoasFisicas.add(new PessoaFisica(2, "Taiany", "Rua Bosco João, 321", "109.876.543-21", "Estudante", 0));
        contas.add(new ContaBancaria(1, 1, 1234, 1, 100.0));
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

        for (ContaBancaria conta : contas) {
            if(conta.getNumero() == numeroConta){
                if(conta.getSenha() == senha) {
                    menuConta();
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

        for(ContaBancaria conta : contas) {
            if(conta.getNumero() == numero) {
                System.out.print("\nNúmero já cadastrado! Tente novamente:");
                cadastrarConta();
            }
        }

        System.out.print("\nSenha\n> ");
        int senha = sc.nextInt();

        System.out.print("\nID Proprietário\n> ");
        int idProprietario = sc.nextInt();

        boolean verificaPessoa = false;

        for(PessoaFisica pessoaFisica : PessoasFisicas) {
            if(pessoaFisica.getId() == idProprietario){
                verificaPessoa = true;
                break;
            }
        }
        
        if(!verificaPessoa) {
            System.out.print("\nID Proprietário inválido! Tente novamente:");
            cadastrarConta();
        }

        System.out.print("\nSaldo\n> ");
        double saldo = sc.nextDouble();

        contas.add(new ContaBancaria(agencia, numero, senha, idProprietario, saldo));
        System.out.print("\nConta cadastrada com sucesso!\n\n");
        menuInicial();
    }

    private static void excluirConta() {
        System.out.print("\nQual o número da conta que desejas excluir?\n> ");
        int numero = sc.nextInt();

        for(ContaBancaria conta : contas){
            if(conta.getNumero() == numero){
                contas.remove(conta);
                System.out.print("\nConta excluída com sucesso!\n\n");
                menuInicial();
            } else {
                System.out.print("\nNúmero inválido! Tente novamente:");
                excluirConta();
            }
        }
    }

    private static void menuConta() {
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
            case 1 -> ContaBancaria.sacar();
            case 2 -> ContaBancaria.depositar();
            case 3 -> ContaBancaria.transferir();
            case 4 -> ContaBancaria.verDados();
            case 5 -> {
                System.out.print("\n");
                menuInicial();
            }
            default -> {
                System.out.print("\nOpção inválida! Tente novamente:\n");
                menuConta();
            }
        }
    }
}
