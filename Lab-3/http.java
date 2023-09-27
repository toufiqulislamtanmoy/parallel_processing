import java.io.*;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.*;

public class http
{
	public static void main(String arg[]) throws Exception
	{
		HttpServer ob = HttpServer.create(new InetSocketAddress(8000),0);
		ob.createContext("/", new nameHandler());
		ob.setExecutor(null);
		ob.start();
	}
	
	static class nameHandler implements HttpHandler
	{
		public void handle(HttpExchange t) throws IOException
		{
			byte [] res = "<h1>This is a heading</h1><p>This is a paragraph</p>".getBytes();
			t.sendResponseHeaders(200,res.length);
			OutputStream os = t.getResponseBody();
			os.write(res);
			os.close();
		}
	}

}
