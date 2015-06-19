package br.unifor.pin.saa.manager.login;

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
@ManagedBean(name = "verLogin")
@Component(value = "verLogin")
public class LoginManager {

	private String email;
	private String senha;
	private String valida;
	private Usuarios usuario;

	@Autowired
	private UsuarioBO usuarioBO;
	@Autowired
	private UsuarioTO usuarioTO;

	public String verificaLogin() {

		usuarioTO.setUsuario(usuarioBO.logar(email,senha));

		if (usuarioTO.getUsuario() != null
				&& usuarioTO.getUsuario().isAtivo()) {
			if(usuarioTO.getUsuario().getTipoUsuario().equals(TPUsuario.ALUNO)){
				//listar as turmas do aluno
			} else if(usuarioTO.getUsuario().getTipoUsuario().equals(TPUsuario.PROFESSOR)){
				//listar as turmas do professor
			}
			MessagesUtils.info("Bem vindo "+usuarioTO.getUsuario().getNome()+"!");
			return Navigation.SUCESSO;
		} else {
			MessagesUtils.error("Login ou senha incorretos!");
			return Navigation.FALHA;
		}
	}
	
	public String preparaCadastro(){
		return Navigation.CONTINUE;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getValida() {
		return valida;
	}

	public void setValida(String valida) {
		this.valida = valida;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public UsuarioBO getUsuarioBO() {
		return usuarioBO;
	}

	public void setUsuarioBO(UsuarioBO usuarioBO) {
		this.usuarioBO = usuarioBO;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}