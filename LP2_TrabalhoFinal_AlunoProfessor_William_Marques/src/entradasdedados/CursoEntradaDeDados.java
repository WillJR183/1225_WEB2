/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entradasdedados;

import dao.AlunoDAO;
import dao.AreaDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.AlunoModel;
import modelo.AreaModel;
import modelo.CursoModel;

/**
 *
 * @author William
 */

public class CursoEntradaDeDados {
     public CursoModel entradaCurso(){
         
        CursoModel curso = new CursoModel();
        AreaModel area = new AreaModel();
        AreaDAO daoArea = new AreaDAO(); 
        
        curso.setTitulo(JOptionPane.showInputDialog("Entre com o titulo: "));
        curso.setDescricao(JOptionPane.showInputDialog("Entre com a descrição: "));
        curso.setLocal(JOptionPane.showInputDialog("Entre com o local: "));
        curso.setQuantidade_vagas(Integer.parseInt(JOptionPane.showInputDialog("Entre com a quantidade de vagas: ")));
        
        int idarea = Integer.parseInt(JOptionPane.showInputDialog("ID da Area: "));
        area = daoArea.buscarPorId(idarea);
        if(area == null){
            JOptionPane.showMessageDialog(null, "Não foi encontrada area com a ID informado");
            }
        else
            {
                curso.setArea(area);
            }

        return curso;
    }

    public CursoModel novaEntradaCurso(CursoModel curso){
             
        AreaModel area = new AreaModel();
        AreaDAO daoArea = new AreaDAO();
        
        curso.setDescricao(JOptionPane.showInputDialog("Entre com o novo titulo: "));
        curso.setDescricao(JOptionPane.showInputDialog("Entre com a nova descrição: "));
        curso.setLocal(JOptionPane.showInputDialog("Entre com o novo local: "));
        curso.setQuantidade_vagas(Integer.parseInt(JOptionPane.showInputDialog("Entre com a nova quantidade de vagas: ")));
       
        int idarea = Integer.parseInt(JOptionPane.showInputDialog("ID da Area: "));
        area = daoArea.buscarPorId(idarea);
        if(area == null){
            JOptionPane.showMessageDialog(null, "Não foi encontrada area com a ID informado");
            }
        else
            {
                curso.setArea(area);
            }
        
        return curso;
    }
    
    public int informarID(String acao){
        int id = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do Curso:  "+acao+": "));
        
        return id;
    }
    
    public CursoModel inserirAlunoNoCurso(CursoModel curso){
        
        AlunoModel aluno = new AlunoModel();
        AlunoDAO daoAluno = new AlunoDAO();
        int idaluno = Integer.parseInt(JOptionPane.showInputDialog("Id Aluno: "));
            aluno = daoAluno.buscarPorId(idaluno);
                if(aluno == null){
                    JOptionPane.showMessageDialog(null, "Não foi encontrado nenhum Aluno com o ID informado");
                        return null;
                }else{
                    List<AlunoModel> listaDeAlunos = new ArrayList<AlunoModel>();
                    listaDeAlunos.add(aluno);
                    curso.setListaDeAlunos(listaDeAlunos);
                }
        return curso;
    }
    
}
