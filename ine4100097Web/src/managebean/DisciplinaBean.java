package managebean;

import java.util.ArrayList;
import java.util.List;

public class DisciplinaBean {
	
	private List<String> listaDisciplinas;
	
	public DisciplinaBean() {
		
	}
	
	private void populaDisciplinas(){
		listaDisciplinas = new ArrayList<String>();
		
		listaDisciplinas.add("Disciplina 1");
		listaDisciplinas.add("Disciplina 6");
		listaDisciplinas.add("Disciplina 5");
		listaDisciplinas.add("Disciplina 4");
	}

	/**
	 * @return the listaDisciplinas
	 */
	public List<String> getListaDisciplinas() {
			if(listaDisciplinas == null)
				populaDisciplinas();
		return listaDisciplinas;
	}

	/**
	 * @param listaDisciplinas the listaDisciplinas to set
	 */
	public void setListaDisciplinas(List<String> listaDisciplinas) {
		this.listaDisciplinas = listaDisciplinas;
	}

}
