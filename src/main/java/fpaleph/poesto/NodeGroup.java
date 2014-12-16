package fpaleph.poesto;

import java.util.HashSet;
import java.util.Set;

public class NodeGroup {

	public int id = -1;
	public Set<Integer> nodes = new HashSet<Integer>();
	public int size = -1;
	public double x, y = Double.NaN;
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[id=").append(id)
		  .append(", nodes=").append(nodes)
		  .append(", size=").append(size)
		  .append(", x=").append(x)
		  .append(", y=").append(y)
		  .append("]");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((nodes == null) ? 0 : nodes.hashCode());
		result = prime * result + size;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		NodeGroup other = (NodeGroup) obj;
		if (id != other.id)
			return false;
		if (nodes == null) {
			if (other.nodes != null)
				return false;
		} else if (!nodes.equals(other.nodes))
			return false;
		if (size != other.size)
			return false;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}

}
