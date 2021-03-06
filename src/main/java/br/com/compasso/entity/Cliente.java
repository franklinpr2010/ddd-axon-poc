package br.com.compasso.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import br.com.compasso.enums.EstadoEnum;
import br.com.compasso.enums.SexoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidade Cliente
 * @author franklin.roza
 *
 */
@org.hibernate.annotations.GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "COMPASSO_CLIENTE")
public class Cliente{

	private static final long serialVersionUID = 4653335586691363469L;


	@Id
	@GeneratedValue(generator = "UUID")
	private UUID id;

	private String nomeCompleto;

	@Enumerated(EnumType.ORDINAL)
	private SexoEnum sexo;

	private Date dataNascimento;

	@OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private Cidade cidade;
	
	@Transient
	private Integer idade;
	
    
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
