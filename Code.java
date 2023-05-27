package misc;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;



public class main_misc2 {
	
	
		
		
	
	
	public static void main(String[] args) {
	//(a+b)%k = ((a % k)+(b % k)) % k    || ||
	
	System.out.println(get_permutations("guilherme"));
		
		
	}	
	
	private static ArrayList<String> get_permutations(String s){
		//ArrayList<String> pivots = generate_pivots(s);
		return f("",s);
	}
	
	private static boolean in_list(ArrayList<String> pivots,String x) {
		
		for(int i = 0;i < pivots.size();i++) {
			if(pivots.get(i).equals(x)){
				return true;
			}
		}
		return false;
		
	}
	
	private static ArrayList<String> generate_pivots(String s) {
		
		ArrayList<String> pivots = new ArrayList<>();
		
		HashMap<String,Integer> count = new HashMap<>();
		
		for(int i = 0;i < s.length();i++) {
			String x = s.substring(i, i+1);
			if(count.containsKey(x)){
				count.replace(x, count.get(x), count.get(x)+1);
				continue;
			}
			count.put(x, 1);
			pivots.add(x);
		}
		return pivots;
		
		
	}
	
	private static ArrayList<String> f(String x,String s){
		
		ArrayList<String> all = new ArrayList<>();
		ArrayList<String> pivots = generate_pivots(s);
		
		if(s.length() == 0) {
			return all;
		}
		if(s.length() == 1) {
			all.add(x+s);
			return all;
		}
		
		for(int i = 0;i < pivots.size();i++) {
			
			
			String pivot = pivots.get(i);
			String novo = s;
			novo = novo.replaceFirst(pivot,"");
			ArrayList<String> sub_perms = f("",novo);
			for(int j = 0;j < sub_perms.size();j++){
				StringBuilder temp_add = new StringBuilder();
				temp_add.append(pivot);
				temp_add.append(sub_perms.get(j));
				sub_perms.remove(j);
				sub_perms.add(j, temp_add.toString());
			}
			all.addAll(sub_perms);
			
		}
		return all;
	}
	
	} 
	
