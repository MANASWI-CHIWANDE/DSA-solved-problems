public class Reverse_Array{
    public static String reverseWord(String str){
        String newString = "";
        for(int i = str.length()-1; i>=0;i--){
            newString += str.charAt(i);
        }
        return newString;
    }
    public static void main(String []args){
        String s = "abcd";
        System.out.println(reverseWord(s));
    }
}