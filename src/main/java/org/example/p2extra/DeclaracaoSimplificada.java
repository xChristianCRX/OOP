package org.example.p2extra;

public final class DeclaracaoSimplificada extends Declaracao {

    public DeclaracaoSimplificada(double ganhoTributavel, double valorPago) {
        super(ganhoTributavel, valorPago);
    }

    @Override
    public double getValorImposto() {
        return 0;
    }
}
