import java.util.*;
import javax.swing.*;
public class Programa{
    static List<Funcionario> funcionario=new ArrayList<Funcionario>();
    public static void main(String[] args) {
        
        int flag=0;
        while(flag<6){
            switch (flag) {
                case 0:
                    flag=Integer.parseInt(JOptionPane.showInputDialog("Qual operação desejada?"
                    + "\n 1-Adicionar funcionário"
                    +"\n 2-Adicionar dependente a funcionário "
                    +"\n 3-Exibir todos os funcionários  "
                    +"\n 4-Exibir todos os dependentes de um funcionário" 
                    +"\n 5-Remover dependente"
                    +"\n 6-Sair"));
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
                                funcionario.add(new Funcionario(nome,estadoCivil,CPF,dependente));
                                JOptionPane.showMessageDialog(null,"Funcionário "+nome+" cadastrado com sucesso");
                            }else if(igualDep){
                                JOptionPane.showMessageDialog(null, "Operação cancelada, dependente já registrado");
                            }
                        }else if(possuiDependentes == 'n' || possuiDependentes == 'N'){
                            funcionario.add(new Funcionario(nome, estadoCivil, CPF));
                            JOptionPane.showMessageDialog(null,"Funcionário "+nome+" cadastrado com sucesso");
                        }
                        
                    }else if(igual){
                        JOptionPane.showMessageDialog(null, "Operação cancelada, funcionario já registrado");
                    }
                    

                    flag=0;
                break;

                case 2: 
                    int qualFuncionario=Integer.parseInt(JOptionPane.showInputDialog("Adicionar a qual funcionario (CPF):"));
                    for (Funcionario fun : funcionario) {
                        if(fun.CPF==qualFuncionario){
                            String nomeDependente=JOptionPane.showInputDialog("Nome do dependente:");
                            String parentesco=JOptionPane.showInputDialog("Parentesco:");
                            String nascimento=JOptionPane.showInputDialog("Data de nascimento (dd/MM/yyyy):");
                            boolean igualDep=verificaDuplicataFuncionario(fun.CPF,nomeDependente);
                            if(!igualDep){
                                Dependente dependente=new Dependente(nomeDependente, parentesco, nascimento);
                                fun.dependenteList.add(dependente);
                            }else{
                                JOptionPane.showMessageDialog(null,"operação cancelada,dependente já registrado");
                            }
                            
                        }
                    }
                    flag=0;
                break;
                
                case 3:
                String allFuncs="";
                for ( Funcionario fun : funcionario) {
                    allFuncs=allFuncs+fun.nome+" ("+fun.matricula+")"+",";
                }
                JOptionPane.showMessageDialog(null, allFuncs);
                    flag=0;
                break;
                
                case 4:
                String allDeps="";
                int qualCPF=Integer.parseInt(JOptionPane.showInputDialog("Exibir os dependentes de qual funcionario (CPF):"));
                    
                    for (Funcionario fun : funcionario) {
                        if(fun.CPF==qualCPF){
                            for (Dependente dep : fun.dependenteList) {
                                if (dep!=null){
                                    allDeps=allDeps+dep.nome+",";
                                }
                            }
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Exibindo dependentes do funcionário selecionado: \n"+allDeps);
                    flag=0;
                break;
                
                case 5:
                    int cpfRemocao=Integer.parseInt(JOptionPane.showInputDialog("Remover de qual funcionario (CPF):"));
                    String dependenteARemover=JOptionPane.showInputDialog("Nome do dependente: ");
                    for (Funcionario fun : funcionario) {
                        if(fun.CPF==cpfRemocao){
                            Iterator<Dependente> iter =  fun.dependenteList.iterator();
                            while(iter.hasNext()) {
                                Dependente dep = iter.next();
                                if(dep.nome.equals(dependenteARemover)) {
                                    iter.remove();
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
        for (Funcionario membro : Programa.funcionario) {
            if(cpf==membro.CPF){
                return true;
            }
        }
        return false;
    }
    public static boolean verificaDuplicataFuncionario(int cpf,String nomeDependente){
        for (Funcionario fun : Programa.funcionario) {
            if(cpf==fun.CPF){
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