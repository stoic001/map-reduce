import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;


public class MovieRelation {

	private int movie1;
	private int movie2;
	private int relation;

	public MovieRelation(int movie1, int movie2, int relation) {
		this.movie1 = movie1;
		this.movie2 = movie2;
		this.relation = relation;
	}
	
	public int getMovie1() {
		return movie1;
	}
	public void setMovie1(int movie1) {
		this.movie1 = movie1;
	}
	public int getMovie2() {
		return movie2;
	}
	public void setMovie2(int movie2) {
		this.movie2 = movie2;
	}
	public int getRelation() {
		return relation;
	}
	public void setRelation(int relation) {
		this.relation = relation;
	}
	
}
