package Data;

import puzzle.Puzzle;
import puzzle.PuzzleLine;
import puzzle.PuzzlePiece;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DataWriter {

    public static void writeData(String fileName, Puzzle puzzle, String header1, String header2) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            // Schreibe die Header-Zeilen
            bw.write(header1);
            bw.newLine();
            bw.write(header2);
            bw.newLine();

            // Schreibe die Puzzleteil-Objekte
            for (PuzzleLine line : puzzle.getPuzzleLines()) {
                for(PuzzlePiece piece : line.getLine())

                bw.write(STR."\{piece.getSideA()} \{piece.getSideB()} \{piece.getSideC()}");
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
