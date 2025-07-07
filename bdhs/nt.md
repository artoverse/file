
1. steps to serialization and deser in Avro:

    - is a process of converting the object into a format that can be stored or transmitted.
    - deserialization is a reverse process, reconstructing the original objects from serialized form.
    - avro is well suited for this due to it's schema structure.

    serialization : 

    1. define schema:  in json format, describes structure of records, include names, types and namespaces.
    2. class : in specific programming language create a user class useing getter and setter methods.
    3. create data objects : intialize the objects in the user class, which is needed for the serialization.
    4. prepare DatumWriter : it converts data objects to Avro in memory data reprasentation.
    5. prepare an Encoder : it takes the data from DatumWriter and converts into an output datastream.
    6. perform serialization : call the Write() method of DatumWriter by passing your object and Encoder. it writes the serialized data as a output stream.

    De serialization: 

    1. Obtain the schema : used in the Serializaiton, for specific file both writer and reader schema is needed.
    2. prepare a DatumReader : converts the avro data to programming lang data objects.
        SpecificDatumReader<User> datumReader = new SpecificDatumReader<>(User.class)
    3. prepare a Decoder : reads the serialized data from an input stream.
    4. Perform Deserialization : call the read method of DatumReader & Decoder, this wiill reconstruct the original data obj.

    Serialization: Data Object -> DatumWriter -> Encoder -> Output Stream

    Deserialization: Input Stream -> Decoder -> DatumReader -> Data Object


2. open-source columnar storage format designed for efficient data storage and retrieval, especially with large-scale analytical processing. It is optimized for use with query processing frameworks like Apache Hive

    Use cases : 

    1. Big Data analytics : ideal for OLAP workloads, where queries typically access the subset of columns across many rows.
        - interactive queries in large datasets.
    2. Machine learning : in case the model only needed the specific colums to process or access the data efficiently.
    3. Data Archiving : it's a compact storage for long time archival of data may in large amount.
    4. Inter-portability : used a common intercharge formate between different bigdata frameworks.

    benefints : 

    1. Reduced Storage spaces : compression and ecoding, significantly reduces the storage.
    2. Faster query performance : column pruning, predicate pushdown, optimized.
    3. cost saving.
    4. shemaevalution : just adding columns without rewriting
    5. efficient data ser/des : 

3. 



wordcount 



import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class WordCount {

  public static class TokenizerMapper
       extends Mapper<Object, Text, Text, IntWritable>{

    private final static IntWritable one = new IntWritable(1);
    private Text word = new Text();

    public void map(Object key, Text value, Context context
                    ) throws IOException, InterruptedException {
      StringTokenizer itr = new StringTokenizer(value.toString());
      while (itr.hasMoreTokens()) {
        word.set(itr.nextToken());
        context.write(word, one);
      }
    }
  }

  public static class IntSumReducer
       extends Reducer<Text,IntWritable,Text,IntWritable> {
    private IntWritable result = new IntWritable();

    public void reduce(Text key, Iterable<IntWritable> values,
                       Context context
                       ) throws IOException, InterruptedException {
      int sum = 0;
      for (IntWritable val : values) {
        sum += val.get();
      }
      result.set(sum);
      context.write(key, result);
    }
  }

  public static void main(String[] args) throws Exception {
    Configuration conf = new Configuration();
    Job job = Job.getInstance(conf, "word count");
    job.setJarByClass(WordCount.class);
    job.setMapperClass(TokenizerMapper.class);
    job.setCombinerClass(IntSumReducer.class);
    job.setReducerClass(IntSumReducer.class);
    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(IntWritable.class);
    FileInputFormat.addInputPath(job, new Path(args[0]));
    FileOutputFormat.setOutputPath(job, new Path(args[1]));
    System.exit(job.waitForCompletion(true) ? 0 : 1);
  }
}
