package programs;

//        Sample Input
//        5
//        1 -2 4 -5 1
//        Sample Output
//        9

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NegativeSubarrays {

    public static void main(String[] args) throws Exception{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        int a[]=new int[n];
        int i=0,count=0,sum=0;
        StringTokenizer st=new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            a[i]=Integer.parseInt(st.nextToken());
            i++;
        }
        for(i=0;i<a.length;i++){
            sum=a[i];
            if(sum<0)
                count++;
            for(int j=i+1;j<a.length;j++){
                sum+=a[j];
                if(sum<0)
                    count++;
            }
        }
        System.out.println(count);
    }
}
