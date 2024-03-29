//https://leetcode.com/problems/vowel-spellchecker/

class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        if(queries == null)
            return new String[0];
        int n = queries.length;
        String res[] = new String[n];
        HashMap<String, Integer> mapExactMatch = new HashMap();
        HashMap<String, Integer> mapIgnoreCase = new HashMap();
        HashMap<String, Integer> mapIgnoreVowelAndCase = new HashMap();
        
        for(int i = 0 ; i < wordlist.length ; i++){
            mapExactMatch.put(wordlist[i],i);
            
            String keyIgnoreCase = wordlist[i].toLowerCase();
            if(mapIgnoreCase.get(keyIgnoreCase) == null)
                mapIgnoreCase.put(keyIgnoreCase, i);
            
            String keyIgnoreVowelAndCase = generateKeyIngnoreVowelAndCase(wordlist[i]);
            if(mapIgnoreVowelAndCase.get(keyIgnoreVowelAndCase) == null)
                mapIgnoreVowelAndCase.put(keyIgnoreVowelAndCase, i);
        }
        //System.out.println(mapIgnoreVowelAndCase);
        for(int i = 0 ; i < queries.length ; i++){
            Integer index = -1;
            if((index = mapExactMatch.get(queries[i])) != null)
                res[i] = wordlist[index];
            else if((index = mapIgnoreCase.get(queries[i].toLowerCase())) != null)
                res[i] = wordlist[index];
            else if((index = mapIgnoreVowelAndCase.get(generateKeyIngnoreVowelAndCase(queries[i]))) != null)
                res[i] = wordlist[index];
            else 
                res[i] = "";
        }
        return res;
    }
    // convert each char as small letter and each vowel to 'a'
    String generateKeyIngnoreVowelAndCase(String s){
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);
            if(vowel[ch]){
                sb.append('a');
            }
            else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
    static boolean []vowel = new boolean[128];
    static{
        vowel['a'] = vowel['e'] = vowel['i'] = vowel['o'] = vowel['u'] = true;
    }
}
/*
["KiTe","kite","hare","Hare"]
["kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"]
["yellow"]
["YellOw"]
["v","t","k","g","n","k","u","h","m","p"]
["n","g","k","q","m","h","x","t","p","p"]

["dtk","oag","pad","nfs","xej","bys","dgp","hev","hsk","gws","kqd","ztv","fvi","irw","rhv","dys","ofl","lnt","vmq","vsp","kbv","fof","ako","gbu","mbd","szy","zlr","cpt","xck","hdg","uoo","fvm","vla","fpe","mpk","abv","mcf","ibp","num","ouv","icx","uab","wka","ozz","gte","vpv","rvd","hed","fcl","iaf","sba","wxa","gjp","qzh","kjv","fxr","msf","bwj","wqp","whj","vxu","xoe","wwh","ray","jor","vsi","yft","ngn","inf","ggw","kwj","irk","vqs","zvi","lwx","ooc","fdi","ana","jcg","rga","vow","gia","nxa","pgr","ymw","kfk","rur","bud","cfe","ffn","wnr","uzh","yff","ucx","xss","mbi","tph","efn","syu","sqz"]
["nrm","szv","inf","ngn","Ouv","mqk","bra","pie","xyz","mif","hjz","hlr","ltt","zce","dtK","lyw","zvi","yha","bMi","eyy","xoc","MCF","vOW","tvv","wpv","jcg","kqd","hvi","wmz","nmf","aiF","fvm","puk","vxi","ztv","NxA","rwo","kFK","vxu","esi","vla","uub","fom","gJp","ahb","bJW","ipv","syU","nyg","xss","iom","qnp","soy","smv","zzo","Bys","lnt","wuc","uqk","syu","aok","efn","dju","ooe","ipu","VSi","bod","hdg","wux","vex","qee","ueq","rhv","czm","yff","npo","wka","vmm","jtk","gto","rjx","gjp","nza","idj","xuf","yzp","nhc","kjv","hdG","xOE","whj","eox","lcv","Mbd","bud","vxe","dgp","smo","qdv","bav"]
*/
