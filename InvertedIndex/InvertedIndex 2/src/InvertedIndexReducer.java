

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Mapper.Context;

public class InvertedIndexReducer extends Reducer<Text, Text, Text, Text> {
	
	@Override
	public void reduce(final Text key, final Iterable<Text> values, final Context context) throws IOException, InterruptedException {
		
		int threashold = 100;
		int count = 0;
		
		StringBuilder sb = new StringBuilder();
		
		//<keyword doc1,doc2,doc3...>
		
		//values <doc1, doc2, doc2, doc2, doc3,..>
		for(Text value: values) {
			sb.append(value);
			sb.append("\t");
			count ++;
		}
		
		if(count <threashold)
			return;
		
		context.write(key, new Text(sb.toString()));
	}

}
