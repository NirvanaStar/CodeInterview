// 使用HashMap, key为原始node，value为复制的node
// Two Pointers, 一个指向原始链表，一个指向新链表，遍历原始的链表，复制next关系，形成新的链表，并将原始node和新复制的node加入map
// 再次遍历原始链表，根据map 复制random关系。

// Time: O(2n) Space: O(n)

public RandomListNode copyRandomList(RandomListNode head) {
      if (head == null){
          return null;
      }

      HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();

      RandomListNode p = head;
      RandomListNode dummy = new RandomListNode(0);
      RandomListNode q = dummy;

      while (p != null){
          RandomListNode node = new RandomListNode(p.label);
          q.next = node;
          map.put(p, node);
          p = p.next;
          q = q.next;
      }

      p = head;

      while (p != null){
          RandomListNode start = map.get(p);
          RandomListNode node = p.random;
          if (node == null){
              start.random = null;
          }
          else{
              RandomListNode end = map.get(node);
              start.random = end;
          }
          p = p.next;
      }

      return dummy.next;
  }
  

// 优化：
// 不需要Extra Space，也就是说不需要Map
// 1. 遍历三遍
// 2. 复制每个node，原始node的next指向复制的node，复制node的next指向原始的
// 3. 复制random指针
// 4. 恢复原始list，生成新list

// Time: O(3n) Space: O(1)

public RandomListNode copyRandomList(RandomListNode head) {
      if (head == null){
          return null;
      }

      RandomListNode p = head;

      while (p != null){
          RandomListNode newNode = new RandomListNode(p.label);
          newNode.next = p.next;
          p.next = newNode;
          p = newNode.next;
      }

      p = head;
      while (p != null){
          if (p.random != null){
              p.next.random = p.random.next;
          }
          p = p.next.next;
      }

      p = head;
      RandomListNode newHead = head.next; 

      while (p != null){
          RandomListNode node = p.next;
          p.next = node.next;
          if (node.next != null){
              node.next = node.next.next;
          }
          p = p.next;
      }

      return newHead;   
}
