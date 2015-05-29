package br.unifor.pin.saa.bussines;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.dao.AlunosDAO;
import br.unifor.pin.saa.entity.Alunos;

@Component
public class AlunosBO {
	
	private static final Logger logger = LoggerFactory
			.getLogger(UsuarioBO.class);

	@Autowired
	private AlunosDAO alunosDAO;

	public void salvar(Alunos aluno){
		loggerInit("salvar");
		alunosDAO.salvar(aluno);
		loggerFinhish("salvar");
	}
	
	public void atualizar(Alunos aluno){
		loggerInit("atualizar");
		alunosDAO.atualizar(aluno);
		loggerFinhish("atualizar");
	}
	
	public Alunos buscarPorNome(String nome) {
		loggerInit("BuscaAlunoPorNome");
		Alunos aluno = alunosDAO.buscarPorNome(nome);
		loggerInit("BuscaAlunoPorNome");
		return aluno;
	}
	
	public Alunos buscarPorId(Long id){
		return alunosDAO.buscarPorId(id);
	}
	
	public List<Alunos> listaAlunosPorNome(String nome) {
		loggerInit("listaAlunosPorNome");
		List<Alunos> alunos = alunosDAO.listarPorNome(nome);
		loggerFinhish("listaAlunosPorNome");
		return alunos;
	}
	

	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void excluir(Alunos aluno) {
		loggerInit("excluir");
		aluno = alunosDAO.buscarPorId(aluno.getId());
		alunosDAO.excluir(aluno);
		loggerFinhish("excluir");
	}

	public void loggerInit(String method) {
		logger.debug("Inicio do método " + method + " da classe"
				+ this.getClass().getName());
	}

	public void loggerFinhish(String method) {
		logger.debug("Fim do método "+method+" da classe"
				+ this.getClass().getName());
	}

}
