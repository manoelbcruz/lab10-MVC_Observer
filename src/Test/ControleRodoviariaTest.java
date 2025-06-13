package Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Model.Onibus;
import Controller.ControleRodoviaria;
import Model.AssentoStatus;

public class ControleRodoviariaTest {

    private Onibus onibus;
    private ControleRodoviaria controller;

    @BeforeEach
    void setUp() {
        onibus = new Onibus(10);
        controller = new ControleRodoviaria(onibus);
    }

    @Test
    void testExecutarReserva() {
        controller.executarReserva(1);
        assertEquals(AssentoStatus.RESERVADO, onibus.getAssentoByNumero(1).getStatus());
    }

    @Test
    void testExecutarCompra() {
        controller.executarCompra(9);
        assertEquals(AssentoStatus.INDISPONIVEL, onibus.getAssentoByNumero(9).getStatus());
    }
}
