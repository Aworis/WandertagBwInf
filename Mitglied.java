public class Mitglied implements Comparable<Mitglied> {
    final private int id;
    final private int minDistance;
    final private int maxDistance;

    public Mitglied(int minDistance, int maxDistance) {
        this.id = IDGenerator.generateID();
        this.minDistance = minDistance;
        this.maxDistance = maxDistance;
    }

    public int getId() {
        return id;
    }

    public int getMinDistance() {
        return minDistance;
    }

    public int getMaxDistance() {
        return maxDistance;
    }

    @Override
    public int compareTo(Mitglied other) {
        return Integer.compare(this.id, other.id);
    }
}
