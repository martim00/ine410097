package domain;

public class AreaConhecimento {
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nomeArea == null) ? 0 : nomeArea.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AreaConhecimento other = (AreaConhecimento) obj;
		if (nomeArea == null) {
			if (other.nomeArea != null)
				return false;
		} else if (!nomeArea.equals(other.nomeArea))
			return false;
		return true;
	}

	private String nomeArea = null;

	public AreaConhecimento(String nomeArea) {		
		this.setNomeArea(nomeArea);
	}

	public String getNomeArea() {
		return nomeArea;
	}

	public void setNomeArea(String nomeArea) {
		this.nomeArea = nomeArea;
	}

}
