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
@ManagedBean(name = "atualizaAluno")
@Component(value = "atualizaAluno")
public class AtualizaAlunoManager {

	@Autowired
	private AlunosBO alunosBO;
	private Alunos alunoSelecionado;

	public String atualizar() {
		alunosBO.atualizar(alunoSelecionado);
		MessagesUtils.info("Aluno atualizado com sucesso!");

		return Navigation.SUCESSO;
	}

	public String preparaAtualizar(Alunos aluno) {
		alunoSelecionado = alunosBO.buscarPorId(aluno.getId());

		return Navigation.ATUALIZA;
	}
	
	public void limparDados(){
		alunoSelecionado.setNome("");
		alunoSelecionado.setCpf("");
		alunoSelecionado.setMatricula("");
	}

	public Alunos getAlunoSelecionado() {
		return alunoSelecionado;
	}
	public void setAlunoSelecionado(Alunos alunoSelecionado) {
		this.alunoSelecionado = alunoSelecionado;
	}
	
}