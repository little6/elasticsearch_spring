/** ======================================
 * Beijing Itcast Tech. Co.,Ltd
 * Date：2017年7月11日 上午10:22:10
 * Author：huyy
 * Version：1.0
 * =========Modification History==========
 * Date          Name        Description
 * 2017年7月11日       Administrator     创建ArticleRepository类
 */
package cn.itcast.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import cn.itcast.domain.Article;

/**
 * @Path cn.itcast.dao.ArticleRepository
 * @Description article的dao接口
 * @date 2017年7月11日上午10:22:10
 * @author huyy
 * @version：1.0
 */
public interface ArticleRepository extends ElasticsearchRepository<Article, Long> {

    List<Article> findByTitle(String title);

    Page<Article> findByTitle(String title, Pageable pageable);

}
