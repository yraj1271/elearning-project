package com.amdocs.training.feedback;

import java.util.List;

public interface FeedbackDAO {
	List<Feedback> findAll();

	boolean addFeedback(Feedback feedback);

	Feedback getFeedbackById(int id);

	boolean deleteFeedback(int id);
	
	boolean updateFeedback(int id);

}
