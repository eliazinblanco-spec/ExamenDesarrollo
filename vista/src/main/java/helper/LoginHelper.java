/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import mx.desarrollo.entity.Usuario;
import mx.desarrollo.integration.ServiceFacadeLocator;
import java.io.Serializable;

public class LoginHelper implements Serializable {
    public Usuario login(String correo, String contrasena){
        return ServiceFacadeLocator.getInstanceFacadeUsuario().login(correo, contrasena);
    }
}
