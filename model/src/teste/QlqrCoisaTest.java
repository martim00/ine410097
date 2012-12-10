package teste;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Table;

import org.junit.Test;

import tablelize.Fixture;

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
		// fail("Not yet implemented");
	}

	@Test
	public void testeEpossivelAdicionarUmaFaseNumCurso() {
		Curso curso = new Curso();
		Fase fase = new Fase(1);
		curso.addFase(fase);

		assertEquals(1, curso.getFases().size());
	}

	@Test
	public void testeUmaFaseTemDisciplinas() {
		Fase fase = new Fase(1);

		assertEquals(0, fase.getDisciplinas().size());

		Disciplina disc = new Disciplina(new AreaConhecimento("algoritmos"), "");
		fase.addDisciplina(disc);

		assertEquals(1, fase.getDisciplinas().size());

	}

	@Test
	public void testeUmProfessorNoCurso() {
		Curso curso = new Curso();

		assertEquals(0, curso.getProfessores().size());

		Professor professor = new Professor("");
		curso.addProfessor(professor);

		assertEquals(1, curso.getProfessores().size());

	}

	@Test
	public void testeDisciplinaHorarios() {
		Disciplina disciplina = new Disciplina(new AreaConhecimento(
				"algoritmos"), "");

		assertEquals(0, disciplina.getHorarios().size());

		Horario horario = new Horario(DiaDaSemana.SEGUNDA_FEIRA,
				HorarioNoDia.PRIMEIRO_HORARIO);
		disciplina.addHorario(horario);

		assertEquals(1, disciplina.getHorarios().size());
	}

	@Test
	public void testeProfessorTemHorariosDisponiveis() {
		Professor professor = new Professor("");

		Horario horario = new Horario(DiaDaSemana.SEGUNDA_FEIRA,
				HorarioNoDia.PRIMEIRO_HORARIO);

		professor.addHorario(horario);

		assertEquals(1, professor.getHorarios().size());
		assertEquals(1, professor.getHorariosDisponiveis().size());

		professor.alocaHorario(horario);

		assertEquals(0, professor.getHorariosDisponiveis().size());
	}

	@Test()
	public void testeAlocacaoParaUmCursoComUmaDisciplinaEUmProfessor()
			throws ProfessorNaoEncontradoParaDisciplinaException {
		Curso curso = new Curso();

		DiaDaSemana segundaFeira = DiaDaSemana.SEGUNDA_FEIRA;
		HorarioNoDia primeiroHorario = HorarioNoDia.PRIMEIRO_HORARIO;
		Horario horario = new Horario(segundaFeira, primeiroHorario);

		AreaConhecimento area = new AreaConhecimento("algoritmos");

		Professor professor = new Professor("");
		professor.addHorario(horario);
		professor.addAreaDeAtuacao(area);

		curso.addProfessor(professor);

		Fase fase = new Fase(1);
		Disciplina disciplina = new Disciplina(area, "");
		fase.addDisciplina(disciplina);

		curso.addFase(fase);

		//
		List<Fase> fases = curso.executeAlocacao();

		assertEquals(1, fases.size());
		GradeHorario gradeFase = fases.get(0).getGradeHorario();

		HorarioAula actual = gradeFase.getGradeHoraria()[segundaFeira.ordinal()][primeiroHorario
				.ordinal()];

		assertEquals(professor, actual.getProfessor());
		assertEquals(disciplina, actual.getDisciplina());
	}

	@Test()
	public void testAlocacaoDeDisciplinasSemProfessoresNoCurso() {

	}

	@Test()
	public void testAlocacaoDeDisciplinasComUmProfessorSemHorarioDisponivel() {

	}

	private Curso setupCurso(List<Professor> professores, List<Fase> fases) {

		Curso curso = new Curso();

		curso.addProfessores(professores);
		curso.addFases(fases);

		return curso;

	}

	private class BuildProfessor {

		Professor professor = new Professor("");

		public BuildProfessor withHorario(DiaDaSemana diaDaSemana,
				HorarioNoDia horarioNoDia) {
			professor.addHorario(new Horario(diaDaSemana, horarioNoDia));
			return this;
		}

		public BuildProfessor withAreaDeAtuacao(String nomeDaArea) {
			professor.addAreaDeAtuacao(new AreaConhecimento(nomeDaArea));
			return this;
		}

		public BuildProfessor withNome(String nome) {
			professor.setNome(nome);
			return this;
		}

		public Professor build() {
			return professor;
		}
	}

	private class BuildDisciplina {

		Disciplina disciplina = new Disciplina(null, "");

		public BuildDisciplina withHorario(DiaDaSemana diaDaSemana,
				HorarioNoDia horarioNoDia) {
			disciplina.addHorario(new Horario(diaDaSemana, horarioNoDia));
			return this;
		}

		public BuildDisciplina withArea(String nomeDaArea) {
			disciplina.setArea(new AreaConhecimento(nomeDaArea));
			return this;
		}

		public Disciplina build() {
			return disciplina;
		}

		public BuildDisciplina withNome(String nome) {
			disciplina.setNome(nome);
			return this;
		}
	}

	@Test()
	public void testDoisProfessoresDuasDisciplinas()
			throws ProfessorNaoEncontradoParaDisciplinaException {
		List<Professor> professores = new ArrayList<Professor>();
		professores.add(new BuildProfessor()
				.withNome("Jose")
				.withHorario(DiaDaSemana.SEGUNDA_FEIRA,
						HorarioNoDia.PRIMEIRO_HORARIO).withAreaDeAtuacao("BD")
				.build());

		professores.add(new BuildProfessor()
				.withNome("Joao")
				.withHorario(DiaDaSemana.TERCA_FEIRA,
						HorarioNoDia.SEGUNDO_HORARIO).withAreaDeAtuacao("SO")
				.build());

		List<Disciplina> disciplinas = new ArrayList<Disciplina>();
		disciplinas.add(new BuildDisciplina()
				.withArea("BD")
				.withHorario(DiaDaSemana.SEGUNDA_FEIRA,
						HorarioNoDia.PRIMEIRO_HORARIO)
				.withNome("Introducao a BD").build());

		disciplinas.add(new BuildDisciplina()
				.withArea("SO")
				.withHorario(DiaDaSemana.TERCA_FEIRA,
						HorarioNoDia.SEGUNDO_HORARIO)
				.withNome("Introducao a SO").build());

		List<Fase> fases = new ArrayList<Fase>();
		Fase fase = new Fase(1);
		fase.addDisciplinas(disciplinas);
		fases.add(fase);

		Curso curso = setupCurso(professores, fases);
		List<Fase> result = curso.executeAlocacao();

		HorarioAula[][] horarios = result.get(0).getGradeHorario()
				.getGradeHoraria();
		HorarioAula segundaFeiraPrimeiroHorario = horarios[DiaDaSemana.SEGUNDA_FEIRA
				.ordinal()][HorarioNoDia.PRIMEIRO_HORARIO.ordinal()];

		HorarioAula tercaFeiraPrimeiroHorario = horarios[DiaDaSemana.TERCA_FEIRA
				.ordinal()][HorarioNoDia.SEGUNDO_HORARIO.ordinal()];

		assertEquals("Jose", segundaFeiraPrimeiroHorario.getProfessor()
				.getNome());
		assertEquals("Introducao a BD", segundaFeiraPrimeiroHorario
				.getDisciplina().getNome());

		assertEquals("Joao", tercaFeiraPrimeiroHorario.getProfessor().getNome());
		assertEquals("Introducao a SO", tercaFeiraPrimeiroHorario
				.getDisciplina().getNome());
	}

	@Test()
	public void testProfessorPossueAreasDeAtuacao() {

		Professor professor = new Professor("");
		AreaConhecimento areaAtuacao = new AreaConhecimento("Banco de dados");
		professor.addAreaDeAtuacao(areaAtuacao);

		assertEquals(true, professor.atuaNaArea(areaAtuacao));
	}
	
	private class AlocacaoFixture extends Fixture {

		private Curso curso = new Curso();
		
		@Override
		public void execute() throws Exception {
			
			List<tablelize.Table> tables = this.getTablesWithName("professor");
			
			for (tablelize.Table table : tables) {
				
				String nome = table.getCell("nome", 0);
				Professor professor = new Professor(nome);
				curso.addProfessor(professor);
				
				tablelize.Table areas = this.getTableWithArg("area do professor", 0, nome);
				for (int i = 0; i < areas.rowsCount(); i++) {
					String nomeArea = areas.getCell("area", i);
					professor.addAreaDeAtuacao(new AreaConhecimento(nomeArea));
				}
				
				tablelize.Table horarios = this.getTableWithArg("horarios do professor", 0, nome);
				for (int i = 0; i < horarios.rowsCount(); i++) {
					String diaDaSemana= horarios.getCell("dia da semana", i);
					String periodo = horarios.getCell("periodo", i);
					
					professor.addHorario(new Horario(parseDiaDaSemana(diaDaSemana), parseHorarioNoDia(periodo)));
				}
			}
			
			tables = this.getTablesWithName("fase");
			for (tablelize.Table table : tables) {
				
				String numeroFase = table.getTableArgAt(0);
				
				Fase fase = new Fase(Integer.parseInt(numeroFase));
				
				for (int i = 0; i < table.rowsCount(); i++) {
					
					String nome = table.getCell("disciplina", i);
					String area = table.getCell("area", i);
					 
					fase.addDisciplina(new Disciplina(new AreaConhecimento(area), nome));
				}
				
				curso.addFase(fase);
			}
		}
		
		private DiaDaSemana parseDiaDaSemana(String str) throws Exception {
			if (str.equals("segunda"))
				return DiaDaSemana.SEGUNDA_FEIRA;
			else if (str.equals("terca"))
				return DiaDaSemana.TERCA_FEIRA;
			else if (str.equals("quarta")) 
				return DiaDaSemana.QUARTA_FEIRA;
			else if (str.equals("quinta")) 
				return DiaDaSemana.QUINTA_FEIRA;
			else if (str.equals("sexta")) 
				return DiaDaSemana.SEXTA_FEIRA;
				
			throw new Exception("cant parse dia da semana");
		}
		
		private HorarioNoDia parseHorarioNoDia(String str) throws Exception {
			if (str.equals("primeiro"))
				return HorarioNoDia.PRIMEIRO_HORARIO;
			if (str.equals("segundo"))
				return HorarioNoDia.SEGUNDO_HORARIO;
			if (str.equals("terceiro"))
				return HorarioNoDia.TERCEIRO_HORARIO;
			if (str.equals("quarto"))
				return HorarioNoDia.QUARTO_HORARIO;
			
			throw new Exception("cant parse horario no dia");
			
		}
		
	}
	
	@Test
	public void testAlgoritmo() throws Exception {
		
		AlocacaoFixture fixture = new AlocacaoFixture();
//		String file = new File(".").getCanonicalPath();
//		System.out.println(file);
		fixture.LoadingDataFromFile("src/teste/teste.txt");
		
		
	}

//	@Test
//	public void testSave() {
//		try {
//			EntityManager entityManager = Persistence
//					.createEntityManagerFactory("teste.agil")
//					.createEntityManager();
//			AreaConhecimento area = new AreaConhecimento("teste");
//			entityManager.getTransaction().begin();
//			entityManager.persist(area);
//			entityManager.getTransaction().commit();
//			entityManager.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

}