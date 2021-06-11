//import java.io.DataInput;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
//import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
//import java.util.Scanner;

import java.io.InputStreamReader;

public class server2 {
    public static void main(String[] args) throws Exception {
        ServerSocket S_S=new ServerSocket(8080);
        Socket s=S_S.accept();
        System.out.println("Connection Established---------------");
        String s1="",s2;
        DataOutputStream Os=new DataOutputStream(s.getOutputStream());
        DataInputStream Is=new DataInputStream(s.getInputStream());
        //Scanner Sc=new Scanner(System.in);
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        while(!s1.equals("bye")){
            s1=(String)Is.readUTF();
            System.out.println("Message from Client-"+s1);
            s2=br.readLine();
            Os.writeUTF(s2);
            Os.flush();
        }
        Is.close();
        Os.close();
        s.close();
    }
}
