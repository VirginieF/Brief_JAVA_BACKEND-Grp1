package gespost.persistance.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gespost.persistance.beanDo.PostDo;

@Repository
public interface IPostDao extends JpaRepository<PostDo, String> {
    List<PostDo> findAllByTitleContaining(String title);
}
