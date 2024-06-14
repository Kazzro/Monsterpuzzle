package puzzle;

import java.util.ArrayList;

public class Puzzle {

    ArrayList<PuzzleLine> puzzleLines;
    ArrayList<PuzzlePiece> pieces;

    public ArrayList<PuzzlePiece> getPieces(){
        return pieces;
    }

    public ArrayList<PuzzleLine> getPuzzleLines() {
        return puzzleLines;
    }

    public Puzzle(ArrayList<PuzzlePiece> pieces){
        this.pieces = pieces;

        puzzleLines = new ArrayList<>();

        initializePuzzleLines(3);
    }

    private void initializePuzzleLines(int numberOfLines){
        for (int i = 0; i < numberOfLines; i++) {

            puzzleLines.add(new PuzzleLine());
        }

        for (int i = 0; i < numberOfLines; i++) {
            PuzzleLine current = puzzleLines.get(i);
            PuzzleLine left = puzzleLines.get((i - 1 + numberOfLines) % numberOfLines);
            PuzzleLine right = puzzleLines.get((i + 1) % numberOfLines);

            current.setLeft(left);
            current.setRight(right);
        }
    }

}
