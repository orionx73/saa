package br.unifor.pin.saa.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name ="cursa")
public class Cursa implements Serializable{
	
	private static final long serialVersionUID = 3600592866221208790L;

	@Id
	@SequenceGenerator(name="cursa_seq",sequenceName="cursa_seq",allocationSize=1)
    @GeneratedValue(generator="cursa_seq",strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="aluno_id")
	private Alunos alunos;
	
	@ManyToOne
	@JoinColumn(name="turma_id")
	private Turma turma;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Alunos getAlunos() {
		return alunos;
	}

	public void setAlunos(Alunos alunos) {
		this.alunos = alunos;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
}