package Controller;

import Model.Onibus;

public class ControleRodoviaria {

    private final Onibus model;

    public ControleRodoviaria(Onibus model) {
        this.model = model;
    }
    public void executarReserva(int numeroAssento) {
        if(numeroAssento <= 0) throw new IllegalArgumentException("");
        System.out.println("\nController: Recebida solicitacao para RESERVAR assento " + numeroAssento);
        model.reservar(numeroAssento);
    }

    public void executarCompra(int numeroAssento) {
        System.out.println("\nController: Recebida solicitacao para COMPRAR assento " + numeroAssento);
        model.comprar(numeroAssento);
    }
}