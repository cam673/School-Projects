import java.net.*;
import java.util.Scanner;
import java.io.*;
public class updClient
{
   public static void main(String args[])
   {
	  Scanner scan = new Scanner(System.in);
      DatagramSocket aSocket = null;
      try
      {
         aSocket = new DatagramSocket();
         int choice = 0;
        while(choice!=2)
         {
        	 System.out.println(""+ "Please input your message, hit 1 to start or 2 to quit.");
        	 choice=scan.nextInt();
        	 if(choice==1)
        	 {
        		 System.out.println("Please input your message.");
        		 args[0]=scan.next();
        		 System.out.println("Please input your ip address");
        		 args[1]=scan.next();
        		 System.out.println("Please input your port number");
        		 args[2]=scan.next(); 
        	 }
        	 else
        	 {
        		 System.out.println("Goodbye");
        		 break;
        	 }
        	  byte[] m = args[0].getBytes();
              InetAddress aHost = InetAddress.getByName(args[1]);
              int serverPort = Integer.parseInt(args[2]);
              DatagramPacket request = new DatagramPacket(m,m.length, aHost, serverPort);
              aSocket.send(request);
              byte[] buffer = new byte[1000];
              DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
              aSocket.receive(reply);
              System.out.println("Reply: " + new String(reply.getData()));
           }
        	}catch(SocketException e)
           {
         	  System.out.println("Socket: " + e.getMessage());
           }catch(IOException e)
           {
         	  System.out.println("IO: " + e.getMessage());
           }finally 
            {
         	  if(aSocket != null)
         		  {
         		  aSocket.close();
         		  }
            }
         }
   }

      