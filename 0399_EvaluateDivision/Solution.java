class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        int index = 0;
        for(List<String> equation: equations){
            if(!map.containsKey(equation.get(0))){
                map.put(equation.get(0), new HashMap<>());
            }
            if(!map.containsKey(equation.get(1))){
                map.put(equation.get(1), new HashMap<>());
            }
            
            Map<String, Double> list = map.get(equation.get(0));
            list.put(equation.get(1), values[index]);
            Map<String, Double> list2 = map.get(equation.get(1));
            list2.put(equation.get(0), 1 / values[index]);
            index++;
        }
        index = 0;
        double []res = new double[queries.size()];
        for(List<String> query: queries){
            String start = query.get(0);
            String end = query.get(1);
            Set<String> seen = new HashSet<>();
            res[index] = dfs(start, end, 1.0, map, seen);
            index++;
        }
        return res;
    }
    public double dfs(String start, String end, double total, Map<String, Map<String, Double>> map, Set<String> seen){
        if(seen.contains(start) || !map.containsKey(start)) return -1;
        if(start.equals(end)){
            return total;
        }
        seen.add(start);
        Map<String, Double> list = map.get(start);
        for(String key: list.keySet()){
            double temp = dfs(key, end, total * list.get(key), map, seen);
            if(temp != -1){
                return temp;
            }
        }
        return -1;
    }
}
