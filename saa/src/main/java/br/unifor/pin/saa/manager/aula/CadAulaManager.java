package br.unifor.pin.saa.manager.aula;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.saa.bussines.AulasBO;
import br.unifor.pin.saa.bussines.TurmaBO;
import br.unifor.pin.saa.entity.Aulas;
import br.unifor.pin.saa.entity.Turma;
import br.unifor.pin.saa.utils.MessagesUtils;
import br.unifor.pin.saa.utils.Navigation;

@RequestScoped
@ManagedBean(name = "cadAula")
@Component(value = "cadAula")
public class CadAulaManager {

	@Autowired
	private AulasBO aulasBO;
	@Autowired
	private TurmaBO turmaBO;

	private Aulas aula;

	public CadAulaManager() {
		aula = new Aulas();
	}

	public String salvar() {

		aulasBO.salvar(aula);
		MessagesUtils.info("Aula cadastrada com sucesso!");

		return Navigation.SUCESSO;
	}
	
	public String preparaSalvar(){
		
		return Navigation.SUCESSO;
	}

	public Collection<SelectItem> getTurma() {
		Collection<SelectItem> items = new ArrayList<SelectItem>();
		items.add(new SelectItem("", "Selecione a Turma"));
		List<Turma> turmas = turmaBO.buscarTodos();
		for (Turma turma : turmas) {
			items.add(new SelectItem(turma, turma.getDisciplina()));
		}
		return items;
	}

	public Aulas getAula() {
		return aula;
	}

	public void setAula(Aulas aula) {
		this.aula = aula;
	}

}