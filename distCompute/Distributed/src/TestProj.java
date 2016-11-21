import java.io.IOException;
import java.net.InetAddress;

public class TestProj 
{
	public static void main(String[] args) 
	{		
		InetAddress clientIP = null;
		String svrRouterIP = "192.168.1.15";
		int svrRouterPort = 5555;
		
		
		// Start the client
		System.out.println("Starting client");
		TCPClient client = new TCPClient(svrRouterIP);
		try 
		{
			client.start();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		
		// Start the server
		System.out.println("Starting server");
		TCPServer server = new TCPServer(svrRouterIP);
		try 
		{ 
			server.start(); 
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		
		// Start the server router
		System.out.println("Starting server router");
		TCPServerRouter router = new TCPServerRouter(svrRouterPort);
		try
		{
			router.start();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}	
	}
}
