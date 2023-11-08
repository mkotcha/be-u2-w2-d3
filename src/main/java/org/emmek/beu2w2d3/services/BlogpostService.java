package org.emmek.beu2w2d3.services;

import org.emmek.beu2w2d3.entities.BlogPost;
import org.emmek.beu2w2d3.exceptions.NotFoundException;
import org.emmek.beu2w2d3.repositories.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogpostService {

    @Autowired
    BlogPostRepository bpRepository;

    public BlogPost save(BlogPost blogpost) {
        bpRepository.save(blogpost);
        return blogpost;
    }

    public List<BlogPost> getBlogposts() {
        return bpRepository.findAll();
    }

    public BlogPost findById(int id) throws NotFoundException {
        return bpRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public void findByIdAndDelete(int id) {
        bpRepository.deleteById(id);
    }

    public BlogPost findByIdAndUpdate(int id, BlogPost blogpost) throws NotFoundException {
        BlogPost bp = bpRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
        bp.setCategory(blogpost.getCategory());
        bp.setTitle(blogpost.getTitle());
        bp.setPicture(blogpost.getPicture());
        bp.setContent(blogpost.getContent());
        bpRepository.save(bp);
        return bp;
    }

}
