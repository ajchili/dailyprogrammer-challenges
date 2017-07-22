import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class Main extends JFrame {
    
    public Main() {
        super("Rövarspråket Translator");
        setSize(400, 250);
        setResizable(false);
        setLayout(new GridLayout(2, 1));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JTextArea text = new JTextArea();
        JScrollPane scroll = new JScrollPane(text);
        JTextArea translation = new JTextArea();
        JScrollPane scrollTranslation = new JScrollPane(translation);
        
        text.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                translation.setText(translateString(text.getText()));
            }

            @Override
            public void keyPressed(KeyEvent e) {
                translation.setText(translateString(text.getText()));
            }

            @Override
            public void keyReleased(KeyEvent e) {
                translation.setText(translateString(text.getText()));
            }
        });
        
        translation.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                text.setText(decodeString(translation.getText()));
            }

            @Override
            public void keyPressed(KeyEvent e) {
                text.setText(decodeString(translation.getText()));
            }

            @Override
            public void keyReleased(KeyEvent e) {
                text.setText(decodeString(translation.getText()));
            }
        });
        
        add(scroll);
        add(scrollTranslation);
        
        setVisible(true);
    }
    
    public String translateString(String text) {
        String translation = "";
        String testText = text.toUpperCase();
        for (int i = 0; i < text.length(); i++) {
            char c = testText.charAt(i);
            if (c != 'A' && c != 'E' && c != 'I' && c !=  'O' && c != 'U' && c != 'Y' && c != 'Å' && c != 'Ä' && c != 'Ö' && c != ' ' && c != '\'' && c != '\"' && c != '!' && c!= '?' && c != '\n')
                translation += text.charAt(i) + "o" + text.toLowerCase().charAt(i);
            else 
                translation += text.charAt(i);
        }
        return translation;
    }
    
    public String decodeString(String text) {
        String translation = "";
        String testText = text.toUpperCase();
        for (int i = 0; i < text.length(); i++) {
            char c = testText.charAt(i);
            if (c != 'A' && c != 'E' && c != 'I' && c !=  'O' && c != 'U' && c != 'Y' && c != 'Å' && c != 'Ä' && c != 'Ö' && c != ' ' && c != '\'' && c != '\"' && c != '!' && c!= '?' && c != '\n') {
                translation += text.charAt(i);
                i += 2;
            } else 
                translation += text.charAt(i);
        }
        return translation;
    }
    
    public static void main(String[] args) {
        new Main();
    }
}
