/** ======================================
 * Beijing Itcast Tech. Co.,Ltd
 * Date：2017年7月11日 上午10:25:50
 * Author：huyy
 * Version：1.0
 * =========Modification History==========
 * Date          Name        Description
 * 2017年7月11日       Administrator     创建ArticleService类
 */
package cn.itcast.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cn.itcast.domain.Article;

/**
 * @Path cn.itcast.service.ArticleService
 * @Description 文章service
 * @date 2017年7月11日上午10:25:50
 * @author huyy
 * @version：1.0
 */
public interface ArticleService {

    /**
     * 
     * 保存article
     * @param article
     * @throws Exception<br/>
     * ============History===========<br/>
     * 2017年7月11日   Administrator    新建
     */
    void save(Article article) throws Exception;
    
    
    public void delete(Article article);

    /**
     * 
     * 根据id查询
     * @param id
     * @return<br/>
     * ============History===========<br/>
     * 2017年7月11日   Administrator    新建
     */
    public Article findOne(Long id);

    /**
     * 
     * 查询所有
     * @return<br/>
     * ============History===========<br/>
     * 2017年7月11日   Administrator    新建
     */
    public Iterable<Article> findAll();

    /**
     * 
     * 分页查询
     * @param pageable
     * @return<br/>
     * ============History===========<br/>
     * 2017年7月11日   Administrator    新建
     */
    public Page<Article> findAll(Pageable pageable);

    public List<Article> findByTitle(String title);

    /**
     * 
     * TODO
     * @param title
     * @param pageable
     * @return<br/>
     * ============History===========<br/>
     * 2017年7月11日   Administrator    新建
     */
    public Page<Article> findByTitle(String title, Pageable pageable);
}
