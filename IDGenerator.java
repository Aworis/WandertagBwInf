public class IDGenerator {
    private static int counter = 0;

    public static synchronized int generateID() {
        return ++counter;
    }
}
