package br.unifor.pin.saa.manager.usuario;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.saa.bussines.UsuarioBO;
import br.unifor.pin.saa.entity.TPUsuario;
import br.unifor.pin.saa.entity.Usuarios;
import br.unifor.pin.saa.utils.MessagesUtils;
import br.unifor.pin.saa.utils.Navigation;

@RequestScoped
@ManagedBean(name="cadUsuario")
@Component(value="cadUsuario")
public class CadUsuarioManager {

	@Autowired
	private UsuarioBO usuarioBO;
	@Autowired
	private ListUsuarioManager listUsuario;
	private String nome;
	private String email;
	private String senha;
	private Integer tipo;
	private TPUsuario tipoUsuario;
	private String vinculo;
	
	public String salvar(){
		Usuarios usuario = new Usuarios();
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setSenha(senha);

		if (vinculo.equals("professor")){
			usuario.setTPUsuario(tipoUsuario.PROFESSOR);
		}
		else if (vinculo.equals("aluno")){
			usuario.setTPUsuario(tipoUsuario.ALUNO);
		}

		usuarioBO.salvar(usuario);
		MessagesUtils.info("Usuário salvo com sucesso!");
		listUsuario.lista();
		
		return Navigation.SUCESSO;
	}
	
	public String preparaSalvar(){
		this.limpaDados();
		
		return Navigation.SUCESSO;
	}
			
	public void limpaDados(){
		this.nome = "";
		this.email = "";
		this.senha = "";
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public String getVinculo() {
		return vinculo;
	}

	public void setVinculo(String vinculo) {
		this.vinculo = vinculo;
	}

	public TPUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TPUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
}