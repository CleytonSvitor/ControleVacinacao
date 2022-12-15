package com.cleyton.vacina.controller.exceptions;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class StandardErro implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long timestamp;
	private Integer status;
	private String error;
	
	

}
