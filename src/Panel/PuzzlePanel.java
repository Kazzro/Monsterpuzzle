package Panel;

import Data.DataReader;
import Solver.PuzzleSolver;
import puzzle.Puzzle;
import puzzle.PuzzleLine;
import puzzle.PuzzlePiece;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Polygon;

public class PuzzlePanel extends JPanel {

    private Puzzle puzzle;

    public PuzzlePanel(){

    }
    public PuzzlePanel(String path) {
        this.puzzle = new Puzzle(DataReader.readData(path));
        System.out.println(solvePuzzle());
    }

    public void setPuzzle(String path){
        this.puzzle = new Puzzle(DataReader.readData(path));
        System.out.println(solvePuzzle());
        repaint();
    }

    private boolean solvePuzzle(){
        PuzzleSolver solver = new PuzzleSolver(puzzle);
        return solver.solve();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        drawPuzzle(g2d);
    }

    private void drawPuzzle(Graphics2D g2d) {
        int size = 120;
        int xOffset = 100;

        int height = (int) (Math.sqrt(3) / 2 * size);
        int yOffset = height+50;

        PuzzleLine currentLine = puzzle.getPuzzleLines().get(0);

        drawPiece(g2d, currentLine.getPiece(0), xOffset, yOffset+height, size,0);
        drawPieceUpsideDown(g2d, currentLine.getPiece(1), xOffset + size/2, yOffset + height, size,0);
        drawPiece(g2d, currentLine.getPiece(2), xOffset + size, yOffset + height, size,1);
        drawPieceUpsideDown(g2d, currentLine.getPiece(3), xOffset + size + size/2, yOffset + height, size,1);
        drawPiece(g2d, currentLine.getPiece(4), xOffset +2* size, yOffset + height, size,2);
        drawPiece(g2d, currentLine.getLeft().getPiece(2), xOffset + size/2, yOffset, size,2);
        drawPieceUpsideDown(g2d, currentLine.getLeft().getPiece(1), xOffset + size, yOffset , size,2);
        drawPiece(g2d, currentLine.getLeft().getPiece(0), xOffset + size, yOffset-height, size,1);
        drawPiece(g2d, currentLine.getRight().getPiece(2), xOffset +size + size/2, yOffset, size,0);
    }

    private void drawPiece(Graphics2D g2d, PuzzlePiece piece, int x, int y, int size, int rotation) {
        if (piece == null) return;

        int height = (int) (Math.sqrt(3) / 2 * size);
        int[] xPoints = {x, x + size / 2, x - size / 2};
        int[] yPoints = {y, y + height, y + height};
        Polygon triangle = new Polygon(xPoints, yPoints, 3);

        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fill(triangle);
        g2d.setColor(Color.BLACK);
        g2d.draw(triangle);

        switch (rotation){
            case 0:
                g2d.drawString("" + piece.getSideA(), x +20, y + 10 + height / 2);
                g2d.drawString("" + piece.getSideB(),x - 30, y + 10 + height / 2);
                g2d.drawString("" + piece.getSideC(), x-5  , y + height-2);
                break;
            case 1:
                g2d.drawString("" + piece.getSideB(),x +20, y + 10 + height / 2);
                g2d.drawString("" + piece.getSideC(), x - 30, y + 10 + height / 2);
                g2d.drawString("" + piece.getSideA(), x-5  , y + height-2);
                break;
            case 2:
                g2d.drawString("" + piece.getSideC(),x +20, y + 10 + height / 2);
                g2d.drawString("" + piece.getSideA(), x - 30, y + 10 + height / 2);
                g2d.drawString("" + piece.getSideB(), x-5  , y + height-2);
                break;
        }

    }

    private void drawPieceUpsideDown(Graphics2D g2d, PuzzlePiece piece, int x, int y, int size, int direction) {
        if (piece == null) return;

        int height = (int) (Math.sqrt(3) / 2 * size);
        int[] xPoints = {x, x + size / 2, x - size / 2};
        int[] yPoints = {y+height, y, y};
        Polygon triangle = new Polygon(xPoints, yPoints, 3);

        g2d.setColor(Color.CYAN);
        g2d.fill(triangle);
        g2d.setColor(Color.BLACK);
        g2d.draw(triangle);

        switch(direction){
            case 0:
                g2d.drawString("" + piece.getSideA(), x, y+15);
                g2d.drawString("" + piece.getSideB(), x - 25, y + height/2);
                g2d.drawString("" + piece.getSideC(), x + 20, y + height/2);
                break;
            case 1:
                g2d.drawString("" + piece.getSideC(), x, y+15);
                g2d.drawString("" + piece.getSideA(), x - 25, y + height/2);
                g2d.drawString("" + piece.getSideB(), x + 20, y + height/2);
                break;
            case 2:
                g2d.drawString("" + piece.getSideB(), x, y+15);
                g2d.drawString("" + piece.getSideC(), x - 25, y + height/2);
                g2d.drawString("" + piece.getSideA(), x + 20, y + height/2);
                break;
        }

    }
}