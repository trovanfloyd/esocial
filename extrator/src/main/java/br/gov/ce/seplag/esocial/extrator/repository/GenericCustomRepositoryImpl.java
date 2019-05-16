package br.gov.ce.seplag.esocial.extrator.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public class GenericCustomRepositoryImpl implements GenericCustomRepository<Object> {

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	@Transactional
	public void saveCustom(Object entity) {
		try {
			entityManager.persist(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
