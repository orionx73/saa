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
@Table(name="users")
public class Users implements Serializable {

	private static final long serialVersionUID = -6256583960665713323L;
	
	@Id
	@SequenceGenerator(name="users_seq", sequenceName="users_seq", allocationSize=1)
	@GeneratedValue(generator="users_seq", strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@Column(nullable=false)
	private String email;
	
	@Column(nullable=false)
	private String senha;
	
	@ManyToOne
	@JoinColumn(name="professor_id")
	private Professores professor;
	
	@ManyToOne
	@JoinColumn(name="aluno_id")
	private Alunos aluno;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Professores getProfessor() {
		return professor;
	}

	public void setProfessor(Professores professor) {
		this.professor = professor;
	}
	
	public Alunos getAluno() {
		return aluno;
	}

	public void setAluno(Alunos aluno) {
		this.aluno = aluno;
	}

}
