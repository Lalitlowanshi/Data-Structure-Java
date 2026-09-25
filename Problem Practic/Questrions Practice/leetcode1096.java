class Solution {
    public List<String> braceExpansionII(String expression) {
        Set<String> result = parse(expression, 0, expression.length()-1);

        List<String> ans = new ArrayList<>(result);
        Collections.sort(ans);

        return ans;
    }

    private Set<String> parse(String s, int l, int r){
        Set<String> result = new HashSet<>();

        Set<String> current = new HashSet<>();
        current.add("");

        int i = l;

        while(i<= r){
            if(s.charAt(i) == '{'){
                int count = 1;
                int j = i+1;

                while(count > 0){
                    if (s.charAt(j) == '{') {
                        count++;
                    } 
                    else if (s.charAt(j) == '}') {
                        count--;
                    }
                    j++;
                }
                Set<String> inside = parse(s, i+1, j-2);
                current = multiply(current, inside);
                i = j;
            }
            else if(s.charAt(i) == ','){
                result.addAll(current);

                current = new HashSet<>();
                current.add("");

                i++;
            }
            else{
                Set<String> single = new HashSet<>();
                single.add(String.valueOf(s.charAt(i)));

                current = multiply(current, single);

                i++;
            }
        }
        result.addAll(current);

        return result;
    }
    private Set<String> multiply(Set<String> a, Set<String> b){
        Set<String> result = new HashSet<>();

        for(String x : a){
            for(String y : b){
                result.add(x+y);
            }
        }
        return result;
    }
}
