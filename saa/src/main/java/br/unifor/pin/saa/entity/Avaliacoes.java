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
@Table(name ="avaliacoes")
public class Avaliacoes implements Serializable{
	
	private static final long serialVersionUID = 9045460114396877875L;

	@Id
	@SequenceGenerator(name="avaliacoes_seq",sequenceName="avaliacoes_seq",allocationSize=1)
    @GeneratedValue(generator="avaliacoes_seq",strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@Column(nullable=false)
	private Double nota;
	
	@Column(nullable=false)
	private Boolean aprovado;
	
	@Column(nullable=false)
	private String comentario;
	
	//Getts and Setts
	
	
	@ManyToOne
	@JoinColumn(name="aluno_id")
	private Alunos aluno;
	
	@ManyToOne
	@JoinColumn(name="aulas_id")
	private Aulas aulas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public Boolean getAprovado() {
		return aprovado;
	}

	public void setAprovado(Boolean aprovado) {
		this.aprovado = aprovado;
	}

	public Alunos getAluno() {
		return aluno;
	}

	public void setAluno(Alunos aluno) {
		this.aluno = aluno;
	}

	public Aulas getAulas() {
		return aulas;
	}

	public void setAulas(Aulas aulas) {
		this.aulas = aulas;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	
	}
