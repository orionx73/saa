package br.unifor.pin.saa.manager.login;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Component;

import br.unifor.pin.saa.entity.Usuarios;

@SessionScoped
@ManagedBean(name="usuarioTO")
@Component(value="usuarioTO")
public class UsuarioTO {

	private Usuarios usuario;

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}
	
}