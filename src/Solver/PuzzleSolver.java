package Solver;

import puzzle.Puzzle;
import puzzle.PuzzleLine;
import puzzle.PuzzlePiece;

import java.util.HashSet;
import java.util.Set;


public class PuzzleSolver {

    private Puzzle puzzle;
    private Set<PuzzlePiece> usedPieces;

    public PuzzleSolver(Puzzle puzzle) {
        this.puzzle = puzzle;
    }

    public boolean solve() {
        usedPieces = new HashSet<>();
        System.out.println("Starte Solver");
        boolean result = solve(0, 0);
        System.out.println("Ergebnis: " + result);
        return result;
    }

    private boolean solve(int lineIndex, int slotIndex) {

        if (lineIndex == puzzle.getPuzzleLines().size()) {
            return true;
        }

        PuzzleLine currentLine = puzzle.getPuzzleLines().get(lineIndex);

        if (currentLine.getPiece(slotIndex) != null) {
            return solve(nextLine(lineIndex, slotIndex), nextSlot(slotIndex));
        }

        for (PuzzlePiece piece : puzzle.getPieces()) {
            if (usedPieces.contains(piece)) {
                continue;
            }

            for (int rotation = 0; rotation < 3; rotation++) {


                if (currentLine.checkPossibility(slotIndex, piece)) {
                    currentLine.setPieceReactive(slotIndex, piece);
                    usedPieces.add(piece);

                    if (solve(nextLine(lineIndex, slotIndex), nextSlot(slotIndex))) {
                        return true;
                    }
                    currentLine.setPieceReactive(slotIndex, null);
                    usedPieces.remove(piece);

                }

                piece.rotate();
            }

        }

        return false;
    }

    private int nextLine(int currentLineIndex, int currentSlotIndex) {
        if (currentSlotIndex == 4) {
            return currentLineIndex + 1;
        }
        return currentLineIndex;
    }

    private int nextSlot(int currentSlotIndex) {
        return (currentSlotIndex + 1) % 5;
    }
}
