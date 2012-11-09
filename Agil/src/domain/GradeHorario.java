package domain;

public class GradeHorario {

	private HorarioAula[][] gradeHoraria = new HorarioAula[DiaDaSemana.values().length][HorarioNoDia
			.values().length];
	
	public GradeHorario() {
	}

	public HorarioAula[][] getGradeHoraria() {
		return gradeHoraria;
	}

	/**
	 * Verifica se já existe aula neste horário. Faz isso verificando se a posição da matriz <code>gradeHoraria</code> é null
	 * @param horario
	 * @return true se já tiver aula alocada neste horário
	 */
	public boolean temAulaNesteHorario(Horario horario) {
		return gradeHoraria[horario.getDiaDaSemana().ordinal()][horario.getHorarioNoDia().ordinal()] != null;
	}

	public void alocaHorarioParaDisciplina(Horario horario,
			Disciplina disciplina, Professor professor) {
		
		gradeHoraria[horario.getDiaDaSemana().ordinal()][horario.getHorarioNoDia().ordinal()]=
				new HorarioAula(disciplina, professor, horario);
	}
		
}
