package com.cst438.main.test;

import static org.mockito.Mockito.*;

import com.cst438.main.AuthEntryPoint;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.Test;
import org.springframework.security.core.AuthenticationException;

import java.io.IOException;

class AuthEntryPointTest {

    @Test
    void commence_ShouldSendUnauthorizedError() throws IOException {
        // Arrange
        AuthEntryPoint entryPoint = new AuthEntryPoint();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        AuthenticationException exception = mock(AuthenticationException.class);

        // Act
        entryPoint.commence(request, response, exception);

        // Assert
        verify(response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
    }
}
