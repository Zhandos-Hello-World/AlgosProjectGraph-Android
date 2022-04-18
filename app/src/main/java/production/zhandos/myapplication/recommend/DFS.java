package production.zhandos.myapplication.recommend;

import android.util.Log;

import java.util.*;

public class DFS {

    static HashSet<FilterUser> set;
    static FilterUser currUser;
    static HashMap<FilterUser, ArrayList<FilterUser>> hm;


    static List<FilterUser> bfs(FilterUser v) {
        set = new HashSet<>();

        int k = 0;
        Queue<FilterUser> queue = new LinkedList<>();
        List<FilterUser> returnValue = new LinkedList<>();
        queue.add(v);
        while (!queue.isEmpty()) {
            int len = queue.size();
            if (k == 2)
                break;
            for (int i = 0; i < len; i++) {
                FilterUser u = queue.poll();
                ArrayList<FilterUser> temp = hm.get(u);
                for (int j = 0; j < temp.size(); j++) {
                    FilterUser friend = temp.get(j);
                    if (!set.contains(friend)) {
                        queue.add(friend);
                        if (!hm.get(currUser).contains(friend))
                            returnValue.add(friend);
                    }
                }
            }
            k++;
        }
        return returnValue;
    }
}

