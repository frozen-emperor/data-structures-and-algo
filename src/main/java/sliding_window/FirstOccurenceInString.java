package sliding_window;

public class FirstOccurenceInString {

    public static void main(String[] args) {
       String haystack = "sadbutsad", needle = "sad";
        System.out.println(needle + " in " +  haystack + " at " + strStr(haystack, needle));

        haystack = "leetcode";
        needle = "leeto";
        System.out.println(needle + " in " +haystack + " at " + strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
        if(needle.length() <= haystack.length()) {
            char[] toFind = needle.toCharArray();
            char[] src = haystack.toCharArray();

            int start = 0, end = needle.length() - 1;

            while(end < src.length){
                if(src[start] == toFind[0] && src[end] == toFind[needle.length() - 1]){

                    boolean fullmatch = true;
                    int j = 0;
                    for(int i = start; i <= end; i++){
                        fullmatch = fullmatch && src[i] == toFind[j++];
                    }

                    if(fullmatch)
                        return start;

                }
                start++;
                end++;
            }
        }
        return -1;
    }

}
