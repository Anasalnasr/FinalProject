package finalProject;

import java.util.Random;

public class Parameters {
    static Random random = new Random();
 String myUrl = "https://www.amazon.com/gift-cards/b/?ie=UTF8&node=2238192011&ref_=nav_cs_gc";
	static String Email = "AnasAlnaser@gmail.com";
	static String [] Message = {"enjoy your gift", "this is from me to you", "hope you like it"};
	static String Name = "Abdulraheem";
    Random randomAmount = new Random();
	int randomIndex = random.nextInt(3);
    String RandomInputMessage = Message[randomIndex];
    static   int randomNumber = random.nextInt(5) + 1; 
  static  String randomQuantityString = Integer.toString(randomNumber);

}