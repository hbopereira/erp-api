package erp.categoria;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import erp.base.BaseController;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController extends BaseController<Categoria,CategoriaRepository,CategoriaService>{

}
