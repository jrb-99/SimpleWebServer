package org.code4all.bootcamp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WebServer {

    private static final Logger logger = Logger.getLogger(WebServer.class.getName());

    public static void main(String[] args) throws IOException {

        int port = 8090;
        int tCount = 0;
        String keyword = "GET";
        String okResponse = "HTTP/1.1 200 OK \r\n";
        String error404 = "HTTP/1.1 404 Not Found \r\n";
        String blankLine = "\r\n";

        ServerSocket svSocket = new ServerSocket(port);
        logger.log(Level.INFO, "Server started. Listening at port: " + port);

        while(true) {
            tCount++;

            Socket clientSkt = svSocket.accept();
            logger.log(Level.INFO ,"Serving client nº: " + tCount);

            ExecutorService newPool = Executors.newCachedThreadPool();


            WorkingThread wT = new WorkingThread(clientSkt, tCount);
            //Thread thread = new Thread(wT);
            newPool.submit(wT);

            newPool.shutdown();

            //thread.start();
        }

            /*
            InputStreamReader msgIn = new InputStreamReader(clientSkt.getInputStream());


            BufferedReader bfrdReader = new BufferedReader(msgIn);

            StringBuilder request = new StringBuilder();

            String line;
            line = bfrdReader.readLine();

            while(!line.isBlank()){
                request.append(line + "\r\n");
                line = bfrdReader.readLine();
            }

            System.out.println("== REQUEST IN ==");
            System.out.println(request);

            String fl = request.toString().split("\n")[0];
            //System.out.println(fl);
            String verb = fl.split(" ")[0];
            String resource = fl.split(" ")[1];
            //System.out.println(verb + " " + resource);
            
            if(verb.equals(keyword)){
                System.out.println("== RESPONDING GET REQUEST ==");
                if(resource.equals("/test.txt")){
                    
                    OutputStream clientOutput = clientSkt.getOutputStream();
                    clientOutput.write(okResponse.getBytes());
                    clientOutput.write(blankLine.getBytes());
                    clientOutput.write(new FileInputStream("Resources/test.txt").readAllBytes());
                    clientOutput.flush();
                    break;
                    
                } else if(resource.equals("/index.html")){
                    
                    OutputStream clientOutput = clientSkt.getOutputStream();
                    clientOutput.write(okResponse.getBytes());
                    clientOutput.write(blankLine.getBytes());
                    clientOutput.write(new FileInputStream("Resources/index.html").readAllBytes());
                    clientOutput.flush();
                    break;
                    
                } else if (resource.equals("/snoop.jpg")) {

                    OutputStream clientOutput = clientSkt.getOutputStream();
                    clientOutput.write(okResponse.getBytes());
                    clientOutput.write(blankLine.getBytes());
                    clientOutput.write(new FileInputStream("Resources/snoop.jpg").readAllBytes());
                    clientOutput.flush();
                    break;
                    
                } else if (resource.equals("/doubleM")) {

                    OutputStream clientOutput = clientSkt.getOutputStream();
                    clientOutput.write(okResponse.getBytes());
                    clientOutput.write(blankLine.getBytes());
                    clientOutput.write(new FileInputStream("Resources/rickRoss.jpg").readAllBytes());
                    clientOutput.flush();
                    break;

                } else if(resource.equals("/uncleSnoop")){

                    OutputStream clientOutput = clientSkt.getOutputStream();
                    clientOutput.write(okResponse.getBytes());
                    clientOutput.write(blankLine.getBytes());
                    clientOutput.write(new FileInputStream("Resources/snoop.jpg").readAllBytes());
                    clientOutput.flush();
                    break;

                } else if (resource.equals("favicon.ico")) {

                    OutputStream clientOutput = clientSkt.getOutputStream();
                    clientOutput.write(okResponse.getBytes());
                    clientOutput.write(blankLine.getBytes());
                    clientOutput.write(new FileInputStream("Resources/favicon.ico").readAllBytes());
                    clientOutput.flush();
                    break;

                } else {

                    OutputStream clientOutput = clientSkt.getOutputStream();
                    clientOutput.write(error404.getBytes());
                    clientOutput.write(blankLine.getBytes());
                    clientOutput.flush();
                    break;
                }
            }

            System.out.println("== REQUEST FINISHED ==");
            clientSkt.close();

        }
        */

    }
}
