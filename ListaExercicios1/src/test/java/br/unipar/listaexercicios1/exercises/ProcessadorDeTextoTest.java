package br.unipar.listaexercicios1.exercises;

import br.unipar.listaexercicios1.exceptions.ValidationException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProcessadorDeTextoTest {
    ProcessadorDeTexto processadorDeTexto;

    @BeforeEach
    void setUp() {
        processadorDeTexto = new ProcessadorDeTexto();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void inverterPalavras() {
        assertEquals("mundo ola", processadorDeTexto.inverterPalavras("ola mundo"));

        assertThrows(ValidationException.class, () -> {
            processadorDeTexto.inverterPalavras("");
        });

        assertThrows(ValidationException.class, () -> {
            processadorDeTexto.inverterPalavras(null);
        });
    }

    @Test
    void substituirPalavras() {
        assertEquals("ola lua", processadorDeTexto.substituirPalavras("ola mundo", "mundo", "lua"));

        assertThrows(ValidationException.class, () -> {
            processadorDeTexto.substituirPalavras("ola mundo", "", "lua");
        });

        assertThrows(ValidationException.class, () -> {
            processadorDeTexto.substituirPalavras("ola mundo", "mundo", "");
        });

        assertThrows(ValidationException.class, () -> {
            processadorDeTexto.substituirPalavras("ola mundo", null, "lua");
        });

        assertThrows(ValidationException.class, () -> {
            processadorDeTexto.substituirPalavras("ola mundo", "mundo", null);
        });

        assertThrows(ValidationException.class, () -> {
            processadorDeTexto.substituirPalavras(null, null, null);
        });

    }

    @Test
    void contarOcorrenciasDePalavra() {
        assertEquals(2, processadorDeTexto.contarOcorrenciasDePalavra("ola mundo mundo", "mundo"));

        assertThrows(ValidationException.class, () -> {
            processadorDeTexto.contarOcorrenciasDePalavra("ola mundo mundo", "");
        });

        assertThrows(ValidationException.class, () -> {
            processadorDeTexto.contarOcorrenciasDePalavra("ola mundo mundo", null);
        });

        assertThrows(ValidationException.class, () -> {
            processadorDeTexto.contarOcorrenciasDePalavra("", "mundo");
        });

        assertThrows(ValidationException.class, () -> {
            processadorDeTexto.contarOcorrenciasDePalavra(null, "mundo");
        });
    }
}