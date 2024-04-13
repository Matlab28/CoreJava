package EssentialsApp;

import java.util.Scanner;


/*  This system allows you to keep money. For instance, you must go market, and you'll need approximately 50 azn. in this
   case how can you keep this money? Accidentally you can spend it and as above mentioned, you must do this. It's your
   priority. That's why I've created this system. You can keep your money for some purposes. Let's say you must buy coffee
   every day, and you need 6 azn for this. For a month, it's 180 azn. You have 450 azn in your account, and you can keep 180
   azn for coffee. You can spend this money only in coffee shops. If you can't spend all money end of the term, then your money
   will return your balance automatically. You can set this weekly and monthly. And you can set several categories simultaneously.
   You are able to create the category. It's 100% up to you. Or maybe you don't need to set any categories, you need only keep
   money let's say for next week. In this case you can keep your money for weekly (i.e. 50 azn), and you can reach your money only
   7 days later. You can't get them as a cash until its deadline. We can call this system "Essentials" or "Priorities". Of course
   these are my preferences. You can give it a name, whichever you want.
 */


public class AppStart {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // with only array, old version.
//        BackData backData = new BackData();
//        backData.setName(scanner.next());
//        backData.generally(scanner);

        // with array list, new version.
        BackData2 backData2 = new BackData2();
        System.out.print("Please enter your name: ");
//        backData2.setName(scanner.next());

        String word = scanner.next();
        backData2.firstLetter(backData2.setName(word));

        backData2.generally(scanner);
        System.out.println();
        backData2.timeManagement(scanner);
    }
}
