package DragonChar;

public class Coordinates {
    private double x;
    private Long y; //Поле не может быть null

    public Coordinates(double x, Long y){
        this.x = x;
        if (y==null) y = Long.valueOf(1);
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public Long getY() {
        return y;
    }
}
