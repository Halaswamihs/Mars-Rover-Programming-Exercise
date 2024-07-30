// Main.java
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter grid width: ");
        int width = scanner.nextInt();
        System.out.print("Enter grid height: ");
        int height = scanner.nextInt();

        
        System.out.print("Enter starting x position: ");
        int startX = scanner.nextInt();
        System.out.print("Enter starting y position: ");
        int startY = scanner.nextInt();
        System.out.print("Enter starting direction ( N FOR NORTH,S FOR SOUTH,E FOR EAST,W FOR WEST): ");
        Direction startDirection = Direction.valueOf(scanner.next().toUpperCase());

        
        System.out.print("Enter number of obstacles: ");
        int numObstacles = scanner.nextInt();
        Set<int[]> obstacles = new HashSet<>();
        for (int i = 0; i < numObstacles; i++) {
            System.out.print("Enter obstacle x position: ");
            int obsX = scanner.nextInt();
            System.out.print("Enter obstacle y position: ");
            int obsY = scanner.nextInt();
            obstacles.add(new int[]{obsX, obsY});
        }

        
        GridComponent grid = new Grid(width, height, obstacles);
        Rover rover = new Rover(startX, startY, startDirection, grid);

        
        System.out.print("Enter commands (M for move, L for turn left, R for turn right): ");
        String commands = scanner.next();
        for (char command : commands.toCharArray()) {
            switch (command) {
                case 'M': new MoveCommand().execute(rover); break;
                case 'L': new TurnLeftCommand().execute(rover); break;
                case 'R': new TurnRightCommand().execute(rover); break;
                default: System.out.println("Invalid command: " + command); break;
            }
        }

        
        System.out.println(rover.finalPosition());
        System.out.println(rover.statusReport());
    }
}
