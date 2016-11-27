package br.com.exemplo.vendas.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author fernandopucci
 *
 */
@XmlRootElement
@Entity
@Table(name = "ITEM_VENDA")
@JsonAutoDetect
public class ItemVenda implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -727394159569003805L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ITEM_VENDA")
	@JsonProperty("id_item_venda")
	private Long idItemVenda;

	@ManyToOne
	@JoinColumn(name = "ID_VENDA")
	private Venda venda;

	@JsonProperty("produto")
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PRODUTO")
	private Produto produto;

	@Column(name = "QUANTIDADE")
	@JsonProperty("quantidade")
	private Double quantidade;

	@Column(name = "SUB_TOTAL")
	@JsonProperty("sub_total")
	private Double subTotal;

	public Long getIdItemVenda() {
		return idItemVenda;
	}

	public void setIdItemVenda(Long idItemVenda) {
		this.idItemVenda = idItemVenda;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {

		if (this.quantidade != null && this.quantidade != 0 && this.produto != null
				&& this.produto.getValorUnitario() != null) {
			this.subTotal = this.quantidade * this.produto.getValorUnitario();

		} else {

			this.subTotal = subTotal;
		}
	}

	@Override
	public String toString() {
		return "ItemVenda [idItemVenda=" + idItemVenda + ", venda=" + venda + ", produto=" + produto + ", quantidade="
				+ quantidade + ", subTotal=" + subTotal + "]";
	}

}
