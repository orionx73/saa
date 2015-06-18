package br.unifor.pin.saa.bussines;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.dao.AulasDAO;
import br.unifor.pin.saa.entity.Aulas;

@Component
public class AulasBO {

	private static final Logger logger = LoggerFactory
			.getLogger(AulasBO.class);

	@Autowired
	private AulasDAO aulasDAO;

	public void salvar(Aulas aula) {
		loggerInit("salvar");
		aula.setTurma(aula.getTurma());
		aulasDAO.salvar(aula);
		loggerFinhish("salvar");
	}
	
	public void atualizar(Aulas aula){
		loggerInit("atualizar");
		aulasDAO.atualizar(aula);
		loggerFinhish("atualizar");
		
	}
	
	public List<Aulas> listaAulaPorConteudo(String conteudo) {
		loggerInit("listaAulaPorConteudo");
		List<Aulas> aulas = aulasDAO.listarPorConteudo(conteudo);
		loggerFinhish("listaAulaPorConteudo");
		return aulas;
	}
	
	public Aulas buscarPorId(Long id){
		return aulasDAO.buscarPorId(id);
	}
	
	public List<Aulas> buscarTodos(){
		return aulasDAO.buscarTodos();
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void excluir(Aulas aula) {
		loggerInit("excluir");
		aula = aulasDAO.buscarPorId(aula.getId());
		aulasDAO.excluir(aula);
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