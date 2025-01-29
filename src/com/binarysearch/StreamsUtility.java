package com.binarysearch;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsUtility {

	public static void main(String[] args) {
		List<Integer> numsArray = Arrays.asList(1, 2, 3, 3, 4, 4, 5, 5, 6, 7, 8, 9, 55, 44, 33, 22, 66);
		List<String> stringsArray = Arrays.asList("Shubham", "Saurabh", "Gaurav", "Gautam", "Gulshan", "Shishu",
				"Aryan", "Anand", "Tuktuk", "Janu");

		System.out.println("===========================================================================");

		Integer intSumUsingReduce = numsArray.stream().reduce(10, (a, b) -> a + b);
		Integer intSumUsingIntStream = numsArray.stream().mapToInt(Integer::intValue).sum();
		Integer intSumUsingIntsum = numsArray.stream().reduce(20, Integer::sum);
		Integer intSumUsingArithmeticUtils = numsArray.stream().reduce(30, ArithmeticUtils::add);
		Integer intSumUsingCollectors = numsArray.stream().collect(Collectors.summingInt(Integer::intValue));

		System.out.println("Total sum of numbers in array is :" + intSumUsingReduce);
		System.out.println("Total sum of numbers in array is :" + intSumUsingIntsum);
		System.out.println("Total sum of numbers in array is :" + intSumUsingArithmeticUtils);
		System.out.println("Total sum of numbers in array is :" + intSumUsingCollectors);
		System.out.println("Total sum of numbers in array is :" + intSumUsingIntStream);

		System.out.println("===========================================================================");

		System.out.print("Distinct Elements in my integer list are :: ");
		numsArray.stream().distinct().forEach(element -> System.out.print(element + " "));

		System.out.println();
		System.out.println("===========================================================================");

		long count = numsArray.stream().distinct().count();
		System.out.println("Total Count of Distinct Elements in my integer list are :: " + count);

		System.out.println("===========================================================================");

		int frequency = Collections.frequency(numsArray, 4);
		System.out.println("Total frequency of 4 in my integer list are :: " + frequency);

		System.out.println("===========================================================================");

		HashMap<Integer, Long> frequencyMap = numsArray.stream()
				.collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()));
		System.out.println("Total Frequency map of elements in numsArray is :: ");
		frequencyMap.forEach((key, val) -> System.out.println("Element :: " + key + " Count :: " + val));

		System.out.println("===========================================================================");

		Optional<Entry<Integer, Long>> maxFrequency = frequencyMap.entrySet().stream()
				.max(Map.Entry.comparingByValue());

		System.out.print("Element with max frequency is :: ");
		maxFrequency.ifPresent(entry -> System.out
				.println("Element Key : " + entry.getKey() + " Element value : " + entry.getValue()));

		System.out.println("===========================================================================");

		// to return the larger element with max frequency, use custom comparator that
		// first compares by frequency and then by the element value itself.

		Comparator<? super Entry<Integer, Long>> keyValComparator = (entry1, entry2) -> {
			int freqCompare = entry1.getValue().compareTo(entry2.getValue());
			if (freqCompare == 0) {
				return entry1.getKey().compareTo(entry2.getKey());
			}
			return freqCompare;
		};

		Optional<Entry<Integer, Long>> maxFrequencyLargerElement = frequencyMap.entrySet().stream()
				.max(keyValComparator);

		System.out.print("Larger Element with max frequency is :: ");
		maxFrequencyLargerElement.ifPresent(entry -> System.out
				.println("Element Key : " + entry.getKey() + " Element count : " + entry.getValue()));

		System.out.println("===========================================================================");

		List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2, 2, 3), Arrays.asList(3, 4, 4, 4),
				Arrays.asList(5, 5, 5, 5));

		HashMap<Integer, Long> frequencyMapListOfLists = listOfLists.stream().flatMap(List::stream)
				.collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()));
		System.out.println("Total Frequency map of elements in numsArray is :: ");
		frequencyMapListOfLists.forEach((key, val) -> System.out.println("Element :: " + key + " Count :: " + val));

		System.out.println("===========================================================================");
	}
}

class ArithmeticUtils {
	public static int add(int a, int b) {
		return a + b;
	}
}

class MostFrequencyUtil {

	static int mostFrequent(int arr[], int n) {

		Map<Integer, Integer> hp = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			int key = arr[i];
			if (hp.containsKey(key)) {
				int freq = hp.get(key);
				freq++;
				hp.put(key, freq);
			} else {
				hp.put(key, 1);
			}
		}
		int max_count = 0, res = -1;
		for (Entry<Integer, Integer> val : hp.entrySet()) {
			if (max_count < val.getValue()) {
				res = val.getKey();
				max_count = val.getValue();
			}
		}
		return res;
	}
}
