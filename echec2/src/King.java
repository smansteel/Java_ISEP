public class King extends Piece{

    @Override
    public boolean valid_move(int test_position_h, int test_position_v) {

        if (test_position_v >=8 || test_position_v <0 ||test_position_h >=8 || test_position_h <0 ) {
        double dist_h = Math.pow(test_position_h - this.getPosition_h(),2);
        double dist_v = Math.pow(test_position_v - this.getPosition_h(),2);
        double dist = Math.sqrt(dist_v + dist_h);
        return (test_position_h == this.getPosition_h() || test_position_v == this.getPosition_v())|| (Math.pow(this.getPosition_h() - test_position_h, 2) == Math.pow(this.getPosition_v() - test_position_v, 2) && (1<= dist) && (Math.sqrt(2)>= dist));
        }else {
            return false;
        }
        }

    public King(int position_h, int position_v, boolean color) {
        this.setPosition_v(position_v);
        this.setPosition_h(position_h);
        this.setColor(color);
    }
}
