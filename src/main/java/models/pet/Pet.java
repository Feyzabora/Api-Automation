package models.pet;

import java.util.List;

public class Pet {
    Long id;
    Category category;
    String name;
    List<String> photoUrls;
    List<Category> tags;
    String status;

    public void setCategory(Category category) {this.category = category;}

    public void setId(Long id) {this.id = id;}

    public void setName(String name) {this.name = name;}

    public void setPhotoUrls(List<String> photoUrls) {this.photoUrls = photoUrls;}

    public void setStatus(String status) {this.status = status;}

    public void setTags(List<Category> tags) {this.tags = tags;}

    public Category getCategory() {return category;}

    public List<Category> getTags() {return tags;}

    public List<String> getPhotoUrls() {return photoUrls;}

    public Long getId() {return id;}

    public String getName() {return name;}

    public String getStatus() {return status;}

    public class Category {
        Long id;
        String name;

        public void setName(String name) {this.name = name;}

        public void setId(Long id) {this.id = id;}

        public String getName() {return name;}

        public Long getId() {return id;}
    }
}
