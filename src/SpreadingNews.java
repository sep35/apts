import java.util.ArrayList;
import java.util.Collections;

public class SpreadingNews {

        public int minTime(int[] supervisors) {
                return minTime(supervisors, 0);
        }

        
        private int minTime(int[] supervisors, int start) {
                ArrayList<Integer> children = new ArrayList<Integer>();
                int l = supervisors.length;
                for (int i = start + 1; i < l; i++) {
                        if (supervisors[i] == start)
                                children.add(minTime(supervisors, i));
                }

                Collections.sort(children);
                Collections.reverse(children);

                int res = 0;
                for (int i = 0; i < children.size(); i++) {
                        res = Math.max(res, i + 1 + children.get(i));
                }

                return res;
        }

}