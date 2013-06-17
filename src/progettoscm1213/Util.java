/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoscm1213;

/**
 *
 * @author gioggi2002
 */
public class Util {
    public static void clearConsole()
    {
        try
        {
            String os = System.getProperty("os.name");
            System.out.println(System.getProperty("os.name"));
            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (Exception exception)
        {
            //  Handle exception.
        }
    }
}
