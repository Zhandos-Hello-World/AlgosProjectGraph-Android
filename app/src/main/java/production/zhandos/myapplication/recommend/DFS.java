package production.zhandos.myapplication.recommend;

import java.util.*;

public class DFS {
    static HashSet<FilterUser> set;
    static FilterUser currUser;

    static void bfs(FilterUser v) {
        int k = 0;
        Queue<FilterUser> queue = new LinkedList<>();
        queue.add(v);
        while (!queue.isEmpty()) {
            int len = queue.size();
            //System.out.println("bef");
            if (k == 2)
                break;
            for (int i = 0; i < len; i++) {
                FilterUser u = queue.poll();
                for (int j = 0; j < u.getFriends().size(); j++) {
                    FilterUser friend = u.getFriends().get(j);
                    if (!set.contains(friend)) {
                        queue.add(friend);
                        if (!currUser.getFriends().contains(friend))
                            System.out.println(friend.getName());
                    }

                }
            }
            k++;
        }
    }


    public static void main(String[] args) {
        FilterUser user1 = new FilterUser(1, "Zhandos", new ArrayList<>());
        FilterUser user2 = new FilterUser(2, "Alibi", new ArrayList<>());
        FilterUser user3 = new FilterUser(3, "Akbota", new ArrayList<>());
        FilterUser user4 = new FilterUser(4, "Kymbat", new ArrayList<>());
        FilterUser user5 = new FilterUser(5, "Nurzhan", new ArrayList<>());
        FilterUser user6 = new FilterUser(6, "Moldir", new ArrayList<>());
        user1.getFriends().add(user2);
        user1.getFriends().add(user3);
        user2.getFriends().add(user4);
        user4.getFriends().add(user5);
        user5.getFriends().add(user6);
        user3.getFriends().add(user5);
        user2.getFriends().add(new FilterUser(7, "Askar", new ArrayList<>()));
        set = new HashSet<>();
        currUser = user1;
        bfs(user1);
    }
}
