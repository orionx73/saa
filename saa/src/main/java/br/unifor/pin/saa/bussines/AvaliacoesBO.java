package br.unifor.pin.saa.bussines;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.dao.AvaliacoesDAO;
import br.unifor.pin.saa.entity.Avaliacoes;

@Component
public class AvaliacoesBO {
	
	private static final Logger logger = LoggerFactory
			.getLogger(AvaliacoesBO.class);

	@Autowired
	private AvaliacoesDAO avaliacoesDAO;

	public void salvar(Avaliacoes avaliacoes) {
		loggerInit("salvar");
		avaliacoesDAO.salvar(avaliacoes);
		loggerFinhish("salvar");
	}
	
	public void atualizar(Avaliacoes avaliacoes){
		loggerInit("atualizar");
		avaliacoesDAO.atualizar(avaliacoes);
		loggerFinhish("atualizar");
		
	}
	
	public Avaliacoes buscarPorId(Long id){
		return avaliacoesDAO.buscarPorId(id);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void excluir(Avaliacoes avaliacoes) {
		loggerInit("excluir");
		avaliacoes = avaliacoesDAO.buscarPorId(avaliacoes.getId());
		avaliacoesDAO.excluir(avaliacoes);
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
