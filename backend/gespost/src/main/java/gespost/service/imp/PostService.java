package gespost.service.imp;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gespost.persistance.beanDo.PostDo;
import gespost.persistance.dao.IPostDao;
import gespost.presentation.pojo.PostDto;

import gespost.service.IPostService;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class PostService implements IPostService {

    @Autowired
    IPostDao postDao;

    /**
     * map un postDo ---> postDto
     * 
     * @param postDo
     * @return postDto
     */
    private PostDto mapToPostDto(final PostDo postDo) {
        final PostDto postDto = new PostDto();
        if (postDo == null) {
            return null;
        }
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
    private PostDo mapToPostDo(final PostDto postDto) {
        final PostDo postDo = new PostDo();
        if (postDto == null) {
            return null;
        }
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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PostDto findPostById(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String createPost(PostDto postDto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updatePost(String id, PostDto postDto) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deletePost(String id) {
        // TODO Auto-generated method stub

    }

}
