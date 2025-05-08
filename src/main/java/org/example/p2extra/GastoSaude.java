package org.example.p2extra;

public final class GastoSaude extends Gasto {
    private String registroConselho;
    public static final double DEDUCAO_MAX_SAUDE = 1500;

    public GastoSaude(long id, String descricao, double valor, String cnpj) {
        super(id, descricao, valor, cnpj);
    }
}
