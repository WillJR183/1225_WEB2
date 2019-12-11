
package entradasdedados;

import dao.AreaDAO;
import dao.CursoDAO;
import javax.swing.JOptionPane;
import modelo.AreaModel;
import modelo.CursoModel;
import modelo.ProfessorModel;

/**
 *
 * @author junio
 */

public class ProfessorEntradaDeDados {
    
    public ProfessorModel entradaProfessor(){
        //AreaModel area = new AreaModel();
        //AreaDAO areaDao = new AreaDAO();
        
        CursoModel curso = new CursoModel();
        CursoDAO cursoDAO = new CursoDAO();
        
        String nome = JOptionPane.showInputDialog("Nome: ");
        String sexo = JOptionPane.showInputDialog("Sexo: ");
        long cpf = Long.parseLong(JOptionPane.showInputDialog("CPF: "));
        int idade = Integer.parseInt(JOptionPane.showInputDialog("Idade: "));
        ProfessorModel professor = new ProfessorModel(nome, idade, cpf, sexo);
        professor.setSiape(Long.parseLong(JOptionPane.showInputDialog("SIAPE: ")));
        /*
        int idarea = Integer.parseInt(JOptionPane.showInputDialog("ID da Area: "));
        area = areaDao.buscarPorId(idarea);
        if(area == null){
            JOptionPane.showMessageDialog(null, "Não foi encontrada area com a ID informado");
            }
        else
            {
                professor.setArea(area);
            }
        */
        int idcurso = Integer.parseInt(JOptionPane.showInputDialog("ID do Curso: "));
        curso = cursoDAO.buscarPorId(idcurso);
        if(curso == null){
            JOptionPane.showMessageDialog(null, "Não foi encontrado cursos com o ID informado");
            }
        else
            {
                professor.setCurso(curso);
            }
        
        return professor;
    }
    
    public ProfessorModel novaEntradaProfessor(ProfessorModel professor){
        AreaModel area = new AreaModel();
        AreaDAO areaDao = new AreaDAO();
        
        CursoModel curso = new CursoModel();
        CursoDAO cursoDAO = new CursoDAO();
        
        professor.setNome(JOptionPane.showInputDialog("Entre com o novo nome: "));
        professor.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Entre com a nova idade: ")));
        professor.setSexo(JOptionPane.showInputDialog("Entre com o novo sexo: "));
        professor.setCpf(Long.parseLong(JOptionPane.showInputDialog("Entre com o novo CPF: ")));
        professor.setSiape(Long.parseLong(JOptionPane.showInputDialog("Entre com o novo SIAPE: ")));
        /*
        int idarea = Integer.parseInt(JOptionPane.showInputDialog("ID da Area: "));
        area = areaDao.buscarPorId(idarea);
        if(area == null){
            JOptionPane.showMessageDialog(null, "Não foi encontrado Professor com o ID informado");
            }
        else
            {
                professor.setArea(area);
            }
        */
        int idcurso = Integer.parseInt(JOptionPane.showInputDialog("ID do Curso: "));
        curso = cursoDAO.buscarPorId(idcurso);
        if(curso == null){
            JOptionPane.showMessageDialog(null, "Não foi encontrado cursos com o ID informado");
            }
        else
            {
                professor.setCurso(curso);
            }
        
        return professor;
    }
    
     public int informarID(String acao){
        int id = Integer.parseInt(JOptionPane.showInputDialog("Entre com o ID de quem deseja " + acao + ": "));
        
        return id;
    }
     
}
