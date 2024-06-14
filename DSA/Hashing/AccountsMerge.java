package DSA.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountsMerge {
    static class DisjointSet {
        private int[] parent;
        private int[] rank;
        DisjointSet(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        // path compression
        int find(int i) {
            if (parent[i] != i) {
                parent[i] = find(parent[i]);
            }

            return parent[i];
        }

        void union(int x, int y) {
            int xroot = find(x);
            int yroot = find(y);

            if (xroot == yroot)
                return;

            if (rank[xroot] < rank[yroot]) {
                parent[yroot] = xroot;
            } else if (rank[xroot] > yroot) {
                parent[xroot] = yroot;
            } else {
                parent[yroot] = xroot;
                rank[xroot]++;
            }
        }
    }

    // accounts[i][0] = name remaining are emails
    static List<List<String>> accountsMerge(List<List<String>> accounts) {
        // code here
        /**
         * 1. create a Disjoint Set of size n
         * 2. Have HashMap<Email, IndexOfAccounts> if email already exists union of
         * previous and current index
         * 3. Iterate over emailsMap and add emails respective to their parent index
         * list
         * 4. remove empty accounts and sort added emails
         */

        HashMap<String, Integer> emailsMap = new HashMap<>();
        DisjointSet disjointSet = new DisjointSet(accounts.size());

        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);

                if (!emailsMap.containsKey(email)) {
                    emailsMap.put(email, i);
                } else {
                    disjointSet.union(i, emailsMap.get(email));
                }
            }
        }
        @SuppressWarnings("unchecked")
        List<String>[] mergedList = new ArrayList[accounts.size()];
        for (Map.Entry<String, Integer> set : emailsMap.entrySet()) {
            int parent = disjointSet.find(set.getValue());
            if (mergedList[parent] == null) {
                mergedList[parent] = new ArrayList<>();
            }

            mergedList[parent].add(set.getKey());
        }

        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < accounts.size(); i++) {
            if (mergedList[i] == null || mergedList[i].size() == 0) {
                continue;
            }
            String name = accounts.get(i).get(0);
            mergedList[i].sort(Comparator.naturalOrder());
            ArrayList<String> account = new ArrayList<>();
            account.add(name);
            account.addAll(mergedList[i]);
            result.add(account);
        }
        return result;
    }

    public static void main(String[] args) {
        // Input
        List<List<String>> accounts = Arrays.asList(
                Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
                Arrays.asList("Mary", "mary@mail.com"),
                Arrays.asList("John", "johnnybravo@mail.com"));

        // Create an instance of the Solution class

        // Call the accountsMerge function
        List<List<String>> result = accountsMerge(accounts);

        // Display the result
        for (List<String> vec : result) {
            for (String str : vec) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }
}
