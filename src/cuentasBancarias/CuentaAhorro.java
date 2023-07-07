package cuentasBancarias;

public class CuentaAhorro extends CuentaBancaria {
	private String tipo = "CuentaAhorro";
	private double saldoSecundario;
	public CuentaAhorro(double monto, String nombre) {
		super(monto, nombre);
		registro.crearRegistro(this.tipo,nombre);
		ingresarDinero(monto,"Primer Deposito: ");
		setSaldoSecundario(0);
	}
	private void agregarASaldoSecundario(double monto) {
		if(condicionDeRetiro(monto)) {
			retirarDinero(monto, "Se transfirio $" +monto+" al saldo secundario");
			saldoSecundario = getSaldoSecundario() + monto;
		}
	}
	private void retirarDeSaldoSecundarioASaldo(double monto) {
		if(getSaldoSecundario() > monto) {
			ingresarDinero(monto, "Se transfirio $"+monto+" desde el saldo secundario");
			saldoSecundario = getSaldoSecundario() - monto;
		}
	}
	// ------------------ Getters y Setters ---------------//

	public double getSaldoSecundario() {
		return saldoSecundario;
	}
	private void setSaldoSecundario(double saldoSecundario) {
		this.saldoSecundario = saldoSecundario;
	}
}
