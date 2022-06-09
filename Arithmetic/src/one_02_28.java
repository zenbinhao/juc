
public class one_02_28 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(2);

        listNode.next = listNode1;
        listNode1.next =listNode2;

        int[] ints = reversePrint(listNode);
        for (int i : ints){
            System.out.println(i);
        }
    }
    //思路一、应该直接遍历一次  长度然后  长度自减式把  链表按顺序遍历放进去即可    相当于把数组倒着填充

    //思路二、把链表倒过来 再按顺序填充即可

    public static int[] reversePrint(ListNode head) {
        int count = 0;
        if(head.next==null){
            return null;
        }
        ListNode nextNode= head.next;
        ListNode listNode= new ListNode(head.next.val);
        while(nextNode.next!=null){
            //新的节点
            ListNode newNode = new ListNode(nextNode.next.val);
            //新的节点 的下一个节点指向原来的已有的节点
            newNode.next = listNode;
            //新的链表  替换原来的链表
            listNode = newNode;

            //指针指向下一个节点  进行遍历
            nextNode = nextNode.next;
            count++;
        }
        int[] ints = new int[count];
        for (int i = 0; i < count; i++) {
            ints[i] = listNode.next.val;

            listNode = listNode.next;
        }
        return ints;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
