package managebean;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

import dao.AreaConhecimentoDAO;
import domain.AreaConhecimento;

public class AreaConhecimentoBean {

	@PostConstruct
	void initialiseSession() {
		FacesContext.getCurrentInstance().getExternalContext().getSession(true);
	}

	private ArrayList<AreaConhecimento> listaAreas;
	private AreaConhecimento areaSelecionada;

	private AreaConhecimentoDAO areaDao;

	public AreaConhecimentoBean() {
		areaSelecionada = new AreaConhecimento();
		areaDao = new AreaConhecimentoDAO();

		listaAreas = areaDao.selectAll();
	}

	/**
	 * @return the listaAreas
	 */
	public ArrayList<AreaConhecimento> getListaAreas() {
		if (listaAreas == null)
			listaAreas = areaDao.selectAll();

		return listaAreas;
	}

	/**
	 * @param listaAreas
	 *            the listaAreas to set
	 */
	public void setListaAreas(ArrayList<AreaConhecimento> listaAreas) {
		this.listaAreas = listaAreas;
	}

	/**
	 * @return the areaSelecionada
	 */
	public AreaConhecimento getAreaSelecionada() {
		if (areaSelecionada == null)
			areaSelecionada = new AreaConhecimento();
		return areaSelecionada;
	}

	/**
	 * @param areaSelecionada
	 *            the areaSelecionada to set
	 */
	public void setAreaSelecionada(AreaConhecimento areaSelecionada) {
		this.areaSelecionada = areaSelecionada;
	}

	public String inserir() {

		return "inserirArea";
	}

	public String cadastrar() {
		System.out.println(areaSelecionada);

		areaDao.insert(areaSelecionada);

		areaSelecionada = new AreaConhecimento();
		listaAreas = areaDao.selectAll();

		return "retornaArea";
	}

	public String atualizar() {
		areaDao.update(areaSelecionada);

		// areaSelecionada = new AreaConhecimento();
		listaAreas = areaDao.selectAll();

<<<<<<< HEAD
		return "retornaArea";
	}
=======
		return "atualizaArea";
	}
	

>>>>>>> Mudanças Web MAdrugada

	public String excluir() {
		areaDao.delete(areaSelecionada);

<<<<<<< HEAD
		// areaSelecionada = new AreaConhecimento();
		listaAreas = areaDao.selectAll();

		return "excluirArea";
=======

		// areaSelecionada = new AreaConhecimento();
		listaAreas = areaDao.selectAll();

		return "atualizaArea";


>>>>>>> Mudanças Web MAdrugada
	}

}
