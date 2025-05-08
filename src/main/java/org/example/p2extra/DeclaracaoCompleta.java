package org.example.p2extra;

import java.util.List;

public final class DeclaracaoCompleta extends Declaracao{
    private List<Gasto> gastos;

    public DeclaracaoCompleta(double ganhoTributavel, double valorPago, List<Gasto> gastos) {
        super(ganhoTributavel, valorPago);
        this.gastos = gastos;
    }

    @Override
    public double getValorImposto() {
        return 0;
    }

    public double getDespesaDedutivel() {
        return 0;
    }

    public void addGasto(Gasto gasto){
        gastos.add(gasto);
    }

    public void removeGasto(Gasto gasto){
        gastos.remove(gasto);
    }
}
