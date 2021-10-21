package gespost.presentation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

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

}
