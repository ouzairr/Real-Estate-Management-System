package individuals;
/**
 * @author ilyas
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Comment implements Serializable {
    private String text;
    private int likes;
    private int dislikes;
    private List<Comment> replies;
    private static int rating;

    public Comment(String text) {
        this.text = text;
        this.likes = 0;
        this.dislikes = 0;
        this.replies = new ArrayList<>();
    }
    public Comment () {
    	
    }

    public void like() {
        likes++;
    }

    public void dislike() {
        dislikes++;
    }

    public void addReply(Comment reply) {
        replies.add(reply);
    }
     public void addComment(Comment reply, ArrayList<Comment> comment) {
        comment.add(reply);
    }
     
    public void RemoveReply(Comment reply) {
        replies.remove(reply);
    }
    
     public void RemoveComment(Comment reply, ArrayList<Comment> comment) {
        comment.remove(reply);
    }

    public boolean searchComment(String keyword, ArrayList<Comment> comment) {
        for (Comment c : comment) {
            if (c.text.contains(keyword)) {
                return true;
            }
        }
        return false;
    }
     
    public void addRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            this.rating = rating;
        } else {
            System.out.println("Invalid rating. Rating should be between 1 and 5.");
        }
    }

  public void display() {
    System.out.println("Comment: " + text);
    System.out.println("Likes: " + likes + " Dislikes: " + dislikes + " Rating: " + rating);
    System.out.println("Replies:");
    for (Comment reply : replies) {
        reply.display();
    }
}



    
}
