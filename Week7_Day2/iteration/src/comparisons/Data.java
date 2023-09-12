package comparisons;

public class Data implements Comparable<Data> {
	private int id;
	private double weight;
	
	public int compareTo(Data other) {
		if (other.getId() > this.id) {
			return 1;
		} else if (other.getId() < this.id) {
			return -1;
		} else { // other.getId() == this.id
			return 0;
		}
	}
	
	public Data(int id, double weight) {
		this.id = id;
		this.weight = weight;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "[id:="+ id + ", weight=" + weight + "]";
	}
}
