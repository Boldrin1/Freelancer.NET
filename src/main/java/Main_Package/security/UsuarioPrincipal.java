package Main_Package.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import Main_Package.model.Usuario;

import java.util.Collection;
import java.util.Collections;

public class UsuarioPrincipal implements UserDetails {

    private Usuario usuario;

    public UsuarioPrincipal(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Especifica o tipo como SimpleGrantedAuthority para o singletonList
        return Collections.<GrantedAuthority>singletonList(new SimpleGrantedAuthority("ROLE_" + usuario.getRole()));
    }


    @Override
    public String getPassword() {
        return usuario.getSenha(); // Retorna a senha da classe Usuario
    }

    @Override
    public String getUsername() {
        return usuario.getEmail(); // Retorna o e-mail como username
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Exemplo simples, pode adicionar lógica real
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Exemplo simples, pode adicionar lógica real
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Exemplo simples, pode adicionar lógica real
    }

    @Override
    public boolean isEnabled() {
        return true; // Exemplo simples, pode adicionar lógica real
    }
}
