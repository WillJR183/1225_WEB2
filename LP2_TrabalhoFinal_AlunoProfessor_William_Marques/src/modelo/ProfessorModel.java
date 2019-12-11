package modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author Frank
 *
 */

@Entity
@Table(name = "professor")
@PrimaryKeyJoinColumn(name = "idpessoa")
public class ProfessorModel extends PessoaModel implements Serializable{
    private long siape;
    
    /*
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idArea", insertable=true, updatable=true, nullable = false)
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.SAVE_UPDATE)
    private AreaModel area;
    */
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idcurso", insertable = true, updatable = true, nullable = false)
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.SAVE_UPDATE)
    private CursoModel curso;
    
    //########################################\\

    public CursoModel getCurso() {
        return curso;
    }

    public void setCurso(CursoModel curso) {
        this.curso = curso;
    }
      
    public ProfessorModel(String nome, int idade, long cpf, String sexo) {
        super(nome, idade, cpf, sexo);
    } 
   
    /*
    public AreaModel getArea() {
        return area;
    }

    public void setArea(AreaModel area) {
        this.area = area;
    }
    */

    public long getSiape() {
        return siape;
    }

    public void setSiape(long siape) {
        this.siape = siape;
    }
    
    public ProfessorModel(){
        
    }
}
