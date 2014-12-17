package fpaleph.poesto.gui.infrastructure;

public class SkillTreeConstraints {

	private double x, y;

	public SkillTreeConstraints(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getY() {
		return y;
	}

	public double getX() {
		return x;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append('(').append(x).append(", ").append(y).append(')');
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		SkillTreeConstraints other = (SkillTreeConstraints) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}

}
