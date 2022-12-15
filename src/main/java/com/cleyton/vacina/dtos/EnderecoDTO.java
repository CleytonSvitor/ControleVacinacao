package com.cleyton.vacina.dtos;

import java.io.Serializable;

import com.cleyton.vacina.model.Endereco;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class EnderecoDTO implements Serializable{	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String rua;
	private String cidade;
	private String estado;
	private String cep;
	private String comentario;
	
	public EnderecoDTO(Endereco obj) {
		super();
		this.id = obj.getId();
		this.rua = obj.getRua();
		this.cidade = obj.getCidade();
		this.estado = obj.getEstado();
		this.cep = obj.getCep();
		this.comentario = obj.getComentario();
	}
	
	
	

}
