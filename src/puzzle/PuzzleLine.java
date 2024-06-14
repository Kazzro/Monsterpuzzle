package puzzle;


public class PuzzleLine {

    PuzzleLine left;
    PuzzleLine right;

    PuzzlePiece[] slot;

    public PuzzleLine(){
        slot = new PuzzlePiece[5];
    }

    public PuzzleLine getLeft() {
        return left;
    }

    public void setLeft(PuzzleLine left) {
        this.left = left;
    }

    public PuzzleLine getRight() {
        return right;
    }

    public void setRight(PuzzleLine right) {
        this.right = right;
    }

    public PuzzlePiece[] getLine(){
        return slot;
    }

    public PuzzlePiece getPiece(int index){
        return slot[index];
    }

    public void setPieceReactive(int index, PuzzlePiece piece){
        if (index < 2){
            left.setPiece(4-index, piece);
        }
        if (index > 2){
            right.setPiece(4-index, piece);
        }
        setPiece(index, piece);
    }

    public void setPiece(int index, PuzzlePiece piece){
        slot[index] = piece;
    }



    public boolean checkPossibility(int index, PuzzlePiece piece)  {

        boolean possible = true;

        switch (index) {
            case 0:

                if(slot[1] != null)
                    possible =(slot[1].getSideB() + piece.getSideA() == 0);

                return possible;

            case 1:

                if ( slot[0] != null)
                    possible = (slot[0].getSideA() + piece.getSideB() == 0);

                if ( slot[index+1] != null && possible)
                    possible = (slot[2].getSideC() + piece.getSideC() == 0);

                return possible;

            case 2:

                if ( slot[1] != null)
                    possible = (slot[1].getSideC() + piece.getSideC() == 0);

                if ( slot[3] != null)
                    possible = (slot[3].getSideA() + piece.getSideB() == 0);

                return possible;

            case 3:

                if (slot[2] != null)
                    possible = (slot[2].getSideB() + piece.getSideA() == 0);

                if (slot[4] != null)
                    possible = (slot[4].getSideA() + piece.getSideB() == 0);

                return possible;

            case 4:

                if(slot[3] != null)
                    possible = (slot[3].getSideB() + piece.getSideA() == 0);

                return possible;

            default:
                return false;
        }
    }
}
