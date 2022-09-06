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

    public static void sacar() {

    }

    public static void depositar() {

    }

    public static void transferir() {

    }

    public static void verDados() {

    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "\nID Proprietário: " + idPessoa +
                "\nAgência: " + agencia +
                "\nNúmero: " + numero +
                "\nSaldo: " + saldo;
    }
}
