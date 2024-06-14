package puzzle;

public class PuzzlePiece {

    int sideA;
    int sideB;
    int sideC;

    public int getSideA() {
        return sideA;
    }

    public void setSideA(int sideA) {
        this.sideA = sideA;
    }

    public int getSideB() {
        return sideB;
    }

    public void setSideB(int sideB) {
        this.sideB = sideB;
    }

    public int getSideC() {
        return sideC;
    }

    public void setSideC(int sideC) {
        this.sideC = sideC;
    }

    public PuzzlePiece(int sideA, int sideB, int sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public boolean rotate(){
        int z = this.sideA;
        this.sideA = this.sideB;
        this.sideB = this.sideC;
        this.sideC = z;

        return true;
    }
}
