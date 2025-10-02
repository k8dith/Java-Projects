import java.util.Random;
import java.util.Scanner;

public class TestPolygon 
{
    private static Scanner in = new Scanner(System.in);
    private static Random rand = new Random();
    
    public static void main(String[] args) 
    {
        boolean hasErrors = false;
        
        try 
        {
            
            System.out.println("Test 1: Creating triangle (0,0),(3,0),(3,4)");
            Polygon triangle = new Polygon();
            triangle.addPoint(new Point(0,0)); 
            triangle.addPoint(new Point(3, 0));
            triangle.addPoint(new Point(3, 4));
            
            double perimeter = triangle.perimeter();

            if (Math.abs(perimeter - 12.0) > 0.0001) 
            {
                System.err.println("FAIL: Expected perimeter 12.0, got " + perimeter);
                hasErrors = true;
            } 
            else 
            {
                System.out.println("PASS: Triangle perimeter is " + perimeter);
            }
            
        } 
        
        catch (Exception e) 
        {
            System.err.println("FAIL: Exception from valid polygon");
            hasErrors = true;
        }
        
        try 
        {
            
            System.out.println("Test 2: Testing duplicate point detection");
            Polygon duplicate = new Polygon();
            duplicate.addPoint(new Point(0, 0));
            duplicate.addPoint(new Point(3, 0));
            duplicate.addPoint(new Point(0, 0)); 
            
            System.err.println("FAIL: Duplicate point should throw IllegalArgumentException");
            hasErrors = true;
            
        } 
        catch (IllegalArgumentException e) 
        {
            System.out.println("PASS: Duplicate point correctly threw IllegalArgumentException");
        } 
        catch (Exception e) 
        {
            System.err.println("FAIL: Duplicate point should throw IllegalArgumentException");
            hasErrors = true;
        }
        
        try 
        {
            
            System.out.println("Test 3: Testing invalid 2-sided polygon");
            Polygon twoSided = new Polygon();
            twoSided.addPoint(new Point(0, 0));
            twoSided.addPoint(new Point(3, 0));
            twoSided.perimeter(); 

            System.err.println("FAIL: Too many points should throw RuntimeException");
            hasErrors = true;
            
        } 
        catch (RuntimeException e) 
        {
            System.out.println("PASS: 2-sided polygon correctly threw RuntimeException");
        } 
        catch (Exception e) 
        {
            System.err.println("FAIL: Too many points should throw RuntimeException");
            hasErrors = true;
        }
        
        try 
        {
        
            System.out.println("Test 4: Testing 13-sided polygon (too many points)");
            Polygon manySided = new Polygon();
            
        
            for (int i = 0; i <= 12; i++) 
            {
                manySided.addPoint(new Point(i, i + 1));
            }
            
            System.err.println("FAIL: Result code 7");
            hasErrors = true;
            
        } 
        
        catch (RuntimeException e) 
        {
            System.out.println("PASS: 13-sided polygon correctly threw RuntimeException");
        } 
        
        catch (Exception e) 
        {
            System.err.println("FAIL: Result code 7");
            hasErrors = true;
        }
        
        
        if (hasErrors) 
        {
            System.err.println("Some tests failed!");
            System.exit(7); 
        } 
        
        else 
        {
            System.out.println("All tests passed!");
            System.exit(0);
        }
    }
}