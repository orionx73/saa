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

import br.unifor.pin.saa.entity.Alunos;
import br.unifor.pin.saa.entity.Avaliacoes;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")
@Transactional(propagation=Propagation.REQUIRES_NEW)
@TransactionConfiguration(defaultRollback=false)
public class AvaliacoesDAOTest {
	
	@Autowired
	private AvaliacoesDAO avaliacoesDAO;
	@Autowired
	private AlunosDAO alunoDAO;

	@Test
	public void testSalvar() {
		final Double nota = 9.8;
		final Boolean aprovado = true;
		
		Avaliacoes avaliacao = new Avaliacoes();
		Alunos aluno = new Alunos();
		aluno.setMatricula("12a");
		aluno.setNome("X");
		aluno.setCpf("123");
		alunoDAO.salvar(aluno);
		
		avaliacao.setAluno(aluno);
		avaliacao.setAprovado(aprovado);
		avaliacao.setNota(nota);
		
		avaliacao.getAluno().setNome("Y");
		avaliacoesDAO.salvar(avaliacao);
		
		Avaliacoes novaAvaliacao = avaliacoesDAO.buscarPorId(avaliacao.getId());
		
		Assert.assertEquals("Y", novaAvaliacao.getAluno().getNome());
	    Assert.assertNotNull(avaliacao.getNota());
	    Assert.assertTrue(avaliacao.getAprovado());
	    
	    avaliacoesDAO.excluir(avaliacao);
	    alunoDAO.excluir(aluno);
	}
	
	@Test
	public void testAtualizar(){
		final Double nota = 9.8;
		final Double nota_alterada = 4.5;
		final Boolean aprovado = true;
		
		Avaliacoes avaliacoes = new Avaliacoes();
		
		avaliacoes.setAprovado(aprovado);
		avaliacoes.setNota(nota);
		
		avaliacoesDAO.salvar(avaliacoes);
		
		avaliacoes.setNota(nota_alterada);
		avaliacoesDAO.atualizar(avaliacoes);
		
		Assert.assertEquals(nota_alterada, avaliacoes.getNota());
	    
		avaliacoesDAO.excluir(avaliacoes);
		
	}
	
	@Test
	public void testBuscarPorId(){
		final Double nota = 9.8;
		final Boolean aprovado = true;
		
		Avaliacoes avaliacoes = new Avaliacoes();
		
		avaliacoes.setAprovado(aprovado);
		avaliacoes.setNota(nota);
		
		avaliacoesDAO.salvar(avaliacoes);
		
		Avaliacoes avaliacoesRetorno = avaliacoesDAO.buscarPorId(avaliacoes.getId());
		
		Assert.assertNotNull(avaliacoesRetorno);
		
		avaliacoesDAO.excluir(avaliacoesRetorno);
		
	}
	
}


