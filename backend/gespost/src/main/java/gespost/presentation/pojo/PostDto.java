package gespost.presentation.pojo;

/**
 * Classe de l'Objet beanDo PostDo
 * 
 * @author Arwa, Mireille, Sabrine, Virginie
 *
 */
public class PostDto {

    private String id;
    private String title;
    private String content;
    private String tags;
    private Boolean published;

    
    public PostDto() {
    	//Empty Method
    }
    
    public PostDto(String id2, String title2, String content2, boolean published2, String tags2) {
    	//Empty Method
    }
   
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTags() {
        return this.tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Boolean isPublished() {
        return this.published;
    }

    public Boolean getPublished() {
        return this.published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    @Override
    public String toString() {
        return "{" + "'" + ", title='" + getTitle() + "'" + ", content='" + getContent() + "'" + ", tags='" + getTags()
                + "'" + ", published='" + isPublished() + "'" + "}";
    }
}
