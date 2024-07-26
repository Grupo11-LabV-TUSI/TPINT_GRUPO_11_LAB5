package frgp.utn.edu.ar.enums;

public enum EEstadoTurno {
	Pendiente,
	Presente,
	Ausente;
	
	public static EEstadoTurno getByIndex(int index) {
		return EEstadoTurno.values()[index];
	}
}
