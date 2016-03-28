package com.killpekeinside.config.spring.security;

import com.killpekeinside.util.StringConstants;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Raman_Susla1 on 10/2/2015.
 */
public class LoginFailureHandler  implements AuthenticationFailureHandler
{
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
            throws IOException, ServletException
    {
        String message = StringConstants.EMPTY;

        if(exception.getClass() == UsernameNotFoundException.class) {
            message = "cannot find a user";
        } else if(exception.getClass() == BadCredentialsException.class) {
            message = "check your password";
        }
        request.getRequestDispatcher(String.format("/error?message=%s", message)).forward(request, response);
    }
}
