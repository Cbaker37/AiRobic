package edu.brown.cs.student.main.models.markov;

import com.squareup.moshi.Json;
import edu.brown.cs.student.main.RandomGenerator;
import edu.brown.cs.student.main.models.exceptions.InvalidDistributionException;
import java.util.HashMap;
import java.util.Set;

/**
 * Still ironing out details of Emission class and HiddenState class.
 */
public class HiddenState {

  private final HashMap<HiddenState, Double> transitionDistribution;
  private final HashMap<Emission, Double> emissionDistribution;
  private final String name;

  public HiddenState(@Json(name="category") String name,
      @Json(name = "transitions") HashMap<HiddenState, Double> transitionDistribution,
      @Json(name = "emissions") HashMap<Emission, Double> emissionDistribution) throws InvalidDistributionException {
    this.transitionDistribution = transitionDistribution;
    this.emissionDistribution = emissionDistribution;
    this.name = name;
    RandomGenerator.validateDistribution(HiddenState.class, transitionDistribution);
    RandomGenerator.validateDistribution(Emission.class, emissionDistribution);
  }

  public Emission emit() throws InvalidDistributionException {
    return RandomGenerator.generateRandomFromDistribution(Emission.class, this.emissionDistribution);
  }

  public HiddenState transition() throws InvalidDistributionException {
    return RandomGenerator.generateRandomFromDistribution(HiddenState.class, this.transitionDistribution);
  }

  public Set<HiddenState> potentialStates() {
    return this.transitionDistribution.keySet();
  }

}
