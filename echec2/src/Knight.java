public class Knight extends Piece {

    @Override
    public boolean valid_move(int test_position_h, int test_position_v) {


        double dist_h = Math.pow(test_position_h - this.getPosition_h(), 2);
        double dist_v = Math.pow(test_position_v - this.getPosition_h(), 2);
        double dist = Math.sqrt(dist_v + dist_h);

        System.out.println(dist);

        if (Math.sqrt(5) == dist) {

            return true;
        } else {
            return false;
        }


    }

    public Knight(int position_h, int position_v, boolean color) {
        this.setPosition_v(position_v);
        this.setPosition_h(position_h);
        this.setColor(color);
    }
}