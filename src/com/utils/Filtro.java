package com.utils;

import java.util.List;

@FunctionalInterface
public interface Filtro<T> {
    List<T> filtroLista(Criterio criterio, List<T> lista);


}



