package frgp.utn.edu.ar.enums;

public enum EDiaHorario {
	Domingo,
    Lunes,
    Martes,
    Miercoles,
    Jueves,
    Viernes,
    Sabado;
	
	public static EDiaHorario getByIndex(int index) {
		return EDiaHorario.values()[index];
	}
}
