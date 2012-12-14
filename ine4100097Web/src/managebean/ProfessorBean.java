package managebean;
import java.util.ArrayList;
import java.util.List;

import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;

import dao.AreaConhecimentoDAO;
import domain.AreaConhecimento;


public class ProfessorBean {
	
	private DualListModel<AreaConhecimento> areaConhecimento;
	private AreaConhecimentoDAO areaDao;
	
	public ProfessorBean() {
		
		areaDao = new AreaConhecimentoDAO();
		
		List<AreaConhecimento> conhecimentoTarget = new ArrayList<AreaConhecimento>();
		List<AreaConhecimento> conhecimentoSource = areaDao.selectAll();
		
		setAreaConhecimento(new DualListModel<AreaConhecimento>(conhecimentoSource, conhecimentoTarget));
		
	}

	/**
	 * @return the areaConhecimento
	 */
	public DualListModel<AreaConhecimento> getAreaConhecimento() {
		return areaConhecimento;
	}

	/**
	 * @param areaConhecimento the areaConhecimento to set
	 */
	public void setAreaConhecimento(DualListModel<AreaConhecimento> areaConhecimento) {
		this.areaConhecimento = areaConhecimento;
	}
	
	public void onTransfer(TransferEvent event){
		
	}

}
