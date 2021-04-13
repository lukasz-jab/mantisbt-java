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

    public Project withName(String name) {
        this.name = name;
        return this;
    }

    public int getId() {
        return id;
    }

    public Project withId(int id) {
        this.id = id;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Project withStatus(String status) {
        this.status = status;
        return this;
    }

    public String getInheritanced() {
        return inheritanced;
    }

    public Project withInheritanced(String inheritanced) {
        this.inheritanced = inheritanced;
        return this;
    }

    public String getVisibility() {
        return visibility;
    }

    public Project withVisibility(String visibility) {
        this.visibility = visibility;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Project withDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
