import java.io.*;  
import java.net.*;

public class MyClient {  
    public static void main(String[] args) {  
        try{      
            Socket s=new Socket("localhost",8080);  
            DataInputStream dis=new DataInputStream(s.getInputStream()); //reads client message
            DataOutputStream dout=new DataOutputStream(s.getOutputStream());  //sends a message
            // sending 1st message
            dout.writeUTF("HELO");  
            dout.flush();  
            // reading 1st client message
            String  str=(String)dis.readUTF();  
            System.out.println("message= "+str);
            // sending 2nd message
            dout.writeUTF("BYE");
            dout.flush(); 
            //reading 2nd message
            String  str3=(String)dis.readUTF();  
            System.out.println("message= "+str3);  
            dout.close();
            s.close();  
        }
        catch(Exception e){System.out.println(e);}  
    }  
}  