/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    int total;
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Set<Integer>> map2 = new HashMap<>();
        for(Employee employee: employees){
            map.put(employee.id, employee.importance);
            if(!map2.containsKey(employee.id)){
                map2.put(employee.id, new HashSet<>());
            }
            Set<Integer> set = map2.get(employee.id);
            for(int subor: employee.subordinates){
                set.add(subor);
            }
        }
        total = 0;
        total += map.getOrDefault(id, 0);
        for(Integer subor: map2.get(id)){
            dfs(map, map2, subor);
        }
        return total;
    }
    public void dfs(Map<Integer, Integer> map, Map<Integer, Set<Integer>> map2, Integer cur){
        if(cur == null) return;
        total += map.get(cur);
        for(Integer subor: map2.get(cur)){
            dfs(map, map2, subor);
        }
        return;
    }
}
