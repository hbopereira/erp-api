package erp.pessoa;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaResponseDTO {
	
	private PessoaTipo pessoaTipo;
	private Endereco endereco;
	private Long id;
	private String nome;
	private String email;
	private LocalDate dataNascimento;
	private Long rg;
	private Long cpf;
	private Long cnpj;
	private boolean ativo;

}
