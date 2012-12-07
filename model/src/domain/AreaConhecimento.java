package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AREA")
public class AreaConhecimento {
	
	private long id;
	private String nomeArea = null;

	public AreaConhecimento() {}
	
	public AreaConhecimento(String nomeArea) {		
		this.setNomeArea(nomeArea);
	}
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	@Column(name="NAME", nullable=false)
	public String getNomeArea() {
		return nomeArea;
	}

	public void setNomeArea(String nomeArea) {
		this.nomeArea = nomeArea;
	}

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
	
}