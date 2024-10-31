package Main_Package.service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.catalina.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import Main_Package.model.Usuario;
import Main_Package.repository.UsuarioRepository;
import Main_Package.security.UsuarioPrincipal;

@Service
public class DetalhesUsuarioService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByEmail(email);
		if(usuario == null) {
			throw new UsernameNotFoundException("usuario não encontrado");
		}
		return new Usuario (usuario.getEmail(), 
					usuario.getSenha(), 
					mapearPapeisParaPermissoes(usuario.getRole()));
	}
	
	private Collection<? extends GrantedAuthority> mapearPapeisParaPermissoes(Set<Role> roles){
		return roles.stream()
				.map(role -> new SimpleGrantedAuthority(role.getRolename()))
				.collect(Collectors.toList());
	}

}
