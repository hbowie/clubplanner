Club Planner User Guide
====================

Table of Contents
-----------------

<div id="toc-div">

<ul>

<li><a href="#intro">Introduction</a></li>

<li><a href="#starting">Getting Started</a>
	<ul>
		<li><a href="#sysrqmts">System Requirements</a></li>
		<li><a href="#rights">Rights</a></li>
		<li><a href="#install">Installation</a></li>
		<li><a href="#events">Events</a></li>
		<li><a href="#files">Files and Folders</a></li>
		<li><a href="#createnew">Creating a New Events Folder</a></li>
		<li><a href="#backups">Backing Up</a></li>
	</ul>
</li>

<li><a href="#ui">Overall User Interface</a>
	<ul>
		<li><a href="#tabs-and-windows">Tabs and Windows</a></li>
		<li><a href="#tool-bar">Tool Bar</a></li>
		<li><a href="#list">The List</a></li>
		<li><a href="#tags">Tags</a></li>
		<li><a href="#menus">Menus and Keyboard Shortcuts</a></li>
		<li><a href="#gen-prefs">Customizing the Look and Feel</a></li>
	</ul>
</li>

<li><a href="#data">Data Stored by Club Planner</a>
	<ul>
		<li><a href="#basics">Basics</a></li>
		<li><a href="#text">Text</a></li>
		<li><a href="#numbers">Numbers</a></li>
		<li><a href="#links">Links</a></li>
		<li><a href="#notes">Notes</a></li>
	</ul>
</li>

<li><a href="#publish">Publish</a></li>

<li><a href="#prefs">Preferences</a>
	<ul>
		<li><a href="#general_prefs">General Prefs</a></li>
	</ul>
</li>

<li><a href="#help">Help</a></li>

</ul>

</div>

<h2 id="intro">Introduction</h2>

Club Planner is a desktop application for planning and communicating the activities of a club (such as an alumni club). 

I wrote the application for use by the [University of Michigan Club of Seattle][umseattle], after several years of involvement with this club and its board. 

Although this is an app that runs on a user's desktop, it is designed to store its data in a folder that can be easily shared with others through a service such as [Dropbox][]. 

<h2 id="starting">Getting Started</h2>

<h3 id="sysrqmts">System Requirements</h3> 

Club Planner is written in Java and can run on any reasonably modern operating system, including Mac OS X, Windows and Linux. Club Planner requires a Java Runtime Environment (JRE), also known as a Java Virtual Machine (JVM). The version of this JRE/JVM must be at least 6. Visit [www.java.com][java] to download a recent version for most operating systems. Installation happens a bit differently under Mac OS X, but generally will occur fairly automatically when you try to launch a Java app for the first time. 

Because Club Planner may be run on multiple platforms, it may look slightly different on different operating systems, and will obey slightly different conventions (using the CMD key on a Mac, vs. an ALT key on a PC, for example).

<h3 id="rights">Rights</h3>

Club Planner Copyright &copy; 2012 - 2013 Herb Bowie

Club Planner is [open source software][osd]. 

Licensed under the Apache License, Version 2.0 (the &#8220;License&#8221;); you may not use this file except in compliance with the License. You may obtain a copy of the License at

	http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

Club Planner also incorporates or adapts the following open source software libraries. 

* BrowserLauncher2 &#8212; Copyright 2004 - 2007 Markus Gebhard, Jeff Chapman, used under the terms of the [GNU General Public License][gnu]. 

* JExcelAPI &#8212; Copyright 2002 Andrew Khan, used under the terms of the [GNU General Public License][gnu]. 

* parboiled  &#8212; Copyright 2009-2011 Mathias Doenitz, used under the terms of the [Apache License, Version 2.0][apache]. 
	
* pegdown &#8212; Copyright 2010-2011 Mathias Doenitz, used under the terms of the [Apache License, Version 2.0][apache].

<h3 id="install">Installation</h3>

This application is distributed in two different forms. Both can be downloaded from [PowerSurgePub.com][downloads].

The first form is a zip archive. This form can be used on either a Windows machine or on Mac OS X (or any other Unix platform). Once downloaded and expanded, you will see a folder containing multiple files and sub-folders. To install the app, drag the entire folder into the location on your hard drive where you normally keep your applications: usually the Applications folder on a Mac, and the My Programs folder on a Windows PC. Launch the application by double-clicking on the file named myApp.jar. 

The second form of distribution is a Mac OS X disk image. This form can only be used on Mac OS X (and is the recommended distribution package for the Mac). Once downloaded and mounted (via a double-click if it doesn't mount automatically), you will see a folder containing a complete self-contained application bundle. To install the app, drag the application into your Applications folder. Launch the app by double-clicking on the application.  

<h3 id="events">Events</h3>

*Club Planner* tracks information about your club's planned, current, and past events. 

Other agenda items to be discussed by your club may be entered as if they were events, in order to build complete meeting agendas. 

<h3 id="files">Files and Folders</h3>

Club Planner assumes that your club records are stored electronically, using something like the following nested folder structure. 

- *Dropbox* -- This would be your Dropbox folder, automatically synced to the cloud and to your other devices. 
    - *Name of Club* -- This would be the folder containing all of your club records. This would be the folder you would share with other club members using a service such as [Dropbox][].
        - *Operating Year* -- This would be a folder containing all of your club's records for a particular operating year. If your operating year is aligned with a calendar year, then this folder name should contain a single 4-digit year (usually following a brief form of the club's name). If your operating year spans two years, then this folder name should contain two 4-digit years, separated by a dash. 
            - *Events* -- This would be the folder containing information about your events. The contents of this folder will be maintained by Club Planner. 
            
For example, the U-M Seattle club's folders look like this. 

- *Dropbox*
    - *UM Seattle*
        - *UM Seattle 2013 - 2014*
            - *Events*
            
The *Events* folder would then contain one folder for each type of event. Each of those folders would then contain one file for each event. These are plain text files, and may be viewed and even edited using any text editor. 

Note that all of these folders above the *Events* folder may contain other folders and files, unrelated to Club Planner. 

The only folder naming convention that is required is the inclusion of the club operating year in the name of the folder above the Events folder. By storing the operating year in this folder name, event info can easily be duplicated and transferred from one operating year to the next, based on the assumption that many of your club's events will recur on a fairly predictable annual cycle. 

<h3 id="createnew">Creating a New Events Folder</h3>

The first time you launch Club Planner, or after selecting <em>Open</em> from the <em>File</em> menu, you will be presented with a series of Open dialogs that will ask you to specify the folder containing Club Records, the folder for the desired Operating Year, and the Events folder. There is no default location for these folder. You can create the necessary folders outside of Club Planner, before launching it, or can create the new folders from within the Open dialogs. Again, it is recommended that the folder containing Club Records be a shared [Dropbox][] folder.  

<h3 id="backups">Backing Up</h3>

The File menu contains a **Backup** command. When backing up, you will be prompted to select a backup folder. This should be the folder that contains all of your Club Planner backups. After selecting this folder, Club Planner will automatically create a subfolder containing a copy of your Events folder, with the backup date and time appended to the folder name. 

<h2 id="ui">Overall User Interface</h2>

<h3 id="tabs-and-windows">Tabs and Windows</h3>

The Club Planner user interface consists of a number of **windows**. The main window shows a split pane. On the left/top you will see your current club events, either in a List or grouped by Tags. On the right/bottom you will see the currently selected event. 

Opening the Preferences window will allow you to modify a number of the operating characteristics of the program. The Preferences window can be found under the Club Planner menu on the Mac, and under Tools / Options on other operating systems.

<h3 id="tool-bar">Tool Bar</h3>

The Club Planner interface also contains a **Tool Bar** containing a number of **Buttons**: the "OK" button saves your changes after adding/editing a event; the "+" and "-" buttons allow you to add a new event or delete an existing one, respectively. The next four buttons move you to the first event in your collection, the next event, the prior event or the last event, again respectively.  

The following text box allows you to enter a text string you wish to search for. The following button, initially labeled **Find**, causes the first event containing that text string to be found and displayed. After the first event is found, this button will be relabeled **Again**, and will then allow you to continue forward through the list of found events.

<h3 id="list">The List</h3>

On the first half of the main screen, you'll see two tabs. The first of these displays the **List**. This is just a simple list of all your events. Click on an event to select that event for display on the other half of the main screen.

<h3 id="tags">Tags</h3>

The second Tab on the first half of the main screen displays the **Tags**. This is an indented list of all your status tags, with events appearing under as many tags as have been assigned to them, and with events with no tags displaying at the very top. Click to the left of a tag to expand it, showing events and/or sub-tags contained within it.

Note that tags that were once used, but that are used no more, will stick around until you close the Club Planner file and re-open it. If you wish, you may accelerate this process by selecting **Reload** from the **File** menu.

<h3 id="menus">Menus and Keyboard Shortcuts</h3>

There are also a number of **Menus** listed across the top. If a command has a keyboard shortcut, then it will be listed as part of the command's menu item. 

The most commonly used commands are accessible in multiple ways. For example, you may navigate to the first item in the collection by clicking on the Tool Bar Button, or by selecting the command from the Event Menu, or through a keyboard shortcut.

Following is a list of all the menus, with a brief description of each menu's purpose. 

* File -- Functions to open and save external disk files
* Event -- Functions that affect a particular event.
* Edit -- Standard Cut, Copy and Paste commands.
* Tools -- Access to Options/Preferences.
* Window -- Access to special windows.
* Help -- Access the iWisdom User Guide or Web Site.

Following is a list of all keyboard shortcuts. The command key is used in conjunction with another key to invoke shortcuts on a Mac, while the control key is used on other platforms. 

<table class="graybox">

  <tr>
    <th class="graybox">
      Key
    </th>
    <th class="graybox">
      Menu
    </th>
    <th class="graybox">
      Menu Item
    </th>
  </tr>

  <tr>
    <td class="graybox">
      A
    </td>
    <td class="graybox">
      Edit
    </td>
    <td class="graybox">
      Select All
    </td>
  </tr>

  <tr>
    <td class="graybox">
      B
    </td>
    <td class="graybox">
      File
    </td>
    <td class="graybox">
      Backup
    </td>
  </tr>

  <tr>
    <td class="graybox">
      C
    </td>
    <td class="graybox">
      Edit
    </td>
    <td class="graybox">
      Copy
    </td>
  </tr>

  <tr>
    <td class="graybox">
      D
    </td>
    <td class="graybox">
      Item
    </td>
    <td class="graybox">
      Delete
    </td>
  </tr>

  <tr>
    <td class="graybox">
      F
    </td>
    <td class="graybox">
      List
    </td>
    <td class="graybox">
      Find
    </td>
  </tr>

  <tr>
    <td class="graybox">
      G
    </td>
    <td class="graybox">
      List
    </td>
    <td class="graybox">
      Find Again
    </td>
  </tr>

  <tr>
    <td class="graybox">
      H
    </td>
    <td class="graybox">
      App (Mac) / <br />Help (Other)
    </td>
    <td class="graybox">
      Hide / <br />User Guide (Other)
    </td>
  </tr>

  <tr>
    <td class="graybox">
      I
    </td>
    <td class="graybox">
      File
    </td>
    <td class="graybox">
      Get Info
    </td>
  </tr>

  <tr>
    <td class="graybox">
      N
    </td>
    <td class="graybox">
      Item
    </td>
    <td class="graybox">
      New
    </td>
  </tr>

  <tr>
    <td class="graybox">
      O
    </td>
    <td class="graybox">
      File
    </td>
    <td class="graybox">
      Open
    </td>
  </tr>

  <tr>
    <td class="graybox">
      P
    </td>
    <td class="graybox">
      File
    </td>
    <td class="graybox">
      Publish
    </td>
  </tr>

  <tr>
    <td class="graybox">
      Q
    </td>
    <td class="graybox">
      App (Mac) / <br />File (Other)
    </td>
    <td class="graybox">
      Quit / <br />Exit
    </td>
  </tr>

  <tr>
    <td class="graybox">
      S
    </td>
    <td class="graybox">
      File
    </td>
    <td class="graybox">
      Save
    </td>
  </tr>

  <tr>
    <td class="graybox">
      V
    </td>
    <td class="graybox">
      Edit
    </td>
    <td class="graybox">
      Paste
    </td>
  </tr>

  <tr>
    <td class="graybox">
      W
    </td>
    <td class="graybox">
      Help
    </td>
    <td class="graybox">
      Reduce Window Size
    </td>
  </tr>

  <tr>
    <td class="graybox">
      X
    </td>
    <td class="graybox">
      Edit
    </td>
    <td class="graybox">
      Cut
    </td>
  </tr>

  <tr>
    <td class="graybox">
      ,
    </td>
    <td class="graybox">
      App (Mac)
    </td>
    <td class="graybox">
      Preferences
    </td>
  </tr>

  <tr>
    <td class="graybox">
      ]
    </td>
    <td class="graybox">
      Item
    </td>
    <td class="graybox">
      Next
    </td>
  </tr>

  <tr>
    <td class="graybox">
      [
    </td>
    <td class="graybox">
      Item
    </td>
    <td class="graybox">
      Prior
    </td>
  </tr>

</table>


<h2 id="data">Data Stored by Club Planner</h2>

<h3 id="basics">Basics</h3>

The following basic event data is available for viewing and editing on this first tab. 

**Type**: This is the general type of the event. The following values are suggested.  

* Active -- An active event, such as a hike.
* Board -- An item for consideration by the board, or pertaining to the board. 
* Career Networking -- Professional advancement.
* Close Meeting -- An item to appear at the end of the board meeting agenda. 
* Collaboration w/Other Clubs -- Worked in common with other clubs, such as  other Big Ten clubs in the area.
* Communication -- An item having to do with club communications, such as our Web site, Facebook page or email newsletters. 
* Community -- A community service event. 
* Culture -- A cultural event. 
* Family -- An event intended for families with children. 
* Finance -- An item having to do with club finances. 
* Membership -- An event planned to promote membership in the club.
* Open Meeting -- An item to appear at the beginning of the board meeting agenda. 
* Organization -- An event or item having to do with the organization of the club. 
* Scholarship -- An event having to do with the club's scholarship fund and the scholarships awarded to deserving students. 
* Social -- A purely social event. 
* Sports -- An event having to do with athletics. 
* Student Connections -- A topic related to prospective or current students hailing from the local area. 

**Seq**: (Calculated) The sequence of discussion at a Board meeting. This is calculated based on the Type value selected. The following sequence numbers will be assigned. 

* 1 -- Open Meeting
* 2 -- Finance
* 4 -- All other types, if the event's date is in the past. 
* 5 -- All other types, if the event's date is in the future. 
* 8 -- Communication
* 9 -- Close Meeting

**Status**: One or more tags indicating the status of the event. The following tags are suggested. 

* Archive -- Events already held, that no longer need to be discussed. 
* Budget -- Items related to the club's budget and finances. 
* Communication -- Items related to club communications. 
* Current -- Events held since the last board meeting, plus upcoming events ready for discussion by the board. 
* Discards -- Ideas considered by the board and rejected. 
* Future -- Events to be considered at some point in the future. 
* Ideas -- Ideas for future consideration. 
* News -- Events to be featured in the next newsletter to be sent to members.
* Next Year -- Events that will not be held in the current year, but may be held in the coming year. 
* Save -- Items to save for later consideration. 

**When**: An indication of the date and time that the event will be held, in a format emphasizing human readability. This need not be a complete date. It need not and generally should not contain the year, since this can be inferred from the operating year identified in the higher level folder. If an exact date is known, then this field should generally start with a three-character abbreviation for the day of the week. Three-character abbreviations for the month are also recognized and encouraged. Following are perfectly good examples of dates.

* Apr
* Sat May 5
* Thu Mar 25 5:30 - 7:30 PM

**YMD**: (Calculated) A full or partial date in year, month, day sequence.

**What**:
A brief descriptive title for the event.

**Where**: The location of the event, including the name of the venue and its address.

**Who**: Who is assigned to plan, coordinate and host the event. Can include multiple names. Can include email addresses and phone numbers.

**Discuss**: Identification of any issues to be discussed at an upcoming board meeting.

<h3 id="text">Text</h3>

This tab allows the user to view and edit the large chunks of text associated with an event. 

**Teaser**:
One to three sentences describing the event. Not intended to provide complete information, but intended to pique the reader's interest and motivate him to read further.

**Blurb**:
Additional information about the event. Need not repeat information in the teaser, and need not repeat additional event details available from other fields, such as When and Where. This field can contain multiple paragraphs, separated by blank lines.

**Why**:
Why does the club think it would be a good idea to host the event? If applying for Strategic Priority Funds, then why do we think this is a deserving event?

**Recap**:
A brief summary of how the event went. Can include lessons learned from the event.

<h3 id="numbers">Numbers</h3>

This tab allows the user to view and edit the various numbers associated with an event. 

**Cost**: The cost per person to attend the event. If the event is free, then leave this field blank.

**Purchase**: Instructions on how to purchase tickets to the event, if any. 

**Tickets**: For purchasers, information on how they are to receive the tickets. 

**Quantity**: Number of seats or tickets available for the event; maximum number of attendees. 

**Planned Attendance**: The number of attendees built into the club's planning assumptions. 

**Actual Attendance**: The actual number of people who attended the event.

**Planned Income**: The amount of money the club plans to receive for the event. For this and the following dollar amount fields, multiple dollar figures may be interspersed with descriptive words. "$20 x 40" will result in a planned income of $800.00, for example. 

**Actual Income**: The club's actual income for the event.

**Planned Expense**: The amount of money planned/budgeted to be spent on the event.

**Actual Expense**: The club's actual expenses for the event.

**Over/Under**: (Calculated) The difference between our actuals and our planned income or expense.

**Finance Projection**: (Calculated) The projected impact on our club finances, based on actuals, if available, or planned income/expense, if actuals are not yet available.

<h3 id="links">Links</h3>

**ID**: After the event has been added to the club web site, the ID assigned to the page by the Content Management System should be entered here. This will be identified in the URL for the event as the articleid, as in articleid=17, meaning that an ID of 17 should be entered here.

**Link**: A URL pointing to a Web page with more information about the event.

**Venue**: A URL pointing to a Web page with more information about the venue for the event.

**Image**: A URL pointing to an image that can be used to help advertise the event.

**News Image**: A URL pointing to an image suitable for use in our newsletter. This is usually wide and short, to fit in the e-new format. 

<h3 id="notes">Notes</h3>

**Notes**: One or more blocks of text with information about the event. This field can contain multiple paragraphs, separated by blank lines. [Markdown][] formatting will be applied to this section.

Each block of text should be preceded by a line similar to the following example. 

    -- AAUM on Feb 21 via email

Note that each such header line contains the following elements:

* Two hyphens and a space
* Identification of the source of the following information.
* The date on which the information was communicated. 
* The means by which the information was communicated. 


<h2 id="toolbar">The Tool Bar</h2>

A toolbar with multiple buttons appears at the top of the user interface.

* **OK** -- Indicates that you have completed adding/editing the fields for the current URL.
* **+** -- Clear the data fields and prepare to add a new URL to the collection.
* **-** -- Delete the current URL.
* **&lt;&lt;** -- Display the first URL in the collection.
* **&lt;** -- Display the next URL in the collection.
* **&gt;** -- Display the next URL in the collection. 
* **&gt;&gt;** -- Display the last URL in the collection. 
* **Launch** -- Launch the current URL in your Web browser. (This may also be accomplished by clicking the arrow that appears just to the left of the URL itself.)
* **Find** -- Looks for the text entered in the field just to the left of this button, and displays the first URL containing this text in any field, ignoring case. After finding the first occurrence, this button's text changes to **Again**, to allow you to search again for the next URL containing the specified text. 

<h2 id="publish">Publish</h2>

A large part of the power of Club Planner lies in its ability to publish the event information you've collected in a variety of different formats, for different purposes. For example, web pages, calendar entries, board meeting agendas, minutes, and e-mail newsletters can all be published using Club Planner. 

Club Planner uses the [PSTextMerge][pstm] engine for its publish function. Open the Publish window by selecting Publish from the File menu. See the [PSTextMerge User Guide][pstmug] for details. 

Note that filtering and sorting functions within the Publish window will affect the list of events visible in the main window. 

<h2 id="prefs">Preferences</h2>

The following preference tabs are available.

<h3 id="general_prefs">General Prefs</h3>

* **SplitPane: Horizontal Split?** --  Check the box to have the **List** and **Tags** appear on the left of the main screen, rather than the top.

* **Deletion: Confirm Deletes?** -- Check the box to have a confirmation dialog shown whenever you attempt to delete a URL.

* **Software Updates: Check Automatically?** -- Check the box to have Club Planner check for newer versions whenever it launches.

* **Check Now** -- Click this button to check for a new version immediately.

* **File Chooser** -- If running on a Mac, you may wish to select AWT rather than Swing, to make your Open and Save dialogs appear more Mac-like. However, Swing dialogs may still appear to handle options that can't be handled by the native AWT chooser. 

* **Look and Feel** -- Select from one of the available options to change the overall look and feel of the application.

* **Menu Location** -- If running on a Mac, you may wish to have the menus appear at the top of the screen, rather than at the top of the window.

<h2 id="help">Help</h2>

The following commands are available. Note that the first two commands open local documentation installed with your application, while the next group of commands will access the Internet and access the latest program documentation, where applicable. 

* **Program History** -- Opens the program's version history in your preferred Web browser.

* **User Guide** -- Opens the program's user guide in your preferred Web browser.

* **Check for Updates** -- Checks to see if a later version of Club Planner has been released.

* **Club Planner Home Page** -- Open's the Club Planner product page on the World-Wide Web. 

* **Submit Feedback** -- Send feedback to the program's author. 

* **Reduce Window Size** -- Restores the main Club Planner window to its default size and location. Note that this command has a shortcut so that it may be executed even when the Club Planner window is not visible. This command may sometimes prove useful if you use multiple monitors, but occasionally in different configurations. On Windows in particular, this sometimes results in Club Planner opening on a monitor that is no longer present, making it difficult to see.


[java]:  http://www.java.com/

[pspub]:     http://www.powersurgepub.com/
[downloads]: http://www.powersurgepub.com/downloads.html
[store]:     http://www.powersurgepub.com/store.html
[pstm]:      http://www.powersurgepub.com/products/pstextmerge.html
[pstmug]:    http://www.powersurgepub.com/products/pstextmerge/opguide.html

[markdown]:  http://daringfireball.net/projects/markdown/
[pegdown]:   https://github.com/sirthias/pegdown/blob/master/LICENSE
[parboiled]: https://github.com/sirthias/parboiled/blob/master/LICENSE
[Mathias]:   https://github.com/sirthias

[club]:         clubplanner.html
[filedir]:      filedir.html
[metamarkdown]: metamarkdown.html
[template]:     template.html

[osd]:				http://opensource.org/osd
[gnu]:        http://www.gnu.org/licenses/
[apache]:			http://www.apache.org/licenses/LICENSE-2.0.html

[umseattle]:  http://www.umseattle.com
[dropbox]:    http://www.dropbox.com
