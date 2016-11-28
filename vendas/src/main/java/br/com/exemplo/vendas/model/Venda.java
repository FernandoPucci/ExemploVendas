package br.com.exemplo.vendas.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

import br.com.exemplo.vendas.util.Utils;

/**
 * @author fernandopucci
 *
 */
@XmlRootElement
@Entity
@Table(name = "VENDA")
@JsonAutoDetect
public class Venda implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2489826485239793800L;

	public Venda() {
		super();
		if (this.dataVenda == null) {
			this.dataVenda = new Date(System.currentTimeMillis());
		}
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_VENDA")
	@JsonProperty("id_venda")
	private Long idVenda;

	@Column(name = "DT_VENDA")
	@JsonSerialize(using = DateSerializer.class)
	@Temporal(value = TemporalType.TIMESTAMP)
	@JsonIgnore
	private Date dataVenda;


	@JsonProperty("itens_venda")
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "venda", cascade = CascadeType.ALL)
	private Set<ItemVenda> itens = new HashSet<>();

	@Column(name = "VLR_TOTAL")
	@JsonProperty("vlr_total")
	private Double valorTotal = 0.0;

	public Long getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(Long idVenda) {
		this.idVenda = idVenda;
	}

	@JsonIgnore
	public Date getDataVenda() {
		return dataVenda;
	
	}
	
	@JsonProperty("data-venda")
	public String getDataVendaStr() {		
		return Utils.formataData(dataVenda);
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}
	
	@JsonManagedReference
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

	 public void addItem(ItemVenda itemVenda) {
	     if (itemVenda != null) {
	        if (itens == null) {
	            itens = new HashSet<>();          
	        }
	        itens.add(itemVenda);
	        itemVenda.setVenda(this);	     }
	  }
	
	
	@Override
	public String toString() {
		return "Venda [idVenda=" + idVenda + ", dataVenda=" + Utils.formataData(dataVenda) + ", itens=" + itens + ", valorTotal="
				+ valorTotal + "]";
	}

}
