package br.unifor.pin.saa.bussines;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.dao.InstituicoesDAO;
import br.unifor.pin.saa.entity.Instituicoes;


@Component
public class InstituicoesBO {

	private static final Logger logger = LoggerFactory
			.getLogger(InstituicoesBO.class);

	@Autowired
	private InstituicoesDAO instituicoesDAO;
	
	public void salvar(Instituicoes instituicoes) {
		loggerInit("salvar");
		instituicoesDAO.salvar(instituicoes);
		loggerFinhish("salvar");
	}
	
	public void atualizar(Instituicoes instituicoes){
		loggerInit("atualizar");
		instituicoesDAO.atualizar(instituicoes);
		loggerFinhish("atualizar");
		
	}
	
	public Instituicoes buscarPorId(Long id){
		return instituicoesDAO.buscarPorId(id);
	}
	
	public Instituicoes buscarPorNome(String nome) {
		loggerInit("BuscaInstituicoesPorNome");
		Instituicoes instituicoes = instituicoesDAO.buscarPorNome(nome);
		loggerInit("BuscaAlunoPorNome");
		return instituicoes;
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void excluir(Instituicoes instituicoes) {
		loggerInit("excluir");
		instituicoes = instituicoesDAO.buscarPorId(instituicoes.getId());
		instituicoesDAO.excluir(instituicoes);
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
