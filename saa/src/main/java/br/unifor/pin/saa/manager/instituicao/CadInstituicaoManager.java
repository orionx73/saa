package br.unifor.pin.saa.manager.instituicao;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.saa.bussines.InstituicoesBO;
import br.unifor.pin.saa.entity.Instituicoes;
import br.unifor.pin.saa.manager.aluno.ListAlunoManager;
import br.unifor.pin.saa.utils.MessagesUtils;
import br.unifor.pin.saa.utils.Navigation;
/**
 * @author rafael.mendes
 * 
 */
@RequestScoped
@ManagedBean(name="cadInstituicao")
@Component(value="cadInstituicao")
public class CadInstituicaoManager {

	@Autowired
	private InstituicoesBO instituicaoBO;
	@Autowired
	private ListAlunoManager listAluno;
	private String nome;
	private String endereco;
	private String sigla;
	private String telefone;
		

	public String salvar(){
		Instituicoes instituicao = new Instituicoes();
		instituicao.setNome(nome);
		instituicao.setSigla(sigla);
		instituicao.setEndereco(endereco);
		instituicao.setTelefone(telefone);
		instituicaoBO.salvar(instituicao);
		MessagesUtils.info("Instituição salva com sucesso!");
		listAluno.lista();
		
		return Navigation.SUCESSO;
	}
	
	public String preparaSalvar(){
		this.limpaDados();
		
		return Navigation.SUCESSO;
	}
			
	public void limpaDados(){
		this.nome = "";
		this.endereco = "";
		this.sigla = "";
		this.telefone = "";
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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
}
