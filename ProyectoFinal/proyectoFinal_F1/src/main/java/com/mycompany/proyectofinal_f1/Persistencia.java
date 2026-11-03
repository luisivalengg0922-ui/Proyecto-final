
package com.mycompany.proyectofinal_f1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class Persistencia {

    public static Connection realizarConexion() {
        String url = "jdbc:mysql://localhost:3306/f1";
        String usuario = "root";
        String clave = "";

        try {
            return DriverManager.getConnection(url, usuario, clave);
        } catch (SQLException ex) {
            System.out.println("Error de conexión: " + ex.getMessage());
            return null;
        }
    }

    public static boolean registrarUsuario(String usuario, String contrasena) {
        String sql = "INSERT INTO usuarios "
                + "(nombre_usuario, contrasena_hash) VALUES (?, ?)";

        try (Connection conexion = realizarConexion()) {
            if (conexion == null) {
                return false;
            }

            try (PreparedStatement ps = conexion.prepareStatement(sql)) {
                ps.setString(1, usuario);
                ps.setString(2, contrasena);
                return ps.executeUpdate() == 1;
            }

        } catch (SQLException ex) {
            System.out.println("Error al registrar usuario: " + ex.getMessage());
            return false;
        }
    }

    public static boolean validarLogin(String usuario, String contrasena) {
        String sql = "SELECT contrasena_hash FROM usuarios "
                + "WHERE nombre_usuario = ?";

        try (Connection conexion = realizarConexion()) {
            if (conexion == null) {
                return false;
            }

            try (PreparedStatement ps = conexion.prepareStatement(sql)) {
                ps.setString(1, usuario);

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        return contrasena.equals(
                                rs.getString("contrasena_hash"));
                    }
                    return false;
                }
            }

        } catch (SQLException ex) {
            System.out.println("Error al validar usuario: " + ex.getMessage());
            return false;
        }
    }


    // MÉTODOS PARA CONSULTAR LAS TABLAS


    private DefaultTableModel crearModelo(String... columnas) {
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };

        for (String columna : columnas) {
            modelo.addColumn(columna);
        }

        return modelo;
    }

    private void cargarFilas(DefaultTableModel modelo, String sql,
                             int cantidadColumnas) {

        try (Connection conexion = realizarConexion()) {
            if (conexion == null) {
                return;
            }

            try (PreparedStatement ps = conexion.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    Object[] fila = new Object[cantidadColumnas];

                    for (int i = 0; i < cantidadColumnas; i++) {
                        fila[i] = rs.getObject(i + 1);
                    }

                    modelo.addRow(fila);
                }
            }

        } catch (SQLException ex) {
            System.out.println("Error al consultar datos: " + ex.getMessage());
        }
    }

    public DefaultTableModel obtenerAutos() {
        DefaultTableModel modelo = crearModelo(
                "Identificador", "Año de fabricación", "Modelo");

        cargarFilas(modelo,
                "SELECT identificador, ano_de_fabricacion, modelo FROM auto",
                3);

        return modelo;
    }

    public DefaultTableModel obtenerPilotos() {
        DefaultTableModel modelo = crearModelo(
                "Código", "Nombre", "Nacionalidad", "Fecha de nacimiento");

        cargarFilas(modelo,
                "SELECT codigo, nombre, nacionalidad, fecha_de_nacimiento "
                + "FROM piloto",
                4);

        return modelo;
    }

    public DefaultTableModel obtenerCircuito() {
        DefaultTableModel modelo = crearModelo(
                "Identificador", "Nombre", "País", "Longitud",
                "Cantidad de vueltas");

        cargarFilas(modelo,
                "SELECT identificador, nombre, pais, longitud, "
                + "cantidad_de_vueltas FROM circuito",
                5);

        return modelo;
    }

    public DefaultTableModel obtenerGranPremio() {
        DefaultTableModel modelo = crearModelo(
                "Identificador", "Fecha", "Nombre", "Año");

        cargarFilas(modelo,
                "SELECT identificador, fecha, nombre, ano FROM gran_premio",
                4);

        return modelo;
    }

    public DefaultTableModel obtenerTemporada() {
        DefaultTableModel modelo = crearModelo("Año");

        cargarFilas(modelo,
                "SELECT ano FROM temporada",
                1);

        return modelo;
    }

    public DefaultTableModel obtenerEscuderia() {
        DefaultTableModel modelo = crearModelo(
                "Identificador", "Nombre");

        cargarFilas(modelo,
                "SELECT identificador, nombre FROM escuderia",
                2);

        return modelo;
    }

    public DefaultTableModel obtenerIndumentaria() {
        DefaultTableModel modelo = crearModelo("Nombre");

        cargarFilas(modelo,
                "SELECT nombre FROM indumentaria",
                1);

        return modelo;
    }

    public DefaultTableModel obtenerMotores() {
        DefaultTableModel modelo = crearModelo("Número de chasis");

        cargarFilas(modelo,
                "SELECT numero_de_chasis FROM motores",
                1);

        return modelo;
    }

    public DefaultTableModel obtenerProveedores() {
        DefaultTableModel modelo = crearModelo(
                "Identificador", "Nombre");

        cargarFilas(modelo,
                "SELECT identificador, nombre FROM proveedores",
                2);

        return modelo;
    }

    public DefaultTableModel obtenerResultados() {
        DefaultTableModel modelo = crearModelo(
                "Código piloto",
                "ID auto",
                "ID Gran Premio",
                "Piloto",
                "Auto",
                "Gran Premio",
                "Tiempo en horas",
                "Vueltas",
                "Puntos",
                "Posición"
        );

        String sql = "SELECT "
                + "r.codigo_piloto, "
                + "r.identificador_auto, "
                + "r.identificador_gran_premio, "
                + "p.nombre AS piloto, "
                + "a.modelo AS auto, "
                + "CONCAT(gp.nombre, ' (', gp.ano, ')') AS gran_premio, "
                + "r.tiempo, r.vueltas, r.puntos, r.posicion "
                + "FROM resultado r "
                + "INNER JOIN piloto p ON r.codigo_piloto = p.codigo "
                + "INNER JOIN auto a ON r.identificador_auto = a.identificador "
                + "INNER JOIN gran_premio gp "
                + "ON r.identificador_gran_premio = gp.identificador";

        cargarFilas(modelo, sql, 10);
        return modelo;
    }

    // OPERACIONES CRUD

    private static final class ConfigTabla {

        String nombreTabla;
        String[] claves;
        String[] campos;

        ConfigTabla(String nombreTabla, String[] claves, String[] campos) {
            this.nombreTabla = nombreTabla;
            this.claves = claves;
            this.campos = campos;
        }
    }

    private ConfigTabla obtenerConfiguracion(String tabla) {

        switch (tabla) {

            case "Autos":
                return new ConfigTabla("auto",
                        new String[]{"identificador"},
                        new String[]{"ano_de_fabricacion", "modelo"});

            case "Pilotos":
                return new ConfigTabla("piloto",
                        new String[]{"codigo"},
                        new String[]{"nombre", "nacionalidad",
                            "fecha_de_nacimiento"});

            case "Circuitos":
                return new ConfigTabla("circuito",
                        new String[]{"identificador"},
                        new String[]{"nombre", "pais", "longitud",
                            "cantidad_de_vueltas"});

            case "Grandes Premios":
                return new ConfigTabla("gran_premio",
                        new String[]{"identificador"},
                        new String[]{"fecha", "nombre", "ano"});

            case "Temporada":
                return new ConfigTabla("temporada",
                        new String[]{"ano"},
                        new String[]{});

            case "Escuderias":
                return new ConfigTabla("escuderia",
                        new String[]{"identificador"},
                        new String[]{"nombre"});

            case "Indumentaria":
                return new ConfigTabla("indumentaria",
                        new String[]{"nombre"},
                        new String[]{});

            case "Motores":
                return new ConfigTabla("motores",
                        new String[]{"numero_de_chasis"},
                        new String[]{});

            case "Proveedores":
                return new ConfigTabla("proveedores",
                        new String[]{"identificador"},
                        new String[]{"nombre"});

            case "Resultados":
                return new ConfigTabla("resultado",
                        new String[]{"codigo_piloto",
                            "identificador_auto",
                            "identificador_gran_premio"},
                        new String[]{"tiempo", "vueltas", "puntos", "posicion"});

            default:
                return null;
        }
    }

    // AGREGAR REGISTRO

    public boolean insertarRegistro(String tabla, Object[] valores) {

        ConfigTabla config = obtenerConfiguracion(tabla);

        if (config == null
                || valores.length != config.claves.length + config.campos.length) {
            return false;
        }

        StringBuilder sql = new StringBuilder("INSERT INTO ");
        sql.append(config.nombreTabla).append(" (");

        for (String clave : config.claves) {
            sql.append(clave).append(",");
        }

        for (String campo : config.campos) {
            sql.append(campo).append(",");
        }

        sql.setLength(sql.length() - 1);
        sql.append(") VALUES (");

        int cantidad = valores.length;

        for (int i = 0; i < cantidad; i++) {
            sql.append("?,");
        }

        sql.setLength(sql.length() - 1);
        sql.append(")");

        try (Connection conexion = realizarConexion()) {
            if (conexion == null) {
                return false;
            }

            try (PreparedStatement ps =
                    conexion.prepareStatement(sql.toString())) {

                for (int i = 0; i < valores.length; i++) {
                    ps.setObject(i + 1, valores[i]);
                }

                return ps.executeUpdate() == 1;
            }

        } catch (SQLException ex) {
            System.out.println("Error al insertar: " + ex.getMessage());
            return false;
        }
    }

    // MODIFICAR REGISTRO

    public boolean modificarRegistro(String tabla,
                                     Object[] claves,
                                     Object[] valores) {

        ConfigTabla config = obtenerConfiguracion(tabla);

        if (config == null
                || claves.length != config.claves.length
                || valores.length != config.campos.length
                || valores.length == 0) {
            return false;
        }

        StringBuilder sql = new StringBuilder("UPDATE ");
        sql.append(config.nombreTabla).append(" SET ");

        for (String campo : config.campos) {
            sql.append(campo).append(" = ?,");
        }

        sql.setLength(sql.length() - 1);
        sql.append(" WHERE ");

        for (String clave : config.claves) {
            sql.append(clave).append(" = ? AND ");
        }

        sql.setLength(sql.length() - 5);

        try (Connection conexion = realizarConexion()) {
            if (conexion == null) {
                return false;
            }

            try (PreparedStatement ps =
                    conexion.prepareStatement(sql.toString())) {

                int posicion = 1;

                for (Object valor : valores) {
                    ps.setObject(posicion++, valor);
                }

                for (Object clave : claves) {
                    ps.setObject(posicion++, clave);
                }

                return ps.executeUpdate() == 1;
            }

        } catch (SQLException ex) {
            System.out.println("Error al modificar: " + ex.getMessage());
            return false;
        }
    }

    // ELIMINAR REGISTRO

    public boolean eliminarRegistro(String tabla, Object[] claves) {

        ConfigTabla config = obtenerConfiguracion(tabla);

        if (config == null || claves.length != config.claves.length) {
            return false;
        }

        StringBuilder sql = new StringBuilder("DELETE FROM ");
        sql.append(config.nombreTabla).append(" WHERE ");

        for (String clave : config.claves) {
            sql.append(clave).append(" = ? AND ");
        }

        sql.setLength(sql.length() - 5);

        try (Connection conexion = realizarConexion()) {
            if (conexion == null) {
                return false;
            }

            try (PreparedStatement ps =
                    conexion.prepareStatement(sql.toString())) {

                for (int i = 0; i < claves.length; i++) {
                    ps.setObject(i + 1, claves[i]);
                }

                return ps.executeUpdate() == 1;
            }

        } catch (SQLException ex) {
            System.out.println("Error al eliminar: " + ex.getMessage());
            return false;
        }
    }
}
