package com.erp.FilmERP.config;

import com.erp.FilmERP.DAO.UsuariDAO;
import com.erp.FilmERP.model.Rol;
import com.erp.FilmERP.model.Usuari;
import java.util.ArrayList;
import java.util.Collections;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author fta
 */

/*Anotació que permet al sistema que reconegui aquesta classe com una classe de servei
 *i en concret una classe de servei que utilitzara Spring Security, per això passem per
 *paràmetre el nom predeterminat "userDetailsService".
*/
@Service("userDetailsService")
@Slf4j
public class UsuariService implements UserDetailsService{
    
    /*Atribut que defineix un UsuariDAO, injectant els seu mètodes a aquesta classe (@Autowired),
     *els quals ens permeten interactuar amb les taules de la BBDD pels usuaris i rols
    */
    @Autowired
    private UsuariDAO usuariDAO;

    /**
     * Carga los detalles de un usuario por su nombre de usuario.
     *
     * @return los detalles del usuario como un objeto UserDetails
     * @throws UsernameNotFoundException si no se encuentra ningún usuario con
     * el nombre de usuario proporcionado
     */
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // Busca el usuario por su DNI en el UsuarioDAO
        Usuari usuari = usuariDAO.findBynom(username);

        // Si no se encuentra ningún usuario, lanza una excepción
        if(usuari==null){
             throw new UsernameNotFoundException(username);
        }
        
        var rols= new ArrayList<GrantedAuthority>();
        rols.add(new SimpleGrantedAuthority(usuari.getRol().getNom()));
       

        // Crea y devuelve un objeto User que implementa UserDetails, utilizando los detalles del usuario encontrado
        return new User(usuari.getNom(), usuari.getPassword(), rols);// lista de roles del usuario
    }
    
}//Collections.singletonList(new SimpleGrantedAuthority(String.valueOf(usuari.getRols())))


