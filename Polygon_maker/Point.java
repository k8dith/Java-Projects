public class Point 
{
    private double x;
    private double y;
    
    public Point() 
    {
        this(0.0, 0.0);
    }
    
    public Point(double x, double y) 
    {
        this.x = x;
        this.y = y;
    }
    
    public double getX() //push 3
    {
        return x;
    }
    
    public double getY() 
    {
        return y;
    }
    
    @Override
    public boolean equals(Object o) 
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0;
    }
    
    @Override
    public int hashCode() 
    {
        return java.util.Objects.hash(x, y); 
    }
    
    @Override
    public String toString() 
    {
        return "(" + x + "," + y + ")";
    }
}