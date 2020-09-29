import java.util.*;
import javax.swing.*;
public class Programa{
    static ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
    public static void main(String[] args) {
        
        int flag=0;
        while(flag<6){
            switch (flag) {
                case 0:
                    flag = Integer.parseInt(JOptionPane.showInputDialog("Qual operação desejada?"
                    + "\n 1-Adicionar funcionário"
                    +"\n 2-Adicionar dependente a funcionário "
                    +"\n 3-Exibir todos os funcionários  "
                    +"\n 4-Exibir todos os dependentes de um funcionário" 
                    +"\n 5-Remover dependente"
                    +"\n 6-Sair"));
                break;
                
                case 1: 
                    String result = addFuncionario();
                    JOptionPane.showMessageDialog(null, result);
                    flag = 0;
                break;

                case 2: 
                    result = addDependente();
                    JOptionPane.showMessageDialog(null, result);
                    flag = 0;
                break;
                
                case 3:
                    result = showFuncionarios();
                    JOptionPane.showMessageDialog(null, result);
                    flag = 0;
                break;
                
                case 4:
                    result = showDependentes();
                    JOptionPane.showMessageDialog(null, result);
                    flag = 0;
                break;
                
                case 5:
                    result = removeDependente();
                    JOptionPane.showMessageDialog(null, result);
                    flag = 0;
                break;
            }
        }
    }

    public static String addFuncionario(){
        int CPF = Integer.parseInt(JOptionPane.showInputDialog("CPF:"));
        
        if(!verificaDuplicataFuncionario(CPF)){
            String nome = JOptionPane.showInputDialog("Nome do funcionario:");
            String estadoCivil = JOptionPane.showInputDialog("Estado civil: ");
            Funcionario novoFuncionario = new Funcionario(nome, estadoCivil, CPF);

            String dependentesString = JOptionPane.showInputDialog("Possui dependentes (s/n)?: ");
            char possuiDependentes = dependentesString.charAt(0);
            
            if(possuiDependentes == 's' || possuiDependentes == 'S'){
                novoFuncionario.addDependente(createDependente(novoFuncionario));
                funcionarios.add(novoFuncionario);
                return "Funcionário " + novoFuncionario.getNome() + " cadastrado com dependente!";
            }else if(possuiDependentes == 'n' || possuiDependentes == 'N'){
                funcionarios.add(novoFuncionario);
                return "Funcionário " + novoFuncionario.getNome() + " cadastrado com sucesso!";
            }      
        }else if(verificaDuplicataFuncionario(CPF)){
            return "Operação cancelada, funcionario já registrado";
        }
        return null;
    }

    public static Dependente createDependente(Funcionario novoFuncionario){
        String nomeDependente = JOptionPane.showInputDialog("Nome do dependente:");
        
        if(!verificaDuplicataDependente(novoFuncionario.getCPF(), nomeDependente)){
            String parentescoDependente = JOptionPane.showInputDialog("Parentesco:");
            String nascimentoDependente = JOptionPane.showInputDialog("Data de nascimento (dd/MM/yyyy):");

            return new Dependente(nomeDependente, parentescoDependente, nascimentoDependente);
        }
        return null;
    }

    public static String addDependente(){
        int qualFuncionario=Integer.parseInt(JOptionPane.showInputDialog("Adicionar a qual funcionario (CPF):"));
        
        for (Funcionario fun : funcionarios) {
            if(fun.getCPF() == qualFuncionario){
                fun.addDependente(createDependente(fun));
                return "Dependente adicionado com sucesso!";
            }
        } 

        return "CPF não encontrado";
    }

    public static String showFuncionarios(){
        String allFuncs = "";
        
        for ( Funcionario fun : funcionarios) {
            allFuncs = allFuncs+fun.getNome()+" ("+fun.getMatricula()+")"+",";
        }
        return allFuncs;
    }

    public static String showDependentes(){
        String allDeps = "";
        int qualCPF = Integer.parseInt(JOptionPane.showInputDialog("Exibir os dependentes de qual funcionario (CPF):"));
                    
        for (Funcionario fun : funcionarios) {
            if(fun.getCPF() == qualCPF){
                for (Dependente dep : fun.getDependentes()) {
                    if (dep != null){
                        allDeps = allDeps+dep.getNome() + ",";
                    }
                }
            }
        }
        return "Exibindo dependentes do funcionário selecionado: \n"+allDeps;
    }

    public static String removeDependente(){
        int cpfRemocao=Integer.parseInt(JOptionPane.showInputDialog("Remover de qual funcionario (CPF):"));
        String dependenteARemover=JOptionPane.showInputDialog("Nome do dependente: ");
        
        for (Funcionario fun : funcionarios) {
            if(fun.getCPF() == cpfRemocao){
                Iterator<Dependente> iter =  fun.getDependentes().iterator();
                while(iter.hasNext()) {
                    Dependente dep = iter.next();
                    if(dep.getNome().equals(dependenteARemover)) {
                        iter.remove();
                        return "Dependente " + dependenteARemover + " removido com sucesso";
                    }
                }
            }
        }
        return null;
    }

    public static boolean verificaDuplicataFuncionario(int cpf){
        for (Funcionario membro : Programa.funcionarios) {
            if(cpf == membro.getCPF()){
                return true;
            }
        }
        return false;
    }

    public static boolean verificaDuplicataDependente(int cpf,String nomeDependente){
        for (Funcionario fun : Programa.funcionarios) {
            if(cpf == fun.getCPF()){
               for (Dependente dep : fun.getDependentes()) {
                    if(dep.getNome() == nomeDependente){
                        return true;
                    }
               }
            }
        }
        return false;
    } 
}
