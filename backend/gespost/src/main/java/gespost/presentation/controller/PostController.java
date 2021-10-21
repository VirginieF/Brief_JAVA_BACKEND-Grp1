package gespost.presentation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping({ "/posts/{id}" })
    public ResponseEntity<PostDto> getById(@PathVariable String id) {
        Optional<PostDto> post = postService.findPostById(id);
        return post.map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound()
                                       .build());
    }

    @GetMapping({ "/posts?title={title}" })
    public List<PostDto> getByTitle(String title) {
        List<PostDto> liste = postService.findAllPostByTitle(title);
        return liste;
    }

}
