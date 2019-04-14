package erp.categoria;

import javax.persistence.Entity;
import javax.persistence.Table;

import erp.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="categoria")
public class Categoria extends BaseEntity {
	
	private String descricao;

}
