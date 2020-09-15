/**
Given the array favoriteCompanies where favoriteCompanies[i] is the list of favorites companies for the ith person (indexed from 0).

Return the indices of people whose list of favorite companies is not a subset of any other list of favorites companies. You must return the indices in increasing order.

 

Example 1:

Input: favoriteCompanies = [["leetcode","google","facebook"],["google","microsoft"],["google","facebook"],["google"],["amazon"]]
Output: [0,1,4] 
Explanation: 
Person with index=2 has favoriteCompanies[2]=["google","facebook"] which is a subset of favoriteCompanies[0]=["leetcode","google","facebook"] corresponding to the person with index 0. 
Person with index=3 has favoriteCompanies[3]=["google"] which is a subset of favoriteCompanies[0]=["leetcode","google","facebook"] and favoriteCompanies[1]=["google","microsoft"]. 
Other lists of favorite companies are not a subset of another list, therefore, the answer is [0,1,4].
Example 2:

Input: favoriteCompanies = [["leetcode","google","facebook"],["leetcode","amazon"],["facebook","google"]]
Output: [0,1] 
Explanation: In this case favoriteCompanies[2]=["facebook","google"] is a subset of favoriteCompanies[0]=["leetcode","google","facebook"], therefore, the answer is [0,1].
Example 3:

Input: favoriteCompanies = [["leetcode"],["google"],["facebook"],["amazon"]]
Output: [0,1,2,3]
 */

 class Solution {
    // google -> 0 2
    // leetcode -> 0 1
    // facebook -> 0 2
    // amazon -> 1
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        HashMap<String, List<Integer>> map = new HashMap<>();
        int i = 0;
        for (List<String> list : favoriteCompanies){
            for (String company : list){
                if (map.containsKey(company)){
                    map.get(company).add(i);
                } else {
                    map.put(company, new ArrayList<Integer>());
                    map.get(company).add(i);
                }
            }
            i++;
        }
        int j = 0;
        List<Integer> res = new ArrayList<>();
        for (List<String> list : favoriteCompanies){
            List<List<Integer>> temp = new ArrayList<>();
            for (String company : list){
                temp.add(map.get(company));
            }
            int common = getCommon(temp);
            if (common == 1) res.add(j);
            j++;
        }
        return res;
    }
    private int getCommon(List<List<Integer>> list){
        List<Integer> res = new ArrayList<>(list.get(0));
        for (int i = 1; i < list.size(); i++){
            Set<Integer> set = new HashSet<>(list.get(i));
            for (int j = res.size() - 1; j >= 0; j--){
                if (!set.contains(res.get(j))){
                    res.remove(new Integer(res.get(j)));
                }
            }
        }
        return res.size();
    }
}