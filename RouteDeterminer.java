import java.util.*;

public class RouteDeterminer {
    private final Mitglied[] mitgliederRegister;
    private final List<DistanceIntersection> intersections;

    public RouteDeterminer(Mitglied[] mitgliederRegister) {
        this.mitgliederRegister = mitgliederRegister;
        this.intersections = new ArrayList<>();
    }

    public List<DistanceIntersection> getIntersections() {
        return intersections;
    }

    private boolean mitgliederHaveIntersection(Mitglied mitglied1, Mitglied mitglied2) {
        int min1 = mitglied1.getMinDistance();
        int max1 = mitglied1.getMaxDistance();
        int min2 = mitglied2.getMinDistance();
        int max2 = mitglied2.getMaxDistance();

        return min1 < max2 && min2 < max1;
    }

    public void createIntersections() {
        for (int i = 0; i < mitgliederRegister.length; i++) {
            Mitglied mitglied1 = mitgliederRegister[i];

            for (int j = i + 1; j < mitgliederRegister.length; j++) {
                Mitglied mitglied2 = mitgliederRegister[j];
                buildIntersection(mitglied1, mitglied2);
            }
        }

        summarizeIntersections();
        sortIntersectionsByNumberOfMitglieder();
    }

    private void sortIntersectionsByNumberOfMitglieder() {
        intersections.sort((d1, d2) -> Integer.compare(d2.getMitglieder().size(), d1.getMitglieder().size()));
    }

    private void buildIntersection(Mitglied mitglied1, Mitglied mitglied2) {
        if (mitgliederHaveIntersection(mitglied1, mitglied2)) {
            intersections.add(new DistanceIntersection(mitglied1, mitglied2));
        }
    }

    // TODO dokumentieren
    public void summarizeIntersections() {
        for (int i = 0; i < intersections.size(); i++) {
            DistanceIntersection currentIntersection = intersections.get(i);
            int currentMinDistance = currentIntersection.getMinDistance();

            for (int j = i + 1; j < intersections.size(); j++) {
                DistanceIntersection comparisonIntersection = intersections.get(j);
                int comparisonMinDistance = comparisonIntersection.getMinDistance();

                if (currentMinDistance == comparisonMinDistance){
                    currentIntersection.setMaxDistance(Math.min(currentIntersection.getMaxDistance(),
                            comparisonIntersection.getMaxDistance()));

                    currentIntersection.getMitglieder().addAll(comparisonIntersection.getMitglieder());
                    intersections.remove(comparisonIntersection);
                    j--;
                }
            }
        }
    }
}
