package com.bigdata.mapreduce.invertedIndex;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class InvertedIndexReducer extends Reducer<Text, Text, Text, Text> {
	
	@Override
	public void reduce(final Text key, final Iterable<Text> values, final Context context) throws IOException, InterruptedException {
		
		StringBuilder sb = new StringBuilder();
		
		//<keyword doc1,doc2,doc3...>
		
		//values <doc1, doc2, doc2, doc2, doc3,..>
		for(Text value: values) {
			sb.append(value);
			sb.append("\t");
		}
		
		context.write(key, new Text(sb.toString()));
	}

//	@Override
//	public void reduce(final Text key, final Iterable<Text> values,
//			final Context context) throws IOException, InterruptedException {
//
//		StringBuilder sb = new StringBuilder();
//		boolean first = true;
//		String last = null;
//		
//		for (Text file: values){
//			if (!first){
//				if(file.toString().equals(last)) {
//					continue;
//				}
//				last = file.toString();
//				sb.append(", ");
//			}
//			if(last == null) {
//				last = file.toString();
//			}
//			
//			first = false;
//			sb.append(file.toString());
//		}
//		
//		context.write(key, new Text(sb.toString()));
//	}

}
