package br.com.exemplo.vendas.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

/**
 * @author fernandopucci
 *
 */
@XmlRootElement
@Entity
@Table(name = "VENDA")
@JsonAutoDetect
public class Venda implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2489826485239793800L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_VENDA")
	@JsonProperty("id_venda")
	private Long idVenda;
	
	@Column(name = "DT_VENDA")
	@JsonSerialize(using = DateSerializer.class)
	@Temporal(value = TemporalType.TIMESTAMP)
	@JsonProperty("dt_venda")
	private Date dataVenda;
	
	@OneToMany(mappedBy = "venda", cascade = CascadeType.ALL)
	@JsonProperty("itens_venda")
	private Set<ItemVenda> itens;
	
	@Column(name = "VLR_TOTAL")
	@JsonProperty("vlr_total")
	private Double valorTotal;

	public Long getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(Long idVenda) {
		this.idVenda = idVenda;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Set<ItemVenda> getItens() {
		return itens;
	}

	public void setItens(Set<ItemVenda> itens) {
		this.itens = itens;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	@Override
	public String toString() {
		return "Venda [idVenda=" + idVenda + ", dataVenda=" + dataVenda + ", itens=" + itens + ", valorTotal="
				+ valorTotal + "]";
	}	

}
