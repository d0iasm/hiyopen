import java.io.*;
import java.util.*;
import java.net.*;

public class SimplewebClient{
	public static void main(String [] args){
		try{
			Scanner stdIn=new Scanner(System.in);
			
			System.out.print("ホスト名:");
			String host_name=stdIn.next();
			
			System.out.print("ポート番号:");
			int port=stdIn.nextInt();
			
			InetAddress addr=InetAddress.getByName(host_name);
			String str_ip=addr.getHostAddress();
			System.out.println("IPアドレス:"+str_ip);
			
			Socket socket =new Socket(addr,port);
			OutputStream ost= socket.getOutputStream();
			PrintWriter sockOut= new PrintWriter(ost);
			InputStream ist= socket.getInputStream();
			InputStreamReader istr= new InputStreamReader(ist);
			Scanner sockIn= new Scanner(istr);
			
			sockOut.println("GET / HTTP /1.1");
			
			sockOut.println("host:"+host_name);
			sockOut.println();
			sockOut.flush();
			String res= sockIn.nextLine();
			System.out.println(res);
			
			sockIn.close();
			sockOut.close();
			socket.close();
			System.out.println("糸冬了〜ノシ");
			
		
		}catch(IOException e){
			System.out.println(e);
		}
	}
}
