
public class Lambda {
final static String salutation = "Hello";
public static void main(String ar[])
{
	GreetingService greetService1 = message ->
	System.out.println(salutation + message);
	greetService1.sayMessage("Mahesh");
}
interface GreetingService
{void sayMessage(String message);}
}
