package edu.udla.vmathias.mjean.pfinal;

import edu.udla.vmathias.mjean.pfinal.inventarios.Finanzas;
import edu.udla.vmathias.mjean.pfinal.inventarios.Inventario;

import java.util.Objects;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        String nombreArchivo = "C:\\Users\\USUARIO\\Desktop\\Datos\\java.txt";
        Scanner scanner = new Scanner(System.in);
        Personal persona1 = new Personal();
        Inventario inventario = new Inventario();
        Finanzas finanzas = new Finanzas();
        int opcion = 0;
        String user = "admin";
        String pass = "admin";
        System.out.println("Por favor ingrese el usuario y contrasena para acceder");
        persona1.setUsuario(scanner.next());
        persona1.setContra(scanner.next());
        if(Objects.equals(persona1.getUsuario(), user) && Objects.equals(persona1.getContra(), pass)){
            System.out.println("---------------Bienvenido!--------------");
            do{
                System.out.print("Seleccione una opcion para continuar: ");
                System.out.print("\n1.Registrar producto\n2.Ver inventario\n3.Calcular presupuesto\n4.Salir\n");
                opcion = scanner.nextInt();
                switch(opcion){
                    case 1:
                        System.out.println("¿Cuantos productos desea agregar al inventario? :");
                        inventario.setNproductos(scanner.nextInt());
                        inventario.addProduct(nombreArchivo);
                        break;
                    case 2:
                        System.out.println("-----------------El inventario actual es el siguiente:----------------");
                        System.out.println(inventario.leerArchivo(nombreArchivo));
                        break;
                    case 3:
                        System.out.println("---------------Ingrese los datos para ver el presupuesto:--------------");
                        System.out.println("Las ganancias de la semana: ");
                        finanzas.setGanancias(scanner.nextFloat());
                        System.out.println("Las perdidas de la semana: ");
                        finanzas.setPerdidas(scanner.nextFloat());
                        System.out.println("La cantidad de articulos a reponer: ");
                        finanzas.setCant_rep(scanner.nextInt());
                        finanzas.calculoValrep(finanzas.getCant_rep());
                        System.out.println("El presupuesto para esta semana es de: ");
                        finanzas.presupuesto(finanzas.getGanancias(), finanzas.getPerdidas(), finanzas.getCosto_rep());
                        break;
                    case 4:
                        System.out.println("Ha salido exitosamente del programa, tenga un buen dia");
                        break;
                }
            }while(opcion!=4);
        }

    }
}
