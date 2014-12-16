package fpaleph.poesto;

public class ClassAttributes {

	public int id = -1;
	public String name = null;
	public int node = -1;
	public int s, d, i = -1;

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append('[')
		  .append("id=").append(id)
		  .append(", name=\"").append(name).append("\"")
		  .append(", node=").append(node)
	      .append(", str=").append(s)
		  .append(", dex=").append(d)
		  .append(", int=").append(i)
		  .append(']');
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + d;
		result = prime * result + i;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + node;
		result = prime * result + s;
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
		ClassAttributes other = (ClassAttributes) obj;
		if (d != other.d)
			return false;
		if (i != other.i)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (node != other.node)
			return false;
		if (s != other.s)
			return false;
		return true;
	}

}
