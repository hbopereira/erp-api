package erp.pessoa;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import erp.base.BaseService;


// esta classe implementa 2 outras superclasses baseService e pessoa Service que extends de crud service
//com isso é obrigatorio implementar os 2 metodos listAll e converteEntidadeParaResponseDTO


@Service
public class PessoaServiceImpl extends BaseService<Pessoa, PessoaRepository> implements PessoaService {

	private final PessoaRepository pessoaRepository;

	public PessoaServiceImpl(PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
	}

	@Override
	public List<PessoaResponseDTO> listAll() {
		List<Pessoa> pessoas = pessoaRepository.findAll();
		List<PessoaResponseDTO> retorno = new ArrayList<>();
		
		pessoas.forEach(pessoa -> retorno.add(converteEntidadeParaResponseDTO(pessoa)));
		
		return retorno;
	}

	@Override
	public PessoaResponseDTO converteEntidadeParaResponseDTO(Pessoa pessoa) {
		PessoaResponseDTO pessoaResponseDTO = new PessoaResponseDTO();
		
		pessoaResponseDTO.setEndereco(pessoa.getEndereco());
		pessoaResponseDTO.setPessoaTipo(pessoa.getPessoaTipo());
		pessoaResponseDTO.setDataNascimento(pessoa.getDataNascimento());
		pessoaResponseDTO.setCpf(pessoa.getCpf());
		pessoaResponseDTO.setRg(pessoa.getRg());
		pessoaResponseDTO.setCnpj(pessoa.getCnpj());
		pessoaResponseDTO.setNome(pessoa.getNome());
		pessoaResponseDTO.setEmail(pessoa.getEmail());
		pessoaResponseDTO.setAtivo(pessoa.isAtivo());
		pessoaResponseDTO.setId(pessoa.getId());
		
		return pessoaResponseDTO;
	}

}
