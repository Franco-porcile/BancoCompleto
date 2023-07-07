package cuentasBancarias;

public class CuentaCorriente extends CuentaBancaria{
	private String tipo = "CuentaCorriente";
	private double descubierto;
	private double deudaAcumulada;
	public CuentaCorriente(double saldo, String nombre,double descubierto) {
		super(saldo, nombre);
		this.descubierto =descubierto;
		this.deudaAcumulada = 0;
		registro.crearRegistro(this.tipo,nombre);
		ingresarDinero(saldo,"Primer Deposito: ");
		// TODO Auto-generated constructor stub
	}
	@Override
	protected boolean condicionDeRetiro(double monto) {
		if(monto < (getSaldo() + getSaldo()*(descubierto/100))) {
			if((getSaldo()-monto) < 0 )
				deudaAcumulada += (monto - getSaldo());
			return true;
		}
		else 
			return false;
	}
	public void pagarDeudaAcumulada(double monto) {
		if(monto <= getSaldo() && monto == deudaAcumulada)
			retirarDinero(monto, "Se retiro $"+monto+" para pagar el descubierto de la cuenta corriente");
	}
	public void verDeudaAcumulada() {
		System.out.println(this.deudaAcumulada);
	}
}
