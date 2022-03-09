import java.io.*;  
import java.net.*;  
public class MyServer{  
    public static void main(String[] args){  
        try{  
            ServerSocket ss=new ServerSocket(8080);  
            Socket s=ss.accept();//establishes connection   
            DataInputStream dis=new DataInputStream(s.getInputStream()); //reads client message
            DataOutputStream dout=new DataOutputStream(s.getOutputStream()); //sends a message

            // reading 1st client message
            String  str=(String)dis.readUTF();  
            System.out.println("message= "+str);
            // sending 1st message
            dout.writeUTF("G'DAY");  
            dout.flush();  
            //reading 2nd message
            String  str2=(String)dis.readUTF();  
            System.out.println("message= "+str2);
            // sending 2nd message
            dout.writeUTF("BYE");  
            dout.flush(); 
            dout.close();  //output message stream closed
            ss.close();  //socket connection closed
        }
        catch(Exception e){System.out.println(e);
        }  
    }  
}  