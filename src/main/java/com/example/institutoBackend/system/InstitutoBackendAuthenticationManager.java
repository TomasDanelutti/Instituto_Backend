package com.example.institutoBackend.system;

import com.example.institutoBackend.dao.Persona.PersonaDao;
import com.example.institutoBackend.dao.UsuarioLogin.UsuarioLoginDao;
import com.example.institutoBackend.model.Empleado;
import com.example.institutoBackend.model.Persona;
import com.example.institutoBackend.model.UsuarioLogin;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InstitutoBackendAuthenticationManager implements AuthenticationManager {

	private final BCryptPasswordEncoder encoder;

	private final String serverUrl;

	private final UsuarioLoginDao usuarioLoginDao;

	private final PersonaDao personaDao;
	
	@Autowired
	public InstitutoBackendAuthenticationManager(BCryptPasswordEncoder encoder, String serverUrl, UsuarioLoginDao usuarioLoginDao, PersonaDao personaDao) {
		this.encoder = encoder;
		this.serverUrl = serverUrl;
		this.usuarioLoginDao = usuarioLoginDao;
		this.personaDao = personaDao;
	}

	@SneakyThrows
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String dni = authentication.getName();
		String clave = (String) authentication.getCredentials();
		List<GrantedAuthority> authorities = new ArrayList<>();

		UsuarioLogin usuarioLogin = usuarioLoginDao.findUsuarioLoginByDni(Long.parseLong(dni));
		if (usuarioLogin == null || !encoder.matches(clave, usuarioLogin.getClave())) {
			throw new BadCredentialsException("Usuario y/o clave incorrectos");
		}

		Persona persona = personaDao.findPersonaByDni(usuarioLogin.getDni());
		if (persona == null) {
			throw new BadCredentialsException("Usuario no encontrado");
		}

		switch (persona.getRol().getIdRol().intValue()) {
			case 0:
				authorities.add(new SimpleGrantedAuthority("ROLE_INSTITUCION"));
				break;
			case 1:
				switch (((Empleado) persona).getPuestoEmpleado().getIdPuestoEmpleado().intValue()) {
					case 0:
						authorities.add(new SimpleGrantedAuthority("ROLE_ADMINISTRATIVO"));
						break;
					case 1:
						authorities.add(new SimpleGrantedAuthority("ROLE_PROFESOR"));
						break;
					default:
						throw new BadCredentialsException("Rol no encontrado");
				}
				authorities.add(new SimpleGrantedAuthority("ROLE_EMPLEADO"));
				break;
			case 2:
				authorities.add(new SimpleGrantedAuthority("ROLE_ALUMNO"));
				break;
			default:
				throw new BadCredentialsException("Rol no encontrado");
		}
		return new UsernamePasswordAuthenticationToken(new User(dni, "", authorities), "", authorities);
	}
}
