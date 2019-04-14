package erp.lancamento;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import erp.base.BaseService;

@Service
public class LancamentoServiceImpl extends BaseService<Lancamento,LancamentoRepository> implements LancamentoService {
	
	private final LancamentoRepository lancamentoRepository;
	
	public LancamentoServiceImpl(LancamentoRepository lancamentoRepository) {
		this.lancamentoRepository = lancamentoRepository;
	}

	@Override
	public List<LancamentoResponseDTO> listAll() {
		List<Lancamento> lancamentos = lancamentoRepository.findAll();
		List<LancamentoResponseDTO> retorno = new ArrayList<>();
		
		lancamentos.forEach(lancamento -> retorno.add(converteEntidadeParaResponseDTO(lancamento)));
		return retorno;
	}

	@Override
	public LancamentoResponseDTO converteEntidadeParaResponseDTO(Lancamento lancamento) {
		
		LancamentoResponseDTO lancamentoResponseDTO = new LancamentoResponseDTO();
		
		lancamentoResponseDTO.setCategoria(lancamento.getCategoria());
		lancamentoResponseDTO.setPessoa(lancamento.getPessoa());
		lancamentoResponseDTO.setDataPagamento(lancamento.getDataPagamento());
		lancamentoResponseDTO.setDataVencimento(lancamento.getDataVencimento());
		lancamentoResponseDTO.setValor(lancamento.getValor());
		lancamentoResponseDTO.setObservacao(lancamento.getObservacao());
		
		return lancamentoResponseDTO;
	}

}
