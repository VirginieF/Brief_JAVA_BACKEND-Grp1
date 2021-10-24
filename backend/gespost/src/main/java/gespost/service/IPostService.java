package gespost.service;

import java.util.List;

import gespost.presentation.pojo.PostDto;

/**
 * Interface IPostServices des méthodes métiers de la gestion des posts
 * 
 * @author Arwa, Mireille, Sabrine, Virginie
 *
 */
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
	 * @return allPosts
	 */
	List<PostDto> findAllPostByTitle(String title);

	/**
	 * Permet de chercher un post à partir de son id
	 * 
	 * @param id
	 * @return postDto
	 */
	PostDto findPostById(String id);

	/**
	 * Permet de creer un nouveau Post
	 * 
	 * @param postDto
	 * @return id
	 */
	String createPost(PostDto postDto);

	/**
	 * Permet de mettre à jour une post à partir de son id
	 * 
	 * @param id
	 * @param postDto
	 * @return id
	 */
	String updatePost(String id, PostDto postDto);

	/**
	 * Permet de supprimer un post
	 * 
	 * @param id
	 */
	void deletePost(String id);

}
