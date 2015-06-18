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

import br.unifor.pin.saa.entity.Avaliacoes;

@Repository
@Transactional(propagation=Propagation.REQUIRED)
public class AvaliacoesDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void salvar(Avaliacoes avaliacao) {
		entityManager.persist(avaliacao);
	}
	
	public void atualizar(Avaliacoes avaliacao){
		entityManager.merge(avaliacao);
	}
	
	public void excluir(Avaliacoes avaliacao){
		entityManager.remove(avaliacao);
	}
	
	public Avaliacoes buscarPorId(Long id){
		return entityManager.find(Avaliacoes.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Avaliacoes> listarPorComentario(String comentario) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Avaliacoes> criteriaQuery = criteriaBuilder.createQuery(Avaliacoes.class);
		Root<Avaliacoes> avaliacoes = criteriaQuery.from(Avaliacoes.class);
		criteriaQuery.where(criteriaBuilder.like(avaliacoes.<String>get("comentario"), "%"+comentario+"%"));
		
		Query query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Avaliacoes> buscarTodos(){
		String jpql = "select a from Avaliacoes a";
		Query query = entityManager.createQuery(jpql);
		
		return (List<Avaliacoes>)query.getResultList();
	}

}