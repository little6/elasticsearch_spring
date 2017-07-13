package cn.itcast.es.test;

import org.elasticsearch.client.Client;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.domain.Article;
import cn.itcast.service.ArticleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class EsSpringTest {
    
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
    
    @Autowired
    private Client client;

    @Autowired
    private ArticleService articleService;
    
    @Test
    public void testCreateIndex() throws Exception{
        elasticsearchTemplate.createIndex(Article.class);
        elasticsearchTemplate.putMapping(Article.class);
    }
    
    /**保存*/
    @Test
    public void testSave() throws Exception {
        Article article = new Article();
        article.setId(1001);
        article.setTitle("Spring Data Elasticsearch 1.3.1 昨天发布");
        article.setContent("DATAES-171 - 添加失效查询关键字支持 DATAES-194 - 测试可以清理  data 目录 DATAES-179 - 支持  Attachment 字段类型 DATAES-94 - 更新到最新版本的 elasticsearch 1.7.3 驱动器");

        articleService.save(article);
    }

    /**删除*/
    @Test
    public void testDelete() {
        Article article = new Article();
        article.setId(1001);
        articleService.delete(article);
    }
    
    //根据id查找
    @Test
    public void testFindOne() {
        System.out.println(articleService.findOne(1001));
    }

    /**批量保存*/
    @Test
    public void testSaveBatch() throws Exception {
        for (int i = 1; i <= 100; i++) {
            Article article = new Article();
            article.setId(i);
            article.setTitle(i + "Spring Data Elasticsearch 1.3.1 昨天发布");
            article.setContent(i
                    + "DATAES-171 - 添加失效查询关键字支持 DATAES-194 - 测试可以清理  data 目录 DATAES-179 - 支持  Attachment 字段类型 DATAES-94 - 更新到最新版本的 elasticsearch 1.7.3 驱动器");

            articleService.save(article);
        }
    }

    @Test
    // 排序分页查询
    public void testSortAndPaging() {
        Iterable<Article> articles = articleService.findAll();
        for (Article article : articles) {
            System.out.println(article);
        }

        Pageable pageable = new PageRequest(0, 10);
        Page<Article> pageData = articleService.findAll(pageable);
        for (Article article : pageData.getContent()) {
            System.out.println(article);
        }
    }

    @Test
    // 条件查询
    public void testConditionQuery() {
        // 查询 标题中含有 “昨天”
        // List<Article> articles = articleService.findByTitle("昨天");
        // for (Article article : articles) {
        // System.out.println(article);
        // }

        // 查询 标题中含有 “昨天” 1-10条
        Pageable pageable = new PageRequest(0, 10);
        Page<Article> pageData = articleService.findByTitle("昨天", pageable);
        System.out.println("总记录数：" + pageData.getTotalElements());
        for (Article article : pageData.getContent()) {
            System.out.println(article);
        }
    }


}
