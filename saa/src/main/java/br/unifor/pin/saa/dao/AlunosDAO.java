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

import br.unifor.pin.saa.entity.Alunos;

@Repository
@Transactional(propagation=Propagation.REQUIRED)
public class AlunosDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void salvar(Alunos aluno) {
		entityManager.persist(aluno);
	}
	
	public void atualizar(Alunos aluno){
		entityManager.merge(aluno);
	}
		
	public void excluir(Alunos aluno){
		entityManager.remove(aluno);
	}
	
	public Alunos buscarPorId(Long id){
		return entityManager.find(Alunos.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Alunos> listarPorNome(String nome) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Alunos> criteriaQuery = criteriaBuilder.createQuery(Alunos.class);
		Root<Alunos> alunos = criteriaQuery.from(Alunos.class);
		criteriaQuery.where(criteriaBuilder.like(alunos.<String>get("nome"), "%"+nome+"%"));
		
		Query query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}
	
	public Alunos buscarPorNome(String nome) {
		String jpql = "select a from Alunos a where a.nome = :nome";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("nome", nome);
		
		return (Alunos) query.getSingleResult();
	}
		

}