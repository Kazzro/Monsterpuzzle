package Data;

import puzzle.PuzzlePiece;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataReader {

    public static ArrayList<PuzzlePiece> readData(String fileName){

        String path = "resources/data/input/" + fileName;

        ArrayList<PuzzlePiece> puzzlePieces = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String header1 = br.readLine();
            String header2 = br.readLine();
            System.out.println("Header 1: " + header1);
            System.out.println("Header 2: " + header2);

            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                int x = Integer.parseInt(parts[0]);
                int y = Integer.parseInt(parts[1]);
                int z = Integer.parseInt(parts[2]);
                PuzzlePiece puzzlePiece = new PuzzlePiece(x, y, z);
                puzzlePieces.add(puzzlePiece);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        return puzzlePieces;
    }
}
