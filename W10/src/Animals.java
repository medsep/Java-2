
public class Animals {

	String name;

	@Override;
	public boolean equals(Object o) {
		
		//cast o to Animal
		Animals otherAnimal = (Animals) o;
		
		//compare this.name to name of animal passed in
		return this.name.contentEquals(otherAnimal.name);
	}

}
