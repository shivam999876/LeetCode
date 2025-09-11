class Solution {
    public String sortVowels(String s) {
        Set<Character> vowelSet = Set.of('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u');
        List<Character> vowels = new ArrayList<>();
        for(char c : s.toCharArray())
        if(vowelSet.contains(c))
        vowels.add(c);
        Collections.sort(vowels);
        StringBuilder result = new StringBuilder();
        int index = 0;
        for(char c : s.toCharArray()){
            if(vowelSet.contains(c))
            result.append(vowels.get(index++));
            else
            result.append(c);
        }
        return result.toString();
    }
}