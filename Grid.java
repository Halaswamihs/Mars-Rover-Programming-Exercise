
import java.util.HashSet;
import java.util.Set;

public class Grid implements GridComponent {
    private final int width;
    private final int height;
    private final Set<int[]> obstacles;

    public Grid(int width, int height, Set<int[]> obstacles) {
        this.width = width;
        this.height = height;
        this.obstacles = new HashSet<>(obstacles);
    }

    @Override
    public boolean isWithinBounds(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    @Override
    public boolean hasObstacle(int x, int y) {
        return obstacles.contains(new int[]{x, y});
    }
}
