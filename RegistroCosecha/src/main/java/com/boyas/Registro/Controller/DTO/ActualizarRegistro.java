package com.boyas.Registro.Controller.DTO;

import com.boyas.Registro.Entity.EnumArandanos;
import com.boyas.Registro.Entity.EnumModulos;

public record ActualizarRegistro(String id, Float kilogramosCosechados, EnumModulos modulos,EnumArandanos tipoArandano) {

}
