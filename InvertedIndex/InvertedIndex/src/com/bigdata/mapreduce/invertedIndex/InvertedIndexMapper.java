package com.bigdata.mapreduce.invertedIndex;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
import org.apache.hadoop.mapreduce.Mapper;

//public class InvertedIndexMapper extends Mapper<LongWritable, Text, Text, Text> {
//
//
//	@Override
//	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
//
//		StringTokenizer tokenizer = new StringTokenizer(value.toString());
//
//		FileSplit fileSplit = (FileSplit) context.getInputSplit();
//		Text filePath = new Text(fileSplit.getPath().getName());
//
//		while (tokenizer.hasMoreTokens()) {
//			context.write(new Text(tokenizer.nextToken()), filePath);
//		}
//	}
//
//}

public class InvertedIndexMapper extends Mapper<LongWritable, Text, Text, Text>{
	
	@Override
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		
		//https://hadoop.apache.org/docs/r2.4.1/api/org/apache/hadoop/mapred/FileSplit.html
		String fileName = ((FileSplit) context.getInputSplit()).getPath().getName();
		Text name = new Text(fileName);
		
		//fast & iterator don't have to load all data
		StringTokenizer tokenizor = new StringTokenizer(value.toString());
		while(tokenizor.hasMoreTokens()) {
			context.write(new Text(tokenizor.nextToken()), name);
		}
	}
}
