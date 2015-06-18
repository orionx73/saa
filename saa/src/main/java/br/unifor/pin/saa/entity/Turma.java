package br.unifor.pin.saa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "turma")
public class Turma implements Serializable {

	private static final long serialVersionUID = -1203019308743583974L;

	@Id
	@SequenceGenerator(name = "turma_seq", sequenceName = "turma_seq", allocationSize = 1)
	@GeneratedValue(generator = "turma_seq", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(nullable = false)
	private String disciplina;

	@Column(nullable = false)
	private String semestre;

	@ManyToOne
	@JoinColumn(name = "professor_id")
	private Professores professor;

	@ManyToOne
	@JoinColumn(name = "instituicao_id")
	private Instituicoes instituicao;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDisciplina() {
		return disciplina + ":" + semestre;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public Professores getProfessor() {
		return professor;
	}

	public void setProfessor(Professores professor) {
		this.professor = professor;
	}

	public Instituicoes getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicoes instituicao) {
		this.instituicao = instituicao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turma other = (Turma) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}