import client.ServerThread;

public class LinkServer extends Thread{

    private ServerThread serverThread;

    public LinkServer(ServerThread serverThread) {
        this.serverThread = serverThread;
    }

    @Override
    public void run() {
        while (true){
            try{
                Thread.sleep(5000);
                Integer[] buf = {0xAA, 0x55, 1, 0, 0, 255, 255};
                serverThread.setDataServer(buf, buf.length);
            }
            catch (InterruptedException e){

            }
        }
    }
}
