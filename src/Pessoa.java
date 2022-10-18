public class Pessoa {
    private String nome, endereco;
    private int id;

    public Pessoa(int id, String nome, String endereco) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    @Override
    public String toString() {
        return "\nID: " + id +
                "\nNome: " + nome +
                "\nEndereço: " + endereco;
    }
}