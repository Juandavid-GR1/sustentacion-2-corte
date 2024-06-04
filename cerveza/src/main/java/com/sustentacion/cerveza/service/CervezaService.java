package com.sustentacion.cerveza.service;

import java.util.ArrayList;

import com.sustentacion.cerveza.Domain.Cerveceria;

public interface CervezaService {
    ArrayList<Cerveceria> listaCervecerias();
    void GuardarCerveceria(Cerveceria cerveceri);
    Cerveceria MostrarCerveceria(String name);
}
