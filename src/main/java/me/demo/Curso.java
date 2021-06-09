package me.demo;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
@Entity
class Curso{
    private @Id @GeneratedValue Long id;
    private String nome;
    private String descricao;
    private String ementa;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private @Temporal(TemporalType.DATE) Date dataCadastro;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private @Temporal(TemporalType.DATE) Date dataInicio;
    private float valor;
     

    public Curso() {
        
    }
        
    


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEmenta() {
        return this.ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public Date getDataCadastro() {

        return this.dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataInicio() {
        return this.dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public float getValor() {
        return this.valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Curso)) {
            return false;
        }
        Curso curso = (Curso) o;
        return Objects.equals(id, curso.id) && Objects.equals(nome, curso.nome) && Objects.equals(descricao, curso.descricao) && Objects.equals(ementa, curso.ementa) && Objects.equals(dataCadastro, curso.dataCadastro) && Objects.equals(dataInicio, curso.dataInicio) && valor == curso.valor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, descricao, ementa, dataCadastro, dataInicio, valor);
    }
    

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nome='" + getNome() + "'" +
            ", descricao='" + getDescricao() + "'" +
            ", ementa='" + getEmenta() + "'" +
            ", dataCadastro='" + getDataCadastro() + "'" +
            ", dataInicio='" + getDataInicio() + "'" +
            ", valor='" + getValor() + "'" +
            "}";
    }
    
}