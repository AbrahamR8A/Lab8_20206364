package sw2.lab5.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

import sw2.lab5.Entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    public interface PostRepository extends JpaRepository<Post, Integer> {

        List<Post> findByPublishedTrue();

        @Query("SELECT p FROM Post p WHERE p.published = true OR p.user.id_user = :userId")
        List<Post> findVisiblesParaUsuario(@Param("userId") Integer userId);
    }

}
