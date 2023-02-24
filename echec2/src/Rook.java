public class Rook extends Piece{


    @Override
    public boolean valid_move(int test_position_h, int test_position_v){
        if (test_position_v >=8 || test_position_v <0 ||test_position_h >=8 || test_position_h <0 ) {
        if (test_position_h==this.getPosition_h() || test_position_v == this.getPosition_v()){
            return true;
        }else {return false;}
        }else {
            return false;
        }

    }
    public Rook(int position_h, int position_v, boolean color) {
        this.setPosition_v(position_v);
        this.setPosition_h(position_h);
        this.setColor(color);
    }

}
