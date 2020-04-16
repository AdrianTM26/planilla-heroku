package com.mitocode.util;

import com.mitocode.dto.WordData;

public class WordConstante {
	
	public WordData titulo() {
		WordData titulo = new WordData();
		titulo.setText1("MODELO DE CONTRATO DE TRABAJO SUJETO A MODALIDAD POR INICIO O INCREMENTO DE ACTIVIDAD");
		return titulo;
	}
	
	public WordData parrafoA() {
		WordData parrafo = new WordData();
		parrafo.setText1("Conste por el presente documento el ");
		parrafo.setText2("“CONTRATO DE TRABAJO SUJETO A MODALIDAD POR (1) $iniAct$.” ");
		parrafo.setText3("que celebran al amparo del Art. 57º de la Ley de Productividad y Competitividad Laboral"
				+ " aprobado por D. S. Nº 003-97-TR y normas complementarias, de una parte (2) $nomEmp$, "
				+ "con RUC. Nº $rucEmp$ con domicilio real en $direcEmp$, debidamente representada por "
				+ "el señor (3) $nomReprEmp$ con DNI. Nº $dniReprEmp$, según poder inscrito en la partida registral Nº $numPartReg$ del"
				+ " Registro de Personas Jurídicas de $regPersJur$, a quien en adelante se le denominará ");
		parrafo.setText4("EL EMPLEADOR");
		parrafo.setText5("; y de la otra parte don (4) $nomTrab$; con DNI. Nº $dniTrab$., domiciliado en $direTrab$ a quien en adelante se le denominará ");
		parrafo.setText6("EL TRABAJADOR");
		parrafo.setText7("; en los términos y condiciones siguientes:");
		return parrafo;
	}
	
	public WordData parrafoB() {
		WordData parrafo = new WordData();
		parrafo.setText1("PRIMERO: EL EMPLEADOR ");
		parrafo.setText2("es una empresa dedicada a (5) $objSocEmp$ la cual requiere cubrir de manera temporal las "
				+ "necesidades de recursos humanos originados (6) ");
		parrafo.setText3("$motivCont$");
		return parrafo;
	}
	
	public WordData parrafoC() {
		WordData parrafo = new WordData();
		parrafo.setText1("SEGUNDO: ");
		parrafo.setText2("Por el presente documento ");
		parrafo.setText3("EL EMPLEADOR ");
		parrafo.setText4("contrata de manera TEMPORAL bajo la modalidad de (7) $modalidad$, los servicios de ");
		parrafo.setText5("EL TRABAJADOR ");
		parrafo.setText6("quien desempeñará el cargo de (8) $cargTrab$, en relación con las causas objetivas "
				+ "señaladas en la cláusula anterior.");
		return parrafo;
	}
	
	public WordData parrafoD() {
		WordData parrafo = new WordData();
		parrafo.setText1("TERCERO: ");
		parrafo.setText2("El plazo de duración del presente contrato es de $durAnoCont$ (Máximo tres años), "
				+ "y rige desde el $diaIniCont$ de $mesIniCont$ del $anoIniCont$, fecha en que debe empezar sus labores ");
		parrafo.setText3("EL TRABAJADOR ");
		parrafo.setText4("hasta el $diaFinCont$ de $mesFinCont$ del $anoFinCont$, fecha en que termina el contrato.");
		return parrafo;
	}
	
	public WordData parrafoE() {
		WordData parrafo = new WordData();
		parrafo.setText1("CUARTO: EL TRABAJADOR ");
		parrafo.setText2("estará sujeto a un período de prueba de tres meses, la misma que inicia el $diaIniPerPru$ "
				+ "de $mesIniPerPru$ del $anoIniPerPru$ y concluye el $diaFinPerPru$ de $mesFinPerPru$ del $anoFinPerPru$.");
		parrafo.setText3("Queda entendido que durante este período de prueba ");
		parrafo.setText4("EL EMPLEADOR ");
		parrafo.setText5("puede resolver el contrato sin expresión de causa.");
		return parrafo;
	}
	
	public WordData parrafoF() {
		WordData parrafo = new WordData();
		parrafo.setText1("QUINTO: EL TRABAJADOR ");
		parrafo.setText2("cumplirá el horario de trabajo siguiente: De $diaLabIni$ a $diaLabFin$ de $horLabIni$ horas a $horLabFin$ horas.");
		return parrafo;
	}
	
	public WordData parrafoG() {
		WordData parrafo = new WordData();
		parrafo.setText1("SEXTO: EL TRABAJADOR ");
		parrafo.setText2("deberá cumplir con las normas propias del Centro de Trabajo, así como las contenidas"
				+ " en el Reglamento interno de Trabajo y en las demás normas laborales, y las que se impartan "
				+ "por necesidades del servicio en ejercicio de las facultades de administración de la empresa, de"
				+ " conformidad con el Art. 9º de la Ley de Productividad y Competitividad Laboral aprobado por D. S. Nº 003-97-TR.");
		return parrafo;
	}
	
	public WordData parrafoH() {
		WordData parrafo = new WordData();
		parrafo.setText1("SETIMO: EL EMPLEADOR ");
		parrafo.setText2("abonará a ");
		parrafo.setText3("EL TRABAJADOR ");
		parrafo.setText4("la cantidad de S/.$remMens$ como remuneración mensual, de la cual se deducirá las aportaciones y "
				+ "descuentos por tributos establecidos en la ley que le resulten de aplicación.");
		return parrafo;
	}
	
	public WordData parrafoI() {
		WordData parrafo = new WordData();
		parrafo.setText1("OCTAVO: EL EMPLEADOR");
		parrafo.setText2(", se obliga a inscribir a ");
		parrafo.setText3("EL TRABAJADOR ");
		parrafo.setText4("en el Libro de Planillas de Remuneraciones, así como poner en conocimiento de la Autoridad"
				+ " Administrativa de Trabajo el presente contrato, para su conocimiento y registro, en cumplimiento"
				+ " de lo dispuesto por el artículo 73º del Texto Único Ordenado del Decreto Legislativo 728, "
				+ "Ley de Productividad y Competitividad Laboral, aprobado mediante Decreto Supremo Nº 003-97-TR.");
		return parrafo;
	}
	
	public WordData parrafoJ() {
		WordData parrafo = new WordData();
		parrafo.setText1("NOVENO: ");
		parrafo.setText2("Queda entendido que ");
		parrafo.setText3("EL EMPLEADOR ");
		parrafo.setText4("no está obligado a dar aviso alguno adicional referente al término del presente contrato,"
				+ " operando su extinción en la fecha de su vencimiento conforme la cláusula tercera, "
				+ "oportunidad en la cual se abonara al TRABAJADOR los beneficios sociales que le pudieran corresponder de acuerdo a ley.");
		return parrafo;
	}
	
	public WordData parrafoK() {
		WordData parrafo = new WordData();
		parrafo.setText1("DÉCIMO: ");
		parrafo.setText2("Este contrato queda sujeto a las disposiciones que contiene el TUO del D. Leg. Nº 728 "
				+ "aprobado por D. S. Nº 003-97-TR Ley de Productividad y Competitividad Laboral, y demás normas legales "
				+ "que lo regulen o que sean dictadas durante la vigencia del contrato.");
		return parrafo;
	}
	
	public WordData parrafoL() {
		WordData parrafo = new WordData();
		parrafo.setText1("Como muestra de conformidad con todas las cláusulas del presente contrato firman las partes, "
				+ "por triplicado al día $diaFirma$ del mes de $mesFirma$ del año $anoFirma$");
		return parrafo;
	}
	
	public WordData parrafoM() {
		WordData parrafo = new WordData();
		parrafo.setText1("--------------------------");
		parrafo.setText2("EL EMPLEADOR");
		parrafo.setText3("--------------------------");
		parrafo.setText4("EL TRABAJADOR");
		return parrafo;
	}
}
