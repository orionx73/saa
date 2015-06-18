package br.unifor.pin.saa.manager.professor;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.saa.bussines.ProfessoresBO;
import br.unifor.pin.saa.entity.Professores;
import br.unifor.pin.saa.utils.Navigation;

@RequestScoped
@ManagedBean(name="listProfessor")
@Component(value="listProfessor")
public class ListProfessorManager {

	@Autowired
	private ProfessoresBO professoresBO;
	private String nome;
	private String email;
	private String cpf;
	private String matricula;
	private List<Professores> professores;
	
	public void lista(){
		
		professores = professoresBO.listarProfessorPorNome(nome);		
	}
	
	public void excluir(Professores professor){
		professoresBO.excluir(professor);
		professores = professoresBO.listarProfessorPorNome(nome);
	}
	
	public String preparaAtualizar(Professores professor){
		System.out.println(professor.getNome());
		return null;
	}
	
	public String preparaListar(){
		this.limparDados();
		return Navigation.SUCESSO;
	}
	
	public void limparDados(){
		this.nome = "";
		this.email="";
		this.matricula="";
		this.cpf ="";
		this.professores = null;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public List<Professores> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professores> professores) {
		this.professores = professores;
	}

}
