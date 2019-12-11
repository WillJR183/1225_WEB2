package entradasdedados;

import javax.swing.JOptionPane;
import modelo.AlunoModel;

public class AlunoEntradaDeDados {

    public AlunoModel entradaAluno() {
        
        String nome = JOptionPane.showInputDialog("Nome: ");
        String sexo = JOptionPane.showInputDialog("Sexo: ");
        long cpf = Long.parseLong(JOptionPane.showInputDialog("CPF: "));
        int idade = Integer.parseInt(JOptionPane.showInputDialog("Idade: "));
        AlunoModel aluno = new AlunoModel(nome, idade, cpf, sexo);
        aluno.setRa(Integer.parseInt(JOptionPane.showInputDialog("RA: ")));
        
        return aluno;
    }
    
    public AlunoModel novaEntradaAluno(AlunoModel aluno){
        
        aluno.setNome(JOptionPane.showInputDialog("Entre com o novo nome: "));
        aluno.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Entre com a nova idade: ")));
        aluno.setSexo(JOptionPane.showInputDialog("Entre com o novo sexo: "));
        aluno.setCpf(Long.parseLong(JOptionPane.showInputDialog("Entre com o novo CPF: ")));
        aluno.setRa(Integer.parseInt(JOptionPane.showInputDialog("Entre com o novo RA: ")));
        
        return aluno;
    }
    
    public int informarID(String acao){
        int id = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID:  " + acao + ": "));
        
        return id;
    } 
}
