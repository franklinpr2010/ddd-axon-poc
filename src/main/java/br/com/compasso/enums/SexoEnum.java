package br.com.compasso.enums;

import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.Optional;

public enum SexoEnum {

	M(0,"Masculino"),
	F(1,"Feminino");
	
	private final int codigo;
	private final String nome;

	private SexoEnum(int codigo,String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}
	
	public String getCodigo() {
		return Integer.toString(codigo);
	}
	
	public String getNome(){
		return nome;
	}
	
	public int getCodigoSexo(){
		return codigo;
	}
	
	public static Optional<SexoEnum> valueOf(int value) {
        return Arrays.stream(values())
            .filter(legNo -> legNo.codigo == value)
            .findFirst();
    }
}
