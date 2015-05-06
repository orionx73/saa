package br.unifor.pin.saa.bussines;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.aspectj.Loggable;
import br.unifor.pin.saa.dao.UsuarioDAO;
import br.unifor.pin.saa.entity.Usuarios;
import br.unifor.pin.saa.exceptions.DAOException;
/**
 * @author patrick.cunha
 * 
 */
@Loggable
@Component
public class UsuarioBO {

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	public void salvar(Usuarios usuario) {
		usuario.setAtivo(false);
		usuario.setPrimeiroAcesso(true);
		usuarioDAO.salvar(usuario);
	}
	
	public void atualizar(Usuarios usuario){
		usuarioDAO.atualizar(usuario);
		
	}

	@Loggable(enable=false)
	public List<Usuarios> listaUsuarioPorNome(String nome) {
		List<Usuarios> usuarios = usuarioDAO.listarPorNome(nome);
		return usuarios;
	}
	
	public Usuarios buscarPorId(Integer id){
		try {
			return usuarioDAO.buscaPorId(id);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void excluir(Usuarios usuario) {
		try {
			usuario = usuarioDAO.buscaPorId(usuario.getId());
		} catch (DAOException e) {
			e.printStackTrace();
		}
		usuarioDAO.excluir(usuario);
	}

}
