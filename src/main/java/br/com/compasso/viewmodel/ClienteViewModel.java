package br.com.compasso.viewmodel;

import java.util.Date;
import java.util.UUID;

import br.com.compasso.entity.Cidade;
import br.com.compasso.enums.SexoEnum;

public class ClienteViewModel {

	public ClienteViewModel() {
		
	}
	
	private UUID id;

	private String nomeCompleto;

	private SexoEnum sexo;

	private Date dataNascimento;

	private Cidade cidade;
	
	
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
}