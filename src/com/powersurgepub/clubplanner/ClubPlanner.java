/*
 * Copyright 2012 - 2013 Herb Bowie
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

package com.powersurgepub.clubplanner;

  import com.powersurgepub.clubplanner.io.*;
  import com.powersurgepub.clubplanner.model.*;
  import com.powersurgepub.clubplanner.view.*;
  import com.powersurgepub.linktweaker.*;
  import com.powersurgepub.psfiles.*;
  import com.powersurgepub.psdatalib.clubplanner.*;
  import com.powersurgepub.psdatalib.pstags.*;
  import com.powersurgepub.psdatalib.textmerge.*;
  import com.powersurgepub.psdatalib.ui.*;
  import com.powersurgepub.psutils.*;
  import com.powersurgepub.xos2.*;
  import java.awt.*;
  import java.awt.event.*;
  import java.io.*;
  import java.net.*;
  import javax.swing.*;
  import javax.swing.event.*;
  import javax.swing.table.*;
  import javax.swing.tree.*;

/**
 Club Planner application. 
 */
public class ClubPlanner 
    extends 
      javax.swing.JFrame 
    implements 
      TextMergeController,
      // ActionListener,
      TagsChangeAgent,
      // FileOpener,
      // FileSpecOpener,
      // PublishAssistant,
      // ClubEventValidationRegistrar,
      AppToBackup, 
      FileSpecOpener,
      XHandler,
      LinkTweakerApp
    { 
  
  public static final String              PROGRAM_NAME    = "Club Planner";
  public static final String              PROGRAM_VERSION = "0.50";
  
  public  static final String             FIND = "Find";
  public  static final String             FIND_AGAIN = "Again";
  
  private             Appster appster;
  private             Home home;
  private             ProgramVersion      programVersion;
  private             XOS                 xos = XOS.getShared();
  private             Trouble             trouble = Trouble.getShared();
  
  // Variables used for logging
  private             Logger              logger = Logger.getShared();
  private             LogOutput           logOutput;
  private             LogWindow           logWindow;
  
  private             File                appFolder;
  
  private             TagTreeCellRenderer renderer;
  
  private             WindowMenuManager   windowMenuManager;
  
  private             AboutWindow         aboutWindow;
  
  private             UserPrefs           userPrefs;
  private             PrefsWindow         prefsWindow;
  private             RecentFiles         recentFiles;
  private             FilePrefs           filePrefs;
  
  private             LinkTweaker         linkTweaker;
  private             TweakerPrefs        tweakerPrefs;
  
  private             boolean             listAvailable = false;
  
  private             ClubEventList       clubEventList = new ClubEventList();
  private             ClubEventPositioned position = new ClubEventPositioned();
  private             String              localPath = "";
  
  private             XFileChooser        fileChooser = new XFileChooser();
  
  private             File                eventsFile = null;
  private             ClubEventWriter     writer = new ClubEventWriter();
  private             File                currentDirectory;
  private             FileSpec            fileSpec = null;
  private             boolean             currentFileModified = false;
  private             boolean             modified = false;
  
  private             String              lastTextFound = "";
  private             ClubEvent           foundClubEvent = null;
  
  private             ClubEventCalc       clubEventCalc = new ClubEventCalc();
  
  private             StatusBar           statusBar = new StatusBar();
  
  private             ClubEventPanel1     clubEventPanel1;
  private             ClubEventPanel2     clubEventPanel2;
  private             ClubEventPanel3     clubEventPanel3;
  private             ClubEventPanel4     clubEventPanel4;
  private             ClubEventPanel5     clubEventPanel5;
  
  // List Manipulation
  private             TextMergeScript     textMergeScript;
  private             TextMergeFilter     textMergeFilter;
  private             TextMergeSort       textMergeSort;
  private             TextMergeTemplate   textMergeTemplate;
  private             PublishWindow       publishWindow = null;
  private             int                 filterTabIndex = 0;
  private             int                 sortTabIndex = 1;
  private             int                 templateTabIndex = 2;

  /**
   Creates new form ClubPlanner
   */
  public ClubPlanner() {
    appster = new Appster
        ("powersurgepub", "com",
          PROGRAM_NAME, PROGRAM_VERSION,
          this, this);
    home = Home.getShared ();
    programVersion = ProgramVersion.getShared ();
    
    initComponents();
    getContentPane().add(statusBar, java.awt.BorderLayout.SOUTH);
    trouble.setParent(this);
    
    // Get App Folder
    appFolder = home.getAppFolder();
    if (appFolder == null) {
      trouble.report ("The " + home.getProgramName()
          + " Folder could not be found",
          "App Folder Missing");
    } else {
      Logger.getShared().recordEvent (LogEvent.NORMAL,
        "App Folder = " + appFolder.toString(),
        false);
    }
    
    windowMenuManager = WindowMenuManager.getShared(windowMenu);
    
    // Connect up to Mac environment as necessary
    xos.setFileMenu (fileMenu);
    xos.setHelpMenu (helpMenu);
    xos.setXHandler (this);
    xos.setMainWindow (this);
    xos.enablePreferences();
    
    // Set up user prefs
    userPrefs = UserPrefs.getShared();
    prefsWindow = new PrefsWindow (this);
    
    filePrefs = new FilePrefs(this);
    filePrefs.loadFromPrefs();
    prefsWindow.setFilePrefs(filePrefs);
    
    recentFiles = new RecentFiles();
    
    filePrefs.setRecentFiles(recentFiles);
    recentFiles.registerMenu(fileOpenRecentMenu, this);
    recentFiles.setFileSelectionMode (JFileChooser.DIRECTORIES_ONLY);
    recentFiles.setFileContentsName("Club Planner Events Folder");
    recentFiles.loadFromPrefs();
    if (filePrefs.purgeRecentFilesAtStartup()) {
      recentFiles.purgeInaccessibleFiles();
    }
    
    setBounds (
        userPrefs.getPrefAsInt (CommonPrefs.PREFS_LEFT, 100),
        userPrefs.getPrefAsInt (CommonPrefs.PREFS_TOP,  100),
        userPrefs.getPrefAsInt (CommonPrefs.PREFS_WIDTH, 620),
        userPrefs.getPrefAsInt (CommonPrefs.PREFS_HEIGHT, 540));

    CommonPrefs.getShared().setSplitPane(mainSplitPane);
    CommonPrefs.getShared().setMainWindow(this);
    
    tweakerPrefs = new TweakerPrefs();
    prefsWindow.getPrefsTabs().add(TweakerPrefs.PREFS_TAB_NAME, tweakerPrefs);
    
    // Set up Logging
    logWindow = new LogWindow ();
    logOutput = new LogOutputText(logWindow.getTextArea());
    logger = Logger.getShared();
    logger.setLog (logOutput);
    logger.setLogAllData (false);
    logger.setLogThreshold (LogEvent.NORMAL);
    windowMenuManager.add(logWindow);
    
    aboutWindow = new AboutWindow (
      false,   // loadFromDisk
      true,    // browserLauncher2Used
      true,    // jxlUsed
      true,    // pegdownUsed
      false,   // xerces used
      false,   // saxon used
      "2012"); // copyRightYearFrom));
    
    // Set up Publish Window
    textMergeScript = new TextMergeScript(clubEventList);
    textMergeScript.allowAutoplay(false);
    textMergeFilter = new TextMergeFilter(clubEventList, textMergeScript);
    textMergeSort   = new TextMergeSort  (clubEventList, textMergeScript);
    textMergeTemplate = new TextMergeTemplate (clubEventList, textMergeScript);
    textMergeScript.setFilterModule(textMergeFilter);
    textMergeScript.setSortModule(textMergeSort);
    textMergeScript.setTemplateModule(textMergeTemplate);
    
    File templateLibrary = new File (appFolder.getPath(),  "templates");
    textMergeTemplate.setTemplateLibrary(templateLibrary);
    publishWindow = new PublishWindow ("Publish");
    textMergeScript.setTabs(publishWindow.getTabs());
    filterTabIndex = 0;
    textMergeFilter.setTabs(publishWindow.getTabs());
    sortTabIndex = 1;
    textMergeSort.setTabs(publishWindow.getTabs(), false);
    templateTabIndex = 2;
    textMergeTemplate.setTabs(publishWindow.getTabs());
    textMergeScript.selectEasyTab();
    
    windowMenuManager.add(publishWindow);
    
    linkTweaker = new LinkTweaker(this, prefsWindow.getPrefsTabs());
    
    clubEventPanel1 = new ClubEventPanel1(this, linkTweaker);
    clubEventPanel2 = new ClubEventPanel2(this, linkTweaker);
    clubEventPanel3 = new ClubEventPanel3(this, linkTweaker);
    clubEventPanel4 = new ClubEventPanel4(this, linkTweaker);
    clubEventPanel5 = new ClubEventPanel5(this, linkTweaker);
    itemTabs.add("Basics", clubEventPanel1);
    itemTabs.add("Text", clubEventPanel2);
    itemTabs.add("Numbers", clubEventPanel3);
    itemTabs.add("Links", clubEventPanel4);
    itemTabs.add("Notes", clubEventPanel5);
    
    initCollection();
    
    /*
     Following initialization, to get user's preferred file or folder to open.
     */
    String lastFileString = filePrefs.getStartupFilePath();
    if (lastFileString != null
        && lastFileString.length() > 0) {
      File lastFile = new File (lastFileString);
      if (lastFile.exists()
          && lastFile.isDirectory()
          && lastFile.canRead()) {
        openFile (lastFile);
      } else {
        openFile();
      }
    } else {
      openFile();
    }
    
    if (fileSpec == null) {
      handleQuit();
    }
  }
  
  private void auxWindowCalcs() {
    if (publishWindow != null) {
      if (mainSplitPane.getOrientation() == JSplitPane.HORIZONTAL_SPLIT) {
        int lawx = 
            this.getX() 
              + mainSplitPane.getDividerLocation() 
              + mainSplitPane.getDividerSize();

        int lawy =
            this.getY()
              + mainSplitPane.getY()
              + navToolBar.getHeight();

        int laww =
            this.getWidth()
              - mainSplitPane.getDividerLocation()
              - mainSplitPane.getDividerSize();

        int lawh =
            this.getHeight()
              - mainSplitPane.getY()
              - navToolBar.getHeight()
              - statusBar.getHeight();

        publishWindow.setBounds(lawx, lawy, laww, lawh);
      } else {
        int lawx = 
            this.getX() 
              // + mainSplitPane.getDividerLocation() 
              // + mainSplitPane.getDividerSize()
            ;

        int lawy =
            this.getY()
              + mainSplitPane.getY()
              + navToolBar.getHeight()
              + mainSplitPane.getDividerLocation() 
              + mainSplitPane.getDividerSize();

        int laww =
            this.getWidth()
              // - mainSplitPane.getDividerLocation()
              // - mainSplitPane.getDividerSize()
            ;

        int lawh =
            this.getHeight()
              - mainSplitPane.getY()
              - navToolBar.getHeight()
              - statusBar.getHeight()
              - mainSplitPane.getDividerLocation()
              - mainSplitPane.getDividerSize();

        publishWindow.setBounds(lawx, lawy, laww, lawh); 
      }
    }
  }
  
  public void setListAvailable(boolean listAvailable) {
    this.listAvailable = listAvailable;
  }
  
  public boolean isListAvailable() {
    return listAvailable;
  }
  
  /**
     Standard way to respond to an About Menu Item Selection on a Mac.
   */
  public void handleAbout() {
    displayAuxiliaryWindow(aboutWindow);
  }
  
  /**      
    Standard way to respond to a document being passed to this application on a Mac.
   
    @param fileSpec File to be processed by this application, generally
                    as a result of a file or directory being dragged
                    onto the application icon.
   */
  public void handleOpenFile (FileSpec fileSpec) {
    this.fileSpec = fileSpec;
    openFile (fileSpec.getFile());
  }
  
  /**      
    Standard way to respond to a document being passed to this application on a Mac.
   
    @param inFile File to be processed by this application, generally
                  as a result of a file or directory being dragged
                  onto the application icon.
   */
  public void handleOpenFile (File inFile) {
    openFile (inFile);
  }
  
  public void handleOpenURI(URI inURI) {
    
  }
  
  /**
     Standard way to respond to a Preferences Item Selection on a Mac.
   */
  public void handlePreferences() {
    displayPrefs ();
  }
  
  public boolean preferencesAvailable() {
    return true;
  }
  
  public void displayPrefs () {
    displayAuxiliaryWindow(prefsWindow);
  }
  
  public void displayAuxiliaryWindow(WindowToManage window) {
    window.setLocation(
        this.getX() + 60,
        this.getY() + 60);
    windowMenuManager.makeVisible(window);
  }
  
  /**
   Standard way to respond to a print request.
   */
  public void handlePrintFile (File printFile) {
    // not supported
  }
  
  /**
     We're out of here!
   */
  public void handleQuit() {
    closeFile();
    savePrefs();
    System.exit(0);
  }
  
  public boolean goodEventsFile() {
    return (eventsFile != null
        && eventsFile.exists()
        && eventsFile.isDirectory()
        && eventsFile.canRead());
  }
  
  private void savePrefs () {
    userPrefs.setPref (CommonPrefs.PREFS_LEFT, this.getX());
    userPrefs.setPref (CommonPrefs.PREFS_TOP, this.getY());
    userPrefs.setPref (CommonPrefs.PREFS_WIDTH, this.getWidth());
    userPrefs.setPref (CommonPrefs.PREFS_HEIGHT, this.getHeight());
    
    if (goodEventsFile()) {
      // userPrefs.setPref (FavoritesPrefs.LAST_FILE, eventsFile.toString());
    }
    
    // savePreferredCollectionView();
    userPrefs.setPref (CommonPrefs.SPLIT_HORIZONTAL,
        mainSplitPane.getOrientation() == JSplitPane.HORIZONTAL_SPLIT);
    prefsWindow.savePrefs();
    boolean prefsOK = userPrefs.savePrefs();
    recentFiles.savePrefs();
		filePrefs.savePrefs();
    tweakerPrefs.savePrefs();
  }
  
  /**
   Let the user choose a file or folder to open.
   */
  private void openFile() {
    
    // Initialize local variables
    File clubRecordsFolder = null;
    File opYearFolder = null;
    File eventsFolder = null;
    ClubEventCalc newClubEventCalc = new ClubEventCalc();
    StringDate strDate = newClubEventCalc.getStringDate();
    File result = null;
    String resultName = "";
    XFileChooser chooser = new XFileChooser ();
    chooser.setFileSelectionMode(XFileChooser.DIRECTORIES_ONLY);
    boolean ok = true;
    int progress = 0;
    String desiredFolder = "";
    while (ok && progress < 3) {
      switch (progress) {
        case 0: 
          desiredFolder = "Folder Containing Club Records";
          break;
        case 1:
          chooser.setCurrentDirectory(clubRecordsFolder);
          desiredFolder = "Folder for Desired Operating Year";
          break;
        case 2:
          chooser.setCurrentDirectory(opYearFolder);
          desiredFolder = "Events Folder";
          break;
      }
      chooser.setDialogTitle ("Specify " + desiredFolder);
      result = chooser.showOpenDialog (this);
      if (result != null
          && result.exists()
          && result.canRead()
          && result.isDirectory()) {
        resultName = result.getName();
        boolean folderContainsOpYear = strDate.parseOpYear(resultName);
        boolean pathContainsOpYear = newClubEventCalc.setFileName(result);
        if (folderContainsOpYear) {
          opYearFolder = result;
          progress = 2;
        }
        else
        if (pathContainsOpYear) {
          eventsFolder = result;
          progress = 3;
        }
        else
        if (progress < 1) {
          clubRecordsFolder = result;
          progress = 1;
        } else {
          ok = false;
          JOptionPane.showMessageDialog(this,
            "A Valid Operating Year Folder was not specified",
            "Operating Year Folder Missing",
            JOptionPane.WARNING_MESSAGE);
        }
      } else {
        ok = false;
        JOptionPane.showMessageDialog(this,
          "A Valid " + desiredFolder + " was not specified",
          "Invalid Folder Specification",
          JOptionPane.WARNING_MESSAGE);
      }
    }
    
    if (ok) {
      closeFile();
      fileSpec = recentFiles.addRecentFile (result);
      handleOpenFile(fileSpec);
    }
    currentFileModified = false;
  } // end method openFile
  
  private void openFile (File fileToOpen) {
    
    initCollection();
    ClubEventListLoader loader = new ClubEventListLoader(fileToOpen);
    loader.setClubEventCalc(clubEventCalc);
    boolean ok = loader.load(clubEventList);
    if (ok) {
      statusBar.setStatus(String.valueOf(loader.getEventsLoaded()) + " Club Events Loaded");
    } else {
      statusBar.setStatus("Trouble loading Club Events");
    }
    setClubEventFolder (fileToOpen);
    setPSList();
    /*
    readFileContents(eventsFile);
    collectionWindow.setClubEvents (clubEventList);
    clubEventList.fireTableDataChanged();
    */
    position = new ClubEventPositioned ();
    // setPreferredCollectionView();
    position = clubEventList.first(position);
    positionAndDisplay();
  }
  
  private void reload () {
    if (eventsFile != null) {
      initCollection();
      ClubEventListLoader loader = new ClubEventListLoader(eventsFile);
      loader.setClubEventCalc(clubEventCalc);
      boolean ok = loader.load(clubEventList);
      if (ok) {
        statusBar.setStatus(String.valueOf(loader.getEventsLoaded()) 
            + " Club Events Reloaded");
      } else {
        statusBar.setStatus("Trouble reloading Club Events");
      }
      setClubEventFolder (eventsFile);
      setPSList();
      /*
      readFileContents(eventsFile);
      collectionWindow.setClubEvents (clubEventList);
      clubEventList.fireTableDataChanged();
      */
      position = new ClubEventPositioned ();
      // setPreferredCollectionView();
      position = clubEventList.first(position);
      positionAndDisplay();
    }
  }
  
  public boolean saveAll() {
    
    boolean saveOK = modIfChanged();
    
    int numberSaved = 0;
    int numberDeleted = 0;
    
    for (int i = 0; i < clubEventList.totalSize() && saveOK; i++) {
      ClubEvent nextClubEvent = clubEventList.getUnfiltered(i);
      writer = new ClubEventWriter();
      String oldDiskLocation = nextClubEvent.getDiskLocation();
      saveOK = writer.save(eventsFile, nextClubEvent, true);
      if (saveOK) {
        numberSaved++;
        String newDiskLocation = nextClubEvent.getDiskLocation();
        if (! newDiskLocation.equals(oldDiskLocation)) {
          File oldDiskFile = new File (oldDiskLocation);
          oldDiskFile.delete();
          numberDeleted++;
        }
      } else {
        trouble.report(this, "Trouble saving the item to disk", "I/O Error");
        saveOK = false;
      }
    }
    
    String saveResult;
    if (saveOK) {
      saveResult = "succeeded";
    } else {
      saveResult = "failed";
    }
      logger.recordEvent(LogEvent.NORMAL, 
          "Save All command succeeded, resulting in " 
            + String.valueOf(numberSaved)
            + " saves and "
            + String.valueOf(numberDeleted)
            + " deletes", false);

    
    return saveOK;
  }
  
  /**
   Prompt the user to save to a different location. 
  
   @return True if save as was successful.
  */
  public boolean saveAs() {
    boolean modOK = modIfChanged();
    boolean saved = false;
    if (modOK) {
      fileChooser.setDialogTitle ("Save As");
      fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
      File selectedFile = fileChooser.showSaveDialog (this);
      if (selectedFile != null) {
        writer = new ClubEventWriter();
        saved = writer.save (selectedFile, clubEventList, true);
        if (saved) {
          setClubEventFolder (selectedFile);
          logger.recordEvent (LogEvent.NORMAL,
            "Club Events saved to " + selectedFile.toString(),
              false);
        } else {
          logger.recordEvent (LogEvent.MEDIUM,
            "Problem saving Club Events to " + selectedFile.toString(),
              false);
        }
        FileSpec fileSpec = recentFiles.get(0);
      }
    }
    return saved;
  }
  
  /**
   Prompt the user for a backup location. 
  
   @return True if backup was successful.
  */
  public boolean promptForBackup() {
    boolean modOK = modIfChanged();
    boolean backedUp = false;
    if (modOK) {
      fileChooser.setDialogTitle ("Make Backup of Club Planner Events folder");
      fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
      FileName eventsFileName = new FileName (home.getUserHome());
      if (goodEventsFile()) {
        eventsFileName = new FileName (eventsFile);
      }
      File backupFolder = getBackupFolder();
      fileChooser.setCurrentDirectory (backupFolder);
      File selectedFile = fileChooser.showSaveDialog (this);
      if(selectedFile != null) {
        File backupFile = selectedFile;
        backedUp = backup (backupFile);
        FileSpec fileSpec = recentFiles.get(0);
        fileSpec.setBackupFolder(backupFile);
        if (backedUp) {
          JOptionPane.showMessageDialog(this,
              "Backup completed successfully",
              "Backup Results",
              JOptionPane.INFORMATION_MESSAGE,
              Home.getShared().getIcon());
        } // end if backed up successfully
      } // end if the user selected a backup location
    } // end if modIfChanged had no problems

    return backedUp;
  }
  
  /**
   Backup without prompting the user. 
  
   @return True if backup was successful. 
  */
  public boolean backupWithoutPrompt() {
    boolean modOK = modIfChanged();
    boolean backedUp = false;
    if (modOK) {
      File backupFolder = getBackupFolder();
      if(backupFolder != null) {
        backedUp = backup (backupFolder);
        if (backedUp) {
          FileSpec fileSpec = recentFiles.get(0);
          fileSpec.setBackupFolder(backupFolder);
        }
      } // end if the user selected a backup location
    } // end if modIfChanged had no problems
    
    if (! backedUp) {
      trouble.report("Could not complete backup", "Backup Errors");
    }

    return backedUp;
  }
  
  /**
   Backup the data store to the indicated location. 
  
   @param backupFile The folder in which the backup should be placed.  
  
   @return 
  */
  public boolean backup(File folderForBackups) {
    boolean backedUp = false;
    StringBuilder backupPath = new StringBuilder();
    try {
      backupPath.append(folderForBackups.getCanonicalPath());
    } catch (IOException e) {
      backupPath.append(folderForBackups.getAbsolutePath());
    }
    backupPath.append(xos.getPathSeparator());
    if (clubEventCalc.ifOpYearFromFolder()) {
      backupPath.append(clubEventCalc.getOpYearFolder());
      backupPath.append(" ");
    }
    backupPath.append("backup ");
    backupPath.append(filePrefs.getBackupDate());
    File backupFolder = new File (backupPath.toString());
    backupFolder.mkdir();
    ClubEventWriter backupWriter = new ClubEventWriter();
    backedUp = backupWriter.save (backupFolder, clubEventList, false);
    if (backedUp) {
      logger.recordEvent (LogEvent.NORMAL,
          "URLs backed up to " + backupFolder.toString(),
            false);
    } else {
      logger.recordEvent (LogEvent.MEDIUM,
          "Problem backing up URLs to " + backupFolder.toString(),
            false);
    }
    return backedUp;
  }
  
  /**
   Return the presumptive folder to be used for backups. 
  
   @return The folder we think the user wishes to use for backups,
           based on his past choices, or on the application defaults.
  */
  private File getBackupFolder() {
    File backupFolder = home.getUserHome();
    if (goodEventsFile()) {    
      FileSpec fileSpec = recentFiles.get(0);
      String backupFolderStr = fileSpec.getBackupFolder();
      File defaultBackupFolder = new File (fileSpec.getFolder(), "backups");
      if (backupFolderStr == null
          || backupFolderStr.length() < 2) {
        backupFolder = defaultBackupFolder;
      } else {
        backupFolder = new File (backupFolderStr);
        if (backupFolder.exists()
            && backupFolder.canWrite()) {
          // leave as-is
        } else {
          backupFolder = defaultBackupFolder;
        }
      }
    }
    return backupFolder;
  }
  
  /**
   Let's close the current file, if one is open. 
  */
  private void closeFile() {
    if (fileSpec != null) {
      boolean modOK = modIfChanged();
      if (currentFileModified) {
        filePrefs.handleClose();
      }
    }
    currentFileModified = false;
  }
  
  private void initCollection () {
    clubEventList = new ClubEventList();
    itemTable.setModel(clubEventList);
    
    TableColumn tc = null;
    int avg = 0;
    int max = 0;
    int pwc = 0;
    int pw = 0;
    for (int i = 0; i < clubEventList.getColumnCount(); i++) { 
      tc = itemTable.getColumnModel().getColumn(i);
      tc.setPreferredWidth (ClubEvent.getColumnWidth(i) * 9);
    }
    
    clubEventPanel1.getStatusTextSelector().setValueList
        (clubEventList.getTagsList());
    tagsTree.setModel (clubEventList.getTagsModel().getModel());
    tagsTree.getSelectionModel().setSelectionMode
        (TreeSelectionModel.SINGLE_TREE_SELECTION);

    tagsTree.addTreeSelectionListener (new TreeSelectionListener() {
      public void valueChanged (TreeSelectionEvent e) {
        selectBranch();
      }
    });
    renderer = new TagTreeCellRenderer ();
    tagsTree.setCellRenderer (renderer);
    tagsTree.doLayout();
  }
  
  private void setPSList() {
    textMergeFilter.setPSList(clubEventList);
    textMergeSort.setPSList(clubEventList);
    textMergeTemplate.setPSList(clubEventList);
    textMergeScript.setPSList(clubEventList);
  }
  
  /**
   Save various bits of information about a new URL file that we are
   working with.

   @param file The folder containing club events, possibly organized into
               subfolders by type of event.

   */
  private void setClubEventFolder (File file) {
    if (file == null) {
      eventsFile = null;
      // currentFileSpec = null;
      statusBar.setFileName("            ", " ");
    } else {
      fileSpec = recentFiles.addRecentFile (file);
      if (clubEventList != null) {
        clubEventList.setSource (fileSpec);
      } else {
        // System.out.println("ClubPlanner.setClubEventFolder clubEventList is null");
      }
      eventsFile = file;
      currentDirectory = file.getParentFile();
      FileName fileName = new FileName (file);
      statusBar.setFileName(fileName);
      // publishWindow.openSource(currentDirectory);
    }
  }
  
  /**
   Prepare the data entry screen for a new item.
   */
  public void newClubEvent() {

    // Capture current category selection, if any
    String selectedTags = "";
    TagsNode tags = (TagsNode)tagsTree.getLastSelectedPathComponent();
    if (tags != null) {
      selectedTags = tags.getTagsAsString();
    } 

    boolean modOK = modIfChanged();

    if (modOK) {
      position = new ClubEventPositioned();
      position.setIndex (clubEventList.size());
      localPath = "";
      display();
      clubEventPanel1.getStatusTextSelector().setText (selectedTags);
    }
  }
  
  /**
   Duplicate the currently displayed event.
   */
  public void duplicateClubEvent() {

    boolean modOK = modIfChanged();

    if (modOK) {
      ClubEvent clubEvent = position.getClubEvent();
      ClubEvent newClubEvent = clubEvent.duplicate();
      newClubEvent.setWhat(clubEvent.getWhat() + " copy");
      position = new ClubEventPositioned();
      position.setIndex (clubEventList.size());
      position.setClubEvent(newClubEvent);
      position.setNewClubEvent(true);
      localPath = "";
      display();
    }
  }
  
  /**
   Remove the currently displayed event from the list. 
  */
  private void removeClubEvent () {
    boolean okToDelete = true;
    if (CommonPrefs.getShared().confirmDeletes()) {
      int userOption = JOptionPane.showConfirmDialog(this, 
          "Really delete this Event?",
          "Delete Confirmation",
          JOptionPane.YES_NO_OPTION,
          JOptionPane.QUESTION_MESSAGE);
      okToDelete = (userOption == JOptionPane.YES_OPTION);
    }
    if (okToDelete) {
      if (position.isNewClubEvent()) {
        position = new ClubEventPositioned();
        position.setIndex (clubEventList.size());
        display();        
      } else {
        noFindInProgress();
        boolean deleted = writer.delete(eventsFile, localPath);
        if (! deleted) {
          Trouble.getShared().report(this, 
              "Event could not be deleted", 
              "Delete Failure", 
              JOptionPane.ERROR_MESSAGE);
        }
        position = clubEventList.remove (position);
        positionAndDisplay();
        currentFileModified = true;
      } // end if new ClubEvent not yet saved
    }
    
  } // end method removeClubEvent
  
	private void replaceTags() {
		boolean modOK = modIfChanged();
    if (modOK) {
      TagsChangeScreen replaceScreen = new TagsChangeScreen
          (this, true, clubEventList.getTagsList(), this);
      replaceScreen.setLocation (
          this.getX() + WindowMenuManager.CHILD_WINDOW_X_OFFSET,
          this.getY() + WindowMenuManager.CHILD_WINDOW_Y_OFFSET);
      replaceScreen.setVisible (true);
      // setUnsavedChanges (true);
      // catScreen.show();
    }
	}

	/**
	 Called from TagsChangeScreen.
	 @param from The from String.
	 @param to	 The to String.
	 */
	public void changeAllTags (String from, String to) {

		boolean modOK = modIfChanged();
    if (modOK) {
      ClubEventPositioned workPositioned = new ClubEventPositioned ();
      int mods = 0;
      for (int workIndex = 0; workIndex < clubEventList.size(); workIndex++) {
        workPositioned.setClubEvent (clubEventList.get (workIndex));
        workPositioned.setIndex (workIndex);
        String before = workPositioned.getClubEvent().getTags().toString();
        workPositioned.getClubEvent().getTags().replace (from, to);
        if (! before.equals (workPositioned.getClubEvent().getTags().toString())) {
          mods++;
          clubEventList.modify(workPositioned);
        }
      }

      JOptionPane.showMessageDialog(this,
        String.valueOf (mods)
            + " tags changed",
        "Tags Replacement Results",
        JOptionPane.INFORMATION_MESSAGE);
      display();
    }
	}

	private void flattenTags() {
		boolean modOK = modIfChanged();
    if (modOK) {
      ClubEventPositioned workPositioned = new ClubEventPositioned();
      for (int workIndex = 0; workIndex < clubEventList.size(); workIndex++) {
        workPositioned.setClubEvent (clubEventList.get (workIndex));
        workPositioned.getClubEvent().flattenTags();
        clubEventList.modify(workPositioned);
      }
      findButton.setText(FIND);
      display();
    }
	}

	private void lowerCaseTags() {
		boolean modOK = modIfChanged();
    if (modOK) {
      ClubEventPositioned workPositioned = new ClubEventPositioned();
      for (int workIndex = 0; workIndex < clubEventList.size(); workIndex++) {
        workPositioned.setClubEvent (clubEventList.get (workIndex));
        workPositioned.getClubEvent().lowerCaseTags();
        clubEventList.modify(workPositioned);
      }
      findButton.setText(FIND);
    }
	}

	public int replaceTags (String find, String replace) {
		int mods = 0;
		ClubEvent next;
		Tags tags;
		String tag;
		for (int i = 0; i < clubEventList.size(); i++) {
			next = clubEventList.get(i);
			tags = next.getTags();
			boolean modified = false;
			if (find.equals("")) {
				tags.merge (replace);
				modified = true;
			} else {
				TagsIterator iterator = new TagsIterator (tags);
				while (iterator.hasNextTag() && (! modified)) {
					tag = iterator.nextTag();
					if (tag.equalsIgnoreCase (find)) {
						iterator.removeTag();
						if (replace.length() > 0) {
							tags.merge (replace);
						}
						modified = true;
					}
				} // end while this item has more categories
			} // end if we the find category is not blank
			if (modified) {
				mods++;
				// setUnsavedChanges (true);
			} // end if modified
		} // end of	 items
		return mods;
	}
  
  /**
   Check to see if the user has changed anything and take appropriate
   actions if so.
  
   @return True if it's ok to proceed, false if the user's changes could
           not be saved. 
   */
  public boolean modIfChanged () {
    
    boolean modOK = true;

    ClubEvent clubEvent = position.getClubEvent();
    if (clubEventPanel1.modIfChanged(clubEvent)) {
      modified = true;
    } 
    if (clubEventPanel2.modIfChanged(clubEvent)) {
      modified = true;
    } 
    if (clubEventPanel3.modIfChanged(clubEvent)) {
      modified = true;
    } 
    if (clubEventPanel4.modIfChanged(clubEvent)) {
      modified = true;
    } 
    if (clubEventPanel5.modIfChanged(clubEvent)) {
      modified = true;
    } 
    
    if (modified) {
      currentFileModified = true;
      String newLocalPath = clubEvent.getLocalPath();
      if ((! clubEvent.hasWhat()) || clubEvent.getWhat().length() == 0) {
        trouble.report (this, 
            "The What field has been left blank", 
            "Missing Key Field");
        modOK = false;
      } 
      else 
      if ((! newLocalPath.equals(localPath))
          && writer.exists(eventsFile, newLocalPath)) {
        trouble.report (this, 
            "An event already exists with the same What field",
            "Duplicate Found");
        modOK = false;
      }
      else
      if (position.isNewClubEvent()) {
        clubEventCalc.calcAll(clubEvent);
        addClubEvent (clubEvent);
      } else {
        clubEventCalc.calcAll(clubEvent);
        clubEventList.modify(position);
        writer = new ClubEventWriter();
        String oldDiskLocation = clubEvent.getDiskLocation();
        boolean saved = writer.save(eventsFile, clubEvent, true);
        if (saved) {
          String newDiskLocation = clubEvent.getDiskLocation();
          if (! newDiskLocation.equals(oldDiskLocation)) {
            File oldDiskFile = new File (oldDiskLocation);
            oldDiskFile.delete();
          }
        } else {
          trouble.report(this, "Trouble saving the item to disk", "I/O Error");
          modOK = false;
        }
      }
      clubEventList.fireTableDataChanged();
    } // end if modified
    
    return modOK;
    
  } // end modIfChanged method
  
  /**
   Add a new club event.
  */
  private void addClubEvent (ClubEvent clubEvent) {
    position = clubEventList.add (position.getClubEvent());
    if (position.hasValidIndex (clubEventList)) {
      writer.save(eventsFile, clubEvent, true);
      positionAndDisplay();
    }
  }
  
  public void firstClubEvent () {
    boolean modOK = modIfChanged();
    if (modOK) {
      noFindInProgress();
      // position.setNavigatorToList (collectionTabbedPane.getSelectedIndex() == 0);
      position = clubEventList.first (position);
      positionAndDisplay();
    }
  }

  public void priorClubEvent () {
    boolean modOK = modIfChanged();
    if (modOK) {
      noFindInProgress();
      // position.setNavigatorToList (collectionTabbedPane.getSelectedIndex() == 0);
      position = clubEventList.prior (position);
      positionAndDisplay();
    }
  }

  public void nextClubEvent() {
    boolean modOK = modIfChanged();
    if (modOK) {
      noFindInProgress();
      // position.setNavigatorToList (collectionTabbedPane.getSelectedIndex() == 0);
      position = clubEventList.next (position);
      positionAndDisplay();
    }
  }

  public void lastClubEvent() {
    boolean modOK = modIfChanged();
    if (modOK) {
      noFindInProgress();
      // position.setNavigatorToList (collectionTabbedPane.getSelectedIndex() == 0);
      position = clubEventList.last (position);
      positionAndDisplay();
    }
  }
  
  /**
    Find the next URL item containing the search string, or position the cursor
    on the search string, if it is currently empty. 
  */
  private void findClubEvent () {

    findClubEvent (
      findButton.getText(), 
      findText.getText().trim(), 
      true);
      
    if (findText.getText().trim().length() == 0) {
      findText.grabFocus();
      statusBar.setStatus("Enter a search string");
    }
  }
  
  /**
    Find the specified text string within the list of URL items. This method may
    be called internally, or from the ReplaceWindow. The result will be to 
    position the displays on the item found, or display a message to the user
    that no matching item was found. 
  
    @param findButtonText Either "Find" or "Again", indicating whether we
                          are starting a new search or continuing an 
                          existing one. 
    @param findString  The string we're searching for. 
    @param checkTitle  Should we check the title of the URL item?
    @param checkURL    Should we check the URL of the URL item?
    @param checkTags   Should we check the tags of the URL item?
    @param checkComments Should we check the comments?
    @param caseSensitive Should we do a case-sensitive comparison?
    @param showDialogAtEnd Show a dialog to user when no remaining URLs found?
  */
  public boolean findClubEvent (
      String findButtonText, 
      String findString, 
      boolean showDialogAtEnd) {
        
    boolean modOK = modIfChanged();
    boolean found = false;

    if (modOK) {
      String notFoundMessage;
      if (findString != null && findString.length() > 0) {
        if (findButtonText.equals (FIND)) {
          notFoundMessage = "No Club Events Found";
          position.setIndex (-1);
        } else {
          notFoundMessage = "No further Club Events Found";
        }
        position.incrementIndex (1);
        String findLower = findString.toLowerCase();
        String findUpper = findString.toUpperCase();
        while (position.hasValidIndex(clubEventList) && (! found)) {
          ClubEvent clubEventCheck = clubEventList.get (position.getIndex());
          found = clubEventCheck.find (findLower, findUpper);
          if (found) {
            foundClubEvent = clubEventCheck;
          } else {
            position.incrementIndex (1);
          }
        } // while still looking for next match
        if (found) {
          findInProgress();
          lastTextFound = findString;
          position = clubEventList.positionUsingListIndex (position.getIndex());
          positionAndDisplay();
          statusBar.setStatus("Matching Club Event found");
        } else {
          JOptionPane.showMessageDialog(this,
              notFoundMessage,
              "OK",
              JOptionPane.WARNING_MESSAGE);
          noFindInProgress();
          lastTextFound = "";
          statusBar.setStatus(notFoundMessage);
          foundClubEvent = null;
        }
      } // end if we've got a find string
    }
    return found;
  } // end method findURL
  
  public void noFindInProgress() {
    findButton.setText(FIND);
    // replaceWindow.noFindInProgress();
  }
  
  public void findInProgress() {
    findButton.setText(FIND_AGAIN);
    // replaceWindow.findInProgress();
  }

  
  private void positionAndDisplay () {
    if (position.getIndex() >= 0
        && position.getIndex() < clubEventList.size()
        && position.getIndex() != itemTable.getSelectedRow()) {
      itemTable.setRowSelectionInterval
          (position.getIndex(), position.getIndex());
      itemTable.scrollRectToVisible
          ((itemTable.getCellRect(position.getIndex(), 0, false)));
    } 
    if (position.getTagsNode() != null
        && position.getTagsNode()
          != tagsTree.getLastSelectedPathComponent()
        ) {
      TreePath path = new TreePath(position.getTagsNode().getPath());
      tagsTree.setSelectionPath (path);
      tagsTree.scrollPathToVisible (path);
    }
    display();
  }
  
  /**
   Respond when the user clicks on a row in the URL list.
   */
  private void selectTableRow () {
    int selectedRow = itemTable.getSelectedRow();
    if (selectedRow >= 0 && selectedRow < clubEventList.size()) {
      boolean modOK = modIfChanged();
      if (modOK) {
        position = clubEventList.positionUsingListIndex (selectedRow);
        positionAndDisplay();
      }
    }
  }
  
  /**
   Respond when user selects a url from the tags tree.
   */
  private void selectBranch () {

    TagsNode node = (TagsNode)tagsTree.getLastSelectedPathComponent();

    if (node == null) {
      // nothing selected
      // System.out.println ("selectBranch selected component = null");
    }
    else
    if (node == position.getTagsNode()) {
      // If we're already positioned on the selected node, then no
      // need to do anything else (especially since it might set off
      // an endless loop).
    }
    else
    if (node.getNodeType() == TagsNode.ITEM) {
      // System.out.println ("selectBranch selected item = " + node.toString());
      boolean modOK = modIfChanged();
      if (modOK) {
        ClubEvent branch = (ClubEvent)node.getTaggable();
        int branchIndex = clubEventList.find (branch);
        if (branchIndex >= 0) {
          position = clubEventList.positionUsingListIndex (branchIndex);
          position.setTagsNode (node);
          positionAndDisplay();
        } else {
          System.out.println ("Selected a branch from the tree that couldn't be found in the list");
        }
      }
    }
    else {
      // Do nothing until an item is selected
      // System.out.println ("selectBranch selected node = " + node.toString());
    }
  }
  
  private void display() {
    ClubEvent clubEvent = position.getClubEvent();
    if (clubEvent.hasDiskLocation()) {
      reload (clubEvent);
    }
    localPath = clubEvent.getLocalPath();
    clubEventPanel1.display(clubEvent);
    clubEventPanel2.display(clubEvent);
    clubEventPanel3.display(clubEvent);
    clubEventPanel4.display(clubEvent);
    clubEventPanel5.display(clubEvent);
    statusBar.setPosition(position.getIndexForDisplay(), clubEventList.size());
    modified = false;
  }
  
  private void reload (ClubEvent clubEvent) {
      ClubEventReader reader 
          = new ClubEventReader (
              clubEvent.getDiskLocation(), 
              ClubEventReader.PLANNER_TYPE);
      boolean ok = true;
      reader.setClubEventCalc(clubEventCalc);
      try {
        reader.openForInput(clubEvent);
      } catch (java.io.IOException e) {
        ok = false;
        Logger.getShared().recordEvent(LogEvent.MEDIUM, 
            "Trouble reading " + clubEvent.getDiskLocation(), false);
      }
      
      reader.close();
  }
  
  /**
   Set a link field to a new value after it has been tweaked. 
  
   @param tweakedLink The link after it has been tweaked. 
   @param linkID      A string identifying the link, in case there are more
                      than one. This would be the text used in the label
                      for the link. 
  */
  public void setTweakedLink (String tweakedLink, String linkID) {
    this.clubEventPanel4.setTweakedLink (tweakedLink, linkID);
  }
  
  /**
   This method is called from within the constructor to initialize the form.
   WARNING: Do NOT modify this code. The content of this method is always
   regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    navToolBar = new javax.swing.JToolBar();
    okButton = new javax.swing.JButton();
    newButton = new javax.swing.JButton();
    deleteButton = new javax.swing.JButton();
    firstButton = new javax.swing.JButton();
    priorButton = new javax.swing.JButton();
    nextButton = new javax.swing.JButton();
    lastButton = new javax.swing.JButton();
    findText = new javax.swing.JTextField();
    findButton = new javax.swing.JButton();
    mainSplitPane = new javax.swing.JSplitPane();
    collectionTabs = new javax.swing.JTabbedPane();
    listPanel = new javax.swing.JPanel();
    itemTableScrollPane = new javax.swing.JScrollPane();
    itemTable = new javax.swing.JTable();
    treePanel = new javax.swing.JPanel();
    treeScrollPane = new javax.swing.JScrollPane();
    tagsTree = new javax.swing.JTree();
    itemTabs = new javax.swing.JTabbedPane();
    mainMenuBar = new javax.swing.JMenuBar();
    fileMenu = new javax.swing.JMenu();
    fileOpenMenuItem = new javax.swing.JMenuItem();
    fileOpenRecentMenu = new javax.swing.JMenu();
    fileReloadMenuItem = new javax.swing.JMenuItem();
    jSeparator1 = new javax.swing.JPopupMenu.Separator();
    fileSaveMenuItem = new javax.swing.JMenuItem();
    fileSaveAllMenuItem = new javax.swing.JMenuItem();
    fileSaveAsMenuItem = new javax.swing.JMenuItem();
    jSeparator2 = new javax.swing.JPopupMenu.Separator();
    filePublishMenuItem = new javax.swing.JMenuItem();
    jSeparator4 = new javax.swing.JPopupMenu.Separator();
    fileBackupMenuItem = new javax.swing.JMenuItem();
    eventMenu = new javax.swing.JMenu();
    eventNextMenuItem = new javax.swing.JMenuItem();
    eventPriorMenuItem = new javax.swing.JMenuItem();
    jSeparator3 = new javax.swing.JPopupMenu.Separator();
    eventNewMenuItem = new javax.swing.JMenuItem();
    eventDeleteMenuItem = new javax.swing.JMenuItem();
    eventDupeMenuItem = new javax.swing.JMenuItem();
    editMenu = new javax.swing.JMenu();
    windowMenu = new javax.swing.JMenu();
    helpMenu = new javax.swing.JMenu();
    helpHistoryMenuItem = new javax.swing.JMenuItem();
    userGuideMenuItem = new javax.swing.JMenuItem();
    jSeparator7 = new javax.swing.JSeparator();
    helpSoftwareUpdatesMenuItem = new javax.swing.JMenuItem();
    webMenuItem = new javax.swing.JMenuItem();
    submitFeedbackMenuItem = new javax.swing.JMenuItem();
    jSeparator8 = new javax.swing.JSeparator();
    helpReduceWindowSizeMenuItem = new javax.swing.JMenuItem();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    addComponentListener(new java.awt.event.ComponentAdapter() {
      public void componentResized(java.awt.event.ComponentEvent evt) {
        formComponentResized(evt);
      }
      public void componentMoved(java.awt.event.ComponentEvent evt) {
        formComponentMoved(evt);
      }
    });

    navToolBar.setRollover(true);

    okButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
    okButton.setText("OK");
    okButton.setToolTipText("Complete your changes to this item");
    okButton.setFocusable(false);
    okButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    okButton.setMargin(new java.awt.Insets(0, 4, 4, 4));
    okButton.setMaximumSize(new java.awt.Dimension(60, 30));
    okButton.setMinimumSize(new java.awt.Dimension(30, 26));
    okButton.setPreferredSize(new java.awt.Dimension(40, 28));
    okButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    okButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        okButtonActionPerformed(evt);
      }
    });
    navToolBar.add(okButton);

    newButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
    newButton.setText("+");
    newButton.setToolTipText("Add a new item");
    newButton.setFocusable(false);
    newButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    newButton.setMargin(new java.awt.Insets(0, 4, 4, 4));
    newButton.setMaximumSize(new java.awt.Dimension(60, 30));
    newButton.setMinimumSize(new java.awt.Dimension(30, 26));
    newButton.setPreferredSize(new java.awt.Dimension(40, 28));
    newButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    newButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        newButtonActionPerformed(evt);
      }
    });
    navToolBar.add(newButton);

    deleteButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
    deleteButton.setText("-");
    deleteButton.setToolTipText("Delete this item");
    deleteButton.setFocusable(false);
    deleteButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    deleteButton.setMargin(new java.awt.Insets(0, 4, 4, 4));
    deleteButton.setMaximumSize(new java.awt.Dimension(60, 30));
    deleteButton.setMinimumSize(new java.awt.Dimension(30, 26));
    deleteButton.setPreferredSize(new java.awt.Dimension(40, 28));
    deleteButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    deleteButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        deleteButtonActionPerformed(evt);
      }
    });
    navToolBar.add(deleteButton);

    firstButton.setText("<<");
    firstButton.setToolTipText("Return to beginning of list");
    firstButton.setFocusable(false);
    firstButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    firstButton.setMaximumSize(new java.awt.Dimension(60, 30));
    firstButton.setMinimumSize(new java.awt.Dimension(30, 26));
    firstButton.setPreferredSize(new java.awt.Dimension(40, 28));
    firstButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    firstButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        firstButtonAction(evt);
      }
    });
    navToolBar.add(firstButton);

    priorButton.setText("<");
    priorButton.setToolTipText("Return to prior item in list");
    priorButton.setFocusable(false);
    priorButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    priorButton.setMaximumSize(new java.awt.Dimension(60, 30));
    priorButton.setMinimumSize(new java.awt.Dimension(30, 26));
    priorButton.setPreferredSize(new java.awt.Dimension(40, 28));
    priorButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    priorButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        priorButtonAction(evt);
      }
    });
    navToolBar.add(priorButton);

    nextButton.setText(">");
    nextButton.setToolTipText("Advance to next item in list");
    nextButton.setFocusable(false);
    nextButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    nextButton.setMaximumSize(new java.awt.Dimension(60, 30));
    nextButton.setMinimumSize(new java.awt.Dimension(30, 26));
    nextButton.setPreferredSize(new java.awt.Dimension(40, 28));
    nextButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    nextButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        nextButtonAction(evt);
      }
    });
    navToolBar.add(nextButton);

    lastButton.setText(">>");
    lastButton.setToolTipText("Go to end of list");
    lastButton.setFocusable(false);
    lastButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    lastButton.setMaximumSize(new java.awt.Dimension(60, 30));
    lastButton.setMinimumSize(new java.awt.Dimension(30, 26));
    lastButton.setPreferredSize(new java.awt.Dimension(40, 28));
    lastButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    lastButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        lastButtonAction(evt);
      }
    });
    navToolBar.add(lastButton);

    findText.setMargin(new java.awt.Insets(4, 4, 4, 4));
    findText.setMaximumSize(new java.awt.Dimension(240, 30));
    findText.setMinimumSize(new java.awt.Dimension(40, 26));
    findText.setPreferredSize(new java.awt.Dimension(120, 28));
    findText.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        findTextActionPerformed(evt);
      }
    });
    findText.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(java.awt.event.KeyEvent evt) {
        findTextKeyTyped(evt);
      }
    });
    navToolBar.add(findText);

    findButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
    findButton.setText("Find");
    findButton.setToolTipText("Search for the text entered to the left");
    findButton.setFocusable(false);
    findButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    findButton.setMaximumSize(new java.awt.Dimension(72, 30));
    findButton.setMinimumSize(new java.awt.Dimension(48, 26));
    findButton.setPreferredSize(new java.awt.Dimension(60, 28));
    findButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    findButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        findButtonActionPerformed(evt);
      }
    });
    navToolBar.add(findButton);

    getContentPane().add(navToolBar, java.awt.BorderLayout.NORTH);

    mainSplitPane.setDividerLocation(120);
    mainSplitPane.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
      public void propertyChange(java.beans.PropertyChangeEvent evt) {
        mainSplitPanePropertyChange(evt);
      }
    });

    listPanel.setLayout(new java.awt.BorderLayout());

    itemTableScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
    itemTableScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

    itemTable.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null}
      },
      new String [] {
        "Title 1", "Title 2", "Title 3", "Title 4"
      }
    ));
    itemTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
    itemTable.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        itemTableMouseClicked(evt);
      }
    });
    itemTable.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyReleased(java.awt.event.KeyEvent evt) {
        itemTableKeyReleased(evt);
      }
    });
    itemTableScrollPane.setViewportView(itemTable);

    listPanel.add(itemTableScrollPane, java.awt.BorderLayout.CENTER);

    collectionTabs.addTab("List", listPanel);

    treePanel.setLayout(new java.awt.BorderLayout());

    treeScrollPane.setViewportView(tagsTree);

    treePanel.add(treeScrollPane, java.awt.BorderLayout.CENTER);

    collectionTabs.addTab("Tags", treePanel);

    mainSplitPane.setLeftComponent(collectionTabs);
    mainSplitPane.setRightComponent(itemTabs);

    getContentPane().add(mainSplitPane, java.awt.BorderLayout.CENTER);

    fileMenu.setText("File");

    fileOpenMenuItem.setAccelerator(KeyStroke.getKeyStroke (KeyEvent.VK_O, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
    fileOpenMenuItem.setText("Open...");
    fileOpenMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        fileOpenMenuItemActionPerformed(evt);
      }
    });
    fileMenu.add(fileOpenMenuItem);

    fileOpenRecentMenu.setText("Open Recent");
    fileMenu.add(fileOpenRecentMenu);

    fileReloadMenuItem.setText("Reload");
    fileReloadMenuItem.setToolTipText("Reload all events from disk");
    fileReloadMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        fileReloadMenuItemActionPerformed(evt);
      }
    });
    fileMenu.add(fileReloadMenuItem);
    fileMenu.add(jSeparator1);

    fileSaveMenuItem.setAccelerator(KeyStroke.getKeyStroke (KeyEvent.VK_S,
      Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
  fileSaveMenuItem.setText("Save");
  fileSaveMenuItem.setToolTipText("Save current item");
  fileSaveMenuItem.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
      fileSaveMenuItemActionPerformed(evt);
    }
  });
  fileMenu.add(fileSaveMenuItem);

  fileSaveAllMenuItem.setText("Save All");
  fileSaveAllMenuItem.setToolTipText("Save all items in the list back to disk. ");
  fileSaveAllMenuItem.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
      fileSaveAllMenuItemActionPerformed(evt);
    }
  });
  fileMenu.add(fileSaveAllMenuItem);

  fileSaveAsMenuItem.setText("Save As...");
  fileSaveAsMenuItem.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
      fileSaveAsMenuItemActionPerformed(evt);
    }
  });
  fileMenu.add(fileSaveAsMenuItem);
  fileMenu.add(jSeparator2);

  filePublishMenuItem.setAccelerator(KeyStroke.getKeyStroke (KeyEvent.VK_P, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
  filePublishMenuItem.setText("Publish...");
  filePublishMenuItem.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
      filePublishMenuItemActionPerformed(evt);
    }
  });
  fileMenu.add(filePublishMenuItem);
  fileMenu.add(jSeparator4);

  fileBackupMenuItem.setAccelerator(KeyStroke.getKeyStroke (KeyEvent.VK_B, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
  fileBackupMenuItem.setText("Backup...");
  fileBackupMenuItem.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
      fileBackupMenuItemActionPerformed(evt);
    }
  });
  fileMenu.add(fileBackupMenuItem);

  mainMenuBar.add(fileMenu);

  eventMenu.setText("Event");

  eventNextMenuItem.setAccelerator(KeyStroke.getKeyStroke (KeyEvent.VK_CLOSE_BRACKET,
    Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
eventNextMenuItem.setText("Next");
eventNextMenuItem.addActionListener(new java.awt.event.ActionListener() {
  public void actionPerformed(java.awt.event.ActionEvent evt) {
    eventNextMenuItemActionPerformed(evt);
  }
  });
  eventMenu.add(eventNextMenuItem);

  eventPriorMenuItem.setAccelerator(KeyStroke.getKeyStroke (KeyEvent.VK_OPEN_BRACKET,
    Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
eventPriorMenuItem.setText("Prior");
eventPriorMenuItem.addActionListener(new java.awt.event.ActionListener() {
  public void actionPerformed(java.awt.event.ActionEvent evt) {
    eventPriorMenuItemActionPerformed(evt);
  }
  });
  eventMenu.add(eventPriorMenuItem);
  eventMenu.add(jSeparator3);

  eventNewMenuItem.setAccelerator(KeyStroke.getKeyStroke (KeyEvent.VK_N,
    Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
eventNewMenuItem.setText("New");
eventNewMenuItem.addActionListener(new java.awt.event.ActionListener() {
  public void actionPerformed(java.awt.event.ActionEvent evt) {
    eventNewMenuItemActionPerformed(evt);
  }
  });
  eventMenu.add(eventNewMenuItem);

  eventDeleteMenuItem.setAccelerator(KeyStroke.getKeyStroke (KeyEvent.VK_D,
    Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
eventDeleteMenuItem.setText("Delete");
eventDeleteMenuItem.addActionListener(new java.awt.event.ActionListener() {
  public void actionPerformed(java.awt.event.ActionEvent evt) {
    eventDeleteMenuItemActionPerformed(evt);
  }
  });
  eventMenu.add(eventDeleteMenuItem);

  eventDupeMenuItem.setText("Duplicate");
  eventDupeMenuItem.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
      eventDupeMenuItemActionPerformed(evt);
    }
  });
  eventMenu.add(eventDupeMenuItem);

  mainMenuBar.add(eventMenu);

  editMenu.setText("Edit");
  mainMenuBar.add(editMenu);

  windowMenu.setText("Window");
  mainMenuBar.add(windowMenu);

  helpMenu.setText("Help");

  helpHistoryMenuItem.setText("Program History");
  helpHistoryMenuItem.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
      helpHistoryMenuItemActionPerformed(evt);
    }
  });
  helpMenu.add(helpHistoryMenuItem);

  userGuideMenuItem.setText("User Guide");
  userGuideMenuItem.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
      userGuideMenuItemActionPerformed(evt);
    }
  });
  helpMenu.add(userGuideMenuItem);
  helpMenu.add(jSeparator7);

  helpSoftwareUpdatesMenuItem.setText("Check for Updates...");
  helpSoftwareUpdatesMenuItem.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
      helpSoftwareUpdatesMenuItemActionPerformed(evt);
    }
  });
  helpMenu.add(helpSoftwareUpdatesMenuItem);

  webMenuItem.setText("Club Planner Home Page");
  webMenuItem.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
      webMenuItemActionPerformed(evt);
    }
  });
  helpMenu.add(webMenuItem);

  submitFeedbackMenuItem.setText("Submit Feedback");
  submitFeedbackMenuItem.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
      submitFeedbackMenuItemActionPerformed(evt);
    }
  });
  helpMenu.add(submitFeedbackMenuItem);
  helpMenu.add(jSeparator8);

  helpReduceWindowSizeMenuItem.setText("Reduce Window Size");
  helpReduceWindowSizeMenuItem.setAccelerator (KeyStroke.getKeyStroke (KeyEvent.VK_W,
    Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
helpReduceWindowSizeMenuItem.addActionListener(new java.awt.event.ActionListener() {
  public void actionPerformed(java.awt.event.ActionEvent evt) {
    helpReduceWindowSizeMenuItemActionPerformed(evt);
  }
  });
  helpMenu.add(helpReduceWindowSizeMenuItem);

  mainMenuBar.add(helpMenu);

  setJMenuBar(mainMenuBar);

  pack();
  }// </editor-fold>//GEN-END:initComponents

  private void fileOpenMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileOpenMenuItemActionPerformed
    openFile();
  }//GEN-LAST:event_fileOpenMenuItemActionPerformed

  private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
    boolean modOK = modIfChanged();
    if (modOK) {
      positionAndDisplay();
    }
  }//GEN-LAST:event_okButtonActionPerformed

  private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
    newClubEvent();
  }//GEN-LAST:event_newButtonActionPerformed

  private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
    removeClubEvent();
  }//GEN-LAST:event_deleteButtonActionPerformed

  private void firstButtonAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstButtonAction
    firstClubEvent();
  }//GEN-LAST:event_firstButtonAction

  private void priorButtonAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priorButtonAction
    priorClubEvent();
  }//GEN-LAST:event_priorButtonAction

  private void nextButtonAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonAction
    nextClubEvent();
  }//GEN-LAST:event_nextButtonAction

  private void lastButtonAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastButtonAction
    lastClubEvent();
  }//GEN-LAST:event_lastButtonAction

  private void findTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findTextActionPerformed
    findClubEvent();
  }//GEN-LAST:event_findTextActionPerformed

  private void findTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_findTextKeyTyped
    if (! findText.getText().equals (lastTextFound)) {
      noFindInProgress();
    }
  }//GEN-LAST:event_findTextKeyTyped

  private void findButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findButtonActionPerformed
    findClubEvent();
  }//GEN-LAST:event_findButtonActionPerformed

  private void itemTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemTableKeyReleased
    selectTableRow();
  }//GEN-LAST:event_itemTableKeyReleased

  private void itemTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemTableMouseClicked
    selectTableRow();
  }//GEN-LAST:event_itemTableMouseClicked

  private void helpHistoryMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpHistoryMenuItemActionPerformed
    File historyFile = new File (appFolder, "versions.html");
    try {
      URI historyURI = historyFile.toURI();
      URL historyURL = historyURI.toURL();
      appster.openURL(historyURL.toString());
    }
    catch (MalformedURLException e) {
      trouble.report("Trouble opening the Program History", "Program History Problem");
    }
  }//GEN-LAST:event_helpHistoryMenuItemActionPerformed

  private void userGuideMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userGuideMenuItemActionPerformed
    File userGuideFile = new File (appFolder, "clubplanner.html");
    try {
      URI userGuideURI = userGuideFile.toURI();
      URL userGuideURL = userGuideURI.toURL();
      appster.openURL(userGuideURL.toString());
    }
    catch (MalformedURLException e) {
      trouble.report("Trouble opening the User Guide", "User Guide Problem");
    }
  }//GEN-LAST:event_userGuideMenuItemActionPerformed

  private void helpSoftwareUpdatesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpSoftwareUpdatesMenuItemActionPerformed
    programVersion.informUserIfNewer();
    programVersion.informUserIfLatest();
  }//GEN-LAST:event_helpSoftwareUpdatesMenuItemActionPerformed

  private void webMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_webMenuItemActionPerformed
    appster.openURL ("http://www.powersurgepub.com/products/clubplanner.html");
  }//GEN-LAST:event_webMenuItemActionPerformed

  private void submitFeedbackMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitFeedbackMenuItemActionPerformed
    appster.openURL ("mailto:support@powersurgepub.com?subject=Club Planner Feedback");
  }//GEN-LAST:event_submitFeedbackMenuItemActionPerformed

  private void helpReduceWindowSizeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpReduceWindowSizeMenuItemActionPerformed
    setBounds(100, 100, 800, 600);
    // pack();
  }//GEN-LAST:event_helpReduceWindowSizeMenuItemActionPerformed

  private void fileBackupMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileBackupMenuItemActionPerformed
    if (goodEventsFile()) {
      promptForBackup();
    } else {
      trouble.report(
          this, 
          "Open an Events folder before attempting a backup", 
          "Backup Error", 
          JOptionPane.ERROR_MESSAGE);
    }
  }//GEN-LAST:event_fileBackupMenuItemActionPerformed

  private void fileSaveAsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileSaveAsMenuItemActionPerformed
    saveAs();
  }//GEN-LAST:event_fileSaveAsMenuItemActionPerformed

  private void eventDeleteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventDeleteMenuItemActionPerformed
    removeClubEvent();
  }//GEN-LAST:event_eventDeleteMenuItemActionPerformed

  private void eventPriorMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventPriorMenuItemActionPerformed
    priorClubEvent();
  }//GEN-LAST:event_eventPriorMenuItemActionPerformed

  private void eventNextMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventNextMenuItemActionPerformed
    nextClubEvent();
  }//GEN-LAST:event_eventNextMenuItemActionPerformed

  private void eventNewMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventNewMenuItemActionPerformed
    newClubEvent();
  }//GEN-LAST:event_eventNewMenuItemActionPerformed

  private void eventDupeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventDupeMenuItemActionPerformed
    duplicateClubEvent();
  }//GEN-LAST:event_eventDupeMenuItemActionPerformed

  private void fileSaveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileSaveMenuItemActionPerformed
    modified = true;
    modIfChanged();
  }//GEN-LAST:event_fileSaveMenuItemActionPerformed

  private void fileSaveAllMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileSaveAllMenuItemActionPerformed
    saveAll();
  }//GEN-LAST:event_fileSaveAllMenuItemActionPerformed

  private void fileReloadMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileReloadMenuItemActionPerformed
    reload();
  }//GEN-LAST:event_fileReloadMenuItemActionPerformed

  private void formComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentMoved
    auxWindowCalcs();
  }//GEN-LAST:event_formComponentMoved

  private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
    auxWindowCalcs();
  }//GEN-LAST:event_formComponentResized

  private void mainSplitPanePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_mainSplitPanePropertyChange
    auxWindowCalcs();
  }//GEN-LAST:event_mainSplitPanePropertyChange

  private void filePublishMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filePublishMenuItemActionPerformed
    windowMenuManager.makeVisible(publishWindow);
  }//GEN-LAST:event_filePublishMenuItemActionPerformed

  /**
   @param args the command line arguments
   */
  public static void main(String args[]) {
    /*
     Set the Nimbus look and feel
     */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
     If Nimbus (introduced in Java SE 6) is not available, stay with the default
     look and feel. For details see
     http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
     */
    /* try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        System.out.println ("ClubPlanner main installed look and feel " + info.getName());
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          System.out.println("  setting " + info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      System.out.println("  class not found");
      java.util.logging.Logger.getLogger(ClubPlanner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      System.out.println("  instantiation exception");
      java.util.logging.Logger.getLogger(ClubPlanner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      System.out.println("  illegal access");
      java.util.logging.Logger.getLogger(ClubPlanner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      System.out.println("  unsupported look and feel");
      java.util.logging.Logger.getLogger(ClubPlanner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    */
    //</editor-fold>

    /*
     Create and display the form
     */
    java.awt.EventQueue.invokeLater(new Runnable() {

      public void run() {
        ClubPlanner clubPlanner = new ClubPlanner();
        clubPlanner.setVisible(true);
        clubPlanner.auxWindowCalcs();
      }
    });
  }
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JTabbedPane collectionTabs;
  private javax.swing.JButton deleteButton;
  private javax.swing.JMenu editMenu;
  private javax.swing.JMenuItem eventDeleteMenuItem;
  private javax.swing.JMenuItem eventDupeMenuItem;
  private javax.swing.JMenu eventMenu;
  private javax.swing.JMenuItem eventNewMenuItem;
  private javax.swing.JMenuItem eventNextMenuItem;
  private javax.swing.JMenuItem eventPriorMenuItem;
  private javax.swing.JMenuItem fileBackupMenuItem;
  private javax.swing.JMenu fileMenu;
  private javax.swing.JMenuItem fileOpenMenuItem;
  private javax.swing.JMenu fileOpenRecentMenu;
  private javax.swing.JMenuItem filePublishMenuItem;
  private javax.swing.JMenuItem fileReloadMenuItem;
  private javax.swing.JMenuItem fileSaveAllMenuItem;
  private javax.swing.JMenuItem fileSaveAsMenuItem;
  private javax.swing.JMenuItem fileSaveMenuItem;
  private javax.swing.JButton findButton;
  private javax.swing.JTextField findText;
  private javax.swing.JButton firstButton;
  private javax.swing.JMenuItem helpHistoryMenuItem;
  private javax.swing.JMenu helpMenu;
  private javax.swing.JMenuItem helpReduceWindowSizeMenuItem;
  private javax.swing.JMenuItem helpSoftwareUpdatesMenuItem;
  private javax.swing.JTable itemTable;
  private javax.swing.JScrollPane itemTableScrollPane;
  private javax.swing.JTabbedPane itemTabs;
  private javax.swing.JPopupMenu.Separator jSeparator1;
  private javax.swing.JPopupMenu.Separator jSeparator2;
  private javax.swing.JPopupMenu.Separator jSeparator3;
  private javax.swing.JPopupMenu.Separator jSeparator4;
  private javax.swing.JSeparator jSeparator7;
  private javax.swing.JSeparator jSeparator8;
  private javax.swing.JButton lastButton;
  private javax.swing.JPanel listPanel;
  private javax.swing.JMenuBar mainMenuBar;
  private javax.swing.JSplitPane mainSplitPane;
  private javax.swing.JToolBar navToolBar;
  private javax.swing.JButton newButton;
  private javax.swing.JButton nextButton;
  private javax.swing.JButton okButton;
  private javax.swing.JButton priorButton;
  private javax.swing.JMenuItem submitFeedbackMenuItem;
  private javax.swing.JTree tagsTree;
  private javax.swing.JPanel treePanel;
  private javax.swing.JScrollPane treeScrollPane;
  private javax.swing.JMenuItem userGuideMenuItem;
  private javax.swing.JMenuItem webMenuItem;
  private javax.swing.JMenu windowMenu;
  // End of variables declaration//GEN-END:variables
}
