package managebean;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

import dao.DisciplinaDAO;
import domain.Disciplina;

public class DisciplinaBean {

	@PostConstruct
	void initialiseSession() {
		FacesContext.getCurrentInstance().getExternalContext().getSession(true);
	}

	private DisciplinaDAO disciplinaDao;

	private ArrayList<Disciplina> listaDisciplinas;
	private Disciplina disciplinaSelecionada;

	public DisciplinaBean() {
	}

	/**
	 * @return the listaDisciplinas
	 */
	public ArrayList<Disciplina> getListaDisciplinas() {
		if (listaDisciplinas == null)
			listaDisciplinas = disciplinaDao.selectAll();
		return listaDisciplinas;
	}

	/**
	 * @param listaDisciplinas
	 *            the listaDisciplinas to set
	 */
	public void setListaDisciplinas(ArrayList<Disciplina> listaDisciplinas) {
		this.listaDisciplinas = listaDisciplinas;
	}

	public Disciplina getDisciplinaSelecionada() {
		if (disciplinaSelecionada == null)
			disciplinaSelecionada = new Disciplina();
		return disciplinaSelecionada;
	}

	public void setDisciplinaSelecionada(Disciplina disciplinaSelecionada) {
		this.disciplinaSelecionada = disciplinaSelecionada;
	}

	public String inserir() {

		return "inserirDisciplina";
	}

	public String cadastrar() {
		System.out.println(disciplinaSelecionada);

		disciplinaDao.insert(disciplinaSelecionada);

		disciplinaSelecionada = new Disciplina();
		listaDisciplinas = disciplinaDao.selectAll();

		return "retornaDisciplina";
	}

	public String atualizar() {
		disciplinaDao.update(disciplinaSelecionada);

		// disciplinaSelecionada = new Disciplina();
		listaDisciplinas = disciplinaDao.selectAll();

		return "retornaDisciplina";
	}

	public String excluir() {
		disciplinaDao.delete(disciplinaSelecionada);

		// disciplinaSelecionada = new Disciplina();
		listaDisciplinas = disciplinaDao.selectAll();

		return "excluirDisciplina";
	}

}