package br.unifor.pin.saa.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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



}
