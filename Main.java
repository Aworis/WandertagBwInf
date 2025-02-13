public class Main {
    public static void main(String[] args) {
        DataStructurer dataStructurer = new DataStructurer("src/A3_Wandertag/wandern6.txt");
        RouteDeterminer routeDeterminer = new RouteDeterminer(dataStructurer.getMitgliederRegister());
        ConsoleOutput consoleOutput = new ConsoleOutput();
        routeDeterminer.createIntersections();
        consoleOutput.output(routeDeterminer.getIntersections());
    }
}