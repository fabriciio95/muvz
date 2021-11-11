package com.muvz.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.groups.Default;

import com.muvz.domain.validation.Validation.ClienteAtualizacaoValidation;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "cli_cliente")
public class Cliente {

	@EqualsAndHashCode.Include
	@NotNull(groups = ClienteAtualizacaoValidation.class, message = "Id não pode ser nulo")
	@Null(message = "Id deve ser nulo")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(groups = { Default.class, ClienteAtualizacaoValidation.class }, message = "Nome não pode ser vazio")
	@Column(nullable = false)
	private String nome;
	
	@NotBlank(groups = { Default.class, ClienteAtualizacaoValidation.class }, message = "Cpf não pode ser vazio")
	@Column(nullable = false, unique = true)
	private String cpf;
	
	@NotBlank(groups = { Default.class, ClienteAtualizacaoValidation.class }, message = "Telefone não pode ser vazio")
	@Column(nullable = false, unique = true)
	private String telefone;
	
	@Email(message = "Padrão de e-mail inválido")
	@Column(nullable = false, unique = true)
	private String email;
}
