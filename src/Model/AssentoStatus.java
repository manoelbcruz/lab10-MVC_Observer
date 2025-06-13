package Model;

public enum AssentoStatus {
    DISPONIVEL("Disponível"),
    RESERVADO("Reservado"),
    INDISPONIVEL("Indisponível");

    private final String descricao;

    AssentoStatus(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}