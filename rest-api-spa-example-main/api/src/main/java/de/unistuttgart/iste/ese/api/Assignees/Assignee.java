// package de.unistuttgart.iste.ese.api.Assignees;

// //import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// // import jakarta.persistence.Table;
// // import jakarta.validation.constraints.Max;
// // import jakarta.validation.constraints.Min;
// // import jakarta.validation.constraints.NotNull;
// // import jakarta.validation.constraints.Size;

// @Entity
// public class Assignee {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String prename;
//     private String name;
//     private String email;

//     // Constructors, Getters, and Setters
//     public Assignee() {}

//     public Assignee(String prename, String name, String email) {
//         this.prename = prename;
//         this.name = name;
//         this.email = email;
//     }

//     // Getters and Setters
//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public String getPrename() {
//         return prename;
//     }

//     public void setPrename(String prename) {
//         this.prename = prename;
//     }

//     public String getName() {
//         return name;
//     }

//     public void setName(String name) {
//         this.name = name;
//     }

//     public String getEmail() {
//         return email;
//     }

//     public void setEmail(String email) {
//         this.email = email;
//     }
// }
package de.unistuttgart.iste.ese.api.Assignees;

//import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.Table;
// import jakarta.validation.constraints.Max;
// import jakarta.validation.constraints.Min;
// import jakarta.validation.constraints.NotNull;
// import jakarta.validation.constraints.Size;

@Entity
public class Assignee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String prename;
    private String name;
    private String email;

    // Constructors, Getters, and Setters
    public Assignee() {}

    public Assignee(String prename, String name, String email) {
        this.prename = prename;
        this.name = name;
        this.email = email;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrename() {
        return prename;
    }

    public void setPrename(String prename) {
        this.prename = prename;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}