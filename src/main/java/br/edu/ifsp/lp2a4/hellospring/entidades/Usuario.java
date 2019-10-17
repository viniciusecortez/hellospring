package br.edu.ifsp.lp2a4.hellospring.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.NotBlank;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotBlank(message = "O nome � obrigat�rio!")
	private String nome;
	
	@NotBlank(message = "O sobrenome � obrigat�rio!")
	private String sobrenome;
	
	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public Usuario() {
		
	}
	
	public Usuario(String nome, String sobrenome) {
		this.nome = nome;
		this.sobrenome = sobrenome;
	}
}
