import javax.swing.*;
import java.util.*;
public class Funcionario{
    String nome;
    String estadoCivil;
    int CPF;
    protected int matricula;
    List<Dependente> dependenteList=new ArrayList<Dependente>();
    

    public Funcionario(String nome, String estadoCivil, int CPF) {
        this.nome = nome;
        this.estadoCivil = estadoCivil;
        this.CPF = CPF;
        this.matricula = (int) (Math.random()*1000)+1;
    }
    public Funcionario(String nome, String estadoCivil, int CPF,Dependente dependente) {
        this.nome = nome;
        this.estadoCivil = estadoCivil;
        this.CPF = CPF;
        this.matricula = (int) (Math.random()*1000)+1;
        dependenteList.add(dependente);
    }

    
    
    public int getMatricula() {
        return matricula;
    }
    
    
    
}