
import java.lang.reflect.Array;
import java.util.*;

public class AccountsMerge {
    static class Disjoint_Set{
        List<Integer> parent=new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        Disjoint_Set(int n ){
            for(int i=0;i<=n;i++){
                parent.add(i);
                size.add(1);
            }
        }

        int findUltimateParent(int node){
            if(node != parent.get(node)){
                int ulp = findUltimateParent(parent.get(node));
                parent.set(node,ulp);
            }
            return parent.get(node);
        }

        void doUnion(int u,int v){
            int ulp_u=findUltimateParent(u);
            int ulp_v=findUltimateParent(v);
            if(ulp_u==ulp_v)return;
            if(size.get(ulp_u)>= size.get(ulp_v)){
                parent.set(ulp_v,ulp_u);
                size.set(ulp_u,size.get(ulp_v)+size.get(ulp_u));
            }
            else{
                parent.set(ulp_u,ulp_v);
                size.set(ulp_v,size.get(ulp_v)+size.get(ulp_u));
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        Disjoint_Set ds = new Disjoint_Set(n);
        HashMap<String,Integer> map = new HashMap<>();
        //adding mails to map
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                if(map.containsKey(accounts.get(i).get(j))){
                    ds.doUnion(i, map.get(accounts.get(i).get(j)));
                }
                else{
                    map.put(accounts.get(i).get(j),i);
                }
            }
        }
        //making merged mail list
        ArrayList<String>[] mergedMail = new ArrayList[n];
        for(int i=0;i<n;i++)mergedMail[i]=new ArrayList<>();
        for(Map.Entry<String ,Integer> it : map.entrySet()){
            String mail = it.getKey();
            int node = ds.findUltimateParent(it.getValue());
            mergedMail[node].add(mail);
        }
        List<List<String>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(mergedMail[i].size()==0)continue;
            List<String> temp = new ArrayList<>();
            temp.add(0,accounts.get(i).get(0));
            Collections.sort(mergedMail[i]);
            temp.addAll(mergedMail[i]);
            ans.add(temp);
        }
        return ans;
    }
}
