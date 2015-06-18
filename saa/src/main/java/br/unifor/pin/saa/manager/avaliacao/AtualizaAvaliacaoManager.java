package br.unifor.pin.saa.manager.avaliacao;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.saa.bussines.AvaliacoesBO;
import br.unifor.pin.saa.entity.Avaliacoes;
import br.unifor.pin.saa.utils.MessagesUtils;
import br.unifor.pin.saa.utils.Navigation;

@RequestScoped
@ManagedBean(name = "atualizaAvaliacao")
@Component(value = "atualizaAvaliacao")
public class AtualizaAvaliacaoManager {

	public class AtualizaAulaManager {

		@Autowired
		private AvaliacoesBO avaliacoesBO;
		private Avaliacoes avaliacaoSelecionada;

		public String atualizar() {
			avaliacoesBO.atualizar(avaliacaoSelecionada);
			MessagesUtils.info("Avaliação atualizada com sucesso!");

			return Navigation.SUCESSO;
		}

		public String preparaAtualizar(Avaliacoes avaliacoes) {
			avaliacaoSelecionada = avaliacoesBO.buscarPorId(avaliacoes.getId());

			return Navigation.ATUALIZA;
		}

		public Avaliacoes getAvaliacaoSelecionada() {
			return avaliacaoSelecionada;
		}

		public void setAvaliacaoSelecionada(Avaliacoes avaliacaoSelecionada) {
			this.avaliacaoSelecionada = avaliacaoSelecionada;
		}
	}
}
	