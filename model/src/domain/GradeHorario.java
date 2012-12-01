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
	 * Verifica se ja existe aula neste horario. Faz isso verificando se a posicao da matriz <code>gradeHoraria</code> e null
	 * @param horario
	 * @return true se ja tiver aula alocada neste horario
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
