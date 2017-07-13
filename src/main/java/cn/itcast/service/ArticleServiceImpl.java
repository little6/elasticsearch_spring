/** ======================================
 * Beijing Itcast Tech. Co.,Ltd
 * Date：2017年7月11日 上午10:28:30
 * Author：huyy
 * Version：1.0
 * =========Modification History==========
 * Date          Name        Description
 * 2017年7月11日       Administrator     创建ArticleServiceImpl类
 */
package cn.itcast.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import cn.itcast.dao.ArticleRepository;
import cn.itcast.domain.Article;

/**
 * @Path cn.itcast.service.ArticleServiceImpl
 * @Description 文章service实现
 * @date 2017年7月11日上午10:28:30
 * @author huyy
 * @version：1.0
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    
    @Autowired
    private ArticleRepository articleRepository;

    /**
     * 保存
     * @param article
     * @throws Exception
     * @see cn.itcast.service.ArticleService#save(cn.itcast.domain.Article)
     */
    @Override
    public void save(Article article) throws Exception {
        articleRepository.save(article);
    }

    @Override
    public void delete(Article article) {
        articleRepository.delete(article);
    }

    @Override
    public Article findOne(Integer id) {
        return articleRepository.findOne(id);
    }

    @Override
    public Iterable<Article> findAll() {
        //按照id字段进行排序
        return articleRepository.findAll(new Sort(new Sort.Order(Direction.ASC, "id")));
    }

    @Override
    public Page<Article> findAll(Pageable pageable) {
        return articleRepository.findAll(pageable);
    }

    @Override
    public List<Article> findByTitle(String title) {
        return articleRepository.findByTitle(title);
    }

    @Override
    public Page<Article> findByTitle(String title, Pageable pageable) {
        return articleRepository.findByTitle(title,pageable);
    }

}
