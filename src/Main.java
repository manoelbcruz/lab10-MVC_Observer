import Controllers.ControleRodoviaria;
import Model.Onibus;
import View.PainelCentralView;
import View.QuiosqueView;

public class Main {

    public static void main(String[] args) {
        try {
            Onibus onibus = new Onibus(12);
            PainelCentralView painel = new PainelCentralView(onibus);
            QuiosqueView quiosque = new QuiosqueView(onibus);
            onibus.adicionarListener(painel);
            onibus.adicionarListener(quiosque);
            ControleRodoviaria controller = new ControleRodoviaria(onibus);

            System.out.println("### Inicio da Simulacao ###");

            controller.executarReserva(5);
            controller.executarCompra(8);
            painel.desenharPainel();

        } catch (IllegalArgumentException err) {
            System.err.println("Erro: " + err.getMessage());
        }
    }
}