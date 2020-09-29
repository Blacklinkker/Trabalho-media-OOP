import java.util.*;
public class Funcionario{
    private String nome;
    private String estadoCivil;
    private int CPF;
    private int matricula;
    private ArrayList<Dependente> dependenteList=new ArrayList<Dependente>();
 
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public int getCPF() {
        return CPF;
    }

    public void setCPF(int CPF) {
        this.CPF = CPF;
    }

    
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public ArrayList<Dependente> getDependentes(){
        return this.dependenteList;
    }

    public Funcionario(String nome, String estadoCivil, int CPF) {
        setNome(nome);
        setCPF(CPF);
        setEstadoCivil(estadoCivil);
        setMatricula( (int) Math.random() * 1000+1);
    }
    
    public void addDependente(Dependente dependente) {
        dependenteList.add(dependente);
    }

    public int geraMatricula(){
        return (int) (Math.random() * ((9-2)+2) * 10000)+1;
    }
}
