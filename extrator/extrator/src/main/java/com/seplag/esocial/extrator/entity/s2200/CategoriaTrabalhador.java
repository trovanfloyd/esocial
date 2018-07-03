package com.seplag.esocial.extrator.entity.s2200;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_01_categoria_trabalhador", schema = "db_esocial")
public class CategoriaTrabalhador implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "isn_categoria_trabalhador")
	private Long isnCategoriaTrabalhador;

	@Column(name = "txt_grupo")
	private String grupo;

	@Column(name = "txt_categoria_trabalhador")
	private String descricao;

	public Long getIsnCategoriaTrabalhador() {
		return isnCategoriaTrabalhador;
	}

	public void setIsnCategoriaTrabalhador(Long isnCategoriaTrabalhador) {
		this.isnCategoriaTrabalhador = isnCategoriaTrabalhador;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
