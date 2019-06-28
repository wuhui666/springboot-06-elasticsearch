package springboot06elasticsearch.elastic;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import springboot06elasticsearch.pojo.Article;

import java.util.List;

/**
 * @author: wuhui
 * @time: 2019/6/27 22:01
 * @desc:啥也不用写，如果不能满足再自定义方法，方法命名规则和jpa类似
 */
public interface MyRepository extends ElasticsearchRepository<Article,Integer> {
        public List<Article> findArticlesByTitleContains(String str);
}
