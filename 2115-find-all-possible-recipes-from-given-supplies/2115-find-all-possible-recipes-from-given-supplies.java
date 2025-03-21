class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        
        HashSet<String> suppliesSet = new HashSet<>();
        HashMap<String, List<String>> recipyMap = new HashMap<>();
        List<String> recipiesCreated = new ArrayList<>();

        for (String s : supplies)
            suppliesSet.add(s);

        for (String s : recipes) {
            recipyMap.putIfAbsent(s, new ArrayList<>());
        }

        int i = 0;
        for (List<String> list : ingredients) {
            for (String s : list)
                recipyMap.get(recipes[i]).add(s);

            i++;
        }

        String val = checkIngredients(suppliesSet, recipyMap);

        while (val != null) {
            suppliesSet.add(val);
            recipiesCreated.add(val);
            recipyMap.remove(val);

            val = checkIngredients(suppliesSet, recipyMap);
        }

        return recipiesCreated;
    }

    String checkIngredients(HashSet<String> supplieSet, HashMap<String, List<String>> recipyMap) {

        int t = 0;
        for (String key : recipyMap.keySet()) {
            t = 0;
            for (String s : recipyMap.get(key)) {
                if (!supplieSet.contains(s))
                    break;
                t++;
            }
            if (t == recipyMap.get(key).size())
                return key;

        }

        return null;
    }
}