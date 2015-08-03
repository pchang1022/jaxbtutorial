package com.phoebe.chang.java8.stream;

import com.google.common.collect.Lists;
import com.phoebe.chang.domain.Article;
import com.phoebe.chnag.AppTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.google.common.truth.Truth.assertThat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.testng.Assert.*;

/**
 * Created by phoebe on 8/2/15.
 */
public class ArticleHelperTest {
    List<Article> articles;
    @Test
    public void testGetFirstJavaArticle_loop() throws Exception {
        ArticleHelper helper = new ArticleHelper(articles);
        Article article = helper.getFirstJavaArticle_loop();

        assertThat(article.getTags().contains("Java"));

    }

    @Test
    public void testGetFirstJavaArticle_Stream() throws Exception {
        ArticleHelper helper = new ArticleHelper(articles);
        Optional<Article> article = helper.getFirstJavaArticle_Stream();
        assertThat(article.get().getTags().contains("Java"));
    }

    @BeforeMethod
    public void setUp() throws Exception {
        articles = new ArrayList<>();
        articles.add(new Article("Java 8 Stream Api", "Johnathan Smith", Lists.newArrayList("Java", "New Features", "Stream Api")));
        articles.add(new Article("Twitter Explosion", "Ken Applebee", Lists.newArrayList("social Media", "Twitter")));
        articles.add(new Article("Movie Reviews", "Hia Chang", Lists.newArrayList("social Media", "Fall 2015 Releases")));
    }
}