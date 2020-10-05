class Solution {
    public int firstUniqChar(String s) {
        
        // hashmaps are great for counting number of occurrances
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        // put all characters of the string into the hashmap, counting amount of each
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        // for each character of the string until the end
        for(int i = 0; i < s.length(); i++)
        {
            // if the value of the character at position i is 1 AKA the value is unique
            if(map.get(s.charAt(i)) == 1)
            {
                // return the position of that character
                return i;
            }
        }
        
        // otherwise we have an empty string so we return the default of -1
        return -1;
    }
}
