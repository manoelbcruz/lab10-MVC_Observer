package Model;

public class Assento {
    private final int numero;
    private AssentoStatus status;

    public Assento(int numero) {
        if (numero <= 0) {
            throw new IllegalArgumentException("O numero do assento nao pode ser zero ou negativo.");
        }
        this.numero = numero;
        this.status = AssentoStatus.DISPONIVEL;
    }

    // Getters e Setters
    public int getNumero() {
        return numero;
    }

    public AssentoStatus getStatus() {
        return status;
    }

    public void setStatus(AssentoStatus status) {
        this.status = status;
    }
}