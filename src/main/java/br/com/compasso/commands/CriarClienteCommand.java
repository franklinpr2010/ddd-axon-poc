package br.com.compasso.commands;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import org.axonframework.commandhandling.RoutingKey;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import br.com.compasso.entity.Cidade;
import br.com.compasso.enums.SexoEnum;


public class CriarClienteCommand implements Serializable {
	
	public CriarClienteCommand() {
		
	}

	public CriarClienteCommand(UUID id, String nomeCompleto, SexoEnum sexo, Date dataNascimento, Cidade cidade,
			Integer idade) {
		super();
		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.cidade = cidade;
		this.idade = idade;
	}
	private static final long serialVersionUID = 896344489334932669L;
	@TargetAggregateIdentifier
	private UUID id;
	private String nomeCompleto;
	private SexoEnum sexo;
	private Date dataNascimento;
	private Cidade cidade;
	private Integer idade;
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public SexoEnum getSexo() {
		return sexo;
	}
	public void setSexo(SexoEnum sexo) {
		this.sexo = sexo;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	
	

}
