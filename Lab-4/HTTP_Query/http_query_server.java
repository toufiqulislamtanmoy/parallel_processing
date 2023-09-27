import com.sun.net.httpserver.*;
import java.net.InetSocketAddress;
import java.io.*;

public class http_query_server
{
	public static int a = 0;
	public static int b = 0;
	public static int sum = 0;
	static class FirstValue implements HttpHandler
	{
		public void handle(HttpExchange he) throws IOException
		{
			a = Integer.parseInt(he.getRequestURI().getQuery());
			String s1 = "A = " + (a);
			he.sendResponseHeaders(200,s1.length());
			OutputStream os = he.getResponseBody();
			os.write(s1.getBytes());
			os.close();
		}	
	}
	static class SecondValue implements HttpHandler
	{
		public void handle(HttpExchange he) throws IOException
		{
			b = Integer.parseInt(he.getRequestURI().getQuery());
			String s1 = "B = " + (b);
			he.sendResponseHeaders(200,s1.length());
			OutputStream os = he.getResponseBody();
			os.write(s1.getBytes());
			os.close();
		}	
	}
	static class SumOfValue implements HttpHandler
	{
		public void handle(HttpExchange he) throws IOException
		{
			
			String s1 = "Total= " + (a+b);
			he.sendResponseHeaders(200,s1.length());
			OutputStream os = he.getResponseBody();
			os.write(s1.getBytes());
			os.close();
		}	
	}
	
	public static void main(String arg[]) throws Exception
	{
		HttpServer s = HttpServer.create(new InetSocketAddress(8000),0);
		s.createContext("/a", new FirstValue());
		s.createContext("/b", new SecondValue());
		s.createContext("/c", new SumOfValue());
		s.setExecutor(null);
		s.start();
		System.out.println("HTTP Server is running...");
	}
}
