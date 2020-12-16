package com.yaprofe.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yaprofe.demo.model.Profesor;
import com.yaprofe.demo.model.Rol;
import com.yaprofe.demo.model.Usuario;
import com.yaprofe.demo.repository.TeacherRepository;

@Service("userDetailService")
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private TeacherRepository teacherRepository;
	@Autowired
	private UserService userService;
	
    private Logger logger = LoggerFactory.getLogger(UserDetailsService.class);
    
    @Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    	try {
    		Usuario usuario = userService.getUserByUsername(s);
    		logger.info(usuario.getRoles().get(0).getNombre());
            if (usuario == null) {
                logger.error("Error login: No existe el usuario " + s);
                throw new UsernameNotFoundException("Usuario no existe en el sistema");
            }
            List<GrantedAuthority> authorities = new ArrayList<>();
            for(Rol rol: usuario.getRoles()) {
                logger.info("Rol: " + rol.getNombre());
            	authorities.add(new SimpleGrantedAuthority(rol.getNombre()));
            	System.out.println(rol.getNombre());
            }

            return new User(usuario.getUsername(), usuario.getPassword(), authorities);
    	}catch(Exception e) {
    		System.out.println(e.toString());
    	}
        
    	return null;
    }
}
