package frgp.utn.edu.ar.TPINT_GRUPO_11_LAB5;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import frgp.utn.edu.ar.negocioImpl.EspecialidadNegocio;
import frgp.utn.edu.ar.negocioImpl.MedicoNegocio;
import frgp.utn.edu.ar.negocioImpl.TurnoNegocio;
import frgp.utn.edu.ar.resources.Config;

public class App3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);
		TurnoNegocio turnoNegocio = (TurnoNegocio) appContext.getBean("TurnoNegocioBean");
		EspecialidadNegocio especialidadNegocio = (EspecialidadNegocio) appContext.getBean("EspecialidadNegocioBean");
		MedicoNegocio medicoNegocio = (MedicoNegocio) appContext.getBean("MedicoNegocioBean");
		// Probando HQL Consultas

		System.out.println("turnos especialidad fechas: " + turnoNegocio.contarTurnosEspecialidadEntreFechas(
				especialidadNegocio.readOne(1), LocalDate.of(2020, 1, 1), LocalDate.of(2025, 1, 1)));

		System.out.println(LocalDate.now().getYear());
		System.out.println(LocalDate.now().getMonth());
		System.out.println(LocalDate.now().getMonthValue());
		System.out.println(LocalDate.now().getDayOfMonth());

		System.out.println("MEDICO: " + medicoNegocio.readOne(1l).toString());

		System.out.println("class ESTADO TURNO: "
				+ medicoNegocio.readOne(1l).getTurnos().get(0).getEstadoTurno().Pendiente.getClass());
		System.out.println("estado TURNO: " + medicoNegocio.readOne(1l).getTurnos().get(0).getEstadoTurno());
		System.out.println("fecha TURNO: " + medicoNegocio.readOne(1l).getTurnos().get(0).getFecha());
		System.out.println("fecha TURNO: " + medicoNegocio.readOne(2l).getTurnos().get(0).getFecha());

		// Fecha actual
		LocalDate hoy = LocalDate.now();
		System.out.println(hoy);

		// Último día del mes
		LocalDate ultimoDia = hoy.with(TemporalAdjusters.lastDayOfMonth());
		System.out.println(ultimoDia);

		// Fecha actual
		hoy = LocalDate.now();

		// Primer día del mes siguiente
		LocalDate primerDiaSiguienteMes = hoy.minusMonths(1L).with(TemporalAdjusters.firstDayOfNextMonth());
		System.out.println(primerDiaSiguienteMes);

		System.out.println("turnos especialidad fechas: "
				+ turnoNegocio.contarTurnosMedicoFechaEstado(medicoNegocio.readOne(1l), primerDiaSiguienteMes,
						ultimoDia, medicoNegocio.readOne(1l).getTurnos().get(0).getEstadoTurno()));
		System.out.println("turnos especialidad fechas: "
				+ turnoNegocio.contarTurnosMedicoFechaEstado(medicoNegocio.readOne(2l), primerDiaSiguienteMes,
						ultimoDia, medicoNegocio.readOne(2l).getTurnos().get(0).getEstadoTurno()));

	}

}
