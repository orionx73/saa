package br.unifor.pin.saa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.entity.Turma;


@Repository
@Transactional(propagation=Propagation.REQUIRED)
public class TurmaDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void salvar(Turma turma) {
		entityManager.persist(turma);
	}
	
	public void atualizar(Turma turma){
		entityManager.merge(turma);
	}
	
	public void excluir(Turma turma){
		entityManager.remove(turma);
	}
	
	public Turma buscarPorId(Long id){
		return entityManager.find(Turma.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Turma> buscarTodos(){
		String jpql = "select t from Turma t";
		Query query = entityManager.createQuery(jpql);
		
		return (List<Turma>)query.getResultList();
	}
	
}