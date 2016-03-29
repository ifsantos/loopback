package br.invest.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(name="Investimento.findAll",query="select e from Investimento e")
})

@Entity
@Table(name="investimento")
public class Investimento implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private Long id;
	private String nome;
	private Date dataInicio;
	private Double valor;
	
	@OneToMany(fetch=FetchType.LAZY)
	private List<Aporte> aportes;  
	
	public Investimento(Long id, String nome, Date dataInicio) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataInicio = dataInicio;
		this.valor = 0.0;
	}

	public Investimento() {
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Double getValor() {
		for (Aporte a : getAportes()){
			valor += a.getValor();
		}
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public List<Aporte> getAportes() {
		if (this.aportes == null){
			this.aportes = new ArrayList<>();
		}
		return aportes;
	}

	public void setAportes(List<Aporte> aportes) {
		this.aportes = aportes;
	}

	@Override
	public String toString() {
		return "Investimento [id=" + id + ", nome=" + nome + ", dataInicio=" + dataInicio + ", valor=" + valor + "]";
	}

}
