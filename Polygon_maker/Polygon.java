public class Polygon 
{
    public static final int MAX_SIDES = 12;
    private int numSides = 0;
    private Point[] points = new Point[MAX_SIDES];
    
    
    public void addPoint(Point point) 
    {
        
        for (int i = 0; i < numSides; i++) 
        {
            if (points[i].equals(point)) 
            {
                throw new IllegalArgumentException("Duplicate point: " + point);
            }
        }
        
       
        if (numSides >= MAX_SIDES)
        {
            throw new RuntimeException("Polygon is full");
        }
        
        
        points[numSides] = point;
        numSides++;
    }
    
    
    private static double lineLength(Point p1, Point p2) 
    {
        double x = p1.getX() - p2.getX();
        double y = p1.getY() - p2.getY();
        return Math.sqrt(x * x + y * y);
    }
    
  
    public double perimeter() 
    {

        if (numSides < 3) 
        {
            throw new RuntimeException("Polygons required 3+ sides!");
        }
        
        double perimeter = 0.0;
        
        for (int i = 0; i < numSides - 1; i++) 
        {
            perimeter += lineLength(points[i], points[i + 1]);
        }
        
        perimeter += lineLength(points[numSides - 1], points[0]);
        
        return perimeter;
    }
    
    @Override
    public String toString() 
    {
        StringBuilder sb = new StringBuilder("Polygon[");
        for (int i = 0; i < numSides; i++) 
        {
            sb.append(points[i]);
            if (i < numSides - 1) 
            {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}