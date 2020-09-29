public class Dependente {
    private String nome;
    private String parentesco;
    private String nascimento;

    public String getNome() {
        return nome;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Dependente(String nome, String parentesco, String nascimento) {
        setNome(nome);
        setParentesco(parentesco);
        setParentesco(nascimento);
    }
}
