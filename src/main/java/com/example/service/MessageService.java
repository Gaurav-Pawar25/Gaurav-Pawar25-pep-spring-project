package com.example.service;

import com.example.entity.Message;
import com.example.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    /**
     * Save a new message or update an existing message in the repository.
     *
     * @param message The message entity to be saved.
     * @return The saved message entity.
     */

    public Message save(Message message) {
        return messageRepository.save(message);
    }

     /**
     * Retrieve all messages from the repository.
     *
     * @return A list of all message entities.
     */

    public List<Message> findAll() {
        return messageRepository.findAll();
    }

     /**
     * Find a message by its ID.
     *
     * @param messageId The ID of the message to be retrieved.
     * @return An Optional containing the message if found, or empty if not found.
     */

    public Optional<Message> findById(Integer messageId) {
        return messageRepository.findById(messageId);
    }

    /**
     * Delete a message by its ID.
     *
     * @param messageId The ID of the message to be deleted.
     */

    public void deleteById(Integer messageId) {
        messageRepository.deleteById(messageId);
    }

    /**
     * Update the text of an existing message.
     *
     * @param messageId The ID of the message to be updated.
     * @param messageText The new text to be set for the message.
     */

    public void updateMessageText(Integer messageId, String messageText) {
        Optional<Message> message = messageRepository.findById(messageId);
        if (message.isPresent()) {
            // Retrieve the existing message and update its text
            Message existingMessage = message.get();
            existingMessage.setMessageText(messageText);
            // Retrieve the existing message and update its text
            messageRepository.save(existingMessage);
        }
    }

     /**
     * Retrieve all messages posted by a specific user.
     *
     * @param postedBy The ID of the user who posted the messages.
     * @return A list of messages posted by the specified user.
     */

    public List<Message> findByPostedBy(Integer postedBy) {
        return messageRepository.findByPostedBy(postedBy);
    }
}
