package org.generation.LojaGame.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity  // Informando que é uma entidade
@Table(name = "tb_categoria")   // Create table categoria 
public class Categoria {
	
	@Id  // Primary Key -- informando que o private long id é meu ID
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
	private long id; // id bigint
	
	@NotBlank  // notnull, não pode ficar vazio, nem com espaços
	@Size(min = 2, max = 30) // tamanho do nosso varchar
	private String tipo; // tipo varchar (30)
	
	@NotBlank  // notnull, não pode ficar vazio, nem com espaços
	@Size(min = 2, max = 250) // tamanho do nosso varchar
	private String descricao; // descricao varchar (250)

	@OneToMany(mappedBy = "categoria", cascade = CascadeType.REMOVE) // uma categoria para muitos produtos, ligacao com a tabela produtos, cascade remove a lista de um looping
	@JsonIgnoreProperties("categoria") // recursividade
	private List<Produto> produtos; 
	
	//Getters and Setters
	
	public long getId() {
		return id;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
}
