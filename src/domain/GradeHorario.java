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
	 * Verifica se j� existe aula neste hor�rio. Faz isso verificando se a posi��o da matriz <code>gradeHoraria</code> � null
	 * @param horario
	 * @return true se j� tiver aula alocada neste hor�rio
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
