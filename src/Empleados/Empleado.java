package Empleados;

public class Empleado{
	
	public enum TipoEmpleado{Vendedor, Encargado};

	private float calculaNominaBruta(TipoEmpleado tipo, float ventasMes, float horasExtra) {
		
		float salariobase=0, prima=0, extras=0;
		
		
		if (tipo == TipoEmpleado.Vendedor ) {
			int salario  = 2000;
		}else if (tipo == TipoEmpleado.Encargado) {
			int salario  = 2500; 
		}
		
		if(ventasMes >= 1500) {
			prima=200;
		}else if(ventasMes >= 1000) {
			prima=100;
		}
		
		extras=horasExtra*30;
		
		return salariobase+prima+extras;
	}
	
	private float calculoNominaNeta(float nominaBruta) {
		float retencion =0;
		
		if (nominaBruta > 2500){
			retencion = (float) 0.18;
			return nominaBruta*(1-retencion);
			
		}else if(nominaBruta > 2100 && nominaBruta < 2500) {
			retencion = (float) 0.15;
			return nominaBruta*(1-retencion);
		}
		
		return nominaBruta;
	}
	
	
}
