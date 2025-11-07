package ro.uvt.info.designpatternslab2023.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class RequestLoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        System.out.println(
                "[LOG] Cerere primită: Metoda=" + req.getMethod() + ", URI=" + req.getRequestURI()
        );
        chain.doFilter(request, response);
        System.out.println("[LOG] Procesarea cererii finalizată.");
    }
}