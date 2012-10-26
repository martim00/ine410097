package domain;

public class GradeHorario {

	private HorarioAula[][] gradeHoraria = new HorarioAula[DiaDaSemana.values().length][HorarioNoDia
			.values().length];

	public HorarioAula[][] getGradeHoraria() {
		return gradeHoraria;
	}
		
}
