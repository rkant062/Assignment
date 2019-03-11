package com.data.median.business;

import java.util.*;

import com.data.median.service.FindMedianUsingHeaps;

public class GroupBy {

	String groupByAttribute;

	public GroupBy(String attributeName) {
		this.groupByAttribute = attributeName;
	}

	public int findIndexToAttribute(List<List> list) {
		int groupIndex = 0;
		for (int i = 0; i < list.get(0).size(); i++) {
			if (("" + list.get(0).get(i)).equals(groupByAttribute) == true)
				groupIndex = i;
		}
		return groupIndex;

	}

	public String mapData(List<List> list, int groupIndex) {
		Map<String, Map<String, FindMedianUsingHeaps>> grouped_map = new HashMap<String, Map<String, FindMedianUsingHeaps>>();
		{
			for (int i = 1; i < list.size(); i++) {
				if (!grouped_map.containsKey(list.get(i).get(groupIndex)))
					grouped_map.put(list.get(i).get(groupIndex).toString(),
							new HashMap<String, FindMedianUsingHeaps>());
				for (int j = 0; j < list.get(i).size(); j++) {
					if (j != groupIndex) {
						if (grouped_map.get(list.get(i).get(groupIndex).toString())
								.get(list.get(0).get(j).toString()) == null)
							grouped_map.get(list.get(i).get(groupIndex).toString()).put(
									list.get(0).get(j).toString(),
									getObjectData(new FindMedianUsingHeaps(), list.get(i).get(j).toString()));
							else
							grouped_map
									.get(list.get(
											i).get(
													groupIndex)
											.toString())
									.put(list.get(0).get(j).toString(),
											getObjectData(
													grouped_map.get(list.get(i).get(groupIndex).toString())
															.get(list.get(0).get(j).toString()),
													list.get(i).get(j).toString()));
					}
				}

			}

			return printMedians(grouped_map, list.get(1).get(groupIndex) + "");
		}
	}

	//method to append the output and send back to the client. 
	public String printMedians(Map<String, Map<String, FindMedianUsingHeaps>> grouped_map, String label) {
		String app = "label";
		for (String k : grouped_map.get(label).keySet())
			app += "," + k;
		app += "\n";
		for (String i : grouped_map.keySet()) {
			app += i;
			for (String j : grouped_map.get(i).keySet()) {
				try {

					if (grouped_map.get(i).get(j) != null) {
						double d = grouped_map.get(i).get(j).findMedian();
						app += "," + d;

					} else
						app += ",null";

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			app += "\n";
		}
		return app;
	}

	public FindMedianUsingHeaps getObjectData(FindMedianUsingHeaps f, String s) {

		try {
			double x = Double.parseDouble(s);
			f.addNum(x);
			return f;
		} catch (Exception e) {
			return null;
		}
	}

}
