import java.util.Scanner;

public class CreatePolygon 
{
    public static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) 
    {
        try 
        {
            System.out.println("Enter a polygon using x y points (Ctrl-d or Ctrl-x to finish):");
            
           
            Polygon polygon = new Polygon();
            
            while (in.hasNextDouble()) 
            {
                double x = in.nextDouble();
                
                if (in.hasNextDouble()) 
                {
                    double y = in.nextDouble();
                    
                    Point point = new Point(x, y);
                    polygon.addPoint(point);
                    System.out.println("Added point " + point);
                } 
                else 
                {
                    break;
                }
            }
            
        
            System.out.println(polygon + " has perimeter " + polygon.perimeter());
            
        } 
        catch (Exception e) 
        {
        
            System.out.println("INVALID: " + e);
        }//pushh12
    }
}