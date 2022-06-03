import org.json.JSONTokener;

public class JSONTokener_StringTokenizing {
    public static void main(String[] args) {

        JSONTokener token = new JSONTokener("I solemnly swear, that I am up to no good.");

            System.out.println(token.skipTo('w')); // Skip until 'w' is found
            System.out.println(token.nextTo(',')); // print after 'w' until the ',' is found -- ',' not included
            System.out.println(token.nextTo('.')); // print after the current cursor position (at ',') until '.'


/*
        while(token.more()) {
            //System.out.println(token.next()); // Extract single character at a time
            System.out.println(token.next(5)); // Extract 5 characters at a time
            //System.out.println(token.next(7)); // Extract 5 characters at a time
            //System.out.print(token.next(7)); // Extract 7 characters at a time, but get error since the string is not multiple of 7
        }


        while(!token.end()){
            System.out.print(token.nextClean()); //Remove all white spaces in the string
        }

 */

    }
}
