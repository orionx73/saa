package br.unifor.pin.saa.manager.aluno;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.saa.bussines.AlunosBO;
import br.unifor.pin.saa.entity.Alunos;
import br.unifor.pin.saa.utils.Navigation;

@RequestScoped
@ManagedBean(name="listAluno")
@Component(value="listAluno")
public class ListAlunoManager {

	@Autowired
	private AlunosBO alunosBO;
	private String nome;
	private List<Alunos> alunos;
	
	public void lista(){
		
		alunos = alunosBO.listaAlunosPorNome(nome);
	}
	
	public void excluir(Alunos aluno){
		alunosBO.excluir(aluno);
		alunos = alunosBO.listaAlunosPorNome(nome);
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
		this.alunos = null;
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

	public List<Alunos> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Alunos> alunos) {
		this.alunos = alunos;
	}
}