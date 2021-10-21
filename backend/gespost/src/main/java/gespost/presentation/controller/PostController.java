package gespost.presentation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    public List<PostDto> list() {

        List<PostDto> liste = postService.getAllPost();
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
    

}


