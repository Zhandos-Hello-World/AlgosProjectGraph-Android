package production.zhandos.myapplication.recommend;

import java.util.*;

public class DFS {
    static HashSet<FilterUser> set;
    static FilterUser currUser;


    static List<FilterUser> bfs(FilterUser v) {
        LinkedHashSet<FilterUser> returnValue = new LinkedHashSet<>();
        int k = 0;
        Queue<FilterUser> queue = new LinkedList<>();
        queue.add(v);
        while (!queue.isEmpty()) {
            int len = queue.size();
            if (k == 2)
                break;
            for (int i = 0; i < len; i++) {
                FilterUser u = queue.poll();
                for (int j = 0; j < u.getFriends().size(); j++) {
                    FilterUser friend = u.getFriends().get(j);
                    if (!set.contains(friend)) {
                        queue.add(friend);
                        if (!currUser.getFriends().contains(friend) && currUser != friend)
                            returnValue.add(friend);
                    }

                }
            }
            k++;
        }
        return new LinkedList<>(returnValue);
    }
}

