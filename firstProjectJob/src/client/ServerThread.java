package client;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.stream.Stream;

public class ServerThread extends Thread{

    private Socket socket;
    private InputStream in;
    private OutputStream out;

    private String error;



    public ServerThread(String host, String port) throws IOException {
        socket = new Socket(host, Integer.parseInt(port));
        in = new BufferedInputStream(new BufferedInputStream(socket.getInputStream()));
        out = new BufferedOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        System.out.println(socket);
    }

    @Override
    public void run() {
        byte[] buf = new byte[256];
        while(error == null){
            try{
                int count = in.read(buf, 0, buf.length);
                System.out.println("count = " + count);
                if(count > 0) {
                    String str = new String(buf, 0, count, StandardCharsets.UTF_8);
                    System.out.println(str);
                }
                else error = "Thread not connect *******************************";
            }
            catch (IOException e){
                error = e.getMessage();
            }
//            catch (ClassNotFoundException c){
//
//            }
        }

    }
    public void setDataServer(Integer[] buf, int len){
        try{
            int i = 0;
            while(len > 0) {
                out.write(buf[i++]);
                len--;
            }
            out.flush();
        }
        catch (IOException e){
            System.out.println("setDataServer " + e.getMessage());
        }
    }

    public String getError() {
        return error;
    }
}
