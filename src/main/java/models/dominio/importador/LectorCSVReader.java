package models.dominio.importador;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import models.dominio.entidades.EntidadPrestadora;
import models.dominio.entidades.OrganismoDeControl;
import models.dominio.excepciones.cargaIncorrectaException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LectorCSVReader implements Lector {
    private String filePath = new File("").getAbsolutePath();
    @Override
    public List<EntidadPrestadora> cargarEntidadesPrestadoras(String rutaArchivo) {
        return leerDesdeCSV(rutaArchivo, this::crearEntidadPrestadora);
    }

    @Override
    public List<OrganismoDeControl> cargarOrganismosDeControl(String rutaArchivo) {
        return leerDesdeCSV(rutaArchivo, this::crearOrganismoControl);
    }

    private <T> List<T> leerDesdeCSV(String rutaArchivo, Function<String[], T> mapper) {
        try (CSVReader reader = new CSVReader(new FileReader(/*filePath +*/ rutaArchivo))) {
            return reader.readAll().stream()
                        .map(mapper)
                        .collect(Collectors.toList());
        } catch (IOException | CsvException e) {
            throw new cargaIncorrectaException("Hubo un error al cargar los datos");
        }
    }

    private EntidadPrestadora crearEntidadPrestadora(String[] datos) {
        String nombre = datos[0];
        EntidadPrestadora entidadPrestadora = new EntidadPrestadora();
        entidadPrestadora.setNombre(nombre);
        return entidadPrestadora;
    }

    private OrganismoDeControl crearOrganismoControl(String[] datos) {
        String nombre = datos[0];
        OrganismoDeControl organismoDeControl = new OrganismoDeControl();
        organismoDeControl.setNombre(nombre);
        return organismoDeControl;
    }
}

