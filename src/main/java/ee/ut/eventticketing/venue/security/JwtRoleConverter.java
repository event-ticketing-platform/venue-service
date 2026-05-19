package ee.ut.eventticketing.venue.security;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JwtRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

    @Override
    public Collection<GrantedAuthority> convert(Jwt jwt) {
        List<GrantedAuthority> authorities = new ArrayList<>();

        Object rolesClaim = jwt.getClaims().get("roles");
        Object roleClaim = jwt.getClaims().get("role");

        if (rolesClaim instanceof Collection<?> roles) {
            for (Object role : roles) {
                authorities.add(toAuthority(role.toString()));
            }
        }

        if (roleClaim instanceof String role) {
            authorities.add(toAuthority(role));
        }

        return authorities;
    }

    private GrantedAuthority toAuthority(String role) {
        if (role.startsWith("ROLE_")) {
            return new SimpleGrantedAuthority(role);
        }

        return new SimpleGrantedAuthority("ROLE_" + role);
    }
}