import java.net.*;
import java.io.*;
import java.util.Scanner;

public class UDPServer{
	public static void main(String args[]) {
		 Scanner scan = new Scanner(System.in);
		DatagramSocket aSocket = null;
		try {
			System.out.println("please input port number");
			args[0]= scan.next();
			int serverPort = Integer.parseInt(args[0]);
			aSocket = new DatagramSocket(serverPort);
			byte[] buffer = new byte [1000];
			while(true) {
				DatagramPacket request = new DatagramPacket(buffer,buffer.length);
				aSocket.receive(request);
				System.out.println("Recieved message: "+ new String(request.getData()));
				DatagramPacket reply = new	 DatagramPacket(request.getData(),
						request.getLength(), request.getAddress(), request.getPort());
				aSocket.send(reply);
				buffer = new byte[1000];
			}
		}catch(SocketException e) {System.out.println("Socket: " + e.getMessage());
	}catch(IOException e) {System.out.println("IO: " + e.getMessage());}
	finally {if(aSocket != null) aSocket.close();}
	}
}