package br.unifor.pin.saa.dao;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.entity.Turma;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")
@Transactional(propagation=Propagation.REQUIRED)
@TransactionConfiguration(defaultRollback=false)
public class TurmaDAOTest {
	
	@Autowired
	private TurmaDAO turmaDAO;

	@Test
	public void testSalvar() {
		final String disciplina = "Porgramação orientada a objetos";
		final Integer semestre = 5;
		
		Turma turma = new Turma();
		turma.setDisciplina(disciplina);
		turma.setSemestre(""+semestre);
		
		turmaDAO.salvar(turma);
		
		Turma turmaRetorno = turmaDAO.buscarPorId(turma.getId());
		Assert.assertNotNull(turmaRetorno);
		
		turmaDAO.excluir(turmaRetorno);
		
	}
	
	@Test
	public void testAtualizar(){
		final String disciplina = "Porgramação orientada a objetos";
		final String disciplina_alterada = "POO";
		final Integer semestre = 5;
		
		Turma turma = new Turma();
		turma.setDisciplina(disciplina);
		turma.setSemestre(""+semestre);
		turmaDAO.salvar(turma);
		
		turma.setDisciplina(disciplina_alterada);
		turmaDAO.atualizar(turma);
		
		Assert.assertEquals(disciplina_alterada, turma.getDisciplina());
		
		turmaDAO.excluir(turma);
		
	}
	
	@Test
	public void testBuscarPorId(){
		final String disciplina = "Porgramação orientada a objetos";
		final Integer semestre = 5;
		
		Turma turma = new Turma();
		turma.setDisciplina(disciplina);
		turma.setSemestre(""+semestre);
		
		turmaDAO.salvar(turma);
		
		Turma turmaRetorno = turmaDAO.buscarPorId(turma.getId());
		
		Assert.assertNotNull(turmaRetorno);
		
		turmaDAO.excluir(turmaRetorno);

	}

}