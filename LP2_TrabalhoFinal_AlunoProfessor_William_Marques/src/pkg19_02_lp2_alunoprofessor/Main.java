package pkg19_02_lp2_alunoprofessor;

import dao.AlunoDAO;
import dao.AreaDAO;
import dao.CursoDAO;
import dao.ProfessorDAO;
import entradasdedados.AlunoEntradaDeDados;
import entradasdedados.AreaEntradaDeDados;
import entradasdedados.CursoEntradaDeDados;
import entradasdedados.ProfessorEntradaDeDados;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.AlunoModel;
import modelo.AreaModel;
import modelo.CursoModel;
import modelo.ProfessorModel;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        AreaEntradaDeDados entradaArea = new AreaEntradaDeDados();
        ProfessorEntradaDeDados entradaProfessor = new ProfessorEntradaDeDados();
        CursoEntradaDeDados entradaCurso = new CursoEntradaDeDados();
        AlunoEntradaDeDados entradaAluno = new AlunoEntradaDeDados();

        AlunoDAO daoAluno = new AlunoDAO();
        ProfessorDAO daoProfessor = new ProfessorDAO();
        AreaDAO daoArea = new AreaDAO();
        CursoDAO daoCurso = new CursoDAO();

        AlunoModel alunoModel = new AlunoModel();
        ProfessorModel professorModel = new ProfessorModel();
        AreaModel areaModel = new AreaModel();
        CursoModel cursoModel = new CursoModel();

        String menu = "0- Sair\n1 - Aluno\n2 - Professor\n3 - Area\n4 - Curso";
        String menuAluno = "0- Sair\n1- Voltar\n2 - Salvar\n3 - Exibir Todos\n4 - Exibir Por ID\n5 - Editar\n6 - Remover";
        String menuProfessor = "0- Sair\n1 - Voltar\n2 - Salvar\n3 - Exibir Todos\n4 - Exibir Por ID\n5 - Editar\n6 - Remover";
        String menuArea = "0- Sair\n1- Voltar\n2 - Salvar\n3 - Exibir Todos\n4 - Exibir Por ID \n5 - Editar\n6 - Remover";
        String menuCurso = "0- Sair\n1 - Voltar\n2 - Salvar\n3 - Exibir Todos\n4 - Exibir Por ID\n5 - Editar\n6 - remover\n7 - Matricular Aluno";
        String opt = "";
        do {
            opt = JOptionPane.showInputDialog(menu);
            switch (opt) {
                case "0":
                    //sair
                    break;
                case "1":
                    opt = JOptionPane.showInputDialog(menuAluno);
                    switch (opt) {
                        case "0":
                            //sair
                            break;

                        case "1":
                            //voltar
                            break;

                        case "2":
                            //salvar
                            daoAluno.salvarOuAtualizar(entradaAluno.entradaAluno());
                            break;

                        case "3":
                            //exibir todos
                            List<AlunoModel> listaDeAlunos = daoAluno.buscarTodos();
                            if (listaDeAlunos.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Não há alunos cadastrados!");
                            } else {
                                for (AlunoModel aluno : listaDeAlunos) {
                                    JOptionPane.showMessageDialog(null,
                                            "Nome: " + aluno.getNome()
                                            + "Idade: " + aluno.getIdade()
                                            + "Sexo: " + aluno.getSexo()
                                            + "CPF: " + aluno.getCpf()
                                            + "RA: " + aluno.getRa());
                                }
                            }
                            break;

                        case "4":
                            //exibir por id
                            alunoModel = daoAluno.buscarPorId(entradaAluno.informarID("Buscar"));
                            if (alunoModel == null) {
                                JOptionPane.showMessageDialog(null, "Não foi encontrado aluno com o ID informado!");
                            } else {
                                JOptionPane.showMessageDialog(null,
                                        "Nome: " + alunoModel.getNome()
                                        + "\nIdade: " + alunoModel.getIdade()
                                        + "\nSexo: " + alunoModel.getSexo()
                                        + "\nCPF: " + alunoModel.getCpf()
                                        + "\nRA: " + alunoModel.getRa());
                            }
                            break;

                        case "5":
                            //editar
                            alunoModel = daoAluno.buscarPorId(entradaAluno.informarID("Editar"));
                            if (alunoModel == null) {
                                JOptionPane.showMessageDialog(null, "Não foi encontrado nenhum professor com este ID!");
                            } else {
                                daoAluno.salvarOuAtualizar(entradaAluno.novaEntradaAluno(alunoModel));
                            }
                            break;

                        case "6":
                            //remover
                            alunoModel = daoAluno.buscarPorId(entradaAluno.informarID("Remover"));
                            if (alunoModel == null) {
                                JOptionPane.showMessageDialog(null, "Não foi encontrado nenhum aluno com este ID!");
                            } else {
                                daoAluno.remover(alunoModel);
                            }
                            break;

                        default:
                            JOptionPane.showMessageDialog(null, "Opção inválida!", null, 2);
                    }
                    break;

                case "2":
                    opt = JOptionPane.showInputDialog(menuProfessor);
                    switch (opt) {
                        case "0":
                            //sair
                            break;

                        case "1":
                            //voltar
                            break;

                        case "2":
                            daoProfessor.salvarOuAtualizar(entradaProfessor.entradaProfessor());
                            break;

                        case "3":
                            List<ProfessorModel> listaDeProfessor = daoProfessor.buscarTodos();
                            if (listaDeProfessor.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Não há Professores cadastrados!");
                            } else {
                                for (ProfessorModel professor : listaDeProfessor) {
                                    JOptionPane.showMessageDialog(null,
                                            "Nome: " + professor.getNome()
                                            + "\nIdade: " + professor.getIdade()
                                            + "\nSexo: " + professor.getSexo()
                                            + "\nCPF: " + professor.getCpf()
                                            + "\nSIAPE: " + professor.getSiape()
                                            + "\nCurso: " + professor.getCurso().getDescricao()
                                            + "\nArea: " + professor.getCurso().getArea().getDescricao());
                                }
                            }
                            break;

                        case "4":
                            professorModel = daoProfessor.buscarPorId(entradaProfessor.informarID("Buscar"));
                            if (professorModel == null) {
                                JOptionPane.showMessageDialog(null, "Não foi encontrado nenhum professor com este ID!");
                            } else {
                                JOptionPane.showMessageDialog(null,
                                        "Nome: " + professorModel.getNome()
                                        + "\nIdade :" + professorModel.getIdade()
                                        + "\nSexo: " + professorModel.getSexo()
                                        + "\nCPF: " + professorModel.getCpf()
                                        + "\nSIAPE: " + professorModel.getSiape()
                                        + "\nArea: " + professorModel.getCurso().getArea().getDescricao()
                                        + "\nCurso: " + professorModel.getCurso().getDescricao());
                            }
                            break;

                        case "5":
                            professorModel = daoProfessor.buscarPorId(entradaProfessor.informarID("Editar"));
                            if (professorModel == null) {
                                JOptionPane.showMessageDialog(null, "Não foi encontrado nenhum professor com este ID!");
                            } else {
                                daoProfessor.salvarOuAtualizar(entradaProfessor.novaEntradaProfessor(professorModel));
                            }
                            break;

                        case "6":
                            professorModel = daoProfessor.buscarPorId(entradaProfessor.informarID("Remover"));
                            if (professorModel == null) {
                                JOptionPane.showMessageDialog(null, "Não foi encontrado nenhum professor com este ID!");
                            } else {
                                daoProfessor.remover(professorModel);
                            }
                            break;

                        default:
                            JOptionPane.showMessageDialog(null, "Opção inválida", null, 2);
                    }
                    break;

                case "3":
                    opt = JOptionPane.showInputDialog(menuArea);
                    switch (opt) {
                        case "0":
                            //sair
                            break;

                        case "1":
                            //voltar
                            break;

                        case "2":
                            daoArea.salvarOuAtualizar(entradaArea.entradaArea());
                            break;

                        case "3":
                            List<AreaModel> listaDeArea = daoArea.buscarTodos();
                            if(listaDeArea.isEmpty()){
                                JOptionPane.showMessageDialog(null, "Não há Area cadastrada!");
                            }else{
                            
                            for (AreaModel area : listaDeArea) {
                                JOptionPane.showMessageDialog(null, "Descrição da Area: " + area.getDescricao());
                                }
                            }
                            break;

                        case "4":
                            areaModel = daoArea.buscarPorId(entradaArea.informarID("Buscar"));
                            if (areaModel == null) {
                                JOptionPane.showMessageDialog(null, "Não foi encontrada area com a ID informado");
                            } else {
                                JOptionPane.showMessageDialog(null, "Descrição da Area: " + areaModel.getDescricao());
                            }
                            break;

                        case "5":
                            areaModel = daoArea.buscarPorId(entradaArea.informarID("Editar"));
                            if (areaModel == null) {
                                JOptionPane.showMessageDialog(null, "Não foi encontrada area com a ID informado");
                            } else {
                                daoArea.salvarOuAtualizar(entradaArea.novaEntradaArea(areaModel));
                            }
                            break;

                        case "6":
                            areaModel = daoArea.buscarPorId(entradaArea.informarID("Remover"));
                            if (areaModel == null) {
                                JOptionPane.showMessageDialog(null, "Não foi encontrada area com a ID informado");
                            } else {
                                daoArea.remover(areaModel);
                            }
                            break;

                        default:
                            JOptionPane.showMessageDialog(null, "Opção inválida", null, 2);
                    }
                    break;

                case "4":
                    opt = JOptionPane.showInputDialog(menuCurso);
                    switch (opt) {
                        case "0":
                            //sair
                            break;

                        case "1":
                            //voltar
                            break;

                        case "2":
                            daoCurso.salvarOuAtualizar(entradaCurso.entradaCurso());
                            break;

                        case "3":
                            List<CursoModel> ListaDeCursos = daoCurso.buscarTodos();

                            for (CursoModel curso : ListaDeCursos) {

                                if (ListaDeCursos.isEmpty()) {
                                    JOptionPane.showInputDialog(null, "Não foi encontrado cursos cadastrados!", null, 2);
                                } else {
                                    List<AlunoModel> listaDeAlunos;
                                    listaDeAlunos = curso.getListaDeAlunos();

                                    {
                                        if (listaDeAlunos.isEmpty()) {
                                            JOptionPane.showMessageDialog(null,
                                                    "Titulo: " + curso.getTitulo()
                                                    + "\nDescrição: " + curso.getDescricao()
                                                    + "\nLocal: " + curso.getLocal()
                                                    + "\nQuantidade de Vagas: " + curso.getQuantidade_vagas()
                                                    + "\nArea: " + curso.getArea().getDescricao());
                                        } else {
                                            for (AlunoModel alunos : listaDeAlunos) {
                                                JOptionPane.showMessageDialog(null,
                                                        "Titulo: " + curso.getTitulo()
                                                        + "\nDescrição: " + curso.getDescricao()
                                                        + "\nLocal: " + curso.getLocal()
                                                        + "\nQuantidade de Vagas: " + curso.getQuantidade_vagas()
                                                        + "\nArea: " + curso.getArea().getDescricao()
                                                        + "\nAluno: " + alunos.getNome());
                                            }
                                        }
                                    }
                                }
                            }
                            break;

                        case "4":
                            cursoModel = daoCurso.buscarPorId(entradaCurso.informarID("Buscar"));
                            List<AlunoModel> listaDeAlunos;

                            if (cursoModel == null) {

                                JOptionPane.showMessageDialog(null, "Não foi encontrado cursos com o ID informado!", null, 2);
                            } else {
                                listaDeAlunos = cursoModel.getListaDeAlunos();
                                for (AlunoModel alunos : listaDeAlunos) {

                                    JOptionPane.showMessageDialog(null,
                                            "Titulo do curso: " + cursoModel.getTitulo()
                                            + "\nDescrição: " + cursoModel.getDescricao()
                                            + "\nLocal: " + cursoModel.getLocal()
                                            + "\nQuantidade de Vagas: " + cursoModel.getQuantidade_vagas()
                                            + "\nArea: " + cursoModel.getArea().getDescricao()
                                            + "\nAluno: " + alunos.getNome());
                                }
                            }
                            break;

                        case "5":
                            cursoModel = daoCurso.buscarPorId(entradaCurso.informarID("Editar"));
                            if (cursoModel == null) {
                                JOptionPane.showMessageDialog(null, "Não foi encontrado cursos com o ID informado!", null, 2);
                            } else {
                                daoCurso.salvarOuAtualizar(entradaCurso.novaEntradaCurso(cursoModel));
                            }
                            break;

                        case "6":
                            cursoModel = daoCurso.buscarPorId(entradaCurso.informarID("Remover"));
                            if (cursoModel == null) {
                                JOptionPane.showMessageDialog(null, "Não foi encontrado cursos com o ID informado!");
                            } else {
                                daoCurso.remover(cursoModel);
                            }
                            break;
                        case "7":
                            cursoModel = daoCurso.buscarPorId(entradaCurso.informarID(""));
                            if (cursoModel == null) {
                                JOptionPane.showMessageDialog(null, "Não foi encontrado cursos com o ID informado!", null, 2);
                            } else {
                                cursoModel = entradaCurso.inserirAlunoNoCurso(cursoModel);
                                daoCurso.salvarCursoComAluno(cursoModel);
                            }
                            break;

                        default:
                            JOptionPane.showMessageDialog(null, "Opção inválida!", null, 2);
                    }
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!", null, 2);
            }
        } while (!opt.equals("0"));

        daoAluno.encerrar();
        daoProfessor.encerrar();
        daoArea.encerrar();
        daoCurso.encerrar();
    }

}
