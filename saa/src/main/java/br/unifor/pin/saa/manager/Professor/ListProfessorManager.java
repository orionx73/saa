package br.unifor.pin.saa.manager.Professor;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.saa.bussines.ProfessoresBO;
import br.unifor.pin.saa.entity.Professores;
import br.unifor.pin.saa.utils.Navigation;

/**
 * @author Alex.torres
 * 
 */
@RequestScoped
@ManagedBean(name="listAluno")
@Component(value="listAluno")
public class ListProfessorManager {

	@Autowired
	private ProfessoresBO professorBO;
	private String nome;
	private String email;
	private String cpf;
	private String matricula;
	private List<Professores> professor;
	
	public void lista(){
		
		professor = professorBO.listaProfessorPorNome(nome);
		
	}
	
	public void excluir(Professores professor){
		professorBO.excluir(professor);
		professor = (Professores) professorBO.listaProfessorPorNome(nome);
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
		this.professor = null;
	}
	
	
	public String salvar(){
		return null;
	}
	
	public List<Professores> getProfessores() {
		return professor;
	}
	public void setProfessores(List<Professores> professor) {
		this.professor = professor;
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
	
	

	
	
}
