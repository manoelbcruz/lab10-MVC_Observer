package Test;

import Model.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AssentoTest {

    @Test
    void testConstrutorEGetters() {
        int numeroDoAssento = 7;

        Assento assento = new Assento(numeroDoAssento);

        assertEquals(numeroDoAssento, assento.getNumero());
        assertEquals(AssentoStatus.DISPONIVEL, assento.getStatus());
    }

    @Test
    void testSetStatus() {
        Assento assento = new Assento(1);

        assento.setStatus(AssentoStatus.RESERVADO);
        assertEquals(AssentoStatus.RESERVADO, assento.getStatus());

        assento.setStatus(AssentoStatus.INDISPONIVEL);
        assertEquals(AssentoStatus.INDISPONIVEL, assento.getStatus());
    }

    @Test
    void testCriarAssentoErro() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Assento(0);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Assento(-1);
        });
    }
}