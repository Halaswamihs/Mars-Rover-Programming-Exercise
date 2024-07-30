
public enum Direction {
    N, S, E, W;

    public Direction turnLeft() {
        switch (this) {
            case N: return W;
            case W: return S;
            case S: return E;
            case E: return N;
            default: throw new IllegalStateException("Unexpected value: " + this);
        }
    }

    public Direction turnRight() {
        switch (this) {
            case N: return E;
            case E: return S;
            case S: return W;
            case W: return N;
            default: throw new IllegalStateException("Unexpected value: " + this);
        }
    }

    public int[] moveForward(int x, int y) {
        switch (this) {
            case N: return new int[]{x, y + 1};
            case S: return new int[]{x, y - 1};
            case E: return new int[]{x + 1, y};
            case W: return new int[]{x - 1, y};
            default: throw new IllegalStateException("Unexpected value: " + this);
        }
    }
}
