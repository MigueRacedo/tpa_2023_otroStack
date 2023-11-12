package models.dominio.usuario;

import io.javalin.security.RouteRole;

public enum TipoRol implements RouteRole {
    ADMINISTRADOR_COMUNIDAD,
    NORMAL,
    ADMINISTRADOR,
    DELEGADO

}