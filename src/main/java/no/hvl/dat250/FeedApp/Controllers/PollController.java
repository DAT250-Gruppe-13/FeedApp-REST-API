package no.hvl.dat250.FeedApp.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import no.hvl.dat250.FeedApp.Models.Poll;
import no.hvl.dat250.FeedApp.Service.PollService;

@RestController
public class PollController {

	@Autowired
	private PollService pollService;

	@GetMapping("/polls")
	List<Poll> getPolls() {
		return pollService.readAllPolls();
	}

	@GetMapping("/polls/{id}")
	Poll getPoll(@PathVariable(name = "id") int id) {
		return pollService.readPoll(id);
	}

	@DeleteMapping("/polls/{id}")
	void deletePoll(@PathVariable(name = "id") int id) {
		pollService.deletePoll(id);
	}

	@PostMapping("/polls")
	Poll postPoll(@RequestBody Poll poll) {
		boolean success = pollService.createPoll(poll);
		if (!success) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
		}
		return poll;
	}

	@PutMapping("/polls")
	Poll putPoll(@RequestBody Poll poll) {
		pollService.updatePoll(poll);
		return poll;
	}

}