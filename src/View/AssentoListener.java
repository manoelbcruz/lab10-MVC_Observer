package View;

import java.util.EventListener;

public interface AssentoListener extends EventListener {
    void estadoAssentoAlterado(AssentoEvent event);
}