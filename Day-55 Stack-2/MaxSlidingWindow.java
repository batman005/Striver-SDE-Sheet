import java.util.*;
class Solution {
    public static int[] maxSlidingWindow(int[] a, int k) {
        int n = a.length;
        int[] r = new int[n - k + 1];
        int ri = 0;
        // store index
        Deque < Integer > q = new ArrayDeque < > ();
        for (int i = 0; i < a.length; i++) {
            // remove numbers out of range k
            if (!q.isEmpty() && q.peek() == i - k) {
                q.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();
            }

            q.offer(i);
            if (i >= k - 1) {
                r[ri++] = a[q.peek()];
            }
        }
        return r;
    }
    public static void main(String args[]) {
        int i, j, n, k = 3, x;
        int arr[]={4,0,-1,3,5,3,6,8};
        int ans[] = maxSlidingWindow(arr, k);
        System.out.println("Maximum element in every " + k + " window ");
        for (i = 0; i < ans.length; i++)
            System.out.print(ans[i] + "  ");

    }
}



//using List of integer
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();  // stores *indices*
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!q.isEmpty() && nums[q.getLast()] <= nums[i]) {
                q.removeLast();
            }
            q.addLast(i);
            // remove first element if it's outside the window
            if (q.getFirst() == i - k) {
                q.removeFirst();
            }
            // if window has k elements add to results (first k-1 windows have < k elements because we start from empty window and add 1 element each iteration)
            if (i >= k - 1) {
                res.add(nums[q.peek()]);
            }
        }
        return res.stream().mapToInt(i->i).toArray();            
    }
}