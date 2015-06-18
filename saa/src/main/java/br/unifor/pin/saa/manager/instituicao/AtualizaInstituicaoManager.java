package br.unifor.pin.saa.manager.instituicao;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.saa.bussines.InstituicoesBO;
import br.unifor.pin.saa.entity.Instituicoes;
import br.unifor.pin.saa.utils.MessagesUtils;
import br.unifor.pin.saa.utils.Navigation;
/**
 * @author rafael.mendes
 * 
 */
@RequestScoped
@ManagedBean(name = "atualizaInstituicao")
@Component(value = "atualizaInstituicao")
public class AtualizaInstituicaoManager {
	@Autowired
	private InstituicoesBO instituicaoBO;
	private Instituicoes InstituicaoSelecionada;

	public String atualizar() {
		instituicaoBO.atualizar(InstituicaoSelecionada);
		MessagesUtils.info("Instituição atualizada com sucesso!");

		return Navigation.SUCESSO;
	}

	public String preparaAtualizar(Instituicoes instituicao) {
		InstituicaoSelecionada = instituicaoBO.buscarPorId(instituicao.getId());

		return Navigation.ATUALIZA;
	}
	
	public void limparDados(){
		InstituicaoSelecionada.setNome("");
		InstituicaoSelecionada.setSigla("");
		InstituicaoSelecionada.setEndereco("");
		InstituicaoSelecionada.setTelefone("");
		
	}

	public Instituicoes geInstituicaoSelecionada() {
		return InstituicaoSelecionada;
	}
	public void setInstituicaoSelecionada(Instituicoes instituicoesSelecionada) {
		this.InstituicaoSelecionada = instituicoesSelecionada;
	}
}
