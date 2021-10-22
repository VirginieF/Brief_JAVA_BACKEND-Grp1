package gespost.service;

import java.util.List;
import java.util.Optional;

import gespost.presentation.pojo.PostDto;

public interface IPostService {

    /**
     * Permet de retouner la liste de tous les posts
     * 
     * @return allPosts
     */
    List<PostDto> getAllPost();

    /**
     * Permet de retourner la liste des posts à partir d'un titre
     * 
     * @param title
     * @return listPostByTitle
     */
    List<PostDto> findAllPostByTitle(String title);

    /**
     * Permet de chercher un post à partir de son id
     * 
     * @param id
     * @return post
     */
    Optional<PostDto> findPostById(String id);

    /**
     * Permet de creer un nouveau Post
     * 
     * @param postDto
     * @return post
     */
    String createPost(PostDto postDto);

    /**
     * Permet de mettre à jour une post à partir de son id
     * 
     * @param id
     * @param postDto
     */
    void updatePost(String id, PostDto postDto);

    /**
     * Permet de supprimer un post
     * 
     * @param id
     */
    void deletePost(String id);

}
