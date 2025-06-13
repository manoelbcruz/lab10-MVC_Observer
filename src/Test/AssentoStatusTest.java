package Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import Model.AssentoStatus;

public class AssentoStatusTest {

    @Test
    void testGetDescricao() {
        assertEquals("Disponível", AssentoStatus.DISPONIVEL.getDescricao());
        assertEquals("Reservado", AssentoStatus.RESERVADO.getDescricao());
        assertEquals("Indisponível", AssentoStatus.INDISPONIVEL.getDescricao());
    }
}
