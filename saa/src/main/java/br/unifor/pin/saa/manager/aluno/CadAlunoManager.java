package br.unifor.pin.saa.manager.aluno;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.saa.bussines.AlunosBO;
import br.unifor.pin.saa.entity.Alunos;
import br.unifor.pin.saa.utils.MessagesUtils;
import br.unifor.pin.saa.utils.Navigation;

@RequestScoped
@ManagedBean(name="cadAluno")
@Component(value="cadAluno")
public class CadAlunoManager {

	@Autowired
	private AlunosBO alunosBO;
	
	@Autowired
	private ListAlunoManager listAluno;
	
	private String matricula;
	private String nome;
	private String cpf;
	private Alunos alunos;
	
	public String salvar(){
		Alunos alunos = new Alunos();
		alunos.setMatricula(matricula);
		alunos.setCpf(cpf);
		alunos.setNome(nome);
		alunosBO.salvar(alunos);
		MessagesUtils.info("Aluno salvo com sucesso!");
		listAluno.lista();
		
		return Navigation.SUCESSO;
	}
	
	public String preparaSalvar(){
		this.limpaDados();
		
		return Navigation.SUCESSO;
	}
			
	public void limpaDados(){
		this.matricula = "";
		this.nome = "";
		this.cpf = "";
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Alunos getAluno() {
		return alunos;
	}

	public void setAluno(Alunos alunos) {
		this.alunos = alunos;
	}
	
}