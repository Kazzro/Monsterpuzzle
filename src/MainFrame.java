import Panel.PuzzlePanel;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    public MainFrame() {
        setTitle("Puzzle Solver");
        setSize(460, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        PuzzlePanel puzzlePanel = new PuzzlePanel("");
        add(puzzlePanel, BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menuChoosePuzzle = new JMenu("Puzzle wählen");
        menuBar.add(menuChoosePuzzle);

        String[] puzzlePaths = {
                "puzzle0.txt",
                "puzzle1.txt",
                "puzzle2.txt",
                "puzzle3.txt"

        };


        ActionListener puzzleMenuListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JMenuItem menuItem = (JMenuItem) e.getSource();
                String selectedPath = menuItem.getText();
                puzzlePanel.setPuzzle(selectedPath);
            }
        };

        for (String path : puzzlePaths) {
            JMenuItem menuItem = new JMenuItem(path);
            menuItem.addActionListener(puzzleMenuListener);
            menuChoosePuzzle.add(menuItem);
        }
    }

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setVisible(true);
    }
}