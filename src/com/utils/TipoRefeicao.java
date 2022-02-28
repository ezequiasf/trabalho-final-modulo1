package com.utils;

public enum TipoRefeicao implements Criterio{
    CAFE_DA_MANHA   ("Café da Manhã"),
    ALMOCO_JANTA("Almoço ou janta"),
    LANCHE("Lanche");

    private final String refeicao;

    TipoRefeicao(String refeicao) {
        this.refeicao = refeicao;
    }

    public String getRefeicao() {
        return refeicao;
    }
}
