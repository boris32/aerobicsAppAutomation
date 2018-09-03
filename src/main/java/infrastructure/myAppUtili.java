package infrastructure;

/**
 * Created by Boris on 8/24/2018.
 */
public class myAppUtili
{
    public static String getMonthAbbrev(int i) {
        String[] monthAbbrevs = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        return monthAbbrevs[i];
    }
}
