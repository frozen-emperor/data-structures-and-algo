package recursion;

public class ReverseStringWithIBH {

	public static void main(String[] args) {
		char[] string = {'h','e','l','l','o','i'};
		reverse(string, 0);
		System.out.println(string);
	}
	
	public static void reverse(char[] s,int i){
        if(i==s.length/2)
            return;
        
        swap(s,i,s.length-i-1);
        
        reverse(s,i+1);
        
    }
    
    public static void swap(char[] s,int i,int j){
        char c = s[i];
        s[i] = s[j];
        s[j] = c;
    }

}
