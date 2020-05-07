package v2;
import java.util.*;
import javax.swing.*;
public class Programa{
    static Set<Funcionario> funcionario=new HashSet<Funcionario>();

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
                    igual=funcionario.verificaDuplicata(cpf);
                    String dependentesString= JOptionPane.showInputDialog("Possui dependentes (s/n)?: ");
                    char possuiDependentes=dependentesString.charAt(0);
                    if(possuiDependentes == 's' || possuiDependentes=='S'){
                        String nomeDependente=JOptionPane.showInputDialog("Nome:");
                        String parentesco=JOptionPane.showInputDialog("Parentesco:");
                        String nascimento=JOptionPane.showInputDialog("Data de nascimento (dd/MM/yyyy):");
                        
                        Dependente dependente=new Dependente(nome, parentesco, nascimento);
                        funcionario.add(new Funcionario(nome,estadoCivil,CPF,dependente));
                    }else{
                        funcionario.add(new Funcionario(nome, estadoCivil, CPF));
                    }

                    flag=0;
                break;

                case 2: 
                    flag=0;
                break;
                
                case 3:
                    flag=0;
                break;
                
                case 4:
                    flag=0;
                break;
                
                case 5:
                    flag=0;
                break;
            }
        }
    }
    public static boolean verificaDuplicata(int cpf){
        for (Funcionario membro : Programa.funcionario) {
            if(cpf==membro.CPF){
                JOptionPane.showMessageDialog(null,"Funcionario já cadastrado, operação cancelada");
                return true;
            }
        }
        return false;
    }
}