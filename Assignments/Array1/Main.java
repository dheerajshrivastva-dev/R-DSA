import java.util.*;
import java.io.*;

public class Main {

     static List<List<Integer>> missingRanges(int[] arr, int lower, int upper) {
        // code here
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        // List<List<Integer>> ans1 = new ArrayList<>();
        int l = lower;
        
        for (int i = 0; i < n; i++) {
            // System.out.println(l);
            List<Integer> temp = new ArrayList<>();
            if(arr[i] - l > 1) {
                if (i > 0) {
                    temp.add(l+1);
                } else {
                    temp.add(l);
                }
                if (arr[i] - l > 2) {
                    temp.add(arr[i] -1);
                } else {
                    temp.add(l+1);
                }
                ans.add(temp);
            }  else {
                if (i==0 && arr[i] - l == 1) {
                    temp.add(l);
                    temp.add(l);
                    ans.add(temp);
                }
            }
            l = arr[i];
        }
        if(upper - arr[n-1] > 0) {
            List<Integer> temp = new ArrayList<>();
            if (upper - arr[n-1] > 1) {
                temp.add(arr[n-1] + 1);
            } else {
                temp.add(l+1);
            }
            temp.add(upper);
            ans.add(temp);
        }
        // System.out.println(ans);
        return ans;
        
    }

    static int[] readInput(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        int lower = Integer.parseInt(br.readLine().trim());
        int upper = Integer.parseInt(br.readLine().trim());
        String[] parts = br.readLine().trim().split("\\s+");
        br.close();

        int[] arr = new int[parts.length + 2];
        arr[0] = lower;
        arr[1] = upper;
        for (int i = 0; i < parts.length; i++) {
            arr[i + 2] = Integer.parseInt(parts[i]);
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        int[] data = readInput("fileInput.txt");
        int lower = data[0];
        int upper = data[1];
        int[] arr = Arrays.copyOfRange(data, 2, data.length);

        System.out.println("lower : " + lower);
        System.out.println("upper : " + upper);
        System.out.println("arr   : " + Arrays.toString(arr));

        List<List<Integer>> result = missingRanges(arr, lower, upper);
        System.out.println("result: " + result);
    }
}
