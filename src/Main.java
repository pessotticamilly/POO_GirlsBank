import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<ContaBancaria> contas = new ArrayList<>();
    static ArrayList<Pessoa> pessoas = new ArrayList<>();

    public static void main(String[] args) {
        pessoas.add(new PessoaFisica(1, "Camilly", "Rua João Bosco, 123", "123.456.789-10", "Estudante", 0));
        pessoas.add(new PessoaFisica(2, "Taiany", "Rua Bosco João, 321", "109.876.543-21", "Estudante", 0));
        contas.add(new ContaBancaria(1, 1, 1234, 1, 100.0));
        contas.add(new ContaBancaria(1, 2, 4321, 2, 200.0));
        menuInicial();
    }

    private static void menuInicial() {
        System.out.print("---- MENU INICIAL ----" +
                "\n1 - Login" +
                "\n2 - Cadastrar conta" +
                "\n3 - Excluir conta" +
                "\n4 - Cadastrar pessoa" +
                "\n5 - Excluir pessoa" +
                "\n6 - Ver relatório" +
                "\n7 - Encerrar sessão" +
                "\n> ");
        int opcao = sc.nextInt();

        switch (opcao) {
            case 1:
                login();
                break;

            case 2:
                cadastrarConta();
                break;

            case 3:
                excluirConta();
                break;

            case 4:
                cadastrarPessoa();
                break;

            case 5:
                excluirPessoa();
                break;

            case 6:
                int cont = 0;
                for (ContaBancaria conta : contas) {
                    System.out.print("\nCONTA " + (cont + 1) + ": " + conta.toString() + "\n - - - - - - - - - -");
                    cont++;
                }
                System.out.print("\n");
                menuInicial();
                break;

            case 7:
                System.out.print("\nEncerrando...");
                System.exit(0);
                break;

            default:
                System.out.print("\nOpção inválida! Tente novamente: \n");
                menuInicial();
                break;
        }
    }

    private static void login() {
        System.out.print("\nNúmero da conta\n> ");
        int numero = sc.nextInt();

        System.out.print("Senha\n> ");
        int senha = sc.nextInt();

        ContaBancaria contaUsuario = null;
        boolean verificaConta = false;

        for (ContaBancaria contaBancaria : contas) {
            contaUsuario = contaBancaria;
            if (contaUsuario.getNumero() == numero) {
                if (contaUsuario.getSenha() == senha) {
                    verificaConta = true;
                    break;
                }
            }
        }

        if (verificaConta) {
            menuConta(contaUsuario);
        } else {
            System.out.print("\nDados inválidos! Tente novamente: ");
            login();
        }
    }

    private static void cadastrarConta() {
        System.out.print("\nAgência\n> ");
        int agencia = sc.nextInt();

        System.out.print("Número\n> ");
        int numero = sc.nextInt();

        for (ContaBancaria conta : contas) {
            if (conta.getNumero() == numero) {
                System.out.print("\nNúmero já cadastrado! Tente novamente:");
                cadastrarConta();
            }
        }

        System.out.print("Senha\n> ");
        int senha = sc.nextInt();

        System.out.print("ID do proprietário\n> ");
        int idPessoa = sc.nextInt();

        boolean verificaPessoa = false;

        for (Pessoa pessoa : pessoas) {
            if (pessoa.getId() == idPessoa) {
                verificaPessoa = true;
                break;
            }
        }

        if (!verificaPessoa) {
            System.out.print("\nID do proprietário! Tente novamente:");
            cadastrarConta();
        }

        System.out.print("Saldo\n> ");
        double saldo = sc.nextDouble();

        contas.add(new ContaBancaria(agencia, numero, senha, idPessoa, saldo));
        System.out.print("\nConta cadastrada com sucesso!\n\n");
        menuInicial();
    }

    private static void excluirConta() {
        System.out.print("\nQual o número da conta que desejas excluir?\n> ");
        int numero = sc.nextInt();

        ContaBancaria conta = null;
        boolean verificaConta = false;

        for (ContaBancaria contaBancaria : contas) {
            if (contaBancaria.getNumero() == numero) {
                conta = contaBancaria;
                verificaConta = true;
                break;
            }
        }

        if (verificaConta) {
            contas.remove(conta);
            System.out.print("\nConta excluída com sucesso!\n\n");
            menuInicial();
        } else {
            System.out.print("\nNúmero inválido! Tente novamente:");
            excluirConta();
        }
    }

    private static void cadastrarPessoa() {
        System.out.print("\nQual o tipo de pessoa?" +
                "]\n1 - Pessoa física" +
                "\n2 - Pessoa Jurídica" +
                "\n> ");
        int tipoPessoa = sc.nextInt();

        System.out.print("\nID\n> ");
        int id = sc.nextInt();

        boolean validaPessoa = false;

        for (Pessoa pessoa : pessoas) {
            if (pessoa.getId() == id) {
                validaPessoa = true;
                break;
            }
        }

        if (validaPessoa) {
            System.out.print("\nID inválido! Tente novamente: ");
            cadastrarPessoa();
        }

        System.out.print("Nome\n> ");
        String nome = sc.next();

        System.out.print("Endereço\n> ");
        String endereco = sc.next();

        if (tipoPessoa == 1) {
            System.out.print("CPF\n> ");
            String cpf = sc.next();

            System.out.print("Profissão\n> ");
            String profissao = sc.next();

            System.out.print("Renda\n> ");
            double renda = sc.nextDouble();

            pessoas.add(new PessoaFisica(id, nome, endereco, cpf, profissao, renda));
        } else {
            System.out.print("CNPJ\n> ");
            String cnpj = sc.next();

            pessoas.add(new PessoaJuridica(id, nome, endereco, cnpj));
        }
        System.out.print("\nPessoa cadastrada com sucesso!\n\n");
        menuInicial();
    }

    private static void excluirPessoa() {
        System.out.print("\nQual o id da pessoa que desejas excluir?\n> ");
        int id = sc.nextInt();

        Pessoa pessoa = null;
        boolean verificaPessoa = false;

        for (Pessoa PessoaLista : pessoas) {
            if (PessoaLista.getId() == id) {
                pessoa = PessoaLista;
                verificaPessoa = true;
                break;
            }
        }

        if (verificaPessoa) {
            pessoas.remove(pessoa);
            System.out.print("\nPessoa excluída com sucesso!\n\n");
            menuInicial();
        } else {
            System.out.print("\nID inválido! Tente novamente:");
            excluirPessoa();
        }
    }

    private static void menuConta(ContaBancaria contaUsuario) {
        System.out.print("\n---- MENU CONTA ----" +
                "\n1 - Sacar" +
                "\n2 - Depositar" +
                "\n3 - Transferir" +
                "\n4 - Ver dados" +
                "\n5 - Sair" +
                "\n> ");
        int opcao = sc.nextInt();

        switch (opcao) {
            case 1:
                sacar(contaUsuario);
                menuConta(contaUsuario);
                break;

            case 2:
                depositar(contaUsuario);
                menuConta(contaUsuario);
                break;

            case 3:
                transferir(contaUsuario);
                menuConta(contaUsuario);
                break;

            case 4:
                System.out.print(contaUsuario.toString() + "\n");
                menuConta(contaUsuario);
                break;

            case 5:
                System.out.print("\nSaindo...\n\n");
                menuInicial();
                break;

            default:
                System.out.print("\nOpção inválida! Tente novamente:\n");
                menuConta(contaUsuario);
                break;
        }
    }

    private static void sacar(ContaBancaria contaUsuario) {
        System.out.print("\nQual o valor que gostarias de sacar?\n> R$ ");
        double valor = sc.nextDouble();

        System.out.print(contaUsuario.sacar(valor));
    }

    private static void depositar(ContaBancaria contaUsuario) {
        System.out.print("\nQual o valor que gostarias de depositar?\n> R$ ");
        double valor = sc.nextDouble();

        System.out.print(contaUsuario.depositar(valor));
    }

    private static void transferir(ContaBancaria contaUsuario) {
        System.out.print("\nQual o número da conta que gostarias de transferir?\n> ");
        int numero = sc.nextInt();

        for (ContaBancaria conta : contas) {
            if (conta.getNumero() == numero) {
                System.out.print("\nQual o valor que gostarias de transferir?\n> R$ ");
                double valor = sc.nextDouble();

                contaUsuario.transferir(conta, valor);
            } else {
                System.out.print("\nNúmero da conta inválido! Encerrando operação...\n");
                menuConta(contaUsuario);
            }
            break;
        }
    }
}