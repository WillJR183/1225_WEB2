package dao;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.AlunoModel;

/**
 *
 * @author Frank
 */

public class AlunoDAO extends Conexao {

   public void salvarOuAtualizar(AlunoModel aluno) {
        try {
            iniciar();
            getSessao().saveOrUpdate(aluno);
            fechar();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e.getMessage());
        }
    }
    
    public AlunoModel buscarPorId(int id) {
        try {
            iniciar();
            AlunoModel aluno = (AlunoModel) getSessao().get(AlunoModel.class, id);
            fechar();
            return aluno;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar: " + e.getMessage());
        }
        return null;
    }
    
    public List<AlunoModel> buscarTodos() {
        List<AlunoModel> listaDeAlunos = new ArrayList<>();
        try {
            iniciar();
            listaDeAlunos = getSessao().createQuery("from AlunoModel").list();
            fechar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar: " + e.getMessage());
        }
        return listaDeAlunos;
    }
    
    public void remover(AlunoModel aluno) {
        try {
            iniciar();
            getSessao().delete(aluno);
            fechar();
            JOptionPane.showMessageDialog(null, "Removido com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao remover: " + e.getMessage());
        }
    }
}
