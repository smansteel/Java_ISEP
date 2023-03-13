import java.util.ArrayList;
import java.util.List;

public class Plateau {
    private List<Piece> pieces_noires = new ArrayList<>();
    private List<Piece> pieces_blanches = new ArrayList<>();
    private List<List> pieces = new ArrayList<>();
    public void init(){

        pieces_blanches.add(new Rook(0, 0, true));
        pieces_blanches.add(new Rook(7, 0, true));
        pieces_blanches.add(new Bishop(2, 0, true));
        pieces_blanches.add(new Bishop(5, 0, true));
        pieces_blanches.add(new Knight(1, 0, true));
        pieces_blanches.add(new Knight(6,0, true));
        pieces_blanches.add(new King(3,0, true));
        pieces_blanches.add(new Queen(4,0, true));
        for(int i = 0; i < 8; i++){
            pieces_blanches.add(new Pawn(i,1, true));
        }

        pieces_noires.add(new Rook(0, 7, false));
        pieces_noires.add(new Rook(7, 7, false));
        pieces_noires.add(new Bishop(2, 7, false));
        pieces_noires.add(new Bishop(5, 7, false));
        pieces_noires.add(new Knight(1, 7, false));
        pieces_noires.add(new Knight(6,7, false));
        pieces_noires.add(new King(4,7, false));
        pieces_noires.add(new Queen(3,7, false));
        for(int i = 0; i < 8; i++){
            pieces_blanches.add(new Pawn(i,6, false));
        }

        pieces.add(pieces_blanches);
        pieces.add(pieces_noires);

    }

    public boolean check(boolean color){
        return color;
    }

    public boolean check_mate(boolean color){
        return color;
    }

}
