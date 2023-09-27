package LabTask;

import java.io.*;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.*;

public class labtask {
    public static void main(String arg[]) throws Exception {
        HttpServer ob = HttpServer.create(new InetSocketAddress(8000), 0);
        ob.createContext("/name", new myHandler());
        ob.createContext("/id", new myIdHandler());
        ob.setExecutor(null);
        ob.start();
    }

    static class myHandler implements HttpHandler {
        public void handle(HttpExchange t) throws IOException {
            String htmlResponse = "<!DOCTYPE html>" +
                    "<html>" +
                    "<head>" +
                    "<title>HTTP Server Name Route</title>" +
                    "<link href=\"https://cdn.jsdelivr.net/npm/tailwindcss@2.2.16/dist/tailwind.min.css\" rel=\"stylesheet\">" +
                    "</head>" +
                    "<body>" +
                    "<h1 class=\"text-4xl text-center font-bold text-blue-500\">This is Me Toufiqul Islam Tanmoy :)</h1>" +
                    "</body>" +
                    "</html>";

            byte[] res = htmlResponse.getBytes();
            t.sendResponseHeaders(200, res.length);
            OutputStream os = t.getResponseBody();
            os.write(res);
            os.close();
        }
    }


    static class myIdHandler implements HttpHandler {
        public void handle(HttpExchange t) throws IOException {
            String htmlResponse = "<!DOCTYPE html>" +
                    "<html>" +
                    "<head>" +
                    "<title>HTTP Server Task</title>" +
                    "<link href=\"https://cdn.jsdelivr.net/npm/tailwindcss@2.2.16/dist/tailwind.min.css\" rel=\"stylesheet\">" +
                    "</head>" +
                    "<body>" +
                    "<h1 class=\"h-[100vh] flex items-center justify-center text-4xl text-center font-bold text-indigo-500\">This is My ID: 193311033 :)</h1>" +
                    "</body>" +
                    "</html>";

            byte[] res = htmlResponse.getBytes();
            t.sendResponseHeaders(200, res.length);
            OutputStream os = t.getResponseBody();
            os.write(res);
            os.close();
        }
    }
}
