package org.emmek.beu2w2d3.controller;

import org.emmek.beu2w2d3.entities.BlogPost;
import org.emmek.beu2w2d3.services.BlogpostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogposts")
public class BlogPostController {

    @Autowired
    private BlogpostService bpService;

    @GetMapping("")
    public List<BlogPost> getBlogPosts() {
        return bpService.getBlogposts();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public BlogPost postBlogPosts(@RequestBody BlogPost blogpost) {
        return bpService.save(blogpost);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public BlogPost getBlogPostById(@PathVariable int id) {
        try {
            return bpService.findById(id);
        } catch (Exception e) {
            return null;
        }
    }

    @PutMapping("/{id}")
    public BlogPost findByIdAndUpdate(@PathVariable int id, @RequestBody BlogPost blogpost) {
        return bpService.findByIdAndUpdate(id, blogpost);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable int id) {
        bpService.findByIdAndDelete(id);
    }

}
