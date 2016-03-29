package br.invest.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import br.invest.api.util.JsonDateDeserializer;
import br.invest.api.util.JsonDateSerializer;

public class InvestimentoBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	private Date dataInicio;
	private Double valor;
	
	@OneToMany(fetch=FetchType.LAZY)
	private List<AporteBean> aportes;  
	
	public InvestimentoBean(Long id, String nome, Date dataInicio) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataInicio = dataInicio;
		this.valor = 0.0;
	}

	public InvestimentoBean() {
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
	@JsonSerialize(using=JsonDateSerializer.class)
	public Date getDataInicio() {
		return dataInicio;
	}
	
	@JsonDeserialize(using=JsonDateDeserializer.class)
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Double getValor() {
		for (AporteBean a : getAportes()){
			valor += a.getValor();
		}
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public List<AporteBean> getAportes() {
		if (this.aportes == null){
			this.aportes = new ArrayList<>();
		}
		return aportes;
	}

	public void setAportes(List<AporteBean> aportes) {
		this.aportes = aportes;
	}

	@Override
	public String toString() {
		return "Investimento [id=" + id + ", nome=" + nome + ", dataInicio=" + dataInicio + ", valor=" + valor + "]";
	}

}
