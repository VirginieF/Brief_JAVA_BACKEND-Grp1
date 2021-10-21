package gespost.service.imp;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gespost.persistance.beanDo.PostDo;
import gespost.persistance.dao.IPostDao;
import gespost.service.IPostService;


@Service
public class PostService implements IPostService {
    private final IPostDao iPostDao;

    @Autowired
    public PostService(IPostDao iPostDao) {
        this.iPostDao = iPostDao;
    }

    @Override
    public Optional<PostDo> findById(String id) {
        return iPostDao.findById(id);
    }
}
