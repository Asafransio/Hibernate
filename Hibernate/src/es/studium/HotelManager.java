package es.studium;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HotelManager {
	
	private static SessionFactory getSessionFactory() {
		SessionFactory sF = new Configuration().addAnnotatedClass(Clientes.class).configure().buildSessionFactory();
		return sF;
	}
	
	public static void create(Clientes c) {
		Session sObj = getSessionFactory().openSession();
		Transaction tObj = sObj.beginTransaction();
		sObj.save(c);
		tObj.commit();
		sObj.close();
		System.out.println("Cliente " + c.getNombre() + " añadido correctamente a la base de datos.");
	}
	
	public static List<?> read() {
		String aux = "FROM Clientes";
		Session sObj = getSessionFactory().openSession();
		List<?> resultado = sObj.createQuery(aux).list();
		Iterator<?> iterador = resultado.iterator();
		while (iterador.hasNext()) {
			Clientes c = (Clientes) iterador.next();
			System.out.println(c.getIdCliente() +  " - " + c.getNombre() + " - " + c.getApellidos() + " - " + c.getEmail() + " - " + c.getDni() + " - " + c.getClave());
		}
		sObj.close();
		return resultado;
	}
	
	public static void update( Clientes c) {
		Session sObj = getSessionFactory().openSession();
		Transaction tObj = sObj.beginTransaction();
		Clientes nuevoC = (Clientes) sObj.load(Clientes.class, c.getIdCliente());
		
		nuevoC.setNombre(c.getNombre());
		nuevoC.setApellidos(c.getApellidos());
		nuevoC.setEmail(c.getEmail());
		nuevoC.setDni(c.getDni());
		nuevoC.setClave(c.getClave());
		tObj.commit();
		sObj.close();
		System.out.println("Cliente " + c.getNombre() + " actualizado correctamente.");
	}
	
	public static void delete(Clientes c) {
		Session sObj = getSessionFactory().openSession();
		Transaction tObj = sObj.beginTransaction();
		Clientes baseDatos = (Clientes) sObj.load(Clientes.class, c.getIdCliente());
		sObj.delete(baseDatos);
		tObj.commit();
		sObj.close();
		System.out.println("Cliente " + c.getNombre() + " eliminado correctamente de la base de datos.");
	}

}
