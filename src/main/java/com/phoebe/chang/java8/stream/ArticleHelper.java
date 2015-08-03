package com.phoebe.chang.java8.stream;

import com.phoebe.chang.domain.Article;

import java.util.List;
import java.util.Optional;

/**
 * Created by phoebe on 8/2/15.
 * See http://www.deadcoderising.com/java-8-no-more-loops/
 *
 */
public class ArticleHelper {


    private List<Article> articles;

    public ArticleHelper(List<Article> articles) {
        this.articles = articles;
    }

    public Article getFirstJavaArticle_loop () {

        for (Article article: articles) {
            if (article.getTags().contains("Java")) {
                return article;
            }
        }
        return null;
    }

    public Optional<Article> getFirstJavaArticle_Stream() {
        return articles.stream().filter(article -> article.getTags().contains("Java")).findFirst();

    }
}
