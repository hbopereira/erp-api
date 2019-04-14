package erp.base;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class BaseController
  <ENTITY extends BaseEntity, REPOSITORY extends BaseRepository<ENTITY>, 
    SERVICE extends BaseService<ENTITY,
       REPOSITORY>> {

	@Autowired
	private SERVICE service;

	@Autowired
	private REPOSITORY repo;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> salvar(@Valid @RequestBody ENTITY entity) {

		try {
			Optional<ENTITY> resultado = service.salvar(entity);
			if (resultado.isPresent()) {
				return ResponseEntity.status(HttpStatus.CREATED).body(resultado.get().getId());
			}
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.badRequest().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<String> atualizar(@PathVariable("id") Long id, @RequestBody ENTITY entity) {

		if (!id.equals(entity.getId())) {
			return ResponseEntity.badRequest().build();
		}
		Optional<ENTITY> resultado = service.atualizar(entity);
		if (resultado.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(resultado.get().getId().toString());
		}

		return ResponseEntity.notFound().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> post(@PathVariable("id") Long id) {
		service.excluirPorId(id);
		return ResponseEntity.noContent().build();
	}

}
