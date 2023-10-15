package com.tulio.teste.filter;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.tulio.teste.user.IUserRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FilterAuth extends OncePerRequestFilter{

    @Autowired
    IUserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        var servletPath = request.getServletPath();
        
        if(servletPath.startsWith("/Task/"))
        {
            var authorization = request.getHeader("Authorization");
            var UserEncoded = authorization.substring("Basic".length()).trim();
            byte[] Userdecoder = Base64.getDecoder().decode(UserEncoded);
            var Userdecoded = new String(Userdecoder);

            String[] Credentials = Userdecoded.split(":");
            String Username = Credentials[0];
            String Password = Credentials[1];
        
            var user = this.userRepository.findByName(Username);
           
            if(user == null)
            {
                System.out.println("\"Usuário não encontrado\"");
                response.sendError(401, "Usuário não encontrado");
            }

            else
            {
                if(Password.equals(user.getPassword()))
                {
                    System.out.println("Task cadastrada por:" + Username + "SENHA" + Password + "UUID" + user.getId());
                    request.setAttribute("cadastradoPor", user.getId());
                    filterChain.doFilter(request, response);
                }

                else
                {
                     System.out.println("\"Senha invalída\"");
                    response.sendError(401, "Senha invalída");
                }
               
            }  
        }
        else 
        {
            filterChain.doFilter(request, response);  
        }   
    }
}