package View;

import java.util.EventObject;
import Model.Assento;

public class AssentoEvent extends EventObject {

    private final Assento assento;

    public AssentoEvent(Object source, Assento assento) {
        super(source);
        this.assento = assento;
    }

    public Assento getAssento() {
        return assento;
    }
}
