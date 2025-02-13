import java.util.Set;
import java.util.TreeSet;

public class DistanceIntersection {
    private final int minDistance;
    private int maxDistance;
    private final Set<Mitglied> mitglieder = new TreeSet<>();

    public DistanceIntersection(Mitglied mitglied1, Mitglied mitglied2) {
        this.minDistance = Math.max(mitglied1.getMinDistance(), mitglied2.getMinDistance());
        this.maxDistance = Math.min(mitglied1.getMaxDistance(), mitglied2.getMaxDistance());
        mitglieder.add(mitglied1);
        mitglieder.add(mitglied2);
    }

    public int getMinDistance() {
        return minDistance;
    }

    public int getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(int maxDistance) {
        this.maxDistance = maxDistance;
    }

    public Set<Mitglied> getMitglieder() {
        return mitglieder;
    }
}
