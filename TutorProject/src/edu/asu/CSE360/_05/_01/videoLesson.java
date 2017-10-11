package edu.asu.CSE360._05._01;

// Fig 21.6: MediaPanel.java
// A JPanel the plays media from a URL
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import javax.media.CannotRealizeException;
import javax.media.Manager;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.swing.*;

public class videoLesson extends JPanel
{
	private JButton doneButton;
	
   public videoLesson( URL q )
   {
	   doneButton = new JButton("DONE");
	   doneButton.setAlignmentX(Component.CENTER_ALIGNMENT);

      //setLayout( new BorderLayout() ); // use a BorderLayout
	  add(doneButton,BorderLayout.NORTH);
      // Use lightweight components for Swing compatibility
      Manager.setHint( Manager.LIGHTWEIGHT_RENDERER, true );
      
      try {
         // create a player to play the media specified in the URL
         Player mediaPlayer = Manager.createRealizedPlayer( q );
         
         // get the components for the video and the playback controls
         Component video = mediaPlayer.getVisualComponent();
         Component controls = mediaPlayer.getControlPanelComponent();
         
         if ( video != null ) 
            add( video); // add video component

         if ( controls != null ) 
            add( controls); // add controls
         
         mediaPlayer.start(); // start playing the media clip
         
         doneButton.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				if (doneButton.isEnabled()) {
 					mediaPlayer.close();
 					removeAll();
 					revalidate();
 					repaint();
					lessonChoices lessonPanel = new lessonChoices();
					add(lessonPanel,BorderLayout.CENTER);

 				}
 			}
       });
      }
      catch ( NoPlayerException noPlayerException ) {
    	  System.err.println( "No media player found" );
      	}
      catch ( CannotRealizeException cannotRealizeException ) {
         System.err.println( "Could not realize media player" );
      	}
      catch ( IOException iOException ) {
         System.err.println( "Error reading from the source" );
      	}
      

   }
}
