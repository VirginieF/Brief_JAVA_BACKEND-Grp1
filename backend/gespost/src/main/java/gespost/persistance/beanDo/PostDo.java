package gespost.persistance.beanDo;

import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Classe de l'objet  Model PostDo
 * 
 * @author Arwa, Mireille, Sabrine, Virginie
 *
 */
@Entity
@Table(name = "posts")
public class PostDo {

	@Id
	@GeneratedValue(generator = "id")
	@GenericGenerator(name = "id", strategy = "uuid2")
	private String id;
	private String content;
	private boolean published;
	private String tags;
	private String title;

	public PostDo() {
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

	public boolean isPublished() {
		return this.published;
	}

	public boolean getPublished() {
		return this.published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}

	public String getTags() {
		return this.tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "{" + " id='" + getId() + "'" + ", title='" + getTitle() + "'" + ", content='" + getContent() + "'"
				+ ", published='" + isPublished() + "'" + ", tags='" + getTags() + "'" + "}";
	}

}
