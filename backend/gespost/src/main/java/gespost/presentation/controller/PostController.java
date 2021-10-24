package gespost.presentation.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gespost.presentation.pojo.PostDto;
import gespost.service.IPostService;

/**
 * Classe ControllerRest
 * 
 * @author Arwa, Mireille, Sabrine, Virginie
 *
 */
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
	 * Permet de retourner la liste de tous les posts
	 * 
	 * Postman link : GET api/posts
	 * 
	 * @return liste des posts
	 */
	@GetMapping({ "/posts" })
	public List<PostDto> list(@RequestParam(required = false) String title) {
		if (StringUtils.isEmpty(title)) {
			return postService.getAllPost();
		}
		return postService.findAllPostByTitle(title);
	}

	/**
	 * Permet de retrouver un post par son id
	 * 
	 * @param id
	 * @return postDto
	 */
	@GetMapping({ "/posts/{id}" })
	public PostDto getById(@PathVariable String id) {
		PostDto postDto = postService.findPostById(id);
		return postDto;
	}

	/**
	 * Permet de retourner tous les posts qui ont le même titre
	 * 
	 * @param title
	 * @return liste
	 */
	@GetMapping({ "/posts?title={title}" })
	public List<PostDto> getByTitle(String title) {
		List<PostDto> liste = postService.findAllPostByTitle(title);
		return liste;
	}

	/**
	 * Permet de creer un nouveau Post
	 * 
	 * @param post
	 */
	@PostMapping({ "/posts" })
	public void save(@RequestBody PostDto post) {
		this.postService.createPost(post);

	}

	/**
	 * Permet de supprimer un Post
	 * 
	 * @param id
	 */
	@DeleteMapping({ "/posts/{id}" })
	public void delete(@PathVariable(value = "id") String id) {
		this.postService.deletePost(id);

	}

	/**
	 * Permet de mettre à jour un Post
	 * 
	 * @param id
	 * @param postDto
	 */
	@PutMapping("/posts/{id}")
	public void update(@PathVariable String id, @RequestBody PostDto postDto) {
		PostDto currentPostDto = postService.findPostById(id);
		if (currentPostDto != null) {
			postService.updatePost(id, postDto);
		} else {
			postService.createPost(postDto);
		}

	}

	/**
	 * Permet de publier ou non une publication
	 * 
	 * @param id
	 * @param postDto
	 */
	@PutMapping("/posts/{id}/publish")
	public void publish(@PathVariable String id, @RequestBody PostDto postDto) {
		PostDto currentPostDto = postService.findPostById(id);
		currentPostDto.setPublished(postDto.getPublished());
		postService.updatePost(id, postDto);
	}

}
