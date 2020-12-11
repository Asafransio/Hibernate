package es.studium;

import java.util.Scanner;

public class Main {



	
	public static void main(String[] args) {

		int eleccion = 0;
	
		Scanner teclado = new Scanner(System.in);
		Scanner teclado2 = new Scanner(System.in);
		Clientes c;
		
		while (eleccion != 5) {
			System.out.println("\n Operaciones CRUD:");
			System.out.println();
			System.out.println("1. Crear Cliente");
			System.out.println("2. Mostrar listado de Clientes");
			System.out.println("3. Actualizar Cliente");
			System.out.println("4. Borrar Cliente");
			System.out.println("5. Salir");
			System.out.println("Escriba la operación CRUD que desea realizar: \n ");
			eleccion = teclado.nextInt();
			
			if (eleccion==1) {

				System.out.println("\n Ha elegido crear un cliente \n");
				c = new Clientes();
				
				System.out.println("Indique el nombre del cliente");
				c.setNombre(teclado2.nextLine());
				
				System.out.println("Indique los apellidos del cliente");
				c.setApellidos(teclado2.nextLine());
				
				System.out.println("Indique el e-mail del cliente");
				c.setEmail(teclado2.nextLine());
				
				System.out.println("Indique el DNI del cliente");
				c.setDni(teclado2.nextLine());
				
				System.out.println("Indique la clave del cliente");
				c.setClave(teclado2.nextLine());
				
				HotelManager.create(c);
			}
			
			else if (eleccion==2) {
				System.out.println("\n Ha elegido mostrar un listado de los clientes \n");
				
				HotelManager.read();
			}
			
			else if (eleccion==3) {
				
				System.out.println("\n Ha elegido modificar un cliente");
				System.out.println();
				c = new Clientes();
				
				System.out.println("Indique el id del cliente que desea modificar:");
				System.out.println();
				c.setIdCliente(teclado.nextInt());
				
				System.out.println("Indique su nuevo nombre");
				c.setNombre(teclado2.nextLine());
				
				System.out.println("Indique su nuevo apellido");
				c.setApellidos(teclado2.nextLine());
				
				System.out.println("Indique su nuevo email");
				c.setEmail(teclado2.nextLine());
				
				System.out.println("Indique su nuevo DNI");
				c.setDni(teclado2.nextLine());
				
				System.out.println("Indique su nueva clave");
				c.setClave(teclado2.nextLine());
				
				HotelManager.update(c);
			}
			
			else if (eleccion==4) {
				c = new Clientes();
				System.out.println("\n Ha elegido borrar un cliente \n");
				System.out.println("Indique el id del cliente que desea borrar");
				c.setIdCliente(teclado.nextInt());
				HotelManager.delete(c);
				
			}
			else if (eleccion==5) {
				System.out.println("\n Cerrando base de datos \n");
			}
			
			else {
				System.out.println("\n Elija una opción válida \n");
			}
		}
		teclado2.close();
		teclado.close();
	}

}
