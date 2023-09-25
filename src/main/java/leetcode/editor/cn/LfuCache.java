//2023-09-25 09:23:49
//第460题
//请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。
//
// 实现 LFUCache 类：
//
//
// LFUCache(int capacity) - 用数据结构的容量 capacity 初始化对象
// int get(int key) - 如果键 key 存在于缓存中，则获取键的值，否则返回 -1 。
// void put(int key, int value) - 如果键 key 已存在，则变更其值；如果键不存在，请插入键值对。当缓存达到其容量
//capacity 时，则应该在插入新项之前，移除最不经常使用的项。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最近最久未使用 的键。
//
//
// 为了确定最不常使用的键，可以为缓存中的每个键维护一个 使用计数器 。使用计数最小的键是最久未使用的键。
//
// 当一个键首次插入到缓存中时，它的使用计数器被设置为 1 (由于 put 操作)。对缓存中的键执行 get 或 put 操作，使用计数器的值将会递增。
//
// 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
//
//
//
// 示例：
//
//
//输入：
//["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get",
//"get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
//输出：
//[null, null, null, 1, null, -1, 3, null, -1, 3, 4]
//
//解释：
//// cnt(x) = 键 x 的使用计数
//// cache=[] 将显示最后一次使用的顺序（最左边的元素是最近的）
//LFUCache lfu = new LFUCache(2);
//lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
//lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
//lfu.get(1);      // 返回 1
//                 // cache=[1,2], cnt(2)=1, cnt(1)=2
//lfu.put(3, 3);   // 去除键 2 ，因为 cnt(2)=1 ，使用计数最小
//                 // cache=[3,1], cnt(3)=1, cnt(1)=2
//lfu.get(2);      // 返回 -1（未找到）
//lfu.get(3);      // 返回 3
//                 // cache=[3,1], cnt(3)=2, cnt(1)=2
//lfu.put(4, 4);   // 去除键 1 ，1 和 3 的 cnt 相同，但 1 最久未使用
//                 // cache=[4,3], cnt(4)=1, cnt(3)=2
//lfu.get(1);      // 返回 -1（未找到）
//lfu.get(3);      // 返回 3
//                 // cache=[3,4], cnt(4)=1, cnt(3)=3
//lfu.get(4);      // 返回 4
//                 // cache=[3,4], cnt(4)=2, cnt(3)=3
//
//
//
// 提示：
//
//
// 1 <= capacity <= 10⁴
// 0 <= key <= 10⁵
// 0 <= value <= 10⁹
// 最多调用 2 * 10⁵ 次 get 和 put 方法
//
//
// Related Topics 设计 哈希表 链表 双向链表 👍 701 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class LfuCache {
    public static void main(String[] args) {
        //["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
        //[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]
        LFUCache cache = new LfuCache().new LFUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
        cache.put(3,3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        cache.put(4,4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LFUCache {
        int minfreq, capacity;
        Map<Integer, Node> keyTable;
        Map<Integer, DoublyLinkedList> freqTable;

        public LFUCache(int capacity) {
            this.minfreq = 0;
            this.capacity = capacity;
            keyTable = new HashMap<>();
            freqTable = new HashMap<>();
        }

        public int get(int key) {
            if (capacity == 0) {
                return -1;
            }
            if (!keyTable.containsKey(key)) {
                return -1;
            }
            Node node = keyTable.get(key);
            int val = node.val, freq = node.freq;
            freqTable.get(freq).remove(node);
            // 如果当前链表为空，我们需要在哈希表中删除，且更新minFreq
            if (freqTable.get(freq).size == 0) {
                freqTable.remove(freq);
                if (minfreq == freq) {
                    minfreq += 1;
                }
            }
            // 插入到 freq + 1 中
            DoublyLinkedList list = freqTable.getOrDefault(freq + 1, new DoublyLinkedList());
            list.addFirst(new Node(key, val, freq + 1));
            freqTable.put(freq + 1, list);
            keyTable.put(key, freqTable.get(freq + 1).getHead());
            return val;
        }

        public void put(int key, int value) {
            if (capacity == 0) {
                return;
            }
            if (!keyTable.containsKey(key)) {
                // 缓存已满，需要进行删除操作
                if (keyTable.size() == capacity) {
                    // 通过 minFreq 拿到 freqTable[minFreq] 链表的末尾节点
                    Node node = freqTable.get(minfreq).getTail();
                    keyTable.remove(node.key);
                    freqTable.get(minfreq).remove(node);
                    if (freqTable.get(minfreq).size == 0) {
                        freqTable.remove(minfreq);
                    }
                }
                DoublyLinkedList list = freqTable.getOrDefault(1, new DoublyLinkedList());
                list.addFirst(new Node(key, value, 1));
                freqTable.put(1, list);
                keyTable.put(key, freqTable.get(1).getHead());
                minfreq = 1;
            } else {
                // 与 get 操作基本一致，除了需要更新缓存的值
                Node node = keyTable.get(key);
                int freq = node.freq;
                freqTable.get(freq).remove(node);
                if (freqTable.get(freq).size == 0) {
                    freqTable.remove(freq);
                    if (minfreq == freq) {
                        minfreq += 1;
                    }
                }
                DoublyLinkedList list = freqTable.getOrDefault(freq + 1, new DoublyLinkedList());
                list.addFirst(new Node(key, value, freq + 1));
                freqTable.put(freq + 1, list);
                keyTable.put(key, freqTable.get(freq + 1).getHead());
            }
        }
    }

    class Node {
        int key, val, freq;
        Node prev, next;

        Node() {
            this(-1, -1, 0);
        }

        Node(int key, int val, int freq) {
            this.key = key;
            this.val = val;
            this.freq = freq;
        }
    }

    class DoublyLinkedList {
        Node dummyHead, dummyTail;
        int size;

        DoublyLinkedList() {
            dummyHead = new Node();
            dummyTail = new Node();
            dummyHead.next = dummyTail;
            dummyTail.prev = dummyHead;
            size = 0;
        }

        public void addFirst(Node node) {
            Node prevHead = dummyHead.next;
            node.prev = dummyHead;
            dummyHead.next = node;
            node.next = prevHead;
            prevHead.prev = node;
            size++;
        }

        public void remove(Node node) {
            Node prev = node.prev, next = node.next;
            prev.next = next;
            next.prev = prev;
            size--;
        }

        public Node getHead() {
            return dummyHead.next;
        }

        public Node getTail() {
            return dummyTail.prev;
        }
    }


/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}