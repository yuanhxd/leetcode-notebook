package leetcode.editor.cn;

//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
// Related Topics 递归 链表 数学 
// 👍 7128 👎 0

class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(6);
        ListNode listNode6 = new ListNode(4);

        listNode1.next = listNode3;
        listNode3.next = listNode2;

        listNode4.next = listNode5;
        listNode5.next = listNode6;
        ListNode listNode = solution.addTwoNumbers(listNode1, listNode4);

        listNode.show();

    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    '}';
        }

        public void show() {
            ListNode root = this;
            if (root == null) {
                return;
            }
            while (true) {
                System.out.println(root);
                if (root.next == null) {
                    break;
                }
                root = root.next;
            }

        }
    }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//            String s1 = "";
//            String s2 = "";
//            while (l1 != null) {
//                s1 += l1.val;
//                l1 = l1.next;
//            }
//            while (l2 != null) {
//                s2 += l2.val;
//                l2 = l2.next;
//            }
//            String sumStr = Integer.parseInt(reverse(s1)) + Integer.parseInt(reverse(s2)) + "";
//            ListNode root = new ListNode(-1);
//            ListNode cur = root;
//            if (s1 == "0" && s2 == "0") {
//                root.next = new ListNode(0);
//                return root;
//            }
//            for (int i = sumStr.length() - 1; i >= 0; i--) {
//                cur.next = new ListNode(Integer.parseInt(sumStr.charAt(i) + ""));
//                cur = cur.next;
//            }
//            return root;


            ListNode head = null, tail = null;
            int carry = 0;
            while (l1 != null || l2 != null) {
                int n1 = l1 != null ? l1.val : 0;
                int n2 = l2 != null ? l2.val : 0;
                int sum = n1 + n2 + carry;
                if (head == null) {
                    head = tail = new ListNode(sum % 10);
                } else {
                    tail.next = new ListNode(sum % 10);
                    tail = tail.next;
                }
                carry = sum / 10;
                if (l1 != null) {
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }
            }
            if (carry > 0) {
                tail.next = new ListNode(carry);
            }
            return head;
        }

        public String reverse(String str) {
            String res = "";
            for (int i = str.length() - 1; i <= 0; i--) {
                res += str.charAt(i);
            }
            return str;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
