import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import java.awt.datatransfer.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("D2R 방이름생성기(by나우죽 ver1.0.0)");
        frame.setBounds(500, 500, 300, 100);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });


        JTextField textfield = new JTextField("diago01");
        Font font1 = new Font("SansSerif", Font.BOLD, 20);
        textfield.setSize(100, 20);
        textfield.setFont(font1);
        //jt.setLocation(110,70);
        frame.add(textfield, BorderLayout.CENTER);

        JButton btn1 = new JButton("Create NextName");
        frame.add(btn1, BorderLayout.EAST);

        JCheckBox random1 = new JCheckBox("랜덤생성", false);
        frame.add(random1, BorderLayout.NORTH);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btn1.addActionListener(event -> {
            String getName = textfield.getText();
            String getNo = getName.replaceAll("[^0-9]", "");
            String getStr = getName.replaceAll("[0-9]", "");

            int lenNo = getNo.length();
            int nextNum = Integer.parseInt(getNo) + 1;
            String nextNoStr;
            String randomNoStr;
            if (lenNo == 2) {
                nextNoStr = String.format("%02d", nextNum);
                randomNoStr = String.format("%02d", (int) (Math.random() * 100));
            } else if (lenNo == 3) {
                nextNoStr = String.format("%03d", nextNum);
                randomNoStr = String.format("%03d", (int) (Math.random() * 1000));
            } else if (lenNo == 4) {
                nextNoStr = String.format("%04d", nextNum);
                randomNoStr = String.format("%04d", (int) (Math.random()* 1000));
            } else {
                nextNoStr = String.format("%d", nextNum);
                randomNoStr = String.format("%03d", (int) (Math.random() * 1000));
            }

            String resultStr;
            if (random1.isSelected()) {
                resultStr = String.format("%s%s", getStr, randomNoStr);
            } else {
                resultStr = String.format("%s%s", getStr, nextNoStr);
            }

            textfield.setText(resultStr);

            StringSelection data = new StringSelection(resultStr);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(data, data);
        });
    }
}
