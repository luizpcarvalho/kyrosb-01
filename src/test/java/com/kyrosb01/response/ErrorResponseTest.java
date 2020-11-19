package com.kyrosb01.response;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ErrorResponseTest {

    private ErrorResponse errorResponse;

    @BeforeEach
    void setUp() {
        errorResponse = new ErrorResponse();
        errorResponse.setCampo("Teste");
        errorResponse.setMensagem("Teste");
    }

    @Test
    void getCampo() {
        assertEquals("Teste", errorResponse.getCampo());
    }

    @Test
    void getMensagem() {
        assertEquals("Teste", errorResponse.getMensagem());
    }
}