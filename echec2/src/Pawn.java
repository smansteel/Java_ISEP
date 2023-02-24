public class Pawn extends Piece{

    @Override
    public boolean valid_move(int test_position_h, int test_position_v) {

        if ((test_position_v == this.getPosition_v()+1 && this.getColor()) || (test_position_v == 1+2 && this.getColor()) || (test_position_v == 6-2 && !this.getColor()) ||  (test_position_v == this.getPosition_v()-1 && !this.getColor())) {
            return true;
        } else {
            return false;
        }

    }

    public Pawn(int position_h, int position_v, boolean color) {
        this.setPosition_v(position_v);
        this.setPosition_h(position_h);
        this.setColor(color);
    }
}
