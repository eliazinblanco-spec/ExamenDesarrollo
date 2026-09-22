package mx.desarrollo.delegate;

import mx.desarrollo.entity.Usuario;
import mx.desarrollo.persistence.integration.ServiceLocator;

public class DelegateUsuario {
    public Usuario login(String correo, String contrasena){
        return ServiceLocator.getInstanceUsuarioDAO().buscarCredenciales(correo, contrasena);
    }

    public void saveUsuario(Usuario usuario){
        ServiceLocator.getInstanceUsuarioDAO().save(usuario);
    }
}