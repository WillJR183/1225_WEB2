
package pkg19_02_lp2_alunoprofessor;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Aluno;
import modelo.Professor;

public class EntradaDeDados {

    DAO dao = new DAO();

    public void salvar(String opcao) throws SQLException {
        String nome = JOptionPane.showInputDialog("Nome: ");
        String cpf = JOptionPane.showInputDialog("CPF: ");
        String sexo = JOptionPane.showInputDialog("Sexo: ");
        int idade = Integer.parseInt(JOptionPane.showInputDialog("Idade: "));
        
        if (opcao.equals("1")) {
           Aluno aluno = new Aluno(nome,sexo,cpf,idade);
           aluno.setRa(Integer.parseInt(JOptionPane.showInputDialog("RA: ")));
           dao.salvarBD_aluno(aluno);
        } else {
            Professor professor = new Professor(nome,sexo,cpf,idade);
            professor.setSiape(Integer.parseInt(JOptionPane.showInputDialog("SIAPE: ")));
            dao.salvarBD_professor(professor);
        }
    }
    
    /* ************************************************************************************************ */
    
    public void exibir(String opcao) throws SQLException{
         if (opcao.equals("2")){
            opcao = "1 - Exibir todos\n2 - Exibir por CPF";
            String opt = JOptionPane.showInputDialog(opcao);
            if (opt.equals("1")){
                 dao.exibirAlunosBD(opcao);
            }
            else{
                String nome = JOptionPane.showInputDialog("Nome: ");
                Aluno aluno = new Aluno();
                aluno.setNome(nome);
                dao.buscaAlunoBD(aluno);
            }
        }
        else{
            opcao = "1 - Exibir todos\n2 - Exibir por CPF";
            String opt = JOptionPane.showInputDialog(opcao);
            if (opt.equals("1")){
                 dao.exibirProfessorBD();
            }
            else{
                String cpf = JOptionPane.showInputDialog("CPF: ");
                Professor professor = new Professor();
                professor.setCpf(cpf);
                dao.buscaProfessorBD(professor);
            }
        }
    }
    
    /* ************************************************************************************************ */
    
    public void remover(String opcao) throws SQLException{
        if (opcao.equals("3")){
            String cpf = JOptionPane.showInputDialog("CPF: ");
            Aluno aluno = new Aluno();
            aluno.setCpf(cpf);
            dao.removeAlunoBD(aluno);
        }
        else{
            String cpf = JOptionPane.showInputDialog("CPF: ");
            Professor professor = new Professor();
            professor.setCpf(cpf);
            dao.removeProfessorBD(professor);
        }
    }
    
    /* ************************************************************************************************ */
    
     public void atualizar(String opcao) throws SQLException{
        opcao = "1 - Alterar aluno\n2 - Alterar professor";
        String opt = JOptionPane.showInputDialog(opcao);
        if (opt.equals("1")){
            String cpf = JOptionPane.showInputDialog("CPF de quem será alterado: ");
            String nome = JOptionPane.showInputDialog("Novo Nome: ");
            String sexo = JOptionPane.showInputDialog("Novo Sexo: ");
            int idade = Integer.parseInt(JOptionPane.showInputDialog("Nova Idade: "));
            Aluno aluno = new Aluno();
            aluno.setCpf(cpf);
            aluno.setNome(nome);
            aluno.setSexo(sexo);
            aluno.setIdade(idade);
            dao.atualizaAlunoBD(aluno);
        }
        else{
            String cpf = JOptionPane.showInputDialog("CPF de quem será alterado: ");
            String nome = JOptionPane.showInputDialog("Novo Nome: ");
            String sexo = JOptionPane.showInputDialog("Novo Sexo: ");
            int idade = Integer.parseInt(JOptionPane.showInputDialog("Nova Idade: "));
            Professor professor= new Professor();
            professor.setCpf(cpf);
            professor.setNome(nome);
            professor.setSexo(sexo);
            professor.setIdade(idade);
            dao.atualizaProfessorBD(professor);
        }
    }
}