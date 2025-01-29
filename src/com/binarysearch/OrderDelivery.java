package com.binarysearch;

import java.util.HashMap;
import java.util.Map;


/*You are given a list of strings orders. Each element in orders starts with either "P" meaning pickup or "D" meaning delivery followed by the order id. For example, "P12" means pick up order 12.

Return whether orders is valid given the following rules:

A delivery cannot happen for an order before pickup
Every pickup must be delivered
An order that's already been picked up and delivered cannot be picked up or delivered again
Constraints

0 ≤ n ≤ 100,000 where n is the length of orders
Example 1
Input
orders = ["P1", "P2", "D2", "D1"]
Output
true
Explanation
We first pick up orders 1 and 2 then we drop 2 and 1.
*/
public class OrderDelivery {
	public static void main(String[] args) {
		String delivery[] = new String[] { "D1" };
		System.out.println(new OrderDelivery().solve(delivery));
	}

	public boolean solve(String[] orders) {
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < orders.length; i++) {
			if (map.containsKey(orders[i])) {
				return false;
			}

			if (orders[i].contains("P")) {
				map.put(orders[i], 0);
			} else {
				String subString = "P" + orders[i].substring(1, orders[i].length());
				if (map.containsKey(subString) && map.get(subString) == 0) {
					map.put(subString, 1);
				} else
					return false;
			}
		}
		for (Map.Entry<String, Integer> e : map.entrySet()) {
			if (e.getValue() == 0)
				return false;
		}
		return true;
	}
}
