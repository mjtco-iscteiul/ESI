package pt.iscte.es1.antiSpamFilter.domain;

import java.util.Objects;

/**
 * This class represents a rule that may contain an associated weight.
 */
public class WeightedRule {

	private final String name;
	private final Double weight;

	/**
	 * Default constructor that accepts a name and an associated weight.
	 * 
	 * @param name rule name
	 * @param weight rule weight
	 */
	public WeightedRule(String name, Double weight) {
		this.name = name;
		this.weight = weight;
	}
	
	/**
	 * Constructor that accepts a name and fills in a neutral weight of 0.0.
	 * 
	 * @param name rule name
	 */
	public WeightedRule(String name) {
		this(name, 0.0);
	}
	
	/**
	 * @return rule name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return rule weight
	 */
	public Double getWeight() {
		return weight;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WeightedRule other = (WeightedRule) obj;
		return Objects.equals(name, other.name);
	}
}
