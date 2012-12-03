package com.powersurgepub.clubplanner.io;

  import com.powersurgepub.clubplanner.model.*;
  import com.powersurgepub.psutils.*;
  import java.io.*;
  import java.util.*;

/**
 Loads a ClubEventList from a folder containing club events. 

 @author Herb Bowie
 */
public class ClubEventListLoader {
  
  private    File                    folder = null;
  private    ClubEventList           list = null;
  private    int                     eventsLoaded = 0;
  
  private    ArrayList<DirToExplode> dirList;
  private		 int							       dirNumber = 0;
  
  private    File                    currDirAsFile = null;
  private    int                     currDirDepth = 0;
  
  private		 ArrayList<String>       dirEntries;
  private		 int							       entryNumber = 0;
  
  public ClubEventListLoader(File folder) {
    this.folder = folder;
  }
  
  public boolean load (ClubEventList list) {
    
    boolean ok = true;
    eventsLoaded = 0;
    this.list = list;
    dirList = new ArrayList();
    dirList.add (new DirToExplode (1, folder.getAbsolutePath()));
    dirNumber = 0;
    while (dirNumber < dirList.size()) {
      boolean resultOK = nextDirectory(dirNumber);
      if (! resultOK) {
        ok = false;
      }
      dirNumber++;
    }
    Logger.getShared().recordEvent(LogEvent.NORMAL, 
        String.valueOf(eventsLoaded) + " Club Events loaded", false);
    System.out.println(String.valueOf(eventsLoaded + " Club Events loaded"));
    return ok;
    
  }
  
  /**
   Let's explode the next directory, if we have any more.
  */
  private boolean nextDirectory(int dirIndex) {

    boolean ok = true;
    DirToExplode currDir = dirList.get(dirIndex);
    currDirAsFile = new File (currDir.path);
    currDirDepth = currDir.depth;
    String[] dirEntry = currDirAsFile.list();
    if (dirEntry != null) {
      dirEntries = new ArrayList (Arrays.asList(dirEntry));
    }
    entryNumber = 0;
    while (entryNumber < dirEntries.size()) {
      boolean resultOK = nextDirEntry (entryNumber);
      if (! resultOK) {
        ok = false;
      }
      entryNumber++;
    }
    return ok;
  }
  
  private boolean nextDirEntry (int entryIndex) {
    
    boolean ok = true;
    String nextDirEntry = dirEntries.get (entryIndex);
    File dirEntryFile = new File (currDirAsFile, nextDirEntry);
    if (dirEntryFile.isDirectory()) {
      DirToExplode newDirToExplode = new DirToExplode 
          (currDirDepth + 1, dirEntryFile.getAbsolutePath());
      dirList.add (newDirToExplode);
    } 
    else
    if (isInterestedIn (dirEntryFile)) {
      ClubEventReader reader 
          = new ClubEventReader (dirEntryFile, ClubEventReader.PLANNER_TYPE);
      try {
        reader.openForInput();
        list.add(reader.getClubEvent());
        eventsLoaded++;
      } catch (java.io.IOException e) {
        ok = false;
        Logger.getShared().recordEvent(LogEvent.MEDIUM, 
            "Trouble reading " + nextDirEntry 
              + " from " + currDirAsFile.toString(), false);
      }
      
      reader.close();
    }
    return ok;
  }
  
  /**
   Is this input module interested in processing the specified file?
  
   @param candidate The file being considered. 
  
   @return True if the input module thinks this file is worth processing,
           otherwise false. 
  */
  public static boolean isInterestedIn(File candidate) {
    if (candidate.isHidden()) {
      return false;
    }
    else
    if (candidate.getName().startsWith(".")) {
      return false;
    }
    else
    if (! candidate.canRead()) {
      return false;
    }
    else
    if (candidate.isFile() 
        && candidate.length() == 0
        && candidate.getName().equals("Icon\r")) {
      return false;
    }
    else
    if (candidate.isDirectory()) {
      return false;
    }
    else
    if (candidate.getParent().endsWith("templates")) {
      return false;
    }
    else
    if (candidate.getName().equalsIgnoreCase("New Event.txt")) {
      return false;
    }
    else
    if (candidate.getName().endsWith (".txt")) {
      return true;
    } else {
      return false;
    }
  }
  
  /**
     Inner class to define a directory to be processed.
   */
  class DirToExplode {
    int 		depth = 0;
    String	path  = "";
    
    DirToExplode (int depth, String path) {
      this.depth = depth;
      this.path = path;
    } // DirToExplode constructor
  } // end DirToExplode inner class

}
