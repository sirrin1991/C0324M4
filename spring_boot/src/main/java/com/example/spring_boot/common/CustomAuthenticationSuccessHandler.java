package com.example.spring_boot.common;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import java.io.IOException;


@Component
public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws  IOException {
        // Lấy URL từ session attribute tự định nghĩa
        String targetUrl = (String) request.getSession().getAttribute("REDIRECT_URL");

        // Xóa attribute khỏi session
        request.getSession().removeAttribute("REDIRECT_URL");

        if (targetUrl == null || targetUrl.isEmpty()) {
            targetUrl = "/";  // Default URL
        }

        clearAuthenticationAttributes(request);
        getRedirectStrategy().sendRedirect(request, response, targetUrl);
    }
}