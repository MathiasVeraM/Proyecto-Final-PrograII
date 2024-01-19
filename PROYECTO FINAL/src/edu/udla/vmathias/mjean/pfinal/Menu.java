package edu.udla.vmathias.mjean.pfinal;

import edu.udla.vmathias.mjean.pfinal.inventarios.Finanzas;
import edu.udla.vmathias.mjean.pfinal.inventarios.Inventario;

import java.util.Objects;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        String nombreArchivo = "C:\\Users\\USUARIO\\Desktop\\Datos\\java.txt";
        Scanner scanner = new Scanner(System.in); //definir el scanner para realizar procesos de ingreso de datos
        Personal persona1 = new Personal();//instancia la clase personal
        Inventario inventario = new Inventario();//instancia la clase inventario
        Finanzas finanzas = new Finanzas();//instancia la clase finanzas
        int opcion = 0; //para el menú
        String user = "admin"; //user y password para admin
        String pass = "admin";
        System.out.println("Por favor ingrese el user y password para acceder como admin: ");
        System.out.print("User: "); persona1.setUsuario(scanner.next());
        System.out.print("Password: "); persona1.setContra(scanner.next());
        if(Objects.equals(persona1.getUsuario(), user) && Objects.equals(persona1.getContra(), pass)){
            System.out.println("---------------Bienvenido " + persona1.getUsuario() + "!--------------");
            do{
                System.out.print("Seleccione una opcion para continuar: ");
                System.out.print("\n1.Registrar producto\n2.Ver inventario\n3.Calcular presupuesto\n4.Salir\n");
                opcion = scanner.nextInt();
                switch(opcion){
                    case 1:
                        System.out.println("---------------¿Cuantos productos desea agregar al inventario?---------------");
                        inventario.setNproductos(scanner.nextInt()); //invoca el metodo setNproductos
                        inventario.addProduct(nombreArchivo); //invoca el metodo addProduct
                        break;
                    case 2:
                        System.out.println("-----------------El inventario actual es el siguiente:----------------");
                        System.out.println(inventario.leerArchivo(nombreArchivo)); //imprime en la consola el inventario, invoca metodo leerArchivo
                        break;
                    case 3:
                        //case para calcular el presupuesto para la proxima semana
                        System.out.println("---------------Ingrese los datos para ver el presupuesto:--------------");
                        System.out.println("Las ganancias de la semana: ");
                        finanzas.setGanancias(scanner.nextFloat());
                        System.out.println("Las perdidas de la semana: ");
                        finanzas.setPerdidas(scanner.nextFloat());
                        System.out.println("La cantidad de articulos a reponer: ");
                        finanzas.setCant_rep(scanner.nextInt());
                        finanzas.calculoValrep(finanzas.getCant_rep());
                        System.out.print("El presupuesto para esta semana es de: ");
                        System.out.println(finanzas.presupuesto(finanzas.getGanancias(), finanzas.getPerdidas(), finanzas.getCosto_rep()));
                        break;
                    case 4:
                        System.out.println("Ha salido exitosamente del programa, tenga un buen dia " + persona1.getUsuario() + " :)");
                        break;
                    default:
                        break;
                }
            }while(opcion!=4);
        }

    }
}
