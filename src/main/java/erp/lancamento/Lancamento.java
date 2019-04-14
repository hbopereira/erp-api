package erp.lancamento;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import erp.base.BaseEntity;
import erp.categoria.Categoria;
import erp.pessoa.Pessoa;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "lancamento")
public class Lancamento extends BaseEntity {

	@Enumerated(EnumType.STRING)
	private LancamentoTipo lancamentoTipo;

	@ManyToOne
	@JoinColumn(name="id_categoria")
	private Categoria categoria;

	@ManyToOne
	@JoinColumn(name="id_pessoa")
	private Pessoa pessoa;

	private String descricao;

	@Column(name = "data_vencimento")
	private LocalDate dataVencimento;

	@Column(name = "data_pagamento")
	private LocalDate dataPagamento;

	private BigDecimal valor;

	private String observacao;

}
