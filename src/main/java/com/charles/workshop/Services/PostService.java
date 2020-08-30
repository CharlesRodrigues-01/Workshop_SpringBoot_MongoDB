package com.charles.workshop.Services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charles.workshop.Services.exception.ObjectNotFoundException;
import com.charles.workshop.domain.Post;
import com.charles.workshop.repositories.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	public Optional<Post> findById(String id) {
		Optional<Post> user = postRepository.findById(id);
		if (user == null) {
			throw new ObjectNotFoundException("Object not found!");
		}
		return user;

	}

	// public List<Post> findByTitle(String text) {
	// return postRepository.findByTitleContainingIgnoreCase(text);
	// }

	public List<Post> findByTitle(String text) {
		return postRepository.searchTitle(text);

	}

	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		maxDate = new Date(maxDate.getTime() + 24 * 60 *60 * 1000);
		return postRepository.fullSearch(text, minDate, maxDate);

	}
}
