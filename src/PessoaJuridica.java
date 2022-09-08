public class PessoaJuridica extends Pessoa {
    private String cnpj;

    public PessoaJuridica(int id, String nome, String endereco, String cnpj) {
        super(id, nome, endereco);
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nCNPJ: " + cnpj;
    }
}