package Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import Model.AssentoStatus;

public class AssentoStatusTest {

    @Test
    void testGetDescricao() {
        assertEquals("Disponivel", AssentoStatus.DISPONIVEL.getDescricao());
        assertEquals("Reservado", AssentoStatus.RESERVADO.getDescricao());
        assertEquals("Indisponivel", AssentoStatus.INDISPONIVEL.getDescricao());
    }
}
