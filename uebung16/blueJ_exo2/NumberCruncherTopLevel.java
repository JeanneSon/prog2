/**
 * NumberCruncherTopLevel
 * 
 * @author A. Venet u. H. Schall
 * @version 1.0
 */
public class NumberCruncherTopLevel
{
    //Klassenkonstanten
    private static final String OPERATION_NOT_VALID = "Ungueltige Operation: ";
    //Objektattribute
    private float[] values;
    private Sum sum = new Sum();
    private Subtract subtract = new Subtract();
    private Swirl swirl = new Swirl();
    private Divide divide = new Divide();
    private Average average = new Average();
    
    /**
    * Konstruktor
    * @param values Array, auf dem operiert werden soll
    */
    public NumberCruncherTopLevel(float[] values)
    {
        this.values = values;
    }
    public void crunch(String[] operations) throws IllegalArgumentException
    {
        for (String op : operations) {
            op = op.trim().toLowerCase();
            switch(op) {
              case "sum":
                 sum.crunch(values);
                 break;
              case "swirl":
                swirl.crunch(values);
                break;
              case "divide":
                divide.crunch(values);
                break;
              case "subtract":
                subtract.crunch(values);
                break;
              case "average":
                average.crunch(values);
                break;
              default:
                throw new IllegalArgumentException(OPERATION_NOT_VALID + op);
            }
        }
    } 
    public float[] getNumbers()
    {
        return values;
    }
}