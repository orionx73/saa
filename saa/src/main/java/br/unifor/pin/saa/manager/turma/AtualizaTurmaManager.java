package br.unifor.pin.saa.manager.turma;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.saa.bussines.AulasBO;
import br.unifor.pin.saa.entity.Aulas;
import br.unifor.pin.saa.utils.MessagesUtils;
import br.unifor.pin.saa.utils.Navigation;

@RequestScoped
@ManagedBean(name = "atualizaTurma")
@Component(value = "atualizaTurma")
public class AtualizaTurmaManager {

	@Autowired
	private AulasBO aulasBO;
	private Aulas aulaSelecionada;

	public String atualizar() {
		aulasBO.atualizar(aulaSelecionada);
		MessagesUtils.info("Aula atualizada com sucesso!");

		return Navigation.SUCESSO;
	}

	public String preparaAtualizar(Aulas aulas) {
		aulaSelecionada = aulasBO.buscarPorId(aulas.getId());

		return Navigation.ATUALIZA;
	}

	public Aulas getAulaSelecionada() {
		return aulaSelecionada;
	}

	public void setAulaSelecionada(Aulas aulaSelecionada) {
		this.aulaSelecionada = aulaSelecionada;
	}
	
}