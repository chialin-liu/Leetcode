import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

  public List<List<String>> groupStrings(String[] strings) {
    Map<String, List<String>> map = new HashMap<>();
    for(String string: strings){
      char []arr = string.toCharArray();
      if(arr[0] == 'a'){
        List<String> list = map.getOrDefault(string, new ArrayList<>());
        list.add(string);
        map.put(string, list);
        continue;
      }
      char head = arr[0];
      for(int i = 0; i < arr.length; i++){
        boolean negative = arr[i] - head < 0;
        arr[i] = (negative)? (char) (arr[i] - head + 26 + 'a'): (char) (arr[i] - head + 'a');
      }
      String cur = String.valueOf(arr);
      if(map.containsKey(cur)){
        List<String> list = map.get(cur);
        list.add(string);
        // map.put(string, list);
      }
      else{
        List<String> list = new ArrayList<>();
        list.add(string);
        map.put(cur, list);
      }
    }
    List<List<String>> res = new ArrayList<>();
    for(String key: map.keySet()){
      List<String> list = map.get(key);
      res.add(list);
    }
    return res;
  }

}
