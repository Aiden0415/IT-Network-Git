
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private List<ClientHandler> clients = new ArrayList<>();
    private ServerGUI gui;

    public Server() {
        this.gui = new ServerGUI(this);
    }

    public static void main(String[] args) {
        new Server().startServer(9999);
    }

    public void startServer(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            gui.appendMessage("Server started. Waiting for Clients...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                gui.appendMessage("Client Connected.");

                ClientHandler clientHandler = new ClientHandler(clientSocket, this);
                clients.add(clientHandler);
                new Thread(clientHandler).start();

                updateClientList();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void broadcastMessage(String message, ClientHandler sender) {
        for (ClientHandler client : clients) {
            if (client != sender) {
                client.sendMessage(message);
                
            }
        }
        updateClientList();
    }

    public void removeClient(ClientHandler client) {
        clients.remove(client);
        updateClientList();
    }

    private void updateClientList() {
        String[] clientNames = getConnectedClientNames();
        gui.updateClientList(clientNames);
    }

    private String[] getConnectedClientNames() {
        List<String> clientNames = new ArrayList<>();
        for (ClientHandler client : clients) {
            clientNames.add(client.getClientName());
        }
        return clientNames.toArray(new String[0]);
    }

    public void stopServer() {
        return;
    }
}


