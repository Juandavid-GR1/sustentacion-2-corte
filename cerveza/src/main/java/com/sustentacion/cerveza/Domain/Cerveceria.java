package com.sustentacion.cerveza.Domain;

import lombok.Data;

@Data
public class Cerveceria {
   private String  nombre_cerveceria;
   private String departamento;
   private String municipio;
   private String direccion;
   private String marca;
   private String stock;
   public void add(Cerveceria cerveceria) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'add'");
   }
}
