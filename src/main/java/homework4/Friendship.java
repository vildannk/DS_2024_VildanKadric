package homework4;

import java.util.Objects;

public class Friendship {
    private String friend1;  // First friend in the friendship
    private String friend2;  // Second friend in the friendship
    private double strength; // Strength of the friendship

    public Friendship(String friend1, String friend2, double strength) {
        this.friend1 = friend1;
        this.friend2 = friend2;
        this.strength = strength;
    }

    public String getFriend1() {
        return friend1;
    }

    public String getFriend2() {
        return friend2;
    }

    public double getStrength() {
        return strength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Friendship that = (Friendship) o;
        return Double.compare(that.strength, strength) == 0 &&
                Objects.equals(friend1, that.friend1) &&
                Objects.equals(friend2, that.friend2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(friend1, friend2, strength);
    }

    @Override
    public String toString() {
        return "Friendship{" +
                "friend1='" + friend1 + '\'' +
                ", friend2='" + friend2 + '\'' +
                ", strength=" + strength +
                '}';
    }
}
