package br.unifor.pin.saa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.entity.Aulas;

@Repository
@Transactional(propagation=Propagation.REQUIRED)
public class AulasDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void salvar(Aulas aula) {
		entityManager.persist(aula);
	}
	
	public void atualizar(Aulas aula){
		entityManager.merge(aula);
	}
	
	public void excluir(Aulas aula){
		entityManager.remove(aula);
	}
	
	public Aulas buscarPorId(Long id){
		return entityManager.find(Aulas.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Aulas> listarPorConteudo(String conteudo) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Aulas> criteriaQuery = criteriaBuilder.createQuery(Aulas.class);
		Root<Aulas> aulas = criteriaQuery.from(Aulas.class);
		criteriaQuery.where(criteriaBuilder.like(aulas.<String>get("conteudo"), "%"+conteudo+"%"));
		
		Query query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}
	


}
