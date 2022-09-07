public class PessoaFisica extends Pessoa {
    private String cpf, profissao;
    private double renda;

    public PessoaFisica(int id, String nome, String endereco, String cpf, String profissao, double renda) {
        super(id, nome, endereco);
        this.cpf = cpf;
        this.profissao = profissao;
        this.renda = renda;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public double getRenda() {
        return renda;
    }

    public void setRenda(double renda) {
        this.renda = renda;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nCPF: " + cpf +
                "\nProfissão: " + profissao +
                "\nRenda: " + renda +
                "\n- - - - - - - - - - - - - - - - - - - -\n\n";
    }
}