/*package br.unifor.pin.saa.manager.professor;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.saa.bussines.ProfessoresBO;
import br.unifor.pin.saa.entity.Professores;
import br.unifor.pin.saa.utils.MessagesUtils;
import br.unifor.pin.saa.utils.Navigation;
*//**
 * @author rafael.mendes
 * 
 *//*
@RequestScoped
@ManagedBean(name = "atualizaProfessor")
@Component(value = "atualizaProfessor")
public class AtualizaProfessorManager {

	@Autowired
	private ProfessoresBO professoresBO;
	private Professores ProfessorSelecionado;

	public String atualizar() {
		professoresBO.atualizar(ProfessorSelecionado);
		MessagesUtils.info("Professor atualizado com sucesso!");

		return Navigation.SUCESSO;
	}

	public String preparaAtualizar(Professores professor) {
		ProfessorSelecionado = professoresBO.buscarPorId(professor.getId());

		return Navigation.ATUALIZA;
	}
	
	public void limparDados(){
		ProfessorSelecionado.setNome("");
		ProfessorSelecionado.setEmail("");
		ProfessorSelecionado.setCpf("");
		ProfessorSelecionado.setMatricula("");
		
	}

	public Professores getProfessorSelecionado() {
		return ProfessorSelecionado;
	}

	public void setProfessorSelecionado(Professores professorSelecionado) {
		ProfessorSelecionado = professorSelecionado;
	}	
}
*/