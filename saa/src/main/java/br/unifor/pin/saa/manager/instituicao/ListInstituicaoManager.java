package br.unifor.pin.saa.manager.instituicao;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.saa.bussines.InstituicoesBO;
import br.unifor.pin.saa.entity.Instituicoes;
import br.unifor.pin.saa.utils.Navigation;


/**
 * @author rafael.mendes
 * 
 */
@RequestScoped
@ManagedBean(name="listInstituicao")
@Component(value="lisInstituicao")
public class ListInstituicaoManager {
	
	@Autowired
	private InstituicoesBO instituicaoBO;
	private String nome;
	private String endereco;
	private String sigla;
	private String telefone;
	private List<Instituicoes> instituicoes;
	
	public void lista(){
		
		instituicoes = instituicaoBO.listaInstituicoesPorNome(nome);
		
	}
	
	public void excluir(Instituicoes instituicao){
		instituicaoBO.excluir(instituicao);
		instituicoes = instituicaoBO.listaInstituicoesPorNome(nome);
	}
	
	public String preparaAtualizar(Instituicoes instituicao){
		System.out.println(instituicao.getNome());
		return null;
	}
	
	public String preparaListar(){
		this.limparDados();
		return Navigation.SUCESSO;
	}
	
	public void limparDados(){
		this.nome = "";
		this.endereco="";
		this.sigla="";
		this.telefone ="";
		this.instituicoes = null;
	}
	
	
	public String salvar(){
		return null;
	}
	
	public List<Instituicoes> getAlunos() {
		return instituicoes;
	}
	public void setAlunos(List<Instituicoes> alunos) {
		this.instituicoes = alunos;
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

	public List<Instituicoes> getInstituicoes() {
		return instituicoes;
	}

	public void setInstituicoes(List<Instituicoes> instituicoes) {
		this.instituicoes = instituicoes;
	}
}
