package homework4;

public class FriendshipRecommendation implements Comparable<FriendshipRecommendation> {
    private String user;  // Recommended user
    private double strength;  // Strength of the recommendation

    public FriendshipRecommendation(String user, double strength) {
        this.user = user;
        this.strength = strength;
    }

    public String getUser() {
        return user;
    }

    public double getStrength() {
        return strength;
    }

    @Override
    public int compareTo(FriendshipRecommendation o) {
        // Sort recommendations in descending order of strength
        return Double.compare(o.strength, this.strength);
    }

    @Override
    public String toString() {
        return user + ": " + strength;
    }
}
