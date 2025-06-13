package View;

import Model.Assento;
import Model.Onibus;

public class QuiosqueView implements AssentoListener {

    private final Onibus model;

    public QuiosqueView(Onibus model) {
        this.model = model;
    }

    @Override
    public void estadoAssentoAlterado(AssentoEvent event) {
        System.out.println(">>> QUIOSQUE: Recebi atualização sobre o assento " + event.getAssento().getNumero() + ". Atualizando lista.");
        exibirLista();
    }

    public void exibirLista() {
        System.out.println("\n--- QUIOSQUE DE AUTOATENDIMENTO ---");
        for(Assento a : model.getAssentos()) {
            System.out.printf("Assento %d -> Status: %s\n", a.getNumero(), a.getStatus().getDescricao());
        }
        System.out.println("------------------------------------");
    }
}