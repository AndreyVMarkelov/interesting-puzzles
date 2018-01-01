/**
 * Determine that after N steps "knight" will stay on chess board starting in (x, y) point.
 *
 * @author Andrey Markelov
 */
public class KnightProbability {
    public static void main(String[] args) {
        System.out.println(probability(1, 0, 0));
        System.out.println(probability(1, 4, 4));
        System.out.println(probability(20, 6, 5));
    }

    private static double probability(int N, int startX, int startY) {
        double probability[][][] = new double[N + 1][8][8];

        // init to 1 for beginning position
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                probability[0][x][y] = 1;
            }
        }

        int dx[] = new int[] { 1, 2, 2, 1, -1, -2, -2, -1 };
        int dy[] = new int[] { 2, 1, -1, -2, -2, -1, 1, 2 };
        for(int n = 1; n <= N; n++) {
            for(int x = 0; x < 8; x ++) {
                for(int y = 0; y < 8; y++) {
                    double currentProbability = 0.0;
                    for(int i = 0; i < 8; i++) {
                        if (x + dx[i] >= 0 && x + dx[i] < 8 && y + dy[i] >= 0 && y + dy[i] < 8) {
                            currentProbability += probability[n - 1][y + dy[i]][x + dx[i]] / 8.0;
                        }
                    }
                    probability[n][y][x] = currentProbability;
                }
            }
        }
        return probability[N][startX][startY];
    }
}
