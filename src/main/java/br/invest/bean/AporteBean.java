package br.invest.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import br.invest.api.util.JsonDateDeserializer;
import br.invest.api.util.JsonDateSerializer;

public class AporteBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Date dataExecucao;
	private Double valor;
	@ManyToOne
	@JoinColumn(name="id_investimento")
	private InvestimentoBean investimento;
	
	public AporteBean(Long id, Date dataExecucao, Double valor, InvestimentoBean investimento) {
		super();
		this.id = id;
		this.dataExecucao = dataExecucao;
		this.valor = valor;
		this.investimento = investimento;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@JsonSerialize(using=JsonDateSerializer.class)
	public Date getDataExecucao() {
		return dataExecucao;
	}
	@JsonDeserialize(using=JsonDateDeserializer.class)
	public void setDataExecucao(Date dataExecucao) {
		this.dataExecucao = dataExecucao;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	@JsonIgnore(value=true)
	public InvestimentoBean getInvestimento() {
		return investimento;
	}
	@JsonIgnore(value=true)
	public void setInvestimento(InvestimentoBean investimento) {
		this.investimento = investimento;
	}
	@Override
	public String toString() {
		return "Aporte [id=" + id + ", dataExecucao=" + dataExecucao + ", valor=" + valor + ", investimento=" + investimento + "]";
	}
	
}
