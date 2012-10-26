package teste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import domain.Curso;
import domain.Disciplina;
import domain.Fase;
import domain.Horario;
import domain.Professor;

public class QlqrCoisaTest {

	@Test
	public void testeUmCursoNovoTemZeroFases() {
		Curso curso = new Curso();
		assertEquals(0, curso.getFases().size());
		//		fail("Not yet implemented");
	}

	@Test
	public void testeEpossivelAdicionarUmaFaseNumCurso(){
		Curso curso = new Curso();
		Fase fase = new Fase();
		curso.addFase(fase);

		assertEquals(1, curso.getFases().size());
	}

	@Test
	public void testeUmaFaseTemDisciplinas(){
		Fase fase = new Fase();

		assertEquals(0,fase.getDisciplinas().size());

		Disciplina disc = new Disciplina();
		fase.addDisciplinas(disc);

		assertEquals(1, fase.getDisciplinas().size());

	}

	@Test
	public void testeUmProfessorNoCurso(){
		Curso curso = new Curso();

		assertEquals(0,curso.getProfessores().size());

		Professor professor = new Professor();
		curso.addProfessor(professor);

		assertEquals(1, curso.getProfessores().size());

	}
	
	@Test
	public void testeDisciplinaHorarios(){
		Disciplina disciplina = new Disciplina();
		
		assertEquals(0, disciplina.getHorarios().size());
		
		Horario horario = new Horario();
		disciplina.addHorario(horario);
		
		assertEquals(1, disciplina.getHorarios().size());
	}
	
	@Test
	public void testeProfessorTemHorariosDisponiveis(){
		Professor professor = new Professor();
		
		Horario horario = new Horario();
		
		professor.addHorario(horario);
		
		assertEquals(1, professor.getHorarios().size());
		assertEquals(1, professor.getHorariosDisponiveis().size());
		
		professor.alocaHorario(horario);
		
		assertEquals(0, professor.getHorariosDisponiveis().size());
	}

}
