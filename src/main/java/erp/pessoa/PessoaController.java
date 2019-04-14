package erp.pessoa;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import erp.base.BaseController;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController extends BaseController<Pessoa, PessoaRepository, PessoaServiceImpl> {

	private final PessoaServiceImpl pessoaServiceImpl;
	private final PessoaRepository pessoaRepository;

	public PessoaController(PessoaServiceImpl pessoaServiceImpl, PessoaRepository pessoaRepository) {
		this.pessoaServiceImpl = pessoaServiceImpl;
		this.pessoaRepository = pessoaRepository;
	}
	
	
	@GetMapping(value="/listarTodosDTO")
	public ResponseEntity<List<PessoaResponseDTO>> listarTodosDTO(){
		return ResponseEntity.status(HttpStatus.OK).body(pessoaServiceImpl.listAll());
	}

}
