package erp.pessoa;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import erp.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pessoa")
public class Pessoa extends BaseEntity {

	@Embedded
	private Endereco endereco;

	@Enumerated(EnumType.STRING)
	private PessoaTipo pessoaTipo;

	@Column(name = "data_nascimento")
	private LocalDate dataNascimento;

	private String nome;
	private String email;
	private Long cpf;
	private Long rg;
	private long cnpj;
	private boolean ativo;

}
