import java.util.*;
public class Main{
    public static void main(String[] args){
        int v = 5;
        int indegree[] = new int[5];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);
        for(int i = 0; i < v; i++){
            adj.add(new ArrayList<Integer>());
        }
        addEdge(adj,0,1,indegree);
        addEdge(adj,1,2,indegree);
        addEdge(adj,2,3,indegree);
        //addEdge(adj,3,1,indegree);
        addEdge(adj,4,1,indegree);
        detectCycle(adj,v,indegree);
    }
    public static void addEdge( ArrayList<ArrayList<Integer>> adj,int u,int v,int[] indegree){
        adj.get(u).add(v);
        indegree[v]++;
    }
    public static void detectCycle(ArrayList<ArrayList<Integer>> adj,int v,int[] indegree){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[v];
        int count = 0;
        for(int i = 0; i < v; i++){
            if(indegree[i] == 0){
                visited[i] = true;
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            count++;
            for(int i : adj.get(curr)){
                if(!visited[i]){
                    indegree[i]--;
                    if(indegree[i] == 0) {
                            visited[i] = true;
                            q.add(i);
                        }
                }
                
            }
        }
        if(count != v){
            System.out.println("CYCLE EXISTS");
        }
        else{
            System.out.println("ACYCLIC");
        }
    }
    
}
