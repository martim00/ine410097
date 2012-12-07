package managebean;
import java.util.ArrayList;
import java.util.List;

import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;


public class ProfessorBean {
	
	private DualListModel<String> areaConhecimento;
	
	public ProfessorBean() {
		List<String> conhecimentoTarget = new ArrayList<String>();
		List<String> conhecimentoSource = new ArrayList<String>();
		
		conhecimentoSource.add("Banco de Dados");
		conhecimentoSource.add("Sistemas Distribuidos");
		conhecimentoSource.add("Engenharia do Software");
		conhecimentoSource.add("Inteligência Artificial");
		
		setAreaConhecimento(new DualListModel<String>(conhecimentoSource, conhecimentoTarget));
	}

	/**
	 * @return the areaConhecimento
	 */
	public DualListModel<String> getAreaConhecimento() {
		return areaConhecimento;
	}

	/**
	 * @param areaConhecimento the areaConhecimento to set
	 */
	public void setAreaConhecimento(DualListModel<String> areaConhecimento) {
		this.areaConhecimento = areaConhecimento;
	}
	
	public void onTransfer(TransferEvent event){
		
	}

}
