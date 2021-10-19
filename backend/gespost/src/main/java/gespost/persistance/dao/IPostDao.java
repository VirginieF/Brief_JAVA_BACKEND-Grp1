package gespost.persistance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gespost.persistance.beanDo.PostDo;

@Repository
public interface IPostDao extends JpaRepository<PostDo, String> {

    
}
