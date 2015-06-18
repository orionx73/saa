package br.unifor.pin.saa.manager.avaliacao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.saa.bussines.AulasBO;
import br.unifor.pin.saa.bussines.AvaliacoesBO;
import br.unifor.pin.saa.entity.Aulas;
import br.unifor.pin.saa.entity.Avaliacoes;
import br.unifor.pin.saa.utils.MessagesUtils;
import br.unifor.pin.saa.utils.Navigation;

@RequestScoped
@ManagedBean(name = "cadAvaliacao")
@Component(value = "cadAvaliacao")
public class CadAvaliacaoManager {

	@Autowired
	private AvaliacoesBO avaliacoesBO;
	@Autowired
	private AulasBO aulasBO;

	private Avaliacoes avaliacoes;
	
	public String preparaSalvar(Aulas aula){
		avaliacoes = new Avaliacoes();
		avaliacoes.setAprovado(false);
		avaliacoes.setAulas(aula);
		return Navigation.CONTINUE;
	}
	
	public String preparaListar(Aulas aula){
		return Navigation.LISTAR;
	}
	
	
	public String salvar() {

		avaliacoesBO.salvar(avaliacoes);
		MessagesUtils.info("Avaliação cadastrada com sucesso!");

		return Navigation.SUCESSO;
	}
	
	public String preparaSalvar(){
		
		return Navigation.SUCESSO;
	}

	public Collection<SelectItem> getAula() {
		Collection<SelectItem> items = new ArrayList<SelectItem>();
		items.add(new SelectItem("", "Selecione a Aula"));
		List<Aulas> aulas = aulasBO.buscarTodos();
		for (Aulas aula : aulas) {
			items.add(new SelectItem(aula, aula.getDescricao()));
		}
		return items;
	}

	public Avaliacoes getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(Avaliacoes avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

}