import java.util.ArrayList;
import java.util.List;

public class MyFirstDemo {
	public static void main(String[] args) {
		System.out.println("hello  world!!!");
		
		boolean var1 = false;
		boolean var2  = true;
		if(! var1 ||(var1 && var2)){
			System.out.println("-----");
		}
		
		
		
		
		System.out.println("*********");
		String s = "lily";
		List<String> lists = new ArrayList<>();
		lists.add(s);
		String s1 = lists.get(0);
		s1 = "dale";
		System.out.println(s);
	}
}
