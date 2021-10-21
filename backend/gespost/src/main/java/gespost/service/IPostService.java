package gespost.service;

import java.util.Optional;

import gespost.persistance.beanDo.PostDo;

public interface IPostService {
    public Optional<PostDo> findById(String id);
}
