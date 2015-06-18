package br.unifor.pin.saa.manager.aula;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.saa.bussines.AulasBO;
import br.unifor.pin.saa.entity.Aulas;
import br.unifor.pin.saa.utils.Navigation;

@RequestScoped
@ManagedBean(name="listAulas")
@Component(value="listAulas")
public class ListAulaManager {

	@Autowired
	private AulasBO aulasBO;
	private String conteudo;
	private List<Aulas> aulas;
	
	public void lista(){
		
		aulas = aulasBO.listaAulaPorConteudo(conteudo);
		
	}
	
	public void excluir(Aulas aula){
		aulasBO.excluir(aula);
		aulas = aulasBO.listaAulaPorConteudo(conteudo);
	}
	
	public String preparaAtualizar(Aulas aula){
		System.out.println("Aula conteudo: " + aula.getConteudo());
		return null;
	}
	
	public String preparaListar(){
		this.limparDados();
		return Navigation.SUCESSO;
	}
	
	public void limparDados(){
		this.conteudo = "";
		this.aulas = null;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public List<Aulas> getAulas() {
		return aulas;
	}

	public void setAulas(List<Aulas> aulas) {
		this.aulas = aulas;
	}
	
}