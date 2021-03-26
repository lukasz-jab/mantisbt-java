package mantisbt.model;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mantis_project_table")
public class Project {
    @Column(name = "name")
    String name;
    @Id
    @Column(name = "id")
    int id;
    @Column(columnDefinition = "smallint")
    String status;
    @Column(name = "inherit_global", columnDefinition = "TINYINT")
    String inheritanced;
    @Column(name = "view_state", columnDefinition = "smallint")
    String visibility;
    @Type(type = "text")
    String description;

    public Project() {

    }

    public Project(String name, int id, String status, String inheritanced, String visibility, String description) {
        this.name = name;
        this.id = id;
        this.status = status;
        this.inheritanced = inheritanced;
        this.visibility = visibility;
        this.description = description;
    }

    public Project(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Project(String name) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInheritanced() {
        return inheritanced;
    }

    public void setInheritanced(String inheritanced) {
        this.inheritanced = inheritanced;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
