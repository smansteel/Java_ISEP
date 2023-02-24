public abstract class Piece {
    private int position_h;
    private int position_v;

    // White true, Black False
    private boolean color;

    public int getPosition_h(){
        return position_h;
    }
    public int getPosition_v(){
        return position_v;
    }

    public boolean getColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public void setPosition_h(int position_h){
        this.position_h = position_h;
    }
    public void setPosition_v(int position_v){
        this.position_v = position_v;
    }

    public abstract boolean valid_move(int test_position_h, int test_position_v);
}
