<?nextrec?>
<?definegroup 1 =$itemclass$=?>
<?ifendgroup 1 ?>
<?if =$itemMaster$= = "Master" ?>
    return outOK;
  }
  
  private boolean writeFieldName (String fieldName) {
    boolean outOK = true;
    outOK = write(fieldName);
    if (outOK) {
      outOK = write(": ");
    }
    for (int i = fieldName.length(); i < 6 && outOK; i++) {
      outOK = write (" ");
    }
    return outOK;
  }
  
  private boolean writeFieldValue (String fieldValue) {
    return writeLine (fieldValue);
  }
  
  private boolean writeLine (String s) {
    try {
      outBuffered.write (s);
      outBuffered.newLine();
    } catch (IOException e) {
      return false;
    }
    return true;
  }
  
  private boolean write (String s) {
    try {
      outBuffered.write (s);
    } catch (IOException e) {
      return false;
    }
    return true;
  }
  
  /**
   Close the output writer. 
  
   @return True if close worked ok.  
  */
  public boolean closeOutput() {
    boolean outOK = true;
    try {
      outBuffered.close();
    } catch (IOException e) {
      outOK = false;
    }
    return outOK;
  }

}
<?endif?>
<?ifnewgroup 1 ?>
<?set itemMaster = =$itemtype$= ?>
<?if =$itemtype$= == "Master" ?>
<?output "../../src/com/powersurgepub/clubplanner/io/=$itemclass$=Writer.java"?>
/*
 * Copyright 1999 - 2015 Herb Bowie
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.powersurgepub.clubplanner.io;

  import com.powersurgepub.clubplanner.model.*;
  import com.powersurgepub.psdatalib.clubplanner.*;
  import com.powersurgepub.psutils.*;
  import java.io.*;

/**
 Writer for =$itemclass$=s. 

 Generated by PSTextMerge using template =$templatefilename$=.

 @author Herb Bowie
 */
public class =$itemclass$=Writer {
  
  private     BufferedWriter      outBuffered;
  
  public static final String FILE_EXT = ".txt";
  
  public =$itemclass$=Writer() {
    
  }
  
  /**
   Does the given =$itemclass&c uul$= already exist on disk?
  
   @param folder    The folder in which the item is to be stored. 
   @param =$itemclass&clul$= The =$itemclass&c uul$= to be stored. 
  
   @return True if a disk file with the same path already exists,
           false if not. 
   */
  public boolean exists (File folder, =$itemclass$= =$itemclass&clul$=) {
    return getFile(folder, =$itemclass&clul$=).exists();
  }
  
  /**
   Does the given =$itemclass&c uul$= already exist on disk?
  
   @param folder    The folder in which the item is to be stored. 
   @param localPath The local path (folder plus file name) for the 
                    =$itemclass&c uul$= to be stored. 
  
   @return True if a disk file with the same path already exists,
           false if not. 
   */
  public boolean exists (File folder, String localPath) {
    return getFile(folder, localPath).exists();
  }
  
  /**
   Delete the passed event from disk. 
  
   @param folder    The folder in which the item is to be stored. 
   @param =$itemclass&clul$= The =$itemclass&c uul$= to be stored. 
  
   @return True if the file was deleted successfully,
           false if not. 
   */
  public boolean delete (File folder, =$itemclass$= =$itemclass&clul$=) {
    return getFile(folder, =$itemclass&clul$=).delete();
  }
  
  /**
   Delete the passed event from disk. 
  
   @param folder    The folder in which the item is to be stored. 
   @param localPath The local path (folder plus file name) for the 
                    =$itemclass&c uul$= to be stored. 
  
   @return True if the file was deleted successfully,
           false if not. 
   */
  public boolean delete (File folder, String localPath) {
    return getFile(folder, localPath).delete();
  }
  
  /**
   Return a standard File object representing the item's stored location on disk. 
  
   @param folder    The folder in which the item is to be stored. 
   @param =$itemclass&clul$= The =$itemclass&c uul$= to be stored. 
  
   @return The File pointing to the intended disk location for the given event. 
   */
  public File getFile (File folder, =$itemclass$= =$itemclass&clul$=) {
    File localFolder;
    if (=$itemclass&clul$=.hasFolderName()) {
      localFolder = new File (folder, =$itemclass&clul$=.getFolderName());
    } else {
      localFolder = folder;
    }
    return new File (localFolder, =$itemclass&clul$=.getFileName() + FILE_EXT);
  }
  
  /**
   Return a standard File object representing the item's stored location on disk. 
  
   @param folder    The folder in which the item is to be stored. 
   @param localPath The local path (folder plus file name) for the 
                    =$itemclass&c uul$= to be stored. 
  
   @return The File pointing to the intended disk location for the given item. 
   */
  public File getFile (File folder, String localPath) {
    StringBuilder completePath = new StringBuilder();
    try {
      completePath = new StringBuilder (folder.getCanonicalPath());
    } catch (Exception e) {
      completePath = new StringBuilder (folder.getAbsolutePath());
    }
    completePath.append('/');
    completePath.append(localPath);
    completePath.append(FILE_EXT);
    return new File (completePath.toString());
  }
  
  /**
    Save an entire list of items to disk. 
    
    @param folder The destination folder.
    @param =$itemclass&clul$=List The list of items to be saved. 
    @param primaryLocation Is this the primary disk location for the items?
    
    @return Number of items saved, or -1 if a problem was encountered. 
   */
  public int save (File folder, =$itemclass$=List =$itemclass&clul$=List, 
      boolean primaryLocation) {
  
    boolean outOK = true;
    int itemsSaved = 0;
    for (int i = 0; i < =$itemclass&clul$=List.size() && outOK; i++) {
      =$itemclass$= next=$itemclass$= = =$itemclass&clul$=List.get(i);
      outOK = save (folder, next=$itemclass$=, primaryLocation);
      itemsSaved++;
    }
    if (! outOK) {
      return -1;
    } else {
      return itemsSaved;
    }
  }
  
  /**
    Save one item to disk. 
    
    @param folder The destination folder.
    @param =$itemclass&clul$= The item to be saved. 
    @param primaryLocation Is this the primary disk location for the items?
    
    @return True if everything went ok. 
   */
  public boolean save (File folder, =$itemclass$= =$itemclass&clul$=, 
      boolean primaryLocation) {
    
    boolean outOK = true;
    
    File categoryFolder = new File (folder, clubEvent.getCategoryAsString());
    if (! categoryFolder.exists()) {
      categoryFolder.mkdir();
    }
    File file = new File (categoryFolder, clubEvent.getFileName() + FILE_EXT);
    outOK = openOutput (file);
    if (outOK) {
      String oldDiskLocation = clubEvent.getDiskLocation();
      outOK = saveOneItem (clubEvent);
    }
    if (outOK && primaryLocation) {
      clubEvent.setDiskLocation (file);
    }
    if (outOK) {
      closeOutput();
    }
    
    return outOK;
  }
  
  /**
   Open the output writer. 
  
   @param outFile The file to be opened. 
  
   @return True if open worked ok. 
  */
  private boolean openOutput (File outFile) {

    boolean outOK = true;
    try {
      FileOutputStream outStream = new FileOutputStream (outFile);
      OutputStreamWriter outWriter = new OutputStreamWriter (outStream, "UTF-8");
      outBuffered = new BufferedWriter (outWriter);
    } catch (IOException e) {
      outOK = false;
      Trouble.getShared().report 
          ("File "+ outFile.toString() + " could not be opened for output", 
              "File Save Error");  
    }
    return outOK;
  }
  
  private boolean saveOneItem (ClubEvent clubEvent) {
    boolean outOK = true;
<?endif?>
<?endif?>
<?if =$itemtype$= == "Master" ?>
<?if =$calc$= == "" ?>
    if (outOK) {
      outOK = writeFieldName 
          (=$itemclass$=.=$field&c_uuu$=_FIELD_NAME); 
    }
    if (outOK) {
      outOK = writeFieldValue 
          (=$itemclass&clul$=.get=$field&cuul$=AsString());
    }
<?endif?>
<?endif?>
<?loop?>
