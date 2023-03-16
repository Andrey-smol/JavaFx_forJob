import client.ServerThread;

import java.io.IOException;

public class ConnectToServer {

    public static boolean connectToServer(ServerThread serverThread, ParamServer paramServer){
        if(serverThread == null || serverThread.getError() != null) {
            try {
                if(serverThread != null) serverThread.join();
                serverThread = new ServerThread(paramServer.getIpHost(), paramServer.getPort());
                serverThread.start();
            } catch (IOException e) {
                serverThread = null;
                return false;
            }
            catch (InterruptedException e){
                serverThread = null;
                return false;
            }
        }
        return true;
    }
}
