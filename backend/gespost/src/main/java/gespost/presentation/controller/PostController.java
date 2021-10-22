package gespost.presentation.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import gespost.service.IPostService;
import gespost.presentation.pojo.PostDto;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private IPostService postService;

    public PostController(IPostService postService) {
        this.postService = postService;
    }

    /**
     * Permet de retouner la liste de tous les posts
     * 
     * Postman link : GET api/posts
     * 
     * @return liste
     */
    @GetMapping({ "/posts" })
    public List<PostDto> list(@RequestParam(required = false) String title) {
        if (StringUtils.isEmpty(title)) {
            return postService.getAllPost();
        }
        return postService.findAllPostByTitle(title);
    }

    @GetMapping({ "/posts/{id}" })
    public PostDto getById(@PathVariable String id) {
        
        return postService.findPostById(id);
       
    }

    @GetMapping({ "/posts?title={title}" })
    public List<PostDto> getByTitle(String title) {
        List<PostDto> liste = postService.findAllPostByTitle(title);
        return liste;
    }
   
    @PostMapping({"/posts"})
    public String save(@RequestBody PostDto post){
        return this.postService.createPost(post);

    }

    @DeleteMapping({"/posts/{id}"})
    public void delete(@PathVariable(value = "id") String id){
        this.postService.deletePost(id);
    }
    
    @PutMapping("/posts/{id}")
    public void update(@PathVariable String id, @RequestBody PostDto postDto) {
        PostDto post = postService.findPostById(id);
        if (post != null) {
            postService.updatePost(id, postDto);
        } else {
            postService.createPost(postDto);
        }
    }

}


