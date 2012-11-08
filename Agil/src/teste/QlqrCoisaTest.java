package teste;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import domain.AreaConhecimento;
import domain.Curso;
import domain.DiaDaSemana;
import domain.Disciplina;
import domain.Fase;
import domain.GradeHorario;
import domain.Horario;
import domain.HorarioAula;
import domain.HorarioNoDia;
import domain.Professor;
import domain.ProfessorNaoEncontradoParaDisciplinaException;

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

		Disciplina disc = new Disciplina(new AreaConhecimento("algoritmos"));
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
		Disciplina disciplina = new Disciplina(new AreaConhecimento("algoritmos"));
		
		assertEquals(0, disciplina.getHorarios().size());
		
		Horario horario = new Horario(DiaDaSemana.SEGUNDA_FEIRA, HorarioNoDia.PRIMEIRO_HORARIO);
		disciplina.addHorario(horario);
		
		assertEquals(1, disciplina.getHorarios().size());
	}
	
	@Test
	public void testeProfessorTemHorariosDisponiveis(){
		Professor professor = new Professor();
		
		Horario horario = new Horario(DiaDaSemana.SEGUNDA_FEIRA, HorarioNoDia.PRIMEIRO_HORARIO);
		
		professor.addHorario(horario);
		
		assertEquals(1, professor.getHorarios().size());
		assertEquals(1, professor.getHorariosDisponiveis().size());
		
		professor.alocaHorario(horario);
		
		assertEquals(0, professor.getHorariosDisponiveis().size());
	}
	
	
	@Test()
	public void testeAlocacaoParaUmCursoComUmaDisciplinaEUmProfessor() throws ProfessorNaoEncontradoParaDisciplinaException
	{
		Curso curso = new Curso();
		Professor professor = new Professor();
		
		DiaDaSemana segundaFeira = DiaDaSemana.SEGUNDA_FEIRA;
		HorarioNoDia primeiroHorario = HorarioNoDia.PRIMEIRO_HORARIO;
		
		Horario horario = new Horario(segundaFeira, primeiroHorario);
		professor.addHorario(horario);
		
		curso.addProfessor(professor);
		
		Fase fase = new Fase();
		Disciplina disciplina = new Disciplina(new AreaConhecimento("algoritmos"));
		disciplina.addHorario(horario);
		fase.addDisciplinas(disciplina);
		
		curso.addFase(fase);
		
		List<Fase> gradeCurso = curso.executeAlocacao();
		
		assertEquals(1, gradeCurso.size());
		GradeHorario gradeFase = gradeCurso.get(0).getGradeHorario();
		
		HorarioAula actual = gradeFase.getGradeHoraria()[segundaFeira.ordinal()][primeiroHorario.ordinal()];
		
		assertEquals(professor, actual.getProfessor());
	}
	
	void testProfessorPossueAreasDeAtuacao() {
		
		Professor professor = new Professor();
		AreaConhecimento areaAtuacao = new AreaConhecimento("Banco de dados");
		professor.addAreaDeAtuacao(areaAtuacao);		
		
		assertEquals(true, professor.atuaNaArea(areaAtuacao));
		
	}
	
}
