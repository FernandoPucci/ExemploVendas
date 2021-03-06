package br.com.exemplo.vendas.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author fernandopucci
 *
 */
@XmlRootElement
@Entity
@Table(name = "LKP_TP_EMBALAGEM")
@JsonAutoDetect
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TipoEmbalagem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7175711914118229209L;
	
	public TipoEmbalagem(String descricao) {
		super();
		this.descricao = descricao != null ? descricao.trim().toUpperCase() : descricao;;
	}

	public TipoEmbalagem() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TP_EMBALAGEM")	
	private Long idTipoEmbalagem;

	@Column(name = "TP_EMBALAGEM")
	@JsonProperty("tp_embalagem")
	private String descricao;

	@JsonIgnore
	public Long getIdTipoEmbalagem() {
		return idTipoEmbalagem;
	}

	@JsonProperty("id_tp_embalagem")
	public void setIdTipoEmbalagem(Long idTipoEmbalagem) {
		this.idTipoEmbalagem = idTipoEmbalagem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao != null ? descricao.trim().toUpperCase() : descricao;
	}

	@Override
	public String toString() {
		return "TipoEmbalagem [idTipoEmbalagem=" + idTipoEmbalagem + ", descricao=" + descricao + "]";
	}

}
