package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "area")
public class AreaModel implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idarea;
    
    @Column(length = 32, nullable = false)
    private String descricao;
    
    /*
    @OneToMany(mappedBy="area", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private List<ProfessorModel> listaDeProfessores;
    */

    @OneToMany(mappedBy = "area", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private List<CursoModel> listaDeCursos;
   
    //########################################\\

    public List<CursoModel> getListaDeCursos() {
        return listaDeCursos;
    }

    public void setListaDeCursos(List<CursoModel> listaDeCursos) {
        this.listaDeCursos = listaDeCursos;
    }
    
    /*   
    public List<ProfessorModel> getListaDeProfessores() {
        return listaDeProfessores;
    }

    public void setListaDeProfessores(List<ProfessorModel> listaDeProfessores) {
        this.listaDeProfessores = listaDeProfessores;
    }
    */
    
    public int getIdarea() {
        return idarea;
    }

    public void setIdarea(int idarea) {
        this.idarea = idarea;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
