package erp.lancamento;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import erp.base.BaseController;

@RestController
@RequestMapping("/api/lancamentos")
public class LancamentoController extends BaseController<Lancamento,LancamentoRepository,LancamentoServiceImpl> {
	
	private final LancamentoServiceImpl lancamentoServiceImpl;

	public LancamentoController(LancamentoServiceImpl lancamentoServiceImpl) {
		this.lancamentoServiceImpl = lancamentoServiceImpl;
	}
	
	@GetMapping(value="/listarTodosDTO")
	public ResponseEntity<List<LancamentoResponseDTO>> listarTodosDTO(){
		return ResponseEntity.status(HttpStatus.OK).body(lancamentoServiceImpl.listAll());
	}
	
	

}
