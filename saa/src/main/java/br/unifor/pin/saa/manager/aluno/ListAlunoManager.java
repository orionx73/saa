package br.unifor.pin.saa.manager.aluno;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.saa.bussines.AlunosBO;
import br.unifor.pin.saa.entity.Alunos;
import br.unifor.pin.saa.utils.Navigation;

/**
 * @author Alex.torres
 * 
 */
@RequestScoped
@ManagedBean(name="listAluno")
@Component(value="listAluno")
public class ListAlunoManager {

	@Autowired
	private AlunosBO alunoBO;
	private String nome;
	private String email;
	private String cpf;
	private String matricula;
	private List<Alunos> alunos;
	
	public void lista(){
		
		alunos = alunoBO.listaAlunosPorNome(nome);
		
	}
	
	public void excluir(Alunos aluno){
		alunoBO.excluir(aluno);
		alunos = alunoBO.listaAlunosPorNome(nome);
	}
	
	public String preparaAtualizar(Alunos aluno){
		System.out.println(aluno.getNome());
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
		this.alunos = null;
	}
	
	
	public String salvar(){
		return null;
	}
	
	public List<Alunos> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<Alunos> alunos) {
		this.alunos = alunos;
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
