
    import java.awt.*;
import javax.swing.*;

public class CaesarCipherGUI extends JFrame {
    private JTextArea inputArea;
    private JTextField shiftField;
    private JButton encryptButton;
    private JButton decryptButton;
    private JTextArea resultArea;

    public CaesarCipherGUI() {
        setTitle("CipherShift - Caesar Cipher Tool");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 350);
        setLocationRelativeTo(null);

        // Create components
        JLabel inputLabel = new JLabel("Enter message:");
        inputArea = new JTextArea(4, 30);
        inputArea.setLineWrap(true);
        inputArea.setWrapStyleWord(true);
        JScrollPane inputScroll = new JScrollPane(inputArea);

        JLabel shiftLabel = new JLabel("Shift value:");
        shiftField = new JTextField(5);

        encryptButton = new JButton("Encrypt");
        decryptButton = new JButton("Decrypt");

        JLabel resultLabel = new JLabel("Result:");
        resultArea = new JTextArea(5, 30);
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);
        resultArea.setEditable(false);
        JScrollPane resultScroll = new JScrollPane(resultArea);

        // Layout setup
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(inputLabel, gbc);

        gbc.gridx = 1;
        panel.add(inputScroll, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(shiftLabel, gbc);

        gbc.gridx = 1;
        panel.add(shiftField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(encryptButton, gbc);

        gbc.gridx = 1;
        panel.add(decryptButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(resultLabel, gbc);

        gbc.gridx = 1;
        panel.add(resultScroll, gbc);

        add(panel);

        // Button events
        encryptButton.addActionListener(e -> processText(true));
        decryptButton.addActionListener(e -> processText(false));
    }

    private void processText(boolean encrypt) {
        String text = inputArea.getText();
        int shift;
        try {
            shift = Integer.parseInt(shiftField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid integer for shift value.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!encrypt) {
            shift = -shift;
        }

        String result = caesarCipher(text, shift);
        resultArea.setText(result);
    }

    private String caesarCipher(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isUpperCase(c)) {
                char ch = (char) (((c - 'A' + shift + 26) % 26) + 'A');
                result.append(ch);
            } else if (Character.isLowerCase(c)) {
                char ch = (char) (((c - 'a' + shift + 26) % 26) + 'a');
                result.append(ch);
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CaesarCipherGUI app = new CaesarCipherGUI();
            app.setVisible(true);
        });
    }
}


