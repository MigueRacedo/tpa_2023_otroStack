package models.dominio.importador;

import models.dominio.entidades.EntidadPrestadora;
import models.dominio.entidades.OrganismoDeControl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LectorCSV implements Lector{
        private String line;
        private String csvDelimiter = ";";
        private BufferedReader br;
        private String filePath = new File("").getAbsolutePath();

        public List<EntidadPrestadora> cargarEntidadesPrestadoras(String ruta){
            List<EntidadPrestadora> entidades = new ArrayList<>();
            try{
                br = new BufferedReader(new FileReader(filePath + ruta));
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(csvDelimiter);
                    String nombre = data[0];
                    EntidadPrestadora entidad = new EntidadPrestadora();
                    entidad.setNombre(nombre);
                    entidades.add(entidad);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return entidades;
        }

        public List<OrganismoDeControl> cargarOrganismosDeControl(String ruta){
            List<OrganismoDeControl> organismos = new ArrayList<>();
            try{
              br = new BufferedReader(new FileReader(filePath + ruta));
              while ((line = br.readLine()) != null) {
                  String[] data = line.split(csvDelimiter);
                  String nombre = data[0];
                  OrganismoDeControl organismo = new OrganismoDeControl();
                  organismo.setNombre(nombre);
                  organismos.add(organismo);
              }
          } catch (IOException e) {
            e.printStackTrace();
          }
          return organismos;
        }




}
