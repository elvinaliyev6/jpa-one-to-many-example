package az.spring.hibernate;

import az.spring.hibernate.model.Comment;
import az.spring.hibernate.model.Post;
import az.spring.hibernate.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernateApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(HibernateApplication.class, args);
    }

    PostRepository postRepository;

    @Autowired
    public HibernateApplication(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Post post=new Post("Java Hibernate","Hibernate one to many example using SPring Boot");

        Comment comment1=new Comment("Great");
        Comment comment2=new Comment("Informative");
        Comment comment3=new Comment("Good explanation");
        Comment comment4=new Comment("Perfect");
        Comment comment5=new Comment("Very clear");

        post.getComments().add(comment1);
        post.getComments().add(comment2);
        post.getComments().add(comment3);
        post.getComments().add(comment4);
        post.getComments().add(comment5);

        postRepository.save(post);

    }
}
