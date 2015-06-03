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
@ManagedBean(name = "atualizaAluno")
@Component(value = "atualizaAluno")
public class AtualizaAlunoManager {

	@Autowired
	private AlunosBO alunoBO;
	private Alunos AlunoSelecionado;

	public String atualizar() {
		alunoBO.atualizar(AlunoSelecionado);
		MessagesUtils.info("Aluno atualizado com sucesso!");

		return Navigation.SUCESSO;
	}

	public String preparaAtualizar(Alunos aluno) {
		AlunoSelecionado = alunoBO.buscarPorId(aluno.getId());

		return Navigation.ATUALIZA;
	}
	
	public void limparDados(){
		AlunoSelecionado.setNome("");
		AlunoSelecionado.setEmail("");
		AlunoSelecionado.setCpf("");
		AlunoSelecionado.setMatricula("");
		
	}

	public Alunos getAlunoSelecionado() {
		return AlunoSelecionado;
	}
	public void setAlunoSelecionado(Alunos alunoSelecionado) {
		this.AlunoSelecionado = alunoSelecionado;
	}
	
}
