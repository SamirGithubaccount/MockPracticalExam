import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class client2 {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket s=new Socket("localhost", 8080);
        DataInputStream Is= new DataInputStream(s.getInputStream());
        DataOutputStream Os= new DataOutputStream(s.getOutputStream());
        String s1="",s2;
        //Scanner Sc=new Scanner(System.in);
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        while(!s1.equals("bye")){
            s1=br.readLine();
            Os.writeUTF(s1);
            Os.flush();
            s2=(String) Is.readUTF();
            System.out.println("Message From Server :"+s2);
        }
        Is.close();
        Os.close();
        s.close();
    }
}
