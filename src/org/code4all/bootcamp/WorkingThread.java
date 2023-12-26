package org.code4all.bootcamp;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WorkingThread implements Runnable {

    private static final Logger logger = Logger.getLogger(WebServer.class.getName());

    Socket clientSkt;
    int clientNb;

    String keyword = "GET";
    String okResponse = "HTTP/1.1 200 OK \r\n";
    String error404 = "HTTP/1.1 404 Not Found \r\n";
    String blankLine = "\r\n";

    public WorkingThread(Socket clientSkt, int clientNb){
        this.clientSkt = clientSkt;
        this.clientNb = clientNb;
    }

    @Override
    public void run() {

        logger.log(Level.INFO ,"Working thread: " + Thread.currentThread().getName());
        logger.log(Level.INFO, "Host connected: " + clientSkt.getInetAddress().getHostAddress() + ":" + clientSkt.getLocalPort());

        while (true) {
            InputStreamReader msgIn = null;
            try {
                msgIn = new InputStreamReader(clientSkt.getInputStream());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            BufferedReader bfrdReader = new BufferedReader(msgIn);

            StringBuilder request = new StringBuilder();

            String line;
            try {
                line = bfrdReader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


            while (!line.isBlank()) {
                request.append(line + "\r\n");
                try {
                    line = bfrdReader.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            System.out.println("== REQUEST IN ==");
            System.out.println(request);

            String fl = request.toString().split("\n")[0];
            //System.out.println(fl);
            String verb = fl.split(" ")[0];
            String resource = fl.split(" ")[1];
            //System.out.println(verb + " " + resource);

            if (verb.equals(keyword)) {
                System.out.println("== RESPONDING GET REQUEST ==");
                System.out.println("REQUEST TYPE: " + fl);
                if (resource.equals("/test.txt")) {

                    OutputStream clientOutput = null;
                    try {
                        clientOutput = clientSkt.getOutputStream();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        clientOutput.write(okResponse.getBytes());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        clientOutput.write(blankLine.getBytes());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        clientOutput.write(new FileInputStream("Resources/test.txt").readAllBytes());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        clientOutput.flush();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }


                } else if (resource.equals("/index.html")) {

                    OutputStream clientOutput = null;
                    try {
                        clientOutput = clientSkt.getOutputStream();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        clientOutput.write(okResponse.getBytes());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        clientOutput.write(blankLine.getBytes());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        clientOutput.write(new FileInputStream("Resources/index.html").readAllBytes());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        clientOutput.flush();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }


                } else if (resource.equals("/snoop.jpg")) {

                    OutputStream clientOutput = null;
                    try {
                        clientOutput = clientSkt.getOutputStream();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        clientOutput.write(okResponse.getBytes());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        clientOutput.write(blankLine.getBytes());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        clientOutput.write(new FileInputStream("Resources/snoop.jpg").readAllBytes());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        clientOutput.flush();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }


                } else if (resource.equals("/doubleM")) {

                    OutputStream clientOutput = null;
                    try {
                        clientOutput = clientSkt.getOutputStream();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        clientOutput.write(okResponse.getBytes());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        clientOutput.write(blankLine.getBytes());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        clientOutput.write(new FileInputStream("Resources/rickRoss.jpg").readAllBytes());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        clientOutput.flush();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }


                } else if (resource.equals("/uncleSnoop")) {

                    OutputStream clientOutput = null;
                    try {
                        clientOutput = clientSkt.getOutputStream();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        clientOutput.write(okResponse.getBytes());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        clientOutput.write(blankLine.getBytes());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        clientOutput.write(new FileInputStream("Resources/snoop.jpg").readAllBytes());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        clientOutput.flush();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }


                } else if (resource.equals("favicon.ico")) {

                    OutputStream clientOutput = null;
                    try {
                        clientOutput = clientSkt.getOutputStream();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        clientOutput.write(okResponse.getBytes());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        clientOutput.write(blankLine.getBytes());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        clientOutput.write(new FileInputStream("Resources/favicon.ico").readAllBytes());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        clientOutput.flush();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }


                } else {

                    OutputStream clientOutput = null;
                    try {
                        clientOutput = clientSkt.getOutputStream();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        clientOutput.write(error404.getBytes());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        clientOutput.write(blankLine.getBytes());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        clientOutput.flush();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                }
            }

            System.out.println("== REQUEST FINISHED ==");
            break;
        }
    }



    }
