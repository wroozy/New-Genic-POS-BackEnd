package lk.wroozy.newgeniccomputer.jwt;

import com.google.common.base.Strings;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import lk.wroozy.newgeniccomputer.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class JwtTokenAuthorizationFilter extends OncePerRequestFilter {

    private final JwtConfig jwtConfig;

    @Autowired
    public JwtTokenAuthorizationFilter(JwtConfig jwtConfig) {
        this.jwtConfig = jwtConfig;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String authorization = request.getHeader(jwtConfig.getHeader());

        if (Strings.isNullOrEmpty(authorization) || !authorization.startsWith(jwtConfig.getPrefix())) {
            filterChain.doFilter(request,response);
            return;
        }
        String token = authorization.replace(jwtConfig.getPrefix(), "");

        try{
            Jws<Claims> claimsJws = Jwts.parser()
                    .setSigningKey(jwtConfig.getSecret().getBytes())
                    .parseClaimsJws(token);

            Claims body = claimsJws.getBody();
            String username = body.getSubject();
            String userId = body.get("id", String.class);
            List<String> authorities = body.get("authorities", List.class);

            if(!username.isEmpty()){
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                        userId,
                        null,
                        authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList())
                );
                Collection<GrantedAuthority> authAuthorities = auth.getAuthorities();
                for (GrantedAuthority authority :
                        authAuthorities) {
                    if (authority.getAuthority().equals("ROLE_"+Role.ADMIN.toString())){
                        SecurityContextHolder.getContext().setAuthentication(auth);
                    }
                }
            }
        }catch (Exception e){
            throw new IllegalStateException("Token %token cannot be trusted");
        }
        filterChain.doFilter(request,response);
    }
}
