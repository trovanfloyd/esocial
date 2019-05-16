package br.gov.ce.seplag.esocial.extrator.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository<T> extends CrudRepository<T, Long> {

	/*@SuppressWarnings("unchecked")
	@Override
	T save(Object entity);*/
	
	List<T> findAllByOrderByIdAsc();
	
}
