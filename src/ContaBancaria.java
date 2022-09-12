public class ContaBancaria {
    private int agencia, numero, senha, idPessoa;
    private double saldo;

    public ContaBancaria(int agencia, int numero, int senha, int idPessoa, double saldo) {
        this.agencia = agencia;
        this.numero = numero;
        this.senha = senha;
        this.idPessoa = idPessoa;
        this.saldo = saldo;
    }

    public String sacar(double valor) {
        if (this.getSaldo() >= valor) {
            this.setSaldo(this.getSaldo() - valor);
            return "\nValor sacado com sucesso!\n";
        } else {
            return "\nSaldo insuficiente!\n";
        }
    }

    public String depositar(double valor) {
        this.setSaldo(this.getSaldo() + valor);
        return "\nValor depositado com sucesso!\n";
    }

    public void transferir(ContaBancaria conta, double valor) {
        this.sacar(valor);
        conta.depositar(valor);
    }

    public void receber(PessoaFisica pessoa) {
        this.setSaldo(this.getSaldo() + pessoa.getRenda());
    }

    public int getNumero() {
        return numero;
    }

    public int getSenha() {
        return senha;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "\nID do proprietário: " + idPessoa +
                "\nAgência: " + agencia +
                "\nNúmero: " + numero +
                "\nSaldo: " + saldo;
    }
}