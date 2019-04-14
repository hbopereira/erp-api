package erp.lancamento;

import java.math.BigDecimal;
import java.time.LocalDate;

import erp.categoria.Categoria;
import erp.pessoa.Pessoa;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LancamentoResponseDTO {
	
	private Pessoa pessoa;
	private Categoria categoria;
	private LocalDate dataPagamento;
	private LocalDate dataVencimento;
	private String observacao;
	private BigDecimal valor;

}
