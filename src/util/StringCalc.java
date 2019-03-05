package util;

public class StringCalc {
    public static String done(String str){
        String strRep = str.replaceAll("_",".");
        String strLow = strRep.toLowerCase();
        return strLow;
    }
}
