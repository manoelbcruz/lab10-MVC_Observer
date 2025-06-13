package Model;

public enum AssentoStatus {
    DISPONIVEL("Disponivel"),
    RESERVADO("Reservado"),
    INDISPONIVEL("Indisponivel");

    private final String descricao;

    AssentoStatus(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}