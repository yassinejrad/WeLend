package com.pidev.welend.Security.Config;

import com.pidev.welend.services.UsersService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Component

public class JwtAuthFilter extends OncePerRequestFilter {


    @Autowired
 private  UsersService userDao;
 private  JwtUtils jwtUtils;


    @Override
    protected void doFilterInternal(@NotNull HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String AuthHeader = request.getHeader(AUTHORIZATION);
        final String userEmail;
        final String jwtToken;
        jwtUtils=new JwtUtils();

        if (AuthHeader == null || !AuthHeader.startsWith("Bearer")){
            filterChain.doFilter(request,response);
            return;
        }
        jwtToken = AuthHeader.substring(7);
        userEmail = jwtUtils.extractUsername(jwtToken);
        if (userEmail !=null && SecurityContextHolder.getContext().getAuthentication()==null){
            UserDetails userDetails = userDao.findUserByEmail(userEmail);
            final boolean isTokenValid;
            if(jwtUtils.isTokenValid(jwtToken,userDetails)){
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null,userDetails.getAuthorities());
            authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}
