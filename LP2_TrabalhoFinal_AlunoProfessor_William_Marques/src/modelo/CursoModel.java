package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author will_jr
 */

@Entity
@Table(name = "curso")
public class CursoModel implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int idcurso;
    
    @Column(length = 32, nullable = false)
    private String titulo;
    
    @Column(length = 64, nullable = false)
    private String descricao;
    
    @Column(length = 32, nullable = false)
    private String local;
    
    @Column(nullable = false)
    private int quantidade_vagas;
    
    @OneToMany(mappedBy = "curso", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private List<ProfessorModel> ListaDeprofessores;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idarea", insertable = true ,updatable = true, nullable = false)
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.SAVE_UPDATE)
    private AreaModel area;
   
    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT) 
    @JoinTable(name = "curso_aluno", joinColumns = @JoinColumn(name = "curso_id"),inverseJoinColumns = @JoinColumn(name = "aluno_id"))
    private List<AlunoModel> listaDeAlunos = new ArrayList<>();
 
    //########################################\\

    public List<AlunoModel> getListaDeAlunos() {
        return listaDeAlunos;
    }

    public void setListaDeAlunos(List<AlunoModel> listaDeAlunos) {
        this.listaDeAlunos = listaDeAlunos;
    }

    public AreaModel getArea() {
        return area;
    }

    public void setArea(AreaModel area) {
        this.area = area;
    }
    
    public List<ProfessorModel> getListaDeprofessores() {
        return ListaDeprofessores;
    }

    public void setListaDeprofessores(List<ProfessorModel> ListaDeprofessores) {
        this.ListaDeprofessores = ListaDeprofessores;
    }
    
    public int getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(int idcurso) {
        this.idcurso = idcurso;
    }

    public int getId() {
        return idcurso;
    }

    public void setId(int id) {
        this.idcurso = id;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getQuantidade_vagas() {
        return quantidade_vagas;
    }

    public void setQuantidade_vagas(int quantidade_vagas) {
        this.quantidade_vagas = quantidade_vagas;
    }
    
    
}
