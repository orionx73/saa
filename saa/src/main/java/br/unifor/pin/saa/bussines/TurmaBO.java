package br.unifor.pin.saa.bussines;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.dao.TurmaDAO;
import br.unifor.pin.saa.entity.Turma;

@Component
public class TurmaBO {
	
	private static final Logger logger = LoggerFactory
			.getLogger(TurmaBO.class);

	@Autowired
	private TurmaDAO turmaDAO;
	
	public void salvar(Turma turma) {
		loggerInit("salvar");
		turma.setProfessor(turma.getProfessor());
		turma.setInstituicao(turma.getInstituicao());
		turmaDAO.salvar(turma);
		loggerFinhish("salvar");
	}
	
	public void atualizar(Turma turma){
		loggerInit("atualizar");
		turmaDAO.atualizar(turma);
		loggerFinhish("atualizar");
		
	}
	
	public Turma buscarPorId(Long id){
		return turmaDAO.buscarPorId(id);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void excluir(Turma turma) {
		loggerInit("excluir");
		turma = turmaDAO.buscarPorId(turma.getId());
		turmaDAO.excluir(turma);
		loggerFinhish("excluir");
	}
	
	public List<Turma> buscarTodos(){
		return turmaDAO.buscarTodos();
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