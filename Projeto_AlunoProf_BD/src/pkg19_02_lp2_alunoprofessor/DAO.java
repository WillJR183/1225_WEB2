
package pkg19_02_lp2_alunoprofessor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Aluno;
import modelo.Pessoa;
import modelo.Professor;

public class DAO {

    List<Pessoa> listaDePessoas = new ArrayList<>();
 

    public void salvarBD_aluno(Aluno aluno) throws SQLException{
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection("jdbc:derby://localhost/BancoTeste", "nbuser", "nbuser");
            String sql = "insert into aluno (nome, idade, cpf, sexo, ra) " + "values(?,?,?,?,?)";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, aluno.getNome());
            ps.setInt(2, aluno.getIdade());
            ps.setString(3, aluno.getCpf());
            ps.setString(4, aluno.getSexo());
            ps.setInt(5, aluno.getRa());
            int retorno = ps.executeUpdate();
            if (retorno > 0) {
                JOptionPane.showMessageDialog(null, "Salvo com Sucesso !");
            }
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally{
            conexao.close();
        }
    }
    
    /* ************************************************************************************************ */
    
     public void salvarBD_professor(Professor professor) throws SQLException{
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection("jdbc:derby://localhost/BancoTeste", "nbuser", "nbuser");
            String sql = "insert into professor (nome, idade, cpf, sexo, siape) " + "values(?,?,?,?,?)";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, professor.getNome());
            ps.setInt(2, professor.getIdade());
            ps.setString(3, professor.getCpf());
            ps.setString(4, professor.getSexo());
            ps.setInt(5, professor.getSiape());
            int retorno = ps.executeUpdate();
            if (retorno > 0) {
                JOptionPane.showMessageDialog(null, "Salvo com Sucesso !");
            }
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally{
            conexao.close();
        }
    }
     
    /* ************************************************************************************************* */ 
     
    public void buscaAlunoBD(Aluno aluno) throws SQLException{
        Connection conexao = null;
        try {
           conexao = DriverManager.getConnection("jdbc:derby://localhost/BancoTeste", "nbuser", "nbuser");
            String sql = "select * from aluno where nome = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1,aluno.getNome());
            ResultSet listaAluno = ps.executeQuery();
            while(listaAluno.next()){
               JOptionPane.showMessageDialog(null, "Nome: "+listaAluno.getString("nome") 
                    +"\n"+ "Sexo: "+listaAluno.getString("sexo") + "\n"+"CPF: "+listaAluno.getString("cpf")
                    +"\n"+"Idade: "+listaAluno.getString("idade") + "\n"+"RA: "+listaAluno.getString("ra"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally{
            conexao.close();
        }
    }
    
    /* ************************************************************************************************* */ 
    
    public void buscaProfessorBD(Professor professor) throws SQLException{
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection("jdbc:derby://localhost/BancoTeste", "nbuser", "nbuser");
            String sql = "select * from professor where cpf = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1,professor.getCpf());
            ResultSet listaProfessor = ps.executeQuery();
            while(listaProfessor.next()){
                JOptionPane.showMessageDialog(null, "Nome: "+listaProfessor.getString("nome") 
                +"\n"+ "Sexo: "+listaProfessor.getString("sexo") + "\n"+"CPF: "+listaProfessor.getString("cpf")
                +"\n"+"Idade: "+listaProfessor.getString("idade") + "\n"+"Siape: "+listaProfessor.getString("siape"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally{
            conexao.close();
        }
    }
    
    /* ************************************************************************************************* */ 
    
     public void atualizaAlunoBD(Aluno aluno) throws SQLException{
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection("jdbc:derby://localhost/BancoTeste", "nbuser", "nbuser");
            String sql = "update aluno set nome = ?,idade = ?, sexo = ? where cpf= ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, aluno.getNome());
            ps.setInt(2, aluno.getIdade());
            ps.setString(3,aluno.getSexo());
            ps.setString(4, aluno.getCpf());
            
            int retorno = ps.executeUpdate();
            if (retorno > 0) {
                JOptionPane.showMessageDialog(null, "Alterado com Sucesso !");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally{
            conexao.close();
        }
    }
     
    /* ************************************************************************************************* */  
    
     public void atualizaProfessorBD(Professor professor) throws SQLException{
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection("jdbc:derby://localhost/BancoTeste", "nbuser", "nbuser");
            String sql = "update professor set nome = ?,idade = ?, sexo = ? where cpf= ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, professor.getNome());
            ps.setInt(2, professor.getIdade());
            ps.setString(3,professor.getSexo());
            ps.setString(4, professor.getCpf());
            
            int retorno = ps.executeUpdate();
            if (retorno > 0) {
                JOptionPane.showMessageDialog(null, "Alterado com Sucesso !");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally{
            conexao.close();
        }
    } 
     
    /* ************************************************************************************************* */   
     
    public void exibirAlunosBD(String opcao) throws SQLException {
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection("jdbc:derby://localhost/BancoTeste", "nbuser", "nbuser");
            String sql = "select * from aluno";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet listaAluno = ps.executeQuery();
            while(listaAluno.next()){
                JOptionPane.showMessageDialog(null, "Nome: "+listaAluno.getString("nome") 
                +"\n"+ "Sexo: "+listaAluno.getString("sexo") + "\n"+"CPF: "+listaAluno.getString("cpf")
                +"\n"+"Idade: "+listaAluno.getString("idade") + "\n"+"RA: "+listaAluno.getString("ra"));
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally{
            conexao.close();
        }
    }
    
    /* ************************************************************************************************* */ 
    
      public void exibirProfessorBD() throws SQLException{
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection("jdbc:derby://localhost/BancoTeste", "nbuser", "nbuser");
            String sql = "select * from professor";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet listaProfessor = ps.executeQuery();
            while(listaProfessor.next()){
                JOptionPane.showMessageDialog(null, "Nome: "+listaProfessor.getString("nome") 
                +"\n"+ "Sexo: "+listaProfessor.getString("sexo") + "\n"+"CPF: "+listaProfessor.getString("cpf")
                +"\n"+"Idade: "+listaProfessor.getString("idade") + "\n"+"Siape: "+listaProfessor.getString("siape"));
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally{
            conexao.close();
        }
    }
    
    /* ************************************************************************************************* */ 
    
     public void removeAlunoBD(Aluno aluno) throws SQLException{
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection("jdbc:derby://localhost/BancoTeste", "nbuser", "nbuser");
            String sql = "delete from aluno where cpf = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1,aluno.getCpf());
            int retorno = ps.executeUpdate();
            if (retorno > 0) {
                JOptionPane.showMessageDialog(null, "Removido com Sucesso !");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally{
            conexao.close();
        }
    }
     
    /* ************************************************************************************************* */ 
     
     public void removeProfessorBD(Professor professor) throws SQLException{
        Connection conexao = null;
        try {
             conexao = DriverManager.getConnection("jdbc:derby://localhost/BancoTeste", "nbuser", "nbuser");
            String sql = "delete from professor where cpf = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1,professor.getCpf());
            
            int retorno = ps.executeUpdate();
            if (retorno > 0) {
                JOptionPane.showMessageDialog(null, "Removido com Sucesso !");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally{
            conexao.close();
        }
    }
     
    /* ************************************************************************************************* */
}