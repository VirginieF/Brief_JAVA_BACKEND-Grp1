package gespost.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import gespost.persistance.beanDo.PostDo;
import gespost.persistance.dao.IPostDao;
import gespost.presentation.pojo.PostDto;
import gespost.service.IPostService;

/**
 * Classe Service de l'objet Post implémantant l'interface Sercice IPostService
 * 
 * @author Arwa, Mireille, Sabrine, Virginie
 *
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class PostService implements IPostService {

	@Autowired
	private IPostDao postDao;

	public PostService(IPostDao postDao) {
		this.postDao = postDao;
	}

	/**
	 * map un postDo ---> postDto
	 * 
	 * @param postDo
	 * @return postDto
	 */
	private PostDto mapToPostDto(PostDo postDo) {
		PostDto postDto = new PostDto();
		if (postDo == null) {
			return null;
		}
		postDto.setId(postDo.getId());
		postDto.setTitle(postDo.getTitle());
		postDto.setContent(postDo.getContent());
		postDto.setPublished(postDo.getPublished());
		postDto.setTags(postDo.getTags());
		return postDto;
	}

	/**
	 * map un postDto ---> postDo
	 * 
	 * @param postDto
	 * @return postDo
	 */
	private PostDo mapToPostDo(PostDto postDto) {
		PostDo postDo = new PostDo();
		if (postDto == null) {
			return null;
		}
		postDo.setId(postDto.getId());
		postDo.setTitle(postDto.getTitle());
		postDo.setContent(postDto.getContent());
		postDo.setPublished(postDto.getPublished());
		postDo.setTags(postDto.getTags());
		return postDo;
	}

	/**
	 * map une liste d'objets Do ---> liste d'objets Dto
	 * 
	 * @param listDesPostsDo
	 * @return listDesPostsDto
	 */
	private List<PostDto> mapToListDesPostsDto(final List<PostDo> listDesChatsDo) {
		final List<PostDto> listDesChatsDto = new ArrayList<>();
		for (PostDo chatDo : listDesChatsDo) {
			listDesChatsDto.add(mapToPostDto(chatDo));
		}

		return listDesChatsDto;
	}

	@Override
	public List<PostDto> getAllPost() {
		List<PostDto> allPosts = new ArrayList<PostDto>();
		allPosts = mapToListDesPostsDto(postDao.findAll());
		return allPosts;
	}

	@Override
	public List<PostDto> findAllPostByTitle(String title) {
		List<PostDto> allPosts = new ArrayList<PostDto>();
		allPosts = mapToListDesPostsDto(postDao.findAllByTitleContaining(title));
		return allPosts;
	}

	@Override
	public PostDto findPostById(String id) {
		PostDo postDo = postDao.findById(id).get();
		return mapToPostDto(postDo);
	}

	@Override
	public String createPost(final PostDto postDto) {

		PostDo postDo = new PostDo();
		postDo = mapToPostDo(postDto);

		final PostDo newPostDo = postDao.save(postDo);
		return newPostDo.getId();
	}

	@Override
	public String updatePost(final String id, final PostDto postDto) {
		PostDo postDo = postDao.findById(id).get();
		postDo.setTitle(postDto.getTitle());
		postDo.setContent(postDto.getContent());
		postDo.setTags(postDto.getTags());
		postDo.setPublished(postDto.getPublished());
		final PostDo updatedPost = postDao.save(postDo);
		return mapToPostDto(updatedPost).getId();

	}

	@Override
	public void deletePost(String id) {
		this.postDao.deleteById(id);
	}

}
