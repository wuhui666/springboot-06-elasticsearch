package springboot06elasticsearch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import springboot06elasticsearch.elastic.MyRepository;
import springboot06elasticsearch.pojo.Article;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot06ElasticsearchApplicationTests {

    @Autowired
    MyRepository repository;

    /*测试加入*/
    @Test
    public void test1() {
        Article article=new Article();
        article.setTitle("西游记");
        article.setAuthor("吴承恩");
        article.setId(101);
        article.setContent("五百年前，孙悟空大闹天空。。。。");
        Article article2=new Article();
        article2.setTitle("东游记");
        article2.setAuthor("吴承恩");
        article2.setId(102);
        article2.setContent("三百年前，世态炎凉，万物。。。。。。。");
        Article article3=new Article();
        article3.setTitle("红楼梦");
        article3.setAuthor("曹雪芹");
        article3.setId(103);
        article3.setContent("万物复苏的春天，林黛玉。。。");
        repository.save(article);
        repository.save(article2);
        repository.save(article3);
    }
    /*测试条件搜索*/
    @Test
    public void test2(){
        List<Article> list = repository.findArticlesByTitleContains("游记");
        if (list == null) {
            return;
        }
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i).toString());
        }
    }

}
