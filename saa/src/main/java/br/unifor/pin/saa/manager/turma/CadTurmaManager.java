package br.unifor.pin.saa.manager.turma;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.saa.bussines.InstituicoesBO;
import br.unifor.pin.saa.bussines.ProfessoresBO;
import br.unifor.pin.saa.bussines.TurmaBO;
import br.unifor.pin.saa.entity.Instituicoes;
import br.unifor.pin.saa.entity.Professores;
import br.unifor.pin.saa.entity.Turma;
import br.unifor.pin.saa.utils.MessagesUtils;
import br.unifor.pin.saa.utils.Navigation;

@RequestScoped
@ManagedBean(name = "cadTurma")
@Component(value = "cadTurma")
public class CadTurmaManager {

	@Autowired
	private TurmaBO turmaBO;
	@Autowired
	private InstituicoesBO instituicoesBO;
	@Autowired
	private ProfessoresBO professoresBO;
	
	private Turma turma;

	public CadTurmaManager() {
		turma = new Turma();
	}

	public String salvar() {

		turmaBO.salvar(turma);
		MessagesUtils.info("Turma cadastrada com sucesso!");

		return Navigation.SUCESSO;
	}
	
	public String preparaSalvar(){
		
		return Navigation.SUCESSO;
	}

	public Collection<SelectItem> getProfessor() {
		Collection<SelectItem> items = new ArrayList<SelectItem>();
		items.add(new SelectItem("", "Selecione o Professor"));
		List<Professores> professores = professoresBO.buscarTodos();
		for (Professores professor : professores) {
			items.add(new SelectItem(professor, professor.getNome()));
		}
		return items;
	}
	
	public Collection<SelectItem> getInstituicao() {
		Collection<SelectItem> items = new ArrayList<SelectItem>();
		items.add(new SelectItem("", "Selecione a Instituicao"));
		List<Instituicoes> instituicoes = instituicoesBO.buscarTodos();
		for (Instituicoes instituicao : instituicoes) {
			items.add(new SelectItem(instituicao, instituicao.getNome()));
		}
		return items;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

}