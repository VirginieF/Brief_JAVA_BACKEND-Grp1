package gespost.service.imp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gespost.persistance.beanDo.PostDo;
import gespost.persistance.dao.IPostDao;
import gespost.presentation.pojo.PostRequest;
import gespost.service.IPostService;


@Service
public class PostService implements IPostService {
    @Autowired
    private IPostDao repoPostDao;
    public void createPost(PostRequest post){
        PostDo postDo = new PostDo();
        postDo.setTitle(post.getTitle());
        postDo.setContent(post.getContent());
        postDo.setTags(post.getTags());
        postDo.setPublished(post.getPublished());
        this.repoPostDao.save(postDo);

    }
    
}
