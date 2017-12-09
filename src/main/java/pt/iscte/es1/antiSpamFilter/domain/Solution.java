package pt.iscte.es1.antiSpamFilter.domain;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Weights composite for a given solution generated by jMetal
 */
public class Solution implements Iterable<Double> {

	private final List<Double> weights;

	/**
	 * @param weights weights of a jMetal solution
	 */
	public Solution(List<Double> weights) {
		validateWeights(weights);
		this.weights = weights;
	}

	/**
	 * Ensure weights are between valid interval
	 * @param weights weights to validate
	 * @throws IllegalArgumentException when a weight isn't between the valid interval
	 */
	private static void validateWeights(List<Double> weights) throws IllegalArgumentException {
		for (Double weight : weights) {
			if (weight < -5.0 || weight > 5.0) {
				throw new IllegalArgumentException("Weight value must be between -5.0 and 5.0");
			}
		}
	}

	/**
	 * Return weights of a jMetal solution
	 * @return weights of a jMetal solution
	 */
	public List<Double> getWeights() {
		return weights;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Iterator<Double> iterator() {
		return weights.iterator();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void forEach(Consumer<? super Double> action) {
		weights.forEach(action);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Spliterator<Double> spliterator() {
		return weights.spliterator();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return weights.toString();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Solution doubles = (Solution) o;

		return getWeights().equals(doubles.getWeights());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return getWeights().hashCode();
	}
}
