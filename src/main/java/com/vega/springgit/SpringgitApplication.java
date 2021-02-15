package com.vega.springgit;

import com.vega.springgit.domain.Comment;
import com.vega.springgit.domain.Link;
import com.vega.springgit.repository.CommentRepository;
import com.vega.springgit.repository.LinkRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringgitApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringgitApplication.class, args);

	}
	@Bean
	CommandLineRunner runner(LinkRepository linkRepository, CommentRepository commentRepository) {
		return args -> {
			Link link = new Link("Getting started with spring boot 2", "http://asas");
			linkRepository.save(link);

			Comment comment = new Comment("as", link);
			commentRepository.save(comment);
			link.addComment(comment);



		};
	}

}
