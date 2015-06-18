package br.unifor.pin.saa.manager.avaliacao;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.saa.bussines.AvaliacoesBO;
import br.unifor.pin.saa.entity.Avaliacoes;
import br.unifor.pin.saa.utils.Navigation;

@RequestScoped
@ManagedBean(name="listAvaliacao")
@Component(value="listAvaliacao")
public class ListAvaliacaoManager {

	@Autowired
	private AvaliacoesBO avaliacoesBO;
	private String comentario;
	
	private List<Avaliacoes> avaliacoes;
	
	public void lista(){
		
		avaliacoes = avaliacoesBO.listaAvaliacaoPorComentario(comentario);
		
	}
	
	public void excluir(Avaliacoes avaliacao){
		avaliacoesBO.excluir(avaliacao);
		avaliacoes = avaliacoesBO.listaAvaliacaoPorComentario(comentario);
	}
	
	public String preparaAtualizar(Avaliacoes avaliacao){
		System.out.println("Avaliação conteudo: " + avaliacao.getComentario());
		return null;
	}
	
	public String preparaListar(){
		this.limparDados();
		return Navigation.SUCESSO;
	}
	
	public void limparDados(){
		this.comentario = "";
		this.avaliacoes = null;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public List<Avaliacoes> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<Avaliacoes> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}
	
}