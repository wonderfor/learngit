
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Test {
	public static void main(String[] args) {
		/*
		Locale[] localeList = Locale.getAvailableLocales();
		for(int i = 0;  i < localeList.length ; i++) {
			System.out.println(localeList[i].getDisplayCountry() + "=" + localeList[i].getCountry() +
					" " + localeList[i].getDisplayLanguage() + "=" + localeList[i].getLanguage() + "\n");
		}
		*/
		
		/*
		Map<String,String> m1 = new HashMap();
		Map<String,String> m2 = new HashMap<String,String>();
		System.out.println(m1.equals(m2));
		*/
		
		Random rand = new Random();
		// ����һ��-0.5~0.5�ı���,���ڿ���С������з���
		double xyRate = rand.nextDouble() - 0.5;
		System.out.println(xyRate);
	}
}
