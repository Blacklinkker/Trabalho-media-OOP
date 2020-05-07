package v2;
import java.util.*;
import javax.swing.*;
public class Programa{
    static Set<Funcionario> funcionarioList=new HashSet<Funcionario>();

    public static void main(String[] args) {
        
        int flag=0;
        while(flag<6){
            switch (flag) {
                case 0:
                    flag=Integer.parseInt(JOptionPane.showInputDialog("Qual operação desejada?"
                    + "\n  1-Adicionar funcionário"
                    +"\n 2-Adicionar dependente a funcionário "
                    +"\n 3-Exibir todos os funcionários  "
                    +"\n 4-Exibir todos os dependentes de um funcionário" 
                    +"\n 5-Remover dependente"));
                break;
                
                case 1: 
                    String nome=JOptionPane.showInputDialog("Nome do funcionario:");
                    String estadoCivil=JOptionPane.showInputDialog("Estado civil: ");
                    int CPF=Integer.parseInt(JOptionPane.showInputDialog("CPF:"));
                    boolean igual=verificaDuplicataFuncionario(CPF);
                    if(!igual){
                        String dependentesString= JOptionPane.showInputDialog("Possui dependentes (s/n)?: ");
                        char possuiDependentes=dependentesString.charAt(0);
                        if(possuiDependentes == 's' || possuiDependentes=='S'){
                            String nomeDependente=JOptionPane.showInputDialog("Nome do dependente:");
                            String parentesco=JOptionPane.showInputDialog("Parentesco:");
                            String nascimento=JOptionPane.showInputDialog("Data de nascimento (dd/MM/yyyy):");
                            boolean igualDep=verificaDuplicataFuncionario(CPF,nomeDependente);
                            if(!igualDep){
                                Dependente dependente=new Dependente(nomeDependente, parentesco, nascimento);
                                funcionarioList.add(new Funcionario(nome,estadoCivil,CPF,dependente));
                            }else if(igualDep){
                                JOptionPane.showMessageDialog(null, "Operação cancelada, dependente já registrado");
                            }
                            
                            
                            
                        }else if(possuiDependentes == 'n' || possuiDependentes == 'N'){
                            funcionarioList.add(new Funcionario(nome, estadoCivil, CPF));
                        }
                        
                    }else if(igual){
                        JOptionPane.showMessageDialog(null, "Operação cancelada, funcionario já registrado");
                    }
                    

                    flag=0;
                break;

                case 2: 
                    String qualFuncionario=JOptionPane.showInputDialog("Adicionar a qual funcionario:");
                    for (Funcionario fun : funcionarioList) {
                        if(fun.nome==qualFuncionario){
                            String nomeDependente=JOptionPane.showInputDialog("Nome do dependente:");
                            String parentesco=JOptionPane.showInputDialog("Parentesco:");
                            String nascimento=JOptionPane.showInputDialog("Data de nascimento (dd/MM/yyyy):");
                            Dependente dependente=new Dependente(nomeDependente, parentesco, nascimento);
                            fun.dependenteList.add(dependente);
                        }
                    }
                    flag=0;
                break;
                
                case 3:
                String allFuncs="";
                for ( Funcionario fun : funcionarioList) {
                    allFuncs=allFuncs+fun.nome+"("+fun.matricula+")"+",";
                }
                JOptionPane.showMessageDialog(null, allFuncs);
                    flag=0;
                break;
                
                case 4:
                String allDeps="";
                int qualCPF=Integer.parseInt(JOptionPane.showInputDialog("Exibir os dependentes de qual funcionario(cpf):"));
                    for (Funcionario fun : funcionarioList) {
                        if(fun.CPF==qualCPF){
                            for (Dependente dep : fun.dependenteList) {
                                allDeps=allDeps+dep.nome+",";
                            }
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Exibindo dependentes do funcionário selecionado: \n"+allDeps);
                    flag=0;
                break;
                
                case 5:
                    int cpfFuncionario=Integer.parseInt(JOptionPane.showInputDialog("CPF do funcionário para remoção de dependente:"));
                    String nomeDependente=JOptionPane.showInputDialog("Nome do dependente:");
                    for ( Funcionario fun : funcionarioList) {
                        if(fun.CPF==cpfFuncionario){
                            for (Dependente dep : fun.dependenteList) {
                                if(dep.nome==nomeDependente){
                                    fun.dependenteList.remove(nomeDependente);
                                }
                            }
                        }
                    }
                    flag=0;
                break;
            }
        }
    }
    public static boolean verificaDuplicataFuncionario(int cpf){
        for (Funcionario membro : Programa.funcionarioList) {
            if(cpf==membro.CPF){
                return true;
            }
        }
        return false;
    }
    public static boolean verificaDuplicataFuncionario(int cpf,String nomeDependente){
        for (Funcionario fun : Programa.funcionarioList) {
            if(cpf==membro.CPF){
               for (Dependente dep : fun.dependenteList) {
                    if(dep.nome==nomeDependente){
                        return true;
                    }
               }
            }
        }
        return false;
    }
}