package br.unifor.pin.saa.manager.instituicao;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.saa.bussines.InstituicoesBO;
import br.unifor.pin.saa.entity.Instituicoes;
import br.unifor.pin.saa.utils.Navigation;

@RequestScoped
@ManagedBean(name="listInstituicao")
@Component(value="listInstituicao")
public class ListInstituicaoManager {

	@Autowired
	private InstituicoesBO instituicoesBO;
	private String nome;
	private List<Instituicoes> instituicoes;
	
	public void lista(){
		
		instituicoes = instituicoesBO.listaInstituicoesPorNome(nome);
	}
	
	public void excluir(Instituicoes isnstituicao){
		instituicoesBO.excluir(isnstituicao);
		instituicoes = instituicoesBO.listaInstituicoesPorNome(nome);
	}
	
	public String preparaAtualizar(Instituicoes isnstituicao){
		System.out.println(isnstituicao.getNome());
		return null;
	}
	
	public String preparaListar(){
		this.limparDados();
		return Navigation.SUCESSO;
	}
	
	public void limparDados(){
		this.nome = "";
		this.instituicoes = null;
	}
	
	public String salvar(){
		return null;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Instituicoes> getInstituicoes() {
		return instituicoes;
	}

	public void setInstituicoes(List<Instituicoes> instituicoes) {
		this.instituicoes = instituicoes;
	}

}