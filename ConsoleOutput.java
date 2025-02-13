import java.util.List;

public class ConsoleOutput {

    public void output (List<DistanceIntersection> intersections) {
        for ( DistanceIntersection intersection : intersections) {
            System.out.print("Schnittmenge: " + intersection.getMinDistance() + " - " + intersection.getMaxDistance() + " km    Anzahl der Mitglieder: " + intersection.getMitglieder().size() + " -->   ");

            for (Mitglied mitglied : intersection.getMitglieder()) {
                System.out.print(mitglied.getId() + " | ");
            }

            System.out.println();
        }
    }
}
