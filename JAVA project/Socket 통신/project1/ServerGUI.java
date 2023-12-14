
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerGUI extends JFrame {
    private JTextArea logArea;
    private JList<String> clientList;
    private DefaultListModel<String> clientListModel;
    private Server server;

    public ServerGUI(Server server) {
        this.server = server;
        createUI();
    }

    private void createUI() {
        setTitle("Server Log");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        logArea = new JTextArea();
        logArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(logArea);

        clientListModel = new DefaultListModel<>();
        clientList = new JList<>(clientListModel);
        JScrollPane clientScrollPane = new JScrollPane(clientList);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(clientScrollPane, BorderLayout.EAST);

        add(panel, BorderLayout.CENTER);


        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("Server power");
        menuBar.add(fileMenu);


        JMenuItem exitMenuItem = new JMenuItem("Down");
        fileMenu.add(exitMenuItem);


        exitMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    server.stopServer();
                    appendMessage("Server stopped.");
                    System.exit(0);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton stopButton = new JButton("Stop Server");
        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    server.stopServer();
                    appendMessage("Server stopped.");
                    System.exit(0);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton startButton = new JButton("Resume server");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                server.startServer(9999);
                appendMessage("Server resumed");
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(stopButton);
        buttonPanel.add(startButton);

        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void appendMessage(String message) {
        SwingUtilities.invokeLater(() -> logArea.append(message + "\n"));
    }

    public void updateClientList(String[] clientNames) {
        SwingUtilities.invokeLater(() -> {
            clientListModel.clear();
            for (String name : clientNames) {
                clientListModel.addElement(name);
            }
        });
    }

    public static void main(String[] args) {
        new ServerGUI(new Server());
    }
}