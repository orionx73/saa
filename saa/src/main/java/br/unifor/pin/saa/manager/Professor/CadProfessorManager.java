package br.unifor.pin.saa.manager.Professor;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import br.unifor.pin.saa.bussines.ProfessoresBO;

import br.unifor.pin.saa.entity.Professores;
import br.unifor.pin.saa.utils.MessagesUtils;
import br.unifor.pin.saa.utils.Navigation;
/**
 * @author Alex.torres
 * 
 */
@RequestScoped
@ManagedBean(name="cadProfessor")
@Component(value="cadProfessor")
public class CadProfessorManager {

	@Autowired
	private ProfessoresBO professorBO;
	@Autowired
	private ListProfessorManager listprofessor;
	private String nome;
	private String email;
	private String cpf;
	private String matricula;
	
	

	public String salvar(){
		Professores professor = new Professores();
		professor.setNome(nome);
		professor.setEmail(email);
		professor.setMatricula(matricula);
		professor.setCpf(cpf);
		professorBO.salvar(professor);
		MessagesUtils.info("Aluno salvo com sucesso!");
		listprofessor.lista();
		
		return Navigation.SUCESSO;
	}
	
	public String preparaSalvar(){
		this.limpaDados();
		
		return Navigation.SUCESSO;
	}
			
	public void limpaDados(){
		this.nome = "";
		this.email = "";
		this.cpf = "";
		this.matricula = "";
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
