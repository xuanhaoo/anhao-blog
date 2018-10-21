package com.blog.service.impl;


import com.blog.dao.LinksAndAboutDao;
import com.blog.model.LinksAndAbout;
import com.blog.service.LinksAndAboutService;
import org.markdownj.MarkdownProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liangxuanhao
 * @date 2018年04月14日  15:54
 */
@Service
public class LinksAndAboutServiceImpl implements LinksAndAboutService{


    @Autowired
    private LinksAndAboutDao linksAndAboutDao;

    @Override
    public void save(LinksAndAbout linksAndAbout) {
        MarkdownProcessor markdownProcessor = new MarkdownProcessor();
        String html = markdownProcessor.markdown(linksAndAbout.getContent());
        linksAndAbout.setContentHtml(html);
        linksAndAboutDao.save(linksAndAbout);
    }

    @Override
    public void update(LinksAndAbout linksAndAbout) {
        MarkdownProcessor markdownProcessor = new MarkdownProcessor();
        String html = markdownProcessor.markdown(linksAndAbout.getContent());
        linksAndAbout.setContentHtml(html);
        linksAndAboutDao.update(linksAndAbout);
    }

    @Override
    public LinksAndAbout queryObject(Integer type) {
        return linksAndAboutDao.queryObject(type);
    }
}
