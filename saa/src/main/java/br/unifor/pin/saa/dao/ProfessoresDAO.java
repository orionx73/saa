package br.unifor.pin.saa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.entity.Professores;

@Repository
@Transactional(propagation=Propagation.REQUIRED)
public class ProfessoresDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void salvar(Professores professor) {
		entityManager.persist(professor);
	}
	
	public void atualizar(Professores professor){
		entityManager.merge(professor);
	}
	
	public void excluir(Professores professor){
		entityManager.remove(professor);
	}
	
	public Professores buscarPorId(Long id){
		return entityManager.find(Professores.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Professores> buscarTodos(){
		String jpql = "select p from Professores p";
		Query query = entityManager.createQuery(jpql);
		
		return (List<Professores>)query.getResultList();
	}
	
	public Professores buscarPorNome(String nome) {
		String jpql = "select i from Professores i where i.nome = :nome";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("nome", nome);
		
		return (Professores) query.getSingleResult();
	}
	
}