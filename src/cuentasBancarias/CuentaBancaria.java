package cuentasBancarias;
import manejoDeArchivos.*;

public class CuentaBancaria {

	private double saldo = 0;
	private String nombre;
	private String tipo="CuentaBancaria";
	ManagerDeArchivos registro = new ManagerDeArchivos();
	public CuentaBancaria(double saldo, String nombre) {
		setNombre(nombre);
		registro.crearRegistro(this.tipo,nombre);
		ingresarDinero(saldo,"Primer Deposito: ");
	}

	protected void ingresarDinero(double monto, String mensaje) {
		this.saldo = getSaldo() + monto;
		registro.registrarMovimientoDeDinero(monto,"Dinero agregado con motivos de: " + mensaje,tipo,getNombre(),getSaldo());
	}

	protected void retirarDinero(double monto, String mensaje) {
		if (condicionDeRetiro(monto)) {
			this.saldo = getSaldo() - monto;
			registro.registrarMovimientoDeDinero( - monto, "Retiro de dinero para: " + mensaje,tipo,getNombre(),getSaldo());
		} else
			System.out.println("Saldo insuficiente");
	}


	protected boolean condicionDeRetiro(double monto) {
		if (getSaldo() > monto) {
			return true;
		} else
			return false;
	}
	// ------------------ Getters y Setters ---------------//

	protected double getSaldo() {
		return saldo;
	}

	protected void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	protected String getNombre() {
		return nombre;
	}

	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
