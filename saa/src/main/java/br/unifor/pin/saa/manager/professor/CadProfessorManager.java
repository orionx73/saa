package br.unifor.pin.saa.manager.professor;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.saa.bussines.ProfessoresBO;
import br.unifor.pin.saa.entity.Professores;
import br.unifor.pin.saa.utils.MessagesUtils;
import br.unifor.pin.saa.utils.Navigation;


@RequestScoped
@ManagedBean(name="cadProfessor")
@Component(value="cadProfessor")
public class CadProfessorManager {

	@Autowired
	private ProfessoresBO professoresBO;
	@Autowired
	private ListProfessorManager listAluno;
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
		professoresBO.salvar(professor);
		MessagesUtils.info("Professor salvo com sucesso!");
		listAluno.lista();
		
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