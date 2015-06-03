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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")
@Transactional(propagation=Propagation.REQUIRED)
@TransactionConfiguration(defaultRollback=false)
public class AlunoDAOTest {
	
	@Autowired
	private AlunosDAO alunoDAO;

	@Test
	public void testSalvar() {
		final String nome = "Matheus";
		final String cpf = "111.222.333-44";
		final String matricula = "123456.7/8";
		
		
		Alunos aluno = new Alunos();
		aluno.setNome(nome);
		aluno.setCpf(cpf);
		aluno.setMatricula(matricula);
		
		alunoDAO.salvar(aluno);
		Alunos alunoRetorno = alunoDAO.buscarPorNome(nome);
		Assert.assertNotNull(alunoRetorno);
		
		alunoDAO.excluir(alunoRetorno);
	}	
	
	@Test
	public void testAtualizar(){
		
		final String nome = "Matheus";
		final String nomeAlterado = "Jorge";
		final String cpf = "111.222.333-44";
		final String matricula = "123456.7/8";
		
		Alunos aluno = new Alunos();
		aluno.setNome(nome);
		aluno.setCpf(cpf);
		aluno.setMatricula(matricula);
		
		alunoDAO.salvar(aluno);
		aluno.setNome(nomeAlterado);		
		alunoDAO.atualizar(aluno);

		Assert.assertEquals(nomeAlterado, aluno.getNome());
		
		alunoDAO.excluir(aluno);
	}
	
	@Test
	public void testBuscarPorId(){
		final String nome = "Matheus";
		final String cpf = "111.222.333-44";
		final String matricula = "123456.7/8";
		
		Alunos aluno = new Alunos();
		aluno.setNome(nome);
		aluno.setCpf(cpf);
		aluno.setMatricula(matricula);
		
		alunoDAO.salvar(aluno);
		
		Alunos alunoRetorno = alunoDAO.buscarPorNome(nome);
		Long id = alunoRetorno.getId();
		Alunos alunoNovo = alunoDAO.buscarPorId(id);
		
		Assert.assertNotNull(alunoNovo);
		
		alunoDAO.excluir(alunoRetorno);
	}
	
	@Test
	public void testBuscarPorNome(){
		final String nome = "Matheus";
		final String cpf = "111.222.333-44";
		final String matricula = "123456.7/8";
		
		Alunos aluno = new Alunos();
		aluno.setNome(nome);
		aluno.setCpf(cpf);
		aluno.setMatricula(matricula);
		
		alunoDAO.salvar(aluno);
		aluno = alunoDAO.buscarPorNome(aluno.getNome());
		
		Assert.assertNotNull(aluno);
		
		alunoDAO.excluir(aluno);
		
	}


}
