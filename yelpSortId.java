/**
 * Created by yiyangtan on 9/8/15.
 * 1.	sort id
 ==========
 我的朋友碰到的一道题，在stadin里输入一些id，value的pair， 让你根据value排序。这里注意输入的pair可以是任意个。需要用到一个while循环

 ---

 第二部分 20分钟 一道coding题。
 输入数据是这样的。一行一组数据，由空格分开两个数，分别是 ID 和 rating， ID不会重复，最多10000.
 ID1  Rating1.
 ID2  Rating2.
 ID3  Rating3
 ...
 IDn  Ratingn.
 . 1point3acres.com/bbs
 让你根据Rating从大到小排序，再输出。
 比如 输入 是
 103  1
 104  2
 105  3
 输出就是
 105 3
 104 2
 103 1

 题目很简单。但是需要自己处理 STDIN 和 STDOUT。
 自己花了好多时间去google怎么用java处理 STDIN。。。上次用java处理STDIN貌似是3年前的事了。。。
 导致后面没时间了直接赶紧写了一个O(n^2)的冒泡排序。。
 真心吃了一次亏。。。
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class yelpSortId {
    private static HashMap sortByValues(HashMap map) {
        List list = new LinkedList(map.entrySet());
        // Defined Custom Comparator here
        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o2)).getValue())
                        .compareTo(((Map.Entry) (o1)).getValue());
            }
        });

        // Here I am copying the sorted list in HashMap
        // using LinkedHashMap to preserve the insertion order
        HashMap sortedHashMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();
        while(sc.hasNext()){
            int id = sc.nextInt();
            int rate = sc.nextInt();
            map.put(id,rate);
            if(rate==0) break;
        }
        Map<Integer, String> smap = sortByValues(map);
        Set set2 = smap.entrySet();
        Iterator iterator2 = set2.iterator();
        while(iterator2.hasNext()) {
            Map.Entry me2 = (Map.Entry)iterator2.next();
            System.out.print(me2.getKey() + " ");
            System.out.println(me2.getValue());
        }
    }
}
