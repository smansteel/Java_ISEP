public class Queen extends Piece{

    @Override
    public boolean valid_move(int test_position_h, int test_position_v){
        if (test_position_v >=8 || test_position_v <0 ||test_position_h >=8 || test_position_h <0 ) {
            return (test_position_h == this.getPosition_h() || test_position_v == this.getPosition_v()) || (Math.pow(this.getPosition_h() - test_position_h, 2) == Math.pow(this.getPosition_v() - test_position_v, 2));
        }else {
            return false;
        }
    }

    public Queen(int position_h, int position_v, boolean color) {
        this.setPosition_v(position_v);
        this.setPosition_h(position_h);
        this.setColor(color);
    }
}
