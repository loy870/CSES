package Archive;

import java.io.*;
import java.util.*;

public class ConcertTickets {

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
    static Reader sc = new Reader();
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

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
        bw.write(a+"\n");
    }


    public static void main(String[] args) throws IOException {
        int numTickets = inputInt();
        int numCustomers = inputInt();

        List<Integer> ticketPrices = new ArrayList<>();

        for(int i = 0; i<numTickets; i++){
            ticketPrices.add(inputInt());
        }

        List<Integer> customerPrices = new ArrayList<>();
        for(int i = 0; i<numCustomers; i++){
            customerPrices.add(inputInt());
        }

        List<Integer> result = new ConcertTickets().calculateTickets(numTickets, numCustomers, ticketPrices, customerPrices);

        for(int e: result)
            System.out.println(e);

    }

    public List<Integer> calculateTickets(int numTickets, int numCustomers, List<Integer> ticketPrices, List<Integer> customerPrices){
        List<Integer> result = new ArrayList<>();

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int i = 0; i< ticketPrices.size(); i++){
            if(!map.containsKey(ticketPrices.get(i))){
                map.put(ticketPrices.get(i), 1);
            }
            else{
                int temp = map.get(ticketPrices.get(i));
                map.put(ticketPrices.get(i), temp+1);
            }
        }

        for(int customer: customerPrices){
            Map.Entry<Integer, Integer> entry = map.lowerEntry(customer);
            if(entry == null)
                result.add(-1);
            else{
                result.add(entry.getKey());
                if(entry.getValue() == 1)
                    map.remove(entry.getKey());
                else{
                    map.put(entry.getKey(), entry.getValue() -1);
                }
            }
        }



        return result;
    }

}