import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Client2 extends JFrame {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private String clientName;

    private JTextArea chatArea;
    private JTextField inputField;

    public Client2() {
        super("Chatting - Client2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setBackground(new Color(230, 240, 255));
        chatArea.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(chatArea);
        add(scrollPane, BorderLayout.CENTER);

        inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.PLAIN, 14));
        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        JButton sendButton = new JButton("Send");
        sendButton.setFont(new Font("Arial", Font.BOLD, 14));
        sendButton.setBackground(new Color(0, 153, 255));
        sendButton.setForeground(Color.blue);
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);
        inputPanel.setBackground(new Color(230, 240, 255));
        add(inputPanel, BorderLayout.SOUTH);

        setVisible(true);

        try {
            String serverAddress = JOptionPane.showInputDialog("Enter Server IP address:");
            String hostName = JOptionPane.showInputDialog("Enter Your Hostname (Client2):");
            connectToServer(serverAddress, hostName);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error connecting to the server. Please check the server and try again.");
            System.exit(1);
        }
    }

    private void connectToServer(String serverAddress, String hostName) throws IOException {
        clientSocket = new Socket(serverAddress, 9999);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        clientName = hostName;
        out.println(clientName);

        new Thread(new IncomingReader()).start();
    }

    private void sendMessage() {
        String message = inputField.getText();
        if (!message.isEmpty()) {
            out.println(message);
            chatArea.append("[" + getCurrentTime() + "] " + clientName + ": " + message + "\n");
            inputField.setText("");
        }
    }

    private String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(new Date());
    }

    private class IncomingReader implements Runnable {
        @Override
        public void run() {
            String message;
            try {
                while ((message = in.readLine()) != null) {
                    displayIncomingMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error reading from the server. Connection lost.");
                System.exit(1);
            }
        }

        private void displayIncomingMessage(String message) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    int timestampStart = message.indexOf('[');
                    int timestampEnd = message.indexOf(']');
                    if (timestampStart != -1 && timestampEnd != -1) {
                        String timestamp = message.substring(timestampStart + 1, timestampEnd);
                        String content = message.substring(timestampEnd + 2);
                        chatArea.append("[" + timestamp + "] " + content + "\n");
                    } else {
                        chatArea.append("[" + getCurrentTime() + "] " + message + "\n");
                    }
                }
            });
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Client2();
            }
        });
    }
}