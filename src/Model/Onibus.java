package Model;

import java.util.ArrayList;
import java.util.List;
import View.AssentoEvent;
import View.AssentoListener;

public class Onibus {
    private final List<Assento> assentos = new ArrayList<>();
    private final List<AssentoListener> listeners = new ArrayList<>();

    public Onibus(int capacidade) {
        if(capacidade <= 0) throw new IllegalArgumentException("Numero de capacidade invalido");
        for (int i = 1; i <= capacidade; i++) {
            this.assentos.add(new Assento(i));
        }
    }

    public void adicionarListener(AssentoListener listener) {
        if (listener == null) throw new IllegalArgumentException("O listener nao pode ser nulo");
        this.listeners.add(listener);
    }

    public void reservar(int numeroAssento) {
        Assento assento = getAssentoByNumero(numeroAssento);
        if (assento == null) throw new IllegalArgumentException("Assento #" + numeroAssento + " nao existe");
        if (assento.getStatus() == AssentoStatus.DISPONIVEL) {
            assento.setStatus(AssentoStatus.RESERVADO);
            System.out.println("Model: Assento " + numeroAssento + " foi reservado.");
            notificarListeners(assento);
        }
    }

    public void comprar(int numeroAssento) {
        Assento assento = getAssentoByNumero(numeroAssento);
        if (assento == null) throw new IllegalArgumentException("Assento #" + numeroAssento + " nao existe");
        if ((assento.getStatus() == AssentoStatus.DISPONIVEL || assento.getStatus() == AssentoStatus.RESERVADO)) {
            assento.setStatus(AssentoStatus.INDISPONIVEL);
            System.out.println("Model: Assento " + numeroAssento + " foi comprado.");
            notificarListeners(assento);
        }
    }

    private void notificarListeners(Assento assentoModificado) {
        AssentoEvent event = new AssentoEvent(this, assentoModificado);
        for (AssentoListener listener : listeners) {
            listener.estadoAssentoAlterado(event);
        }
    }

    public Assento getAssentoByNumero(int numero) {
        for (Assento assento : this.assentos) {
            if (assento.getNumero() == numero) {
                return assento;
            }
        }
        return null;
    }

    public List<Assento> getAssentos() {
        return this.assentos;
    }
}