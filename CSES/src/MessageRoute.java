import java.io.*;
import java.util.*;

class MessageRoute
{
    static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }
        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }
        public long nextLong() throws IOException
        {
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
        public double nextDouble() throws IOException
        {
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
            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }
            if (neg)
                return -ret;
            return ret;
        }
        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
    static Reader sc=new Reader();
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String args[])throws IOException
    {
        int computers = inputInt();
        int networks = inputInt();
        int destination = computers;

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<=computers; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<networks; i++){
            int a = inputInt();
            int b = inputInt();

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        PriorityQueue<Integer> q = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        int[] distance = new int[computers+1];
        boolean[] visited = new boolean[computers+1];

        q.add(1);
        List<Set<Integer>> answer;
        answer = new ArrayList<>();
        for(int i=0; i<=computers; i++){
            answer.add(new HashSet<>());
        }

        while(!q.isEmpty()){
            int s = q.poll();

            for(int i : adj.get(s)){
                if(visited[i])
                    continue;
                visited[i] = true;
                if(answer.get(s).isEmpty()){
                    answer.get(i).add(s);
                    answer.get(i).add(i);
                }
                else{
                    answer.get(i).addAll(answer.get(s));
                    answer.get(i).add(s);
                    answer.get(i).add(i);
                }
                q.add(i);
            }
        }

        if(answer.get(computers).isEmpty()){
            System.out.println("IMPOSSIBLE");
        }
        else{
            System.out.println(answer.get(computers).size());
            for(int i : answer.get(computers)){
                System.out.print(i + " ");
            }
        }

    }

    class Node implements Comparable<Node>{

        public int id;
        public int distance;

        @Override
        public int compareTo(Node o) {
            if(this.distance > o.distance)
                return 1;
            else if(o.distance > this.distance)
                return -1;
            else
                return 0;
        }
    }
    public static int inputInt()throws IOException
    {
        return sc.nextInt();
    }
    public static long inputLong()throws IOException
    {
        return sc.nextLong();
    }
    public static double inputDouble()throws IOException
    {
        return sc.nextDouble();
    }
    public static String inputString()throws IOException
    {
        return sc.readLine();
    }
    public static void print(String a)throws IOException
    {
        bw.write(a);
    }
    public static void printSp(String a)throws IOException
    {
        bw.write(a+" ");
    }
    public static void println(String a)throws IOException
    {
        System.out.println(a+"\n");
    }

    public static void println(int a){
        System.out.println(a);
    }
}