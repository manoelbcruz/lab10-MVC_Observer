package View;

import Model.Assento;
import Model.AssentoStatus;
import Model.Onibus;

public class PainelCentralView implements AssentoListener {
    private final Onibus model;
    public PainelCentralView(Onibus model) {
        this.model = model;
    }

    @Override
    public void estadoAssentoAlterado(AssentoEvent event) {
        System.out.println(">>> PAINEL CENTRAL: Notificação recebida para o assento " + event.getAssento().getNumero());
        desenharPainel();
    }

    public void desenharPainel() {
        System.out.println("\n--- PAINEL CENTRAL DA RODOVIÁRIA ---");
        for (Assento a : model.getAssentos()) {
            String cor;

            if (a.getStatus() == AssentoStatus.RESERVADO) {
                cor = "Amarelo";
            } else if (a.getStatus() == AssentoStatus.INDISPONIVEL) {
                cor = "Vermelho";
            } else {
                cor = "Verde";
            }

            System.out.printf("[Assento %02d: %s] ", a.getNumero(), cor);
            if (a.getNumero() % 4 == 0) {
                System.out.println();
            }
        }
        System.out.println("\n------------------------------------");
    }
}