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
@ManagedBean(name="cadInstituicao")
@Component(value="cadInstituicao")
public class CadInstituicaoManager {

	@Autowired
	private InstituicoesBO instituicoesBO;
	
	@Autowired
	private ListInstituicaoManager listInstituicao;
	
	private String nome;
	private String endereco;
	private String telefone;
	private String sigla;
	
	public String salvar(){
		Instituicoes instituicoes = new Instituicoes();
		instituicoes.setNome(nome);
		instituicoes.setEndereco(endereco);
		instituicoes.setTelefone(telefone);
		instituicoes.setSigla(sigla);
		instituicoesBO.salvar(instituicoes);
	
		MessagesUtils.info("Instituição salva com sucesso!");
		listInstituicao.lista();
		
		return Navigation.SUCESSO;
	}
	
	public String preparaSalvar(){
		this.limpaDados();
		
		return Navigation.SUCESSO;
	}
			
	public void limpaDados(){
		this.nome = "";
		this.endereco = "";
		this.telefone = "";
		this.sigla = "";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
}