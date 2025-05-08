package org.example.p2extra;

public final class GastoEducacao extends Gasto {
    public static final double DEDUCAO_MAX_EDUCA = 2000;

    public GastoEducacao(long id, String descricao, double valor, String cnpj) {
        super(id, descricao, valor, cnpj);
    }
}
