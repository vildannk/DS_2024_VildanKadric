package homework4;

import java.util.*;

public class SocialNetwork {
    public int V;  // Number of users
    public int E;  // Number of friendships
    private HashMap<String, ArrayList<Friendship>> adj;  // Adjacency list to store friendships

    public SocialNetwork() {
        this.V = 0;
        this.E = 0;
        this.adj = new HashMap<>();
    }

    public SocialNetwork(Scanner in) {
        this();  // Initialize the network
        if (in.hasNextLine()) in.nextLine();  // Skip the header line
        while (in.hasNextLine()) {
            String[] line = in.nextLine().split(";");
            if (line.length != 3) continue;
            String friend1 = line[0];
            String friend2 = line[1];
            double strength = Double.parseDouble(line[2]);
            Friendship f = new Friendship(friend1, friend2, strength);
            addFriendship(f);
        }
    }

    // Add a user to the network if they don't already exist
    public void addUser(String user) {
        if (!adj.containsKey(user)) {
            adj.put(user, new ArrayList<>());
            V++;
        }
    }

    // Add a friendship to the network ensuring no duplicates and counting each unique friendship once
    public void addFriendship(Friendship f) {
        addUser(f.getFriend1());
        addUser(f.getFriend2());
        adj.get(f.getFriend1()).add(f);
        adj.get(f.getFriend2()).add(new Friendship(f.getFriend2(), f.getFriend1(), f.getStrength()));
        E++;
    }

    // Recommend friends for a given user based on mutual friends
    public ArrayList<FriendshipRecommendation> recommendFriends(String user) {
        if (!adj.containsKey(user)) return new ArrayList<>();

        HashMap<String, Double> recommendationStrengths = new HashMap<>();
        Set<String> userFriends = new HashSet<>();
        for (Friendship friend : adj.get(user)) {
            userFriends.add(friend.getFriend2());
        }

        for (Friendship friend : adj.get(user)) {
            String friendName = friend.getFriend2();
            for (Friendship friendsFriend : adj.get(friendName)) {
                String potentialFriend = friendsFriend.getFriend2();
                if (!potentialFriend.equals(user) && !userFriends.contains(potentialFriend)) {
                    double minStrength = Math.min(friend.getStrength(), friendsFriend.getStrength());
                    recommendationStrengths.put(potentialFriend, recommendationStrengths.getOrDefault(potentialFriend, 0.0) + minStrength);
                }
            }
        }

        ArrayList<FriendshipRecommendation> recommendations = new ArrayList<>();
        for (String potentialFriend : recommendationStrengths.keySet()) {
            recommendations.add(new FriendshipRecommendation(potentialFriend, recommendationStrengths.get(potentialFriend)));
        }
        Collections.sort(recommendations);
        return recommendations;
    }
}
