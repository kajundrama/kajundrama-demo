package me.kajundrama.demo.batch;

import javax.sql.DataSource;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

  @Autowired
  private JobBuilderFactory jobBuilderFactory;

  @Autowired
  private StepBuilderFactory stepBuilderFactory;

  @Autowired
  public DataSource dataSource;

  @Bean
  public FlatFileItemReader<Person> reader() {
    FlatFileItemReader<Person> reader = new FlatFileItemReader<Person>();
    reader.setResource(new ClassPathResource("sample-data.csv"));
    reader.setLineMapper(new DefaultLineMapper<Person>() {{
      setLineTokenizer(new DelimitedLineTokenizer() {{
        setNames(new String[] { "firstName", "lastName" });
      }});
      setFieldSetMapper(new BeanWrapperFieldSetMapper<Person>() {{
        setTargetType(Person.class);
      }});
    }});
    return reader;
  }

  @Bean
  public PersonItemProcessor processor() {
    return new PersonItemProcessor();
  }

  @Bean
  public JdbcBatchItemWriter<Person> writer() {
    JdbcBatchItemWriter<Person> writer = new JdbcBatchItemWriter<Person>();
    writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Person>());
    writer.setSql("INSERT INTO people (first_name, last_name) VALUES (:firstPName, :lastName)");
    writer.setDataSource(dataSource);
    return writer;
  }
  // end::readerwriterprocessor[]

  // tag::jobstep[]

  /**
   * Job을 빌드한다.
   * @param listener
   * @return
   */
  @Bean
  public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
    return jobBuilderFactory.get("importUserJob")
        .incrementer(new RunIdIncrementer())
        .listener(listener)
        .flow(step1)
        .end()
        .build();
  }

  @Bean
  public Step step1(FlatFileItemReader reader) {
    return stepBuilderFactory.get("step1")
        .<Person, Person> chunk(10)
        .reader(reader)
        .processor(processor())
        .writer(writer())
        .build();
  }
  // end::jobstep[]

}
