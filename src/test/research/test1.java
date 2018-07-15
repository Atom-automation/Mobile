import helper.Tools;

import java.text.ParseException;

public class test1 {
    public static void main(String[] args) throws ParseException {
        Tools tools=new Tools();
        System.out.println(tools.getDateInFormat("15","7","2018","MMMM dd, yyyy"));
    }
}
