package br.unifor.pin.saa.dao;

import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.entity.Aulas;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")
@Transactional(propagation=Propagation.REQUIRED)
@TransactionConfiguration(defaultRollback=false)
public class AulasDAOTest {
	@Autowired
	private AulasDAO aulasDAO;
	
	@Test
	public void testSalvar() {
		Aulas aulas = new Aulas();
		
		aulasDAO.salvar(aulas);
		
		Aulas aulasRetorno = aulasDAO.buscarPorId(aulas.getId());
		
	    Assert.assertNotNull(aulasRetorno);

	    aulasDAO.excluir(aulasRetorno);
	}
	
	@Ignore
	public void testAtualizar(){
		
	}
	
	@Test
	public void testBuscarPorId(){
		Aulas aulas = new Aulas();
		
		aulasDAO.salvar(aulas);
		
		Aulas aulasRetorno = aulasDAO.buscarPorId(aulas.getId());
		
	    Assert.assertEquals(aulas,aulasRetorno);

	    aulasDAO.excluir(aulasRetorno);
	}

}
