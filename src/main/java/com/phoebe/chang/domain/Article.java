package com.phoebe.chang.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by phoebe on 8/2/15.
 */
public class Article implements Serializable{

    private final String title;
    private final String author;
    private final List<String> tags;

    public Article (String title, String author, List<String> tags) {
        this.title = title;
        this.author = author;
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public List<String> getTags() {
        return tags;
    }


}
