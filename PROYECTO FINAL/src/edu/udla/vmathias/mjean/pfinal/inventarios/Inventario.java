package edu.udla.vmathias.mjean.pfinal.inventarios;

import java.io.*;
import java.util.Scanner;

public class Inventario{
    //escribir las propiedades
    Scanner scanner = new Scanner(System.in);
    private String nom_producto;
    private String cod_producto;
    private String valor_producto;
    private String cant_producto;
    private String distr_producto;
    private int nproductos;
    //asignar el constructor
    public Inventario() {
    }
    //asignar los getters y setters
    public String getNom_producto() {
        return nom_producto;
    }

    public void setNom_producto(String nom_producto) {
        this.nom_producto = nom_producto;
    }

    public String getCod_producto() {
        return cod_producto;
    }

    public void setCod_producto(String cod_producto) {
        this.cod_producto = cod_producto;
    }

    public String getValor_producto() {
        return valor_producto;
    }

    public void setValor_producto(String valor_producto) {
        this.valor_producto = valor_producto;
    }

    public String getCant_producto() {
        return cant_producto;
    }

    public void setCant_producto(String cant_producto) {
        this.cant_producto = cant_producto;
    }

    public String getDistr_producto() {
        return distr_producto;
    }

    public void setDistr_producto(String distr_producto) {
        this.distr_producto = distr_producto;
    }

    public int getNproductos() {
        return nproductos;
    }
    public void setNproductos(int nproductos) {
        this.nproductos = nproductos;
    }
    public void addProduct(String nombre){
        File archivo = new File(nombre);

        try { //try - catch para evitar errores
            BufferedWriter buffer = new BufferedWriter(new FileWriter(archivo,true));
            for (int i = 1; i <= this.nproductos ; i++){
                //Escribir en el archivo los datos proporcionados por el usuario
                System.out.println("Escriba el codigo del producto: ");
                buffer.append(this.cod_producto = scanner.nextLine() + " ");
                System.out.println("Escriba el nombre del producto: ");
                buffer.append(this.nom_producto = scanner.nextLine() + " ");
                System.out.println("Escriba el valor del producto: ");
                buffer.append(this.valor_producto = scanner.nextLine() + " ");
                System.out.println("Escriba la cantidad del producto: ");
                buffer.append(this.cant_producto = scanner.nextLine() + " ");
                System.out.println("Escriba el distribuidor del producto: ");
                buffer.append(this.distr_producto = scanner.nextLine() + "\n");
            }
            buffer.close(); //cerrar el buffer fuera del bucle, sino tenemos que volverlo a abrir en algún punto
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //Metodo para leer el archivo
    public String leerArchivo(String nombre){
        StringBuilder sB = new StringBuilder();
        File archivo = new File(nombre);

        try {
            BufferedReader reader = new BufferedReader(new FileReader(archivo));
            String linea;
            while((linea = reader.readLine()) != null){
                sB.append(linea).append("\n");
            }
        }catch (FileNotFoundException e) {
            throw new RuntimeException(e); //Si no encuentra el archivo, no se crea correctamente
        }catch (IOException e) {
            throw new RuntimeException(e); //Si ocurre algún fallo en general
        }
        return sB.toString();
    }
}

