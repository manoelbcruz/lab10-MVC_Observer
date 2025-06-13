package Test;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import View.PainelCentralView;
import Model.Onibus;

public class PainelCentralViewTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void testDesenharPainel() {
        // Arrange
        Onibus onibus = new Onibus(4);
        PainelCentralView painel = new PainelCentralView(onibus);

        // Act
        painel.desenharPainel();

        // Assert
        String saidaDoConsole = outputStreamCaptor.toString().trim();
        assertTrue(saidaDoConsole.contains("PAINEL CENTRAL DA RODOVIÁRIA"));
        assertTrue(saidaDoConsole.contains("[Assento 01: Verde]"));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
