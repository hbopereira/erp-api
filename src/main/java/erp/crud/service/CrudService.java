package erp.crud.service;

import java.util.List;

import erp.base.BaseEntity;

public interface CrudService<ResponseDTO, Entidade extends BaseEntity, Id>{
	
	List<ResponseDTO> listAll();
	ResponseDTO converteEntidadeParaResponseDTO(Entidade entidade);

}
