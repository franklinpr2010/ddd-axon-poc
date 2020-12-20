package br.com.compasso.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import br.com.compasso.enums.SexoEnum;

/**
 * Entidade Cliente
 * @author franklin.roza
 *
 */
@Entity(name = "CLIENTE")
public class Cliente implements Serializable{

	private static final long serialVersionUID = 4653335586691363469L;

	public Cliente() {

	}
	
	public Cliente(UUID id,  String nomeCompleto, SexoEnum sexo, Date dataNascimento, Cidade cidade) {
		this.nomeCompleto = nomeCompleto;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.cidade = cidade;
		this.setId(id);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private UUID id;

	private String nomeCompleto;

	@Enumerated(EnumType.ORDINAL)
	private SexoEnum sexo;

	private Date dataNascimento;

	@OneToOne
	private Cidade cidade;
	
	@Transient
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

	public SexoEnum getSexo() {
		return sexo;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public Cidade getCidade() {
		return cidade;
	}
	
	
	
    
    public void atualizar(String nomeCompleto, SexoEnum sexo, Date dataNascimento, Cidade cidade)
    {
    	this.nomeCompleto = nomeCompleto;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.cidade = cidade;
    }
	
	
	/**
	 *  Obtem a idade
	 *  Atributos calculados não precisam estar no banco
	 * @return idade
	 */
	public Integer getIdade() {
		Date dataNascInput = getDataNascimento();
		Calendar dateOfBirth = new GregorianCalendar();
		dateOfBirth.setTime(dataNascInput);
		Calendar today = Calendar.getInstance();
		idade = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
		dateOfBirth.add(Calendar.YEAR, idade);
		if (today.before(dateOfBirth)) {
			idade--;
	    }
		return idade;	
	}


}
