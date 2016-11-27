package br.com.exemplo.vendas.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "PRODUTO")
@JsonAutoDetect
public class Produto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2626074609816922800L;

	public Produto(Long idProduto, String descricao, Double valorUnitario, TipoEmbalagem tipoEmbalagem) {
		super();
		this.idProduto = idProduto;
		this.descricao = descricao != null ? descricao.trim().toUpperCase() : descricao;
		this.valorUnitario = valorUnitario;
		this.tipoEmbalagem = tipoEmbalagem;
	}

	public Produto() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PRODUTO")
	@JsonProperty("id_produto")
	private Long idProduto;

	@Column(name = "DESCRICAO")
	@JsonProperty("descricao")
	private String descricao;

	@Column(name = "VLR_UNITARIO")
	@JsonProperty("vlr_unitario")
	private Double valorUnitario;

	@JsonProperty("tp_embalagem")
	@OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name = "ID_TP_EMBALAGEM")
	private TipoEmbalagem tipoEmbalagem;

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao != null ? descricao.trim().toUpperCase() : descricao;
		;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public TipoEmbalagem getTipoEmbalagem() {
		return tipoEmbalagem;
	}

	public void setTipoEmbalagem(TipoEmbalagem tipoEmbalagem) {
		this.tipoEmbalagem = tipoEmbalagem;
	}

	@Override
	public String toString() {
		return "Produto [idProduto=" + idProduto + ", descricao=" + descricao + ", valorUnitario=" + valorUnitario
				+ ", tipoEmbalagem=" + tipoEmbalagem + "]";
	}

}
