package com.example.projetodesktop.database;

import com.example.projetodesktop.model.Lembrete;
import com.example.projetodesktop.model.Receita;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public final class BancoDeDados {

    public static final ObservableList<Lembrete> lembretes = FXCollections.observableArrayList();
    public static final ObservableList<Receita> receitas = FXCollections.observableArrayList();

    static {
        receitas.add(new Receita("Salada colorida", "Alface, tomate, cenoura e azeite.",
                "Verificar rótulos dos ingredientes.", "Porção individual"));
    }

    private BancoDeDados() {
    }
}
