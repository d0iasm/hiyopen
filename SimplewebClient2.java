import java.io.*;
import java.util.*;
import java.net.*;

public class SimplewebClient2{
	public static void main(String [] args){
		try{
			Scanner stdIn=new Scanner(System.in);
			System.out.print("URL:");
			String str_url= stdIn.next();
			URL url = new URL(str_url);
			
			System.out.println("主な属性の表示");
			String protocol=url.getProtocol();
			System.out.println("プロトコル:"+protocol);
			String host_name=url.getHost();
			System.out.println("ホスト名:"+host_name);
			String file_name=url.getFile();
			System.out.println("ファイル名:"+file_name);
			
			int port =url.getPort();
			System.out.println("ポート番号:"+port);
			if(port==-1){
				System.out.println("80番に設定しました");
				port=80;
			}
			
			InetAddress addr =InetAddress.getByName(host_name);
			String str_ip =addr.getHostAddress();
			System.out.println("IPアドレス:"+str_ip);
			
			Socket socket = new Socket(addr,port);
			
			OutputStream ost =socket.getOutputStream();
			PrintWriter sockOut =new PrintWriter(ost);
			
			InputStream ist =socket.getInputStream();
			InputStreamReader istr =new InputStreamReader(ist);
			Scanner sockIn =new Scanner(istr);
			
			sockOut.println("GET "+file_name+" HTTP/1.1");
			sockOut.println("host:"+host_name);
			sockOut.println();
			sockOut.flush();
			
			while(sockIn.hasNext()){
				String res = sockIn.nextLine();
				System.out.println(res);
				if(res.equals("</html>")||res.equals("</HTML>"))
					break;
					}
					
			sockIn.close();
			sockOut.close();
			socket.close();
			System.out.println("糸冬了〜ノシ");
			
			
			
			}catch(IOException e){
			System.out.println(e);
		}
	}
}
