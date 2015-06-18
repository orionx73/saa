package br.unifor.pin.saa.manager.instituicao;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.saa.bussines.InstituicoesBO;
import br.unifor.pin.saa.entity.Instituicoes;
import br.unifor.pin.saa.utils.MessagesUtils;
import br.unifor.pin.saa.utils.Navigation;

@RequestScoped
@ManagedBean(name = "atualizaInstituicao")
@Component(value = "atualizaInstituicao")
public class AtualizaInstituicaoManager {

	@Autowired
	private InstituicoesBO instituicoesBO;
	private Instituicoes instituicaoSelecionada;

	public String atualizar() {
		instituicoesBO.atualizar(instituicaoSelecionada);
		MessagesUtils.info("Instituição atualizada com sucesso!");

		return Navigation.SUCESSO;
	}

	public String preparaAtualizar(Instituicoes instituicao) {
		instituicaoSelecionada = instituicoesBO.buscarPorId(instituicao.getId());

		return Navigation.ATUALIZA;
	}
	
	public void limparDados(){
		instituicaoSelecionada.setNome("");
		instituicaoSelecionada.setEndereco("");
		instituicaoSelecionada.setTelefone("");
		instituicaoSelecionada.setSigla("");
	}

	public Instituicoes getInstituicaoSelecionada() {
		return instituicaoSelecionada;
	}
	public void setInstituicaoSelecionada(Instituicoes instituicaoSelecionada) {
		this.instituicaoSelecionada = instituicaoSelecionada;
	}
	
}