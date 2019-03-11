package com.data.median.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.data.median.business.GroupBy;
import com.google.gson.Gson;

@RestController
public class MedianOfLabels {

	private static final Logger logger = LoggerFactory.getLogger(MedianOfLabels.class);

	@RequestMapping(value = "/findMedian", method = RequestMethod.POST)
	public ResponseEntity<String> findMedians(@RequestBody String data) {
		List<List> list = new Gson().fromJson(data, List.class);
		GroupBy gb = new GroupBy("label"); // The group by attribute will hold a value which can be specified by the
											// user through a combo box.
		int groupIndex = gb.findIndexToAttribute(list);
		String output = gb.mapData(list, groupIndex);

		return ResponseEntity.status(HttpStatus.OK).body(output.toString());
	}

}
