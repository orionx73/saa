package br.unifor.pin.saa.bussines;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.dao.ProfessoresDAO;
import br.unifor.pin.saa.entity.Professores;

@Component
public class ProfessoresBO {
	
	private static final Logger logger = LoggerFactory
			.getLogger(ProfessoresBO.class);

	@Autowired
	private ProfessoresDAO professoresDAO;
	
	public void salvar(Professores professores) {
		loggerInit("salvar");
		professoresDAO.salvar(professores);
		loggerFinhish("salvar");
	}
	
	public void atualizar(Professores professores){
		loggerInit("atualizar");
		professoresDAO.atualizar(professores);
		loggerFinhish("atualizar");
		
	}
	
	public List<Professores> buscarTodos(){
		return professoresDAO.buscarTodos();
	}
	
	public Professores buscarPorId(Long id){
		return professoresDAO.buscarPorId(id);
	}
	
	public Professores buscarPorNome(String nome) {
		loggerInit("BuscaProfessoresPorNome");
		Professores professores = professoresDAO.buscarPorNome(nome);
		loggerInit("BuscaProfessoresPorNome");
		return professores;
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void excluir(Professores professores) {
		loggerInit("excluir");
		professores = professoresDAO.buscarPorId(professores.getId());
		professoresDAO.excluir(professores);
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