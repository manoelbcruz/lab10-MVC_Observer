package Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Model.*;
import View.AssentoEvent;
import View.AssentoListener;

public class OnibusTest {

    private Onibus onibus;

    @BeforeEach
    void setUp() {
        onibus = new Onibus(10);
    }

    @Test
    void testReservarAssentoDisponivel() {
        onibus.reservar(5);
        assertEquals(AssentoStatus.RESERVADO, onibus.getAssentoByNumero(5).getStatus());
    }

    @Test
    void testComprarAssentoReservado() {
        onibus.reservar(7);
        onibus.comprar(7);
        assertEquals(AssentoStatus.INDISPONIVEL, onibus.getAssentoByNumero(7).getStatus());
    }

    @Test
    void testNotificacaoDeListener() {
        ListenerDeTeste listenerFalso = new ListenerDeTeste();
        onibus.adicionarListener(listenerFalso);

        onibus.reservar(1);

        assertTrue(listenerFalso.foiNotificado);
        assertEquals(1, listenerFalso.assentoDoEvento.getNumero());
    }

    private static class ListenerDeTeste implements AssentoListener {
        boolean foiNotificado = false;
        Assento assentoDoEvento = null;
        public void estadoAssentoAlterado(AssentoEvent event) {
            this.foiNotificado = true;
            this.assentoDoEvento = event.getAssento();
        }
    }

    @Test
    void testCriarOnibusComCapacidadeInvalidaLancaExcecao() {
        assertThrows(IllegalArgumentException.class, () -> new Onibus(0));
        assertThrows(IllegalArgumentException.class, () -> new Onibus(-5));
    }

    @Test
    void testReservarAssentoErro() {
        assertThrows(IllegalArgumentException.class, () -> {
            onibus.reservar(99);
        });
    }

    @Test
    void testComprarAssentoErro() {
        assertThrows(IllegalArgumentException.class, () -> {
            onibus.comprar(5);
            onibus.comprar(5);
        });
    }

    @Test
    void testReservarAssentoReservadoErro() {
        assertThrows(IllegalArgumentException.class, () -> {
            onibus.reservar(7);
            onibus.reservar(7);
        });
    }
}