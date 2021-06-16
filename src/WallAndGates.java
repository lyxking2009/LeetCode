import java.util.*;

class wallsAndGateLeetCode {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;
        int cur_i = 0;
        int cur_j = 0;

        for (cur_i = 0; cur_i < m; cur_i++)
            for (cur_j = 0; cur_j < n; cur_j++) {
                if (rooms[cur_i][cur_j] != 0 && rooms[cur_i][cur_j] != -1) {
                    Queue<Pair> queue = new LinkedList<Pair>();
                    HashSet<Integer> visited = new HashSet<Integer>();
                    int distance = 0;
                    Pair curNode = new Pair(cur_i, cur_j);
                    queue.offer(curNode);
                    visited.add(curNode.hashCode());
                    while (!queue.isEmpty()) {
                        distance++;
                        int curSize = queue.size();
                        int rep = 0;
                        while (rep < curSize) {
                            Pair cur = queue.poll();
                            int i = cur.row;
                            int j = cur.column;
                            curNode = new Pair(i - 1, j);
                            if (i - 1 >= 0 && rooms[i - 1][j] != -1 && !visited.contains(curNode.hashCode()))
                                if (rooms[i - 1][j] == 0) {
                                    rooms[cur_i][cur_j] = distance;
                                    break;
                                } else {
                                    queue.offer(curNode);
                                    visited.add(curNode.hashCode());
                                }
                            curNode = new Pair(i, j - 1);
                            if (j - 1 >= 0 && rooms[i][j - 1] != -1 && !visited.contains(curNode.hashCode()))
                                if (rooms[i][j - 1] == 0) {
                                    rooms[cur_i][cur_j] = distance;
                                    break;
                                } else {
                                    queue.offer(curNode);
                                    visited.add(curNode.hashCode());
                                }
                            curNode = new Pair(i + 1, j);
                            if (i + 1 < m && rooms[i + 1][j] != -1 && !visited.contains(curNode.hashCode()))
                                if (rooms[i + 1][j] == 0) {
                                    rooms[cur_i][cur_j] = distance;
                                    break;
                                } else {
                                    queue.offer(curNode);
                                    visited.add(curNode.hashCode());
                                }
                            curNode = new Pair(i, j + 1);
                            if (j + 1 < n && rooms[i][j + 1] != -1 && !visited.contains(curNode.hashCode()))
                                if (rooms[i][j + 1] == 0) {
                                    rooms[cur_i][cur_j] = distance;
                                    break;
                                } else {
                                    queue.offer(curNode);
                                    visited.add(curNode.hashCode());
                                }
                            rep++;
                        }
                        if (rooms[cur_i][cur_j] != 2147483647)
                            break;
                    }
                }
            }
    }
}


class Pair {
    public int row;
    public int column;

    public Pair(int i, int j) {
        this.row = i;
        this.column = j;
    }

    @Override
    public int hashCode()
    {
        return row * 250 + column;
    }
}