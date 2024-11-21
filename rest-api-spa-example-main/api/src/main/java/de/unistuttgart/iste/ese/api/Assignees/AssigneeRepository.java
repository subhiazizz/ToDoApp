// package de.unistuttgart.iste.ese.api.Assignees;

// import org.springframework.data.repository.CrudRepository;

// public class AssigneeRepository {
//     public interface CatRepository extends CrudRepository<Assignee, Long> {
//     Assignee findByName(String name);

//     Assignee findById(long id);
//     }
// }


// package de.unistuttgart.iste.ese.api.Assignees;

// import org.springframework.data.jpa.repository.JpaRepository;

// // AssigneeRepository extending JpaRepository provides all necessary CRUD methods
// public interface AssigneeRepository extends JpaRepository<Assignee, Long> {
//     // JpaRepository already includes findById, save, deleteById, findAll, etc.
// }


package de.unistuttgart.iste.ese.api.Assignees;

import org.springframework.data.repository.CrudRepository;

// Extend CrudRepository for basic CRUD functionality
public interface AssigneeRepository extends CrudRepository<Assignee, Long> {
    // No additional methods needed unless you want custom queries
}
