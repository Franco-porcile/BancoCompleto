package manejoDeArchivos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ManagerDeArchivos {
	public ManagerDeArchivos() {
		
	}
	
	public void crearRegistro(String tipo,String nombre) {
		String rutaArchivo = "sistemaDeBancos/registroDeTransacciones/transaccionesDeUsuarios/";
		try {
			FileWriter archivo = new FileWriter(rutaArchivo + nombre + tipo +".txt");
			archivo.close();
		}catch(IOException e) {
			System.out.println("Ocurrio un error al crear el archivo " + e.getMessage());
		}
	}

	public void registrarMovimientoDeDinero(double monto, String mensaje,String tipo,String nombre,double saldo) {
		String rutaArchivo = "sistemaDeBancos/registroDeTransacciones/transaccionesDeUsuarios/";
	
		try {
			PrintWriter registrarMovimiento = new PrintWriter(new FileWriter(rutaArchivo+nombre+tipo+".txt",true));
			
			registrarMovimiento.println("Operacion: " + monto);
			registrarMovimiento.println("Saldo actualizado: "+ saldo + " " + mensaje);
			registrarMovimiento.close();
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("Ocurrio un error al abrir el archivo " + e.getMessage());
		}
	}
	
	protected void mostrarInfoDeLaCuenta() {
	//	System.out.println("Saldo Actual: " + getSaldo());
	}
}
