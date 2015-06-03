package br.unifor.pin.saa.manager.aluno;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.saa.bussines.AlunosBO;
import br.unifor.pin.saa.entity.Alunos;
import br.unifor.pin.saa.utils.MessagesUtils;
import br.unifor.pin.saa.utils.Navigation;
/**
 * @author Alex.torres
 * 
 */
@RequestScoped
@ManagedBean(name="cadAluno")
@Component(value="cadAluno")
public class CadAlunoManager {

	@Autowired
	private AlunosBO alunoBO;
	@Autowired
	private ListAlunoManager listAluno;
	private String nome;
	private String email;
	private String cpf;
	private String matricula;
	
	

	public String salvar(){
		Alunos aluno = new Alunos();
		aluno.setNome(nome);
		aluno.setEmail(email);
		aluno.setMatricula(matricula);
		aluno.setCpf(cpf);
		alunoBO.salvar(aluno);
		MessagesUtils.info("Aluno salvo com sucesso!");
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
