import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int commandCount = Integer.parseInt(br.readLine());
        String command;
        myStack stack = new myStack();
        for (int i = 0; i < commandCount; i++) {
            st = new StringTokenizer(br.readLine());
            command = st.nextToken();
            switch (command) {
                case "push_back":
                    stack.push_back(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_back":
                    stack.pop_back();
                    break;
                case "get":
                    sb.append(stack.get(Integer.parseInt(st.nextToken()))).append("\n");
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

class myStack {
    int size;
    int[] data;

    public myStack() { // 초기화
        size = -1; // 마지막 원소의 위치를 의미함
        data = new int[10000];
    }

    public void push_back(int num) {
        size++; // 마지막 원소 위치 늘리고
        data[size] = num; // 쏙
    }

    public void pop_back() {
        size--;
    }

    public int size() {
        return size + 1;
    }

    public int get(int index) {
        return data[index-1];
    }
}