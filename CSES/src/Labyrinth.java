
import java.io.*;
import java.util.*;

class Labyrinth {
    static class Reader {
        final private int BUFFER_SIZE = 1024;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[1024]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }

    static Reader sc = new Reader();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String result = null;
    static char start = 'A';
    static char end = 'B';
    static char wall = '#';
    static char floor = '.';
    static boolean[][] visited;

    static TreeMap<Integer, String> resultMap = new TreeMap<>();


    public static void main(String args[]) throws IOException {
        int height = inputInt();
        int width = inputInt();

        char[][] grid = new char[height][width];

        for (int i = 0; i < height; i++) {

            String row = inputString();
            for (int j = 0; j < width; j++) {
                grid[i][j] = row.toCharArray()[j];
            }
        }

        List<Integer> list = new ArrayList<>();
        char[][] gridCopy = grid;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == 'A') {
                    bfs(gridCopy, i, j);
                    break;
                }
            }
        }

        if (resultMap.isEmpty()) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
            System.out.println(resultMap.firstKey());
            System.out.println(resultMap.get(resultMap.firstKey()));
        }

    }


    static void bfs(char[][] grid, int y, int x) {

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(y, x, new StringBuilder(), 0));
        grid[y][x] = '#';

        while (!q.isEmpty()) {
            Node coordinates = q.poll();
            int tempX = coordinates.x;
            int tempY = coordinates.y;
            StringBuilder path = coordinates.path;

            if (grid[coordinates.y][coordinates.x] == 'B') {
                resultMap.put(coordinates.distance, coordinates.path.toString());
                return;
            }

            grid[tempY][tempX] = '#';

            //look left
            if (tempX > 0 && grid[coordinates.y][coordinates.x - 1] != '#') {
                q.add(new Node(coordinates.y, coordinates.x - 1, new StringBuilder(coordinates.path).append('L'), coordinates.distance + 1));
            }
            //look up
            if (tempY > 0 && grid[coordinates.y - 1][coordinates.x] != '#') {
                q.add((new Node(coordinates.y - 1, coordinates.x, new StringBuilder(coordinates.path).append('U'), coordinates.distance + 1)));
            }
            //look right
            if (tempX < grid[tempY].length - 1 && grid[coordinates.y][coordinates.x + 1] != '#') {
                q.add(new Node(coordinates.y, coordinates.x + 1, new StringBuilder(coordinates.path).append('R'), coordinates.distance + 1));
            }
            //look down
            if (tempY < grid.length - 1 && grid[coordinates.y + 1][coordinates.x] != '#') {
                q.add(new Node(coordinates.y + 1, coordinates.x, new StringBuilder(coordinates.path).append('D'), coordinates.distance + 1));
            }
        }
    }

    static class Node {
        public int x;
        public int y;
        public StringBuilder path;
        public int distance;

        public Node(int y, int x, StringBuilder path, int distance) {
            this.y = y;
            this.x = x;
            this.path = path;
            this.distance = distance;
        }
    }


    public static int inputInt() throws IOException {
        return sc.nextInt();
    }

    public static long inputLong() throws IOException {
        return sc.nextLong();
    }

    public static double inputDouble() throws IOException {
        return sc.nextDouble();
    }

    public static String inputString() throws IOException {
        return sc.readLine();
    }

    public static void print(String a) throws IOException {
        bw.write(a);
    }

    public static void printSp(String a) throws IOException {
        bw.write(a + " ");
    }

    public static void println(String a) throws IOException {
        bw.write(a + "\n");
    }


}