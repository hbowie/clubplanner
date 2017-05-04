<!-- Generated using template product-user-guide-template.mdtoc -->
<!-- Generated using template product-user-guide-template.md -->
<h1 id="club-planner-user-guide">Club Planner User Guide</h1>


<h2 id="table-of-contents">Table of Contents</h2>

<div id="toc">
  <ul>
    <li>
      <a href="#introduction">Introduction</a>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li>
          <a href="#system-requirements">System Requirements</a>
        </li>
        <li>
          <a href="#rights">Rights</a>
        </li>
        <li>
          <a href="#installation">Installation</a>
        </li>
      </ul>

    </li>
    <li>
      <a href="#data-fields">Data Fields</a>
      <ul>
        <li>
          <a href="#clubevent-fields">ClubEvent Fields</a>
        </li>
        <li>
          <a href="#eventaction-fields">EventAction Fields</a>
        </li>
        <li>
          <a href="#eventnote-fields">EventNote Fields</a>
        </li>
        <li>
          <a href="#eventtransaction-fields">EventTransaction Fields</a>
        </li>
      </ul>

    </li>
    <li>
      <a href="#file-operations">File Operations</a>
      <ul>
        <li>
          <a href="#files-and-folders">Files and Folders</a>
        </li>
        <li>
          <a href="#creating-a-new-events-folder">Creating a New Events Folder</a>
        </li>
        <li>
          <a href="#import-minutes">Import Minutes</a>
        </li>
        <li>
          <a href="#export-minutes">Export Minutes</a>
        </li>
        <li>
          <a href="#backup">Backup</a>
        </li>
        <li>
          <a href="#start-new-year">Start New Year</a>
        </li>
        <li>
          <a href="#clear-actuals">Clear Actuals</a>
        </li>
      </ul>

    </li>
    <li>
      <a href="#user-interface">User Interface</a>
      <ul>
        <li>
          <a href="#menus-and-keyboard-shortcuts">Menus and Keyboard Shortcuts</a>
        </li>
        <li>
          <a href="#the-tool-bar">The Tool Bar</a>
        </li>
        <li>
          <a href="#main-window">Main Window</a>
        </li>
      </ul>

    </li>
    <li>
      <a href="#tips-tricks-and-special-functions">Tips, Tricks and Special Functions</a>
      <ul>
        <li>
          <a href="#publish">Publish</a>
        </li>
        <li>
          <a href="#textmerge-sort">TextMerge Sort</a>
        </li>
        <li>
          <a href="#textmerge-filter">TextMerge Filter</a>
        </li>
        <li>
          <a href="#textmerge-template">TextMerge Template</a>
        </li>
        <li>
          <a href="#textmerge-script">TextMerge Script</a>
        </li>
      </ul>

    </li>
    <li>
      <a href="#preferences">Preferences</a>
      <ul>
        <li>
          <a href="#general-prefs">General Prefs</a>
        </li>
      </ul>

    </li>
    <li>
      <a href="#help">Help</a>
    </li>
    <li>
      <a href="#file-formats">File Formats</a>
      <ul>
        <li>
          <a href="#template-file-format">Template File Format</a>
        </li>
        <li>
          <a href="#script-files">Script Files</a>
        </li>
      </ul>

    </li>
  </ul>

</div>


<h2 id="introduction">Introduction</h2>


Club Planner is a desktop application for planning and communicating the activities of a club (such as an alumni club). 

I wrote the application for use by the [University of Michigan Club of Seattle](http://www.umseattle.com), after several years of involvement with this club and its board. 

Although this is an app that runs on a user's desktop, it is designed to store its data in a folder that can be easily shared with others through a service such as [Dropbox](http://www.dropbox.com). 


<h2 id="getting-started">Getting Started</h2>


<h3 id="system-requirements">System Requirements</h3>


Club Planner is written in Java and can run on any reasonably modern operating system, including Mac OS X, Windows and Linux. Club Planner requires a Java Runtime Environment (JRE), also known as a Java Virtual Machine (JVM). The version of this JRE/JVM must be at least 6. Visit [www.java.com](http://www.java.com) to download a recent version for most operating systems. Installation happens a bit differently under Mac OS X, but generally will occur fairly automatically when you try to launch a Java app for the first time.

Because Club Planner may be run on multiple platforms, it may look slightly different on different operating systems, and will obey slightly different conventions (using the CMD key on a Mac, vs. an ALT key on a PC, for example).

<h3 id="rights">Rights</h3>


Club Planner Copyright 2013 - 2015 by Herb Bowie

Club Planner is [open source software](http://opensource.org/osd). Source code is available at [GitHub](http://github.com/hbowie/clubplanner).

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

  [www.apache.org/licenses/LICENSE-2.0](http://www.apache.org/licenses/LICENSE-2.0)

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.

Club Planner also incorporates or adapts the following open source software libraries.

* JExcelAPI — Copyright 2002 Andrew Khan, used under the terms of the [GNU General Public License](http://www.gnu.org/licenses/).

* parboiled — Copyright 2009-2011 Mathias Doenitz, used under the terms of the [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0).

* flexmark-java — Copyright 2016 Vladimir Schneider, used under the terms of the [2-Clause BSD License](2-Clause BSD License).


<h3 id="installation">Installation</h3>


Download the latest version from [PowerSurgePub.com](http://www.powersurgepub.com/downloads.html). Decompress the downloaded file. Drag the resulting file or folder into the location where you normally store your applications. Double-click on the jar file (or the application, if you've downloaded the Mac app) to launch.


<h2 id="data-fields">Data Fields</h2>


<h3 id="clubevent-fields">ClubEvent Fields</h3>


Club Planner tracks information about your club's planned, current, and past events.

Other agenda items to be discussed by your club may be entered as if they were events, in order to build complete meeting agendas.

<h4 id="clubevent--panel-1">ClubEvent - Panel 1</h4>


Item Type
:    The type of item.

Category
:    The category assigned to the event.

Seq
:    The sequence of discussion at a Board meeting.

Status
:    One or more tags indicating the status of the event. Note that events are organized by these values on the Status tab, as an alternative to the List tab. The following values are suggested.

	* Archive -- A completed/cancelled event that no longer needs further discussion by the board.
	* Budget -- A pseudo-event used to track planned income/expense for a given Category of events.
	* Communication
	* Current -- An event for discussion at our current board meetings, either as one recently completed, or being contemplated for the near future.
	* Discards -- Ideas that have been abandoned as not worthy of further pursuit.
	* Future -- An even to be considered at some future time.
	* Ideas -- Ideas for possible events.
	* News -- Items to be included in current newsletters.
	* Next Year
	* Proposed
	* Rotate -- A pseudo-event to be occasionally included in club communications, on a rotating basis.
	* Save

When
:    An indication of the date and time that the event will be held, in a format emphasizing human readability. This need not be a complete date. It need not and generally should not contain the year, since this can be inferred from the operating year identified in the higher level folder. If an exact date is known, then this field should generally start with a three-character abbreviation for the day of the week. Three-character abbreviations for the month are also recognized and encouraged. Following are perfectly good examples of dates: Apr; Sat May 5; Thu Sun Mar 25 5:30 - 7:30 PM.

YMD
:    A full or partial date in year, month, day sequence.

What
:    A brief descriptive title for the event.

Where
:    The location of the event, including the name of the venue and its address. The following variants of this field are also available, identified via the following suffixes, containing the appropriate information extracted from this primary field: Name, Address, City, State, Zip, Phone, Email, and MapURL.

Who
:    Who is assigned to plan, coordinate and host the event. Can include multiple names. Can include email addresses and phone numbers. The following variants of this field are also available, identified via the following suffixes, containing the appropriate information extracted from this primary field: Name, Address, City, State, Zip, Phone, Email, and MapURL.

Discuss
:    Identification of any issues to be discussed at an upcoming board meeting.

Actions
:    Identification of any action items to be worked. This field uses Markdown syntax, but also has some special conventions. Create the action items as a numbered list. After the number, place the name(s) of the actionees, followed by a colon. The action to be taken should then follow the colon. Placing an 'x' inside of parentheses, after the number and before the list of actionees, will flag the action as completed.

<h4 id="clubevent--panel-2">ClubEvent - Panel 2</h4>


Teaser
:    One to three sentences describing the event. Not intended to provide complete information, but intended to pique the reader's interest and motivate him to read further.

Blurb
:    Additional information about the event. Need not repeat information in the teaser, and need not repeat additional event details available from other fields, such as When and Where. This field can contain multiple paragraphs, separated by blank lines.

Purchase
:    Instructions on how to purchase tickets to the event, if any.

Why
:    Why does the club think it would be a good idea to host the event? If applying for Strategic Priority Funds, then why do we think this is a deserving event?

Recap
:    A brief summary of how the event went. Can include lessons learned from the event.

<h4 id="clubevent--panel-3">ClubEvent - Panel 3</h4>


Cost
:    The cost per person to attend the event. If the event is free, then leave this field blank.

Tickets
:    For purchasers, information on how they are to receive the tickets.

Quantity
:    Number of seats or tickets available for the event; maximum number of attendees.

Planned Attendance
:    The number of attendees built into our planning assumptions.

Actual Attendance
:    The actual number of people who attended the event.

Planned Income
:    The amount of money we have planned to receive for the event. For this and the following dollar amount fields, multiple dollar figures may be interspersed with descriptive words. $20 x 40 will result in a planned income of $800.00, for example.

Actual Income
:    Our actual income for the event. Note that each '+' or '-' sign will signal the start of a new transaction for the Financial Register export file. Keywords 'on', 'for', 'to', 'from', 'via', 'Ck', '#' and 'DC' will be used to break each transaction down into its appropriate fields.

Planned Expense
:    The amount of money we have planned/budgeted to be spent on the event.

Actual Expense
:    Our actual expenses for the event. See the description of Actual Income for a description of how the field will be interpreted for extraction into the financial register.

Over/Under
:    The difference between our actuals and our planned income or expense.

Finance Projection
:    The projected impacted on our club finances, based on actuals, if available, or planned income/expense, if actuals are not yet available.

<h4 id="clubevent--panel-4">ClubEvent - Panel 4</h4>


ID
:    After the event has been added to the club web site, the ID assigned to the page by the Content Management System should be entered here. This will be identified in the URL for the event as the articleid, as in articleid=17, meaning that an ID of 17 should be entered here.

Link
:    A URL pointing to a Web page with more information about the event.

Venue
:    A URL pointing to a Web page with more information about the venue for the event.

Image
:    A URL pointing to an image that can be used to help advertise the event.

News Image
:    A URL pointing to an image suitable for use in our newsletter.

Call to Action
:    Brief request to the reader to take some sort of action.

CTA Link
:    The actionable link.

Layout
:    The type of layout to use for this item in a newsletter.

<h4 id="clubevent--panel-5">ClubEvent - Panel 5</h4>


Notes
:    One or more blocks of text with information about the event. This field can contain multiple paragraphs, separated by blank lines. Each block of text should be preceded by a line similar to the following example: -- AAUM on Feb 21 via email. Note that each such header line contains the following elements: Two hyphens and a space; identification of the source of the note; the date on which the information was communicated; the means by which the information was communicated.

<h3 id="eventaction-fields">EventAction Fields</h3>


<h4 id="eventaction--panel-1">EventAction - Panel 1</h4>


Numbered
:    Is this a numbered list?

Actionee
:    The person(s) repsponsible to take the indicated action

Action
:    The action to be taken.

<h3 id="eventnote-fields">EventNote Fields</h3>


<h4 id="eventnote--panel-1">EventNote - Panel 1</h4>


Note For
:    Date on which note was made.

Note From
:    Person from whom note came.

Note Via
:    Medium by which note was communicated.

Note
:    Note itself.

<h3 id="eventtransaction-fields">EventTransaction Fields</h3>


<h4 id="eventtransaction--panel-1">EventTransaction - Panel 1</h4>


Date
:    The date on which the financial transaction occurred.

Income/Expense
:    Identified whether this is an income or an expense item.

From/To
:    The person or company from which we received money, or to whom we paid money.

Paid For
:    A description of the item.

Amount
:    The amount of the transaction.

<h2 id="file-operations">File Operations</h2>


File operations may be accessed via the File menu.

<h3 id="files-and-folders">Files and Folders</h3>


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

The *Events* folder would then contain one folder for each category of event. Each of those folders would then contain one file for each event. These are plain text files, and may be viewed and even edited using any text editor.

Note that all of these folders above the *Events* folder may contain other folders and files, unrelated to Club Planner.

The only folder naming convention that is required is the inclusion of the club operating year in the name of the folder above the Events folder. By storing the operating year in this folder name, event info can easily be duplicated and transferred from one operating year to the next, based on the assumption that many of your club's events will recur on a fairly predictable annual cycle.

<h3 id="creating-a-new-events-folder">Creating a New Events Folder</h3>


The first time you launch Club Planner, or after selecting **Open** from the **File** menu, you will be presented with a series of Open dialogs that will ask you to specify the folder containing Club Records, the folder for the desired Operating Year, and the Events folder. There is no default location publish
for these folder. You can create the necessary folders outside of Club Planner, before launching it, or can create the new folders from within the Open dialogs. Again, it is recommended that the folder containing Club Records be a shared [Dropbox][] folder.

<h3 id="import-minutes">Import Minutes</h3>


This allows the program to import a minutes file. The data in the minutes file will then be used to update the referenced events. See the [Club Planner Minutes File Format](#club-planner-minutes-file-format) section for information about the file format.

<h3 id="export-minutes">Export Minutes</h3>


This allows the program to export a minutes file. The minutes file will be in Markdown format, and can be easily published to a web site. See the [Club Planner Minutes File Format](#club-planner-minutes-file-format) section for information about the file format.

<h3 id="backup">Backup</h3>


The File menu contains a **Backup** command. When backing up, you will be prompted to select a backup folder. This should be the folder that contains all of your Club Planner backups. After selecting this folder, Club Planner will automatically create a subfolder containing a copy of your Events folder, with the backup date and time appended to the folder name.

<h3 id="start-new-year">Start New Year</h3>


As one operating year closes, and a new one begins, you may wish to start a new year by transferring events from the current year into the next year (assuming that one year looks much like the last, from a planning perspective). This is the intent of the **Start New Year** command.

After you specify the new Events folder within the new operating year folder, all events from the current year will be transferred to the new year, with the following exceptions.

* Events with a status of 'Discards' will not be copied.
* Events formerly having a status of 'Archive' or 'Next Year' will appear in the new year with a status of 'Current'.
* Events formerly having a state of '9 - Completed' will appear in the new year with a state of '1 - Suggested'.
* Income and Expense fields will be copied to the Prior Year fields, and the current year fields will be zeroed out.
* Only one historical event containing 'Board Meeting' in its title will be retained.

<h3 id="clear-actuals">Clear Actuals</h3>


Use the **Clear Actuals** command from the **File** menu to set all the actual income and expense fields to zero for the current operating year.


<h2 id="user-interface">User Interface</h2>



<h3 id="menus-and-keyboard-shortcuts">Menus and Keyboard Shortcuts</h3>


There are a number of **Menus** listed across the top of the screen. If a command has a keyboard shortcut, then it will be listed as part of the command's menu item.

The most commonly used commands are accessible in multiple ways. For example, you may navigate to the first item in the collection by clicking on the Tool Bar Button, or by selecting the command from the Event Menu, or through a keyboard shortcut.

Following is a list of all the menus, with a brief description of each menu's purpose.

* File -- Functions to open and save external disk files
* Event -- Functions that affect a particular event.
* Edit -- Standard Cut, Copy and Paste commands.
* Tools -- Access to Options/Preferences.
* Window -- Access to special windows.
* Help -- Access the iWisdom User Guide or Web Site.

<h3 id="the-tool-bar">The Tool Bar</h3>


A toolbar with multiple buttons appears at the top of the user interface.

* **OK** -- Indicates that you have completed adding/editing the fields for the current Event.
* **+** -- Clear the data fields and prepare to add a new Event to the collection.
* **-** -- Delete the current Event.
* **&lt;&lt;** -- Display the first Event in the collection.
* **&lt;** -- Display the next Event in the collection.
* **&gt;** -- Display the next Event in the collection.
* **&gt;&gt;** -- Display the last Event in the collection.
* **Launch** -- Launch the current Event in your Web browser. (This may also be accomplished by clicking the arrow that appears just to the left of the URL itself.)
* **Find** -- Looks for the text entered in the field just to the left of this button, and displays the first Event containing this text in any field, ignoring case. After finding the first occurrence, this button's text changes to **Again**, to allow you to search again for the next Event containing the specified text.

<h3 id="main-window">Main Window</h3>


The main window contains three different panes.

<h4 id="the-list">The List</h4>


On the first half of the main window, you'll see two tabs. The first of these displays the **List**. This is just a simple list of all your Events. You can rearrange/resize columns. You can't sort by other columns. Click on a row to select that Event for display on the other half of the main window. Use the entries on the **View** menu to select a different sorting/filtering option. Use the **View Preferences** to modify your view options.

<h4 id="tags">Tags</h4>


The second Tab on the first half of the main window displays the **Tags**. This is an indented list of all your Tags, with Events appearing under as many Tags as have been assigned to them, and with Events with no Tags displaying at the very top. Click to the left of a Tag to expand it, showing Events and/or sub-tags contained within it.

Note that Tags that were once used, but that are used no more, will stick around until you close the Club Planner file and re-open it. If you wish, you may accelerate this process by selecting **Reload** from the **File** menu.

<h4 id="details">Details</h4>


The detailed data for the currently selected Event appears on the second half of the main window.


<h2 id="tips-tricks-and-special-functions">Tips, Tricks and Special Functions</h2>


<h3 id="publish">Publish</h3>


The publish option allows you to easily publish your Events in a variety of useful formats.

To begin the publication process, select the **Publish...** command from the **File** menu.

You will then see a window with the following fields available to you.

Publish to
:    You may use the Browse button above and to the right to select a folder on your computer to which you wish to publish your Events. You may also enter or modify the path directly in the text box. When modifying this field, you will be prompted to specify whether you wish to update the existing publication location, or add a new one. By specifying that you wish to add a new one, you may create multiple publications, and then later select the publication of interest by using the drop-down arrow to the right of this field.

Equivalent URL
:    If the folder to which you are publishing will be addressable from the World-Wide Web, then enter its Web address here.

Templates
:    This is the address of a folder containing one or more publishing templates. This will default to the location of the templates provided along with the application executable. You may use the Browse button above and to the right to pick a different location, if you have your own templates you wish to use for publishing.

Select
:    Use the drop-down list to select the template you wish to use.

	**Favorites Plus**: This template will produce the following files and formats.

	1. index.html -- This file is an index file with links to the other files. You can browse this locally by selecting **Browse local index** from the **File** menu.
	 2. favorites.html -- This file tries to arrange all of the Events you have tagged as "Favorites" into a four-column format that will fit on a single page.
	 3. bookmark.html -- This file formats your URLs in the time-honored Netscape bookmarks format, suitable for import into almost any Web browser or URL manager.
	 4. outline.html -- This is a dynamic html file that organizes your URLs within your tags, allowing you to reveal/disclose selected tags.

Apply
:    Press this button to apply the selected template. This will copy the contents of the template folder to the location specified above as the Publish to location.

Publish Script
:    Specify the location of the script to be used. The PSTextMerge templating system is the primary scripting language used for publishing. A PSTextMerge script will usually end with a '.tcz' file extension.

Publish when
:    You may specify publication 'On Close' (whenever you Quit the application or close a data collection), 'On Save' (whenever you save the data collection to disk), or 'On Demand'.

Publish Now
:    Press this button to publish to the currently displayed location. Note that, if you've specified 'On Demand', then this is the only time that publication will occur.

View
:    Select the local file location or the equivalent URL location.

View Now
:    Press this button to view the resulting Web site in your Web browser.

<h3 id="textmerge-sort">TextMerge Sort</h3>


This tab allows the user to sort the data that has been input. Sorting is accomplished by using the following buttons that appear on this tab.

<h4 id="field-name">Field Name</h4>


This is a drop down list of all the columns in your data. Select the next field name on which you wish to sort, by starting with the most significant fields and proceeding to less significance.

<h4 id="sort-sequence">Sort Sequence</h4>


This is a drop down list. Pick either ascending (lower values towards the top, higher values towards the bottom) or descending. This sequence applies to the currently selected field name (see above).

<h4 id="add">Add</h4>


Pressing this button will add the field and sequence currently specified to the current sort parameters being built. The sort parameters added will appear in the text area shown below on this tab. After pressing the Add button, the user may go back and specify additional fields to be used in the sort criteria.

<h4 id="clear">Clear</h4>


Pressing this button will clear the sort parameters being built, so that you can start over.

<h4 id="set">Set</h4>


Once your desired sort parameters have been completely built, by pressing the Add button one or more times, you must press the Set button to cause your parameters to be applied to the data you are currently processing.

<h4 id="combine">Combine</h4>


After setting the desired sort sequence, you may optionally press this button to combine records with duplicate sort keys. The following buttons allow you to adjust the parameters controlling the combination process.

<h4 id="tolerance-for-data-loss">Tolerance for Data Loss</h4>


Record combination can be done with varying degrees of tolerance for data loss. Select one of the following radio buttons.

* No Data Loss &#8212; Records will only be combined if data (non-key) fields are identical, or if one of the two corresponding values is blank (in which case the non-blank value will be preserved in the resulting combined record).
* Later Records Override Earlier &#8212; If you are merging two input files, and one is known to carry more current data, then you can specify which file is the more current with this button or the next. This button will cause files merged later to be treated as more current.
* Earlier Records Override Later &#8212; Similar to prior button, but with files merged earlier taking precedence over later ones.
* Combine Fields Where Allowed &#8212; If the data dictionary allows fields to be concatenated, then this radio button indicates that concatenation may take place. This may be appropriate for a comment field.


<h4 id="minimum-number-of-lossless-fields">Minimum Number of Lossless Fields</h4>


If you specify some data loss to be acceptable, then this field may be used to specify a minimum number of data (non-key) fields that must be lossless (equal or one blank) before combination will be allowed to take place. This should be used if the sort keys are not guaranteed to establish uniqueness. Specifying a non-zero value here may help to prevent completely disparate records from being inadvertently combined. For example, names can be used to identify people, but two different people may have the same name.

Increment (+)
:    Use this button to increase the minimum number of lossless fields.

Decrement (-)
:    Use this button to decrease the minimum number of lossless fields. Zero is the smallest allowable value.

<h3 id="textmerge-filter">TextMerge Filter</h3>


This tab allows the user to filter the data that has been input, selecting some rows to appear and others to be suppressed. Filtering is accomplished by using the following buttons that appear on this tab.

<h4 id="field-name">Field Name</h4>


This is a drop down list of all the columns in your data. Select the next field name on which you wish to filter.

<h4 id="comparison-operator">Comparison Operator</h4>


This is a drop down list. Pick the operator that you want to use to compare your selected field to the following value. The following operators are available.

* equals
* greater than
* greater than or equal to
* less than
* less than or equal to
* not equal to
* contains
* does not contain
* starts with
* does not start with
* ends with
* does not end with

<h4 id="comparison-value">Comparison Value</h4>


This is the value to which the selected field will be compared. Only rows that satisfy this comparison will be visible after the filtering operation. You may type in a desired value, or select from the drop down list. The drop down list will consist of all the values found in this field within your data.

<h4 id="add">Add</h4>


Pressing this button will add the field, operator and value currently specified to the current filter parameters being built. The filter parameters added will appear in the text area shown below on this tab. After pressing the Add button, the user may go back and specify additional fields to be used in the filtering criteria.

<h4 id="clear">Clear</h4>


Pressing this button will clear the filter parameters being built, so that you can start over.

<h4 id="set">Set</h4>


Once your desired filter parameters have been completely built, by pressing the Add button one or more times, you must press the Set button to cause your parameters to be applied to the data you are currently processing.

<h4 id="andor">And/Or</h4>


If you specify more than one filter parameter, then you may specify whether all of them must be true (and) or only any one of them must be true (or) in order to satisfy the filtering criteria. This choice applies to the entire set of criteria, so this need only be selected once before pressing the Set button.

<h3 id="textmerge-template">TextMerge Template</h3>


This tab allows the user to merge the currently loaded data into a template file, producing one or more output text files. The greatest anticipated use for this function is to create Web pages, based on input template files containing a mixture of HTML tags and special PSTextMerge tags. This allows tab-delimited data to be periodically merged into an HTML template that determines the format in which the data will be displayed on a Web site.

<h4 id="buttons">Buttons</h4>


This screen contains the following buttons.

<h5 id="set-template-library">Set Template Library</h5>


PSTextMerge supports the concept of a central template library where you can store reusable templates. The initial location for this folder is the &#8220;templates&#8221; folder within the PSTextMerge Folder that comes as part of the software distribution. However, this button can be used to allow you to select another folder as your template library. After installation of PSTextMerge, you may wish to copy the templates folder to another location, perhaps within your home folder, or your documents folder, and then use this button to specify that new location.

<h5 id="open-template">Open Template</h5>


This button allows you to specify the location and name of the template file you wish to use. (This file must have previously been created using a text editor.) This function may also be invoked via the Template/Open Menu item or with the T shortcut key.

<h5 id="open-from-library">Open From Library</h5>


This button also opens a template file, but uses your template library as the starting location.

<h5 id="generate-output">Generate Output</h5>


This button processes the template file you have selected, and creates whatever output file(s) you have specified in the template file.  The function may also be invoked via the Template/Generate Menu item or with the G shortcut key.

<h4 id="template-file-format">Template File Format</h4>


See the [Template File Format specification](#template-file-format) for details.

<h3 id="textmerge-script">TextMerge Script</h3>


This tab allows the user to record and playback sequences of PSTextMerge commands. The following buttons and menu commands are available.

<h4 id="record">Record</h4>


Clicking on this button once causes the program to begin recording your subsequent actions as part of a script that can be edited and played back later. This function may also be invoked via the Script/Record Menu item, or with the R shortcut key. You will need to specify the location and name for your script file. It is recommended that &#8220;.tcz&#8221; be used as a file extension for PSTextMerge script files (the original name for the program was &#8220;TDF Czar&#8221;). This will be supplied as a default if no extension is specified by the user.

<h4 id="stop">Stop</h4>


Clicking on this button causes recording of the current script to stop. This function may also be invoked via the Script/End Recording Menu item, or with the E shortcut key. The script file will be closed, and can now be opened for editing, if desired, using the text editor, spreadsheet or database program of your choice.

<h4 id="play">Play</h4>


This button allows you to select a script file to be played back. This function may also be invoked via the Script/Play Menu item, or with the P shortcut key. At the end of a script&#8217;s execution, the input file options will be reset to their initial default values, to ensure consistent execution when multiple scripts are executed consecutively.

<h4 id="play-again">Play Again</h4>


This button allows you to replay the last script file either played or recorded. Using this button allows you to bypass the file selection dialog. It can be handy if you are developing, modifying or debugging a series of actions and associated files. This function may also be invoked via the Script/Play Again Menu item, or with the A shortcut key.

<h4 id="turn-autoplay-on">Turn Autoplay On</h4>


Clicking this button will allow you to select a script to be automatically played every time the application is launched.

After selecting a script to play automatically, the label of this button will change to &#8220;Turn Autoplay Off&#8221;.

<h4 id="turn-easy-play-on">Turn Easy Play On</h4>


Clicking this button will allow you to select a folder of scripts that you want easy access to. A new tab will then be added to the interface, labeled &#8220;Easy&#8221;. The new tab will contain a button for every script found in the folder. Clicking on a button will then play the corresponding script.

After selecting an Easy Play folder, the label of this button will change to &#8220;Turn Easy Play Off&#8221;.

<h4 id="play-recent">Play Recent</h4>


This menu item, within the Script menu, allows you to select a recently played script to run. The most recent 10 scripts will be available to select from.

<h4 id="script-file">Script File</h4>


See the [Script File Format specification](#scriptfiles) for details.

<h2 id="preferences">Preferences</h2>


The following preference tabs are available.

<h3 id="general-prefs">General Prefs</h3>


The program's General Preferences contain a number of options for modifying the program's look and feel. Feel free to experiment with these to find your favorite configuration. Some options may require you to quit and re-launch Club Planner before the changes will take effect.

SplitPane: Horizontal Split?
:    Check the box to have the **List** and **Tags** appear on the left of the main screen, rather than the top.

Deletion: Confirm Deletes?
:    Check the box to have a confirmation dialog shown whenever you attempt to delete the selected Event.

Software Updates: Check Automatically?
:    Check the box to have Club Planner check for newer versions whenever it launches.

Check Now
:    Click this button to check for a new version immediately.

File Chooser
:    If running on a Mac, you may wish to select AWT rather than Swing, to make your Open and Save dialogs appear more Mac-like. However, Swing dialogs may still appear to handle options that can't be handled by the native AWT chooser.

Look and Feel
:    Select from one of the available options to change the overall look and feel of the application.

Menu Location
:    If running on a Mac, you may wish to have the menus appear at the top of the screen, rather than at the top of the window.

<h2 id="help">Help</h2>


The following commands are available. Note that the first two commands open local documentation installed with your application, while the next group of commands will access the Internet and access the latest program documentation, where applicable.

* **Program History** -- Opens the program's version history in your preferred Web browser.

* **User Guide** -- Opens the program's user guide in your preferred Web browser.

* **Check for Updates** -- Checks the PowerSurgePub web site to see if you're running the latest version of the application.

* **Club Planner Home Page** -- Open's the Club Planner product page on the World-Wide Web.

* **Reduce Window Size** -- Restores the main Club Planner window to its default size and location. Note that this command has a shortcut so that it may be executed even when the Club Planner window is not visible. This command may sometimes prove useful if you use multiple monitors, but occasionally in different configurations. On Windows in particular, this sometimes results in Club Planner opening on a monitor that is no longer present, making it difficult to see.

<h2 id="file-formats">File Formats</h2>


The following file formats are used by Club Planner.

<h3 id="template-file-format">Template File Format</h3>


This section describes the contents of a template file, used for producing formatted output from a table of rows and columns.

This program will look for two sorts of special strings embedded within the template file: <a href="#vars">variables</a> and <a href="#commands">commands</a>.

<h4 id="delimiters">Delimiters</h4>


Beginning with version 3.0, PSTextMerge will recognize either of two sets of command and variable delimiters automatically. The choice of delimiters will be triggered by the first command beginning delimiters encountered. The new delimiters are generally recommended, since they are more likely to be treated kindly by various HTML editors on the market when you are editing your template files.

<table>
<tr><th>Meaning</th><th>Original Delimiters</th><th>New Delimiters</th></tr>
<tr><td>Start of Command</td><td>&lt;&lt;</td><td>&lt;?</td></tr>
<tr><td>End of Command</td><td>&gt;&gt;</td><td>?&gt;</td></tr>
<tr><td>Start of Variable</td><td>&lt;&lt;</td><td>=$</td></tr>
<tr><td>End of Variable</td><td>&gt;&gt;</td><td>$=</td></tr>
<tr><td>Start of Variable Modifiers</td><td>&amp;</td><td>&amp;</td></tr>
</table>

<h4 id="variables">Variables</h4>


Variables will be replaced by values taken from the corresponding columns of the current data record, or from an internal table of global variables. Variables must be enclosed in the chosen delimiters. Each variable name must match a column heading from the data file, or a global name specified in a SET command. The comparison ignores case (upper or lower), embedded spaces and embedded punctuation when looking for a matching column heading. So a column heading of "First Name" will match with a variable of "firstname", for example.

A variable, unlike a command, can appear anywhere within the template file, and need not be isolated on a line by itself. More than one variable can appear on the same line. Variables can be used within PSTextMerge commands, as well as other places within the template file.

The following special variables are predefined and available for substitution, no matter what data source is being used.

<dl>
<dt>datafilename</dt>
	<dd>The name of the data source being used.</dd>
<dt><a id="dataparent">dataparent</a></dt>
	<dd>The path to the enclosing folder for the current data file. This can be used as part of an output command to specify an output file in the same folder as the data file. </dd>
<dt>templatefilename</dt>
	<dd>The name of the template file itself</dd>
<dt>today</dt>
	<dd>The current date, at the time that template output is being generated.</dd>
</dl>

<h5 id="variable-modifiers">Variable Modifiers</h5>


A variable can be optionally followed (within the less than/greater than signs) by a modifier indicator and one or more modifiers. The default modifier character is the ampersand (&amp;).

<h5 id="case-modifiers-u-or-l">Case Modifiers "U" or "L"</h5>


The letters "U" or "L" (in either upper- or lower-case) will indicate that the variable is to be converted, respectively, to upper- or lower-case. If the letter "i" is also supplied (again in either upper- or lower-case), then only the first character of the variable value will be converted to the requested case. (The letter "i" stands for "initial".)

<h5 id="xml-modifier-x">XML Modifier "X"</h5>


The letter "X" will cause selected special characters to be translated to their equivalent XML entities. This is recommended, for example, when publishing an RSS (Really Simple Syndication) feed.

<h5 id="html-modifier-h">HTML Modifier "H"</h5>


The letter "H" will cause selected special characters to be translated to their equivalent HTML entities.

<h5 id="email-apostrophes-modifier-">E-mail Apostrophes Modifier '</h5>


Placing a single apostrophe as part of the variable modifiers string will cause any HTML entities representing an apostrophe to be converted back to a normal ASCII/UTF apostrophe character: '. This can be useful for generating HTML to use as e-mail content, since e-mail parsers seem to sometimes drop the HTML entities commonly used for apostrophes.

<h5 id="link-modifier-j">Link Modifier "J"</h5>


Convert a URL to an HTML anchor tag with that URL as the href value.

<h5 id="no-breaks-modifier-n">No Breaks Modifier "N"</h5>


Remove HTML break (br) tags from the string.

<h5 id="base-file-modifier-b">Base File Modifier "B"</h5>


The letter "B" will cause the file extension, including the period, to be removed from a file name. This can be used, for example, to generate an output file name with the same name as the input data file (using the variable name "datafilename"), but with a different extension.

<h5 id="file-name-modifier-f">File Name Modifier "F"</h5>


Converts a string to a conventional, universal file name, changing spaces to dashes, removing any odd characters, making all letters lower-case, and converting white space to hyphens.

<h5 id="remove-awkward-punctuation-modifier-p">Remove Awkward Punctuation Modifier "P"</h5>


Remove awkward punctuation characters.

<h5 id="keep-characters-on-the-right-modifier-r">Keep Characters on the Right Modifier "R"</h5>


The letter "R", in combination with a length modifier (see below), will cause the variable to be truncated to the given length, truncating characters on the left and keeping characters on the right.

<h5 id="length-modifier">Length Modifier</h5>


One or more digits following the modifier indicator will be interpreted as the length to which the variable should be truncated or padded. If the length modifier is shorter than the variable length, then by default characters will be truncated on the right (and preserved on the left) of the variable to bring it to the specified length (if it is desired to keep characters on the right, then also use the "R" modifier, described above). If the length modifier is longer than the initial variable length, then the variable will be padded with zeroes on the left to bring it to the specified length.

<h5 id="underscore-modifier">Underscore Modifier</h5>


An underscore character ("_") following the modifier indicator will cause all spaces in the variable to be replaced by underscores. This can be useful when creating a file name, for example.

<h5 id="punctuation-modifier">Punctuation Modifier</h5>


Any punctuation character other than an underscore following the modifier indicator will be interpreted as a separator that will be placed before the current variable, if the variable is non-blank, and if the preceding variable was also non-blank and also marked by a similar variable modifier. A space will be added after the separator, and before the current variable, if the punctuation is not a forwards or backwards slash ("/" or "\"). This is an easy way to list several variables on a single line, separating non-blank ones from others with commas (or other punctuation).

<h5 id="word-demarcation-modifier">Word Demarcation Modifier</h5>


If a variable may be interpreted as a series of "words," with the words delimited by white space, punctuation, or transitions from lower to upper case ("two words", "TWO_WORDS" or "twoWords"), then these variable modifiers may be used to change the way in which the words are delimited.

<table>
<tr><th>Letter</th><th>Meaning</th></tr>

	<tr><td>c </td>
		<td>This letter must begin the string, to indicate that modified word demarcation is desired. This should be followed by three letters, each with one of the following values. The first occurrence indicates what should be done with the first letter of the variable; the second occurrence indicates what should be done with the first letter of all other words; the third occurrence indicates what should be done with all other letters in the variable.</td></tr>
	<tr><td>u </td>
		<td>This letter indicates that upper-case is desired. </td></tr>
	<tr><td>l </td>
		<td>This letter indicates that lower-case is desired. </td></tr>
	<tr><td>a </td>
		<td>This letter indicates that the case should be left as-is. </td></tr>
	<tr><td>- </td>
		<td>Any character(s) following the 'c', other than 'u', 'l' or 'a', will be used as delimiters separating each word. </td></tr>
</table>

For example, if the template file contained the following:

<blockquote>
	
</blockquote>

And the name variable was equal to:

<blockquote>
	HERB BOWIE
</blockquote>

Then the resulting name in the output text file would be:

<blockquote>
	Herb Bowie
</blockquote>

<h5 id="formatting-string">Formatting String</h5>


A string of characters indicating how the variable is to be formatted. The formatting string, if specified, should follow any other variable modifiers. Any character other than those listed above will cause the remainder of the variable modifiers to be treated as a formatting string. Currently, a formatting string is valid only for dates -- either for the special variable **today**, or for any variable date in "mm/dd/yy" format.

A date formatting string follows the normal rules for Java date formatting. One or more occurrences of an upper-case "M" indicates a month, a lower-case "y" is used for a year, and a lower-case "d" is used for the day of the month. An upper-case "E" can be used for the day of the week. Generally, the number of occurrences of each letter you specify will be used to indicate the width of the field you want ("yyyy" for a 4-digit year, for example). Specifying more than two occurrences of "M" indicates you want the month represented by letters rather than numbers, with 4 or more occurrences indicating you want the month spelled out, and 3 occurrences indicating you want a three-letter abbreviation.

See below for full definition of allowable characters and their meanings.

<table>
	<tr>
		<th>Symbol</th>
		<th>Meaning</th>
		<th>Presentation</th>
		<th>Example</th>
	</tr>
	<tr>
		<td>G</td>
		<td>era designator</td>
		<td>Text</td>
		<td>AD</td>
	</tr>
	<tr>
		<td>y</td>
		<td>year</td>
		<td>Number</td>
		<td>1996</td>
	</tr>
	<tr>
		<td>M</td>
		<td>month in year</td>
		<td>Text & Number</td>
		<td>July & 07</td>
	</tr>
	<tr>
		<td>d</td>
		<td>day in month</td>
		<td>Number</td>
		<td>10</td>
	</tr>
	<tr>
		<td>h</td>
		<td>hour in am/pm</td>
		<td>1~12</td>
		<td>12</td>
	</tr>
	<tr>
		<td>H</td>
		<td>hour in day</td>
		<td>0~23</td>
		<td>0</td>
	</tr>
	<tr>
		<td>m</td>
		<td>minute in hour</td>
		<td>Number</td>
		<td>30</td>
	</tr>
	<tr>
		<td>s</td>
		<td>second in minute</td>
		<td>Number</td>
		<td>55</td>
	</tr>
	<tr>
		<td>S</td>
		<td>millisecond</td>
		<td>Number</td>
		<td>978</td>
	</tr>
	<tr>
		<td>E</td>
		<td>day in week</td>
		<td>Text</td>
		<td>Tuesday</td>
	</tr>
	<tr>
		<td>D</td>
		<td>day in year</td>
		<td>Number</td>
		<td>189</td>
	</tr>
	<tr>
		<td>F</td>
		<td>day of week in month</td>
		<td>Number</td>
		<td>2 (2nd Wed in July)</td>
	</tr>
	<tr>
		<td>w</td>
		<td>week in year</td>
		<td>Number</td>
		<td>27</td>
	</tr>
	<tr>
		<td>W</td>
		<td>week in month</td>
		<td>Number</td>
		<td>2</td>
	</tr>
	<tr>
		<td>a</td>
		<td>am/pm marker</td>
		<td>Text</td>
		<td>PM</td>
	</tr>
	<tr>
		<td>k</td>
		<td>hour in day</td>
		<td>Number</td>
		<td>24</td>
	</tr>
	<tr>
		<td>K</td>
		<td>hour in am/pm</td>
		<td>Number</td>
		<td>0</td>
	</tr>
	<tr>
		<td>z</td>
		<td>time zone</td>
		<td>Text</td>
		<td>Pacific Standard Time</td>
	</tr>
	<tr>
		<td>'</td>
		<td>escape for text</td>
		<td>Delimiter</td>
		<td></td>
	</tr>
	<tr>
		<td></td>
		<td>single quote</td>
		<td>Literal</td>
		<td></td>
	</tr>
</table>

The count of pattern letters determine the format.

<strong>(Text)</strong>: 4 or more pattern letters--use full form,
&lt; 4--use short or abbreviated form if one exists.

<strong>(Number)</strong>: the minimum number of digits. Shorter
numbers are zero-padded to this amount. Year is handled specially;
that is, if the count of 'y' is 2, the Year will be truncated to 2 digits.

<strong>(Text &amp; Number)</strong>: 3 or over, use text, otherwise use number.

Any characters in the pattern that are not in the ranges of ['a'..'z']
and ['A'..'Z'] will be treated as quoted text. For instance, characters
like ':', '.', ' ', '#' and '@' will appear in the resulting time text
even they are not embraced within single quotes.

<h4 id="commands">Commands</h4>


All commands must be enclosed in the chosen delimiters. In addition, all commands must appear on lines by themselves. Command names can be in upper- or lower-case. Each command may have zero or more operands. Operands may be separated by any of the following delimiters: space, comma (','), semi-colon (';') or colon (':'). Operands that contain any of these delimiters must be enclosed in single or double-quotation marks.

The following commands are recognized. They are presented in the typical sequence in which they would be used.

<div class="pnobr">
<p>&lt;?delims new delimiters?&gt;</p>
<p>&lt;?output "filename.ext"?&gt;</p>
<p>&lt;?set global = 0?&gt;</p>
<p>&lt;?nextrec?&gt;</p>
<p>&lt;?include "filename.ext" ?&gt;</p>
<p>&lt;?ifchange ?&gt;</p>
<p>&lt;?if ?&gt;</p>
<p>&lt;?definegroup group-number ?&gt;</p>
<p>&lt;?ifendgroup group-number?&gt;</p>
<p>&lt;?ifendlist group-number?&gt;</p>
<p>&lt;?ifnewlist group-number?&gt;</p>
<p>&lt;?ifnewgroup group-number?&gt;</p>
<p>&lt;?else?&gt;</p>
<p>&lt;?endif?&gt;</p>
<p>&lt;?loop?&gt;</p>
</div>

<h5 id="ltdelims-inew-delimitersigta">&lt;?delims <i>new delimiters</i>?&gt;</a></h5>


If used at all, this command should be the first command in the template file. This command overrides the standard delimiters used to recognize the beginnings and ends of commands and variables, for the remainder of the current template file. The command can have one to five operands. Each operand will become a new delimiter. They should be specified in the following order.

* beginning of a command (normally paired less than signs)
* the end of a command (normally paired greater than signs)
* the beginning of a variable (normally paired less than signs)
* the end of a variable (normally paired greater than signs)
* the beginning of variable modifiers (normally a single ampersand)

Note that, when using this command, this command itself must use the standard delimiters. The new delimiters should only begin to be used on following lines.

<h5 id="ltoutput-ifilenameextigt">&lt;?output <i>filename.ext</i>?&gt;</h5>


This command names and opens the output file. The single operand is the name of the output file. <i>filename.ext</i> should be the desired name of your output file. This command would normally be the first line in your template file. Subsequent template records will be written to the output file. Note, however, that the filename can contain a variable name. In this case, the output command would immediately follow the nextrec command, and a new output file would be opened for each tab-delimited data record.

<h5 id="ltset-iglobali--0gt">&lt;?set <i>global</i> = 0?&gt;</h5>


This command can define a global variable and set its value. This command would normally have three operands: the name of the global variable, an operator, and a value.

<ul>
<li>Global variable name. This should not be the same as the name of any variable name specified by the input data file. The global variable name, when used as the object of a SET command, should not be enclosed within the normal variable delimiters, since this would cause the variable name to be replaced by its current value.</li>

<li>Operator. Any of the following operators can be used.
<dl>
<dt>=</dt>
<dd>This will cause the global variable to be set equal to the following value.</dd>
<dt>+= or simply +</dt>
<dd>This will cause the value to be added to the current value of the global variable.</dd>
<dt>++</dt>
<dd>This can be used to add a value of 1 to the current value of the global variable, without having to specify the following value of 1. (In this case, the SET command only takes two operands.)</dd>
<dt>-= or simply -</dt>
<dd>This will cause the value to be subtracted from the current value of the global variable.</dd>
<dt>--</dt>
<dd>This can be used to subtract a value of 1 from the current value of the global variable, without having to specify the following value of 1. (In this case, the SET command only requires two operands.)</dd>
</dl></li>
<li>Value. This can be a literal or a variable (in which case it should be surrounded by the normal variable delimiters). The value can be a text string or an integer.</li>
</ul>
One intended use for the SET command is to support a line counter. By initializing the value to 0, and then adding to it whenever an output line is generated, the IF command can be used to check for page overflow (in a table column, for example), and then start a new page or column, resetting the counter to 0 again.

Another common use for the SET command is to preserve record variables in global variables so that they will be available within an IFENDGROUP block.

<h5 id="ltnextrecgt">&lt;?nextrec?&gt;</h5>


This command indicates the beginning of the code that will be written out once per data record. Lines prior to the nextrec command will only be written out once.

<h5 id="ltinclude-ifilenameextigt">&lt;?include <i>filename.ext</i>?&gt;</h5>


This command allows you to include text from another file into the output stream being generated by the template.

An optional operand of "copy" will ensure that the include file is included without conversion; otherwise, if the input and output file extensions are different, and are capable of conversion, the input file will be converted to the output file's format (for example, [Markdown][] or Textile can be converted to html).

Markdown conversion will be done using the [Flexmark][] processor, using the options for typographic conversions (as with SmartyPants) and table generation.

If converting from Markdown, then an optional operand of "nometa" will cause metadata lines to be skipped when generating the HTML output; otherwise, they will be included.

The filename may include variables, allowing you to tailor the included content based on one or more fields from your input data source. This is especially useful when you would like to include output from another template in the output generated by this template (effectively combining outputs from two separate templates into a single output). If an include file is not found, then it will simply be skipped and processing will continue, with a log message to note the event.

For any conversion resulting in HTML, a pseudo-tag of &lt;toc&gt; can be used to generate a table of contents based on following heading tags. An optional attribute of "from" can be used to specify the beginning of a range of heading levels to be included; an optional attribute of "through" or "thru" can be used to specify the end of a range of heading levels to be included. See the following example.

		<toc from="h2" thru="h4" />

<h5 id="ltifchange-gt">&lt;?ifchange ?&gt;</h5>


The ifchange command can be used to test a variable to see if it has a different value than it did on the last data record. If the variable has changed, then the following lines up to the closing endif command will be subjected to normal output processing. If the variable has not changed, then following lines will be skipped until the closing endif command is encountered. This command can be used to generate some special header information whenever a key field changes. Note that only one variable can be used with ifchange commands in one template file, since the value of any ifchange command is simply compared to the variable for the last ifchange command encountered.

<h5 id="ltif-gt">&lt;?if ?&gt;</h5>


The if command can be used to test a variable to see if it is non-blank. If the variable is non-blank, then the following lines up to the closing endif command will be subject to normal output processing. If the variable is blank, then following lines will be skipped until the closing endif command is encountered. In this case, the first and only operand would be the variable to be tested.

The if command can also be used to test a variable to compare it  to one or more constants. In this case, the command would have three or more operands: the name of the variable, a logical operator, and one or more values.

<ul>
<li>Variable Name. This can be a variable from the input data file, or a global variable (see the SET command above).</li>

<li>Logical Operator. Any of the following operators can be used.
<dl>
<dt>= or ==</dt>
<dd>This will return true if the variable is equal to any of the specified values.</dd>
<dt>&gt;</dt>
<dd>This will return true if the variable is greater than the value.</dd>
<dt>&lt;</dt>
<dd>This will return true if the variable is less than the value.</dd>
<dt>&gt;= or !&lt;</dt>
<dd>This will return true if the variable is greater than or equal to the value.</dd>
<dt>&lt;= or !&gt;</dt>
<dd>This will return true if the variable is less than or equal to the value.</dd>
</dl></li>
<li>Value. This can be a literal or a variable. The value can be a text string or an integer.</li>
</ul>

<h5 id="ltdefinegroup-igroupnumberi-gt">&lt;?definegroup <i>group-number</i> ?&gt;</h5>


This is the first of five commands that define key fields and then conditionally write output when there is a break on any of those fields. Up to ten group break fields can be defined. Each must be assigned a number from 1 to 10. Numbers should be assigned sequentially beginning with 1. Input data should normally be sorted by the same fields used in any definegroup commands. Definegroup commands should precede ifendgroup and ifnewgroup commands, and should generally be specified in ascending order by group number. The definegroup command has two operands.

* Group Number. This must be a number from 1 to 10. Numbers should be assigned sequentially beginning with 1. Lower-numbered groups are considered more major than higher-numbered groups, in the sense that lower-numbered group breaks will automatically trigger higher-numbered group breaks.

* Variable Name. This is the name of the key field variable.

<h5 id="ltifendgroup-igroupnumberigt">&lt;?ifendgroup <i>group-number</i>?&gt;</h5>


This is the second of the five group commands. Lines following this command and preceding the next group or endif command will be written to the output file at the end of a group of records sharing a common value for this key field. Ifendgroup commands should follow definegroup commands and precede ifnewgroup commands, and should generally be specified in <i>descending</i> order by group number. The ifendgroup command has one operand.

<ul>
<li>Group Number. The group number whose group-ending output lines follow.</li>
</ul>

Note that references to record variables within an IFENDGROUP block will retrieve the data from the record causing the break (i.e., the first record in the new group), not the last record in the group just ended. Use the SET command to save data in global variables if you need to later access it when a group break has been detected.

<h5 id="ltifendlist-igroupnumberigt">&lt;?ifendlist <i>group-number</i>?&gt;</h5>


This is the third of the five group commands. Lines following this command and preceding the next group or endif command will be written to the output file at the end of a list of records containing this key field. The end of a list will be triggered by a change in key values at the next higher level, or by a record containing blanks at the current group level. Ifendlist commands should follow ifendgroup commands and precede ifnewlist commands, and should generally be specified in <i>descending</i> order by group number. The ifendlist command has one operand. Note that the ifendlist and ifnewlist commands can generally be used to insert HTML tags to end a list and begin a list.

<ul>
<li>Group Number. The group number whose list-ending output lines follow.</li>
</ul>

Note that references to record variables within an IFENDLIST block will retrieve the data from the record causing the break (i.e., the first record in the new group), not the last record in the group just ended. Use the SET command to save data in global variables if you need to later access it when a list break has been detected. Note that the ifendlist and ifnewlist commands can generally be used to insert HTML tags to end a list and begin a list.

<h5 id="ltifnewlist-igroupnumberigt">&lt;?ifnewlist <i>group-number</i>?&gt;</h5>


This is the fourth of the five group commands. Lines following this command and preceding the next group or endif command will be written to the output file at the beginning of a new list of records at this group level. Ifnewlist commands should follow definegroup, ifendgroup and ifendlist commands, should precede ifnewgroup commands, and should generally be specified in <i>ascending</i> order by group number. The ifnewlist command has one operand.

<ul>
<li>Group Number. The group number whose list-beginning output lines follow.</li>
</ul>

<h5 id="ltifnewgroup-igroupnumberigt">&lt;?ifnewgroup <i>group-number</i>?&gt;</h5>


This is the fifth of the five group commands. Lines following this command and preceding the next group or endif command will be written to the output file at the beginning of a group of records sharing a common value for this key field. Ifnewgroup commands should follow all other group commands, and should generally be specified in <i>ascending</i> order by group number. The ifnewgroup command has one operand.

<ul>
<li>Group Number. The group number whose group-beginning output lines follow.
</ul>

<h5 id="ltelsegt">&lt;?else?&gt;</h5>


The else command terminates the scope of its corresponding if, ifchange, ifendgroup or ifnewgroup command, and applies the opposite logical condition to the following template lines.

<h5 id="ltendifgt">&lt;?endif?&gt;</h5>


The endif command terminates the scope of its corresponding if, ifchange, ifendgroup or ifnewgroup command.

<h5 id="ltloopgt">&lt;?loop?&gt;</h5>


This command indicates the end of the code that will be written out once per data record. Lines after the loop command will be written out once per output file created, at the end of each file.

<h3 id="script-files">Script Files</h3>


The script file is a tab-delimited text file, and you can edit one using your favorite tool for such things. You can create one completely from scratch if you want, but it usually easiest to record one first, and then edit the results.

The script file has the following columns.

1. module &#8212; This names the tab to process the command.
2. action &#8212; This names the action to be taken, and usually corresponds to a button on a tab.
3. modifier &#8212; This supplies a value that modifies the intent of the command in some way.
4. object &#8212; The name of the thing to be acted upon.
5. value &#8212; A value that the object is to be set equal to.

Following is a complete list of all the allowable forms for script commands. Constants are displayed in normal type. Variables appear in italics. Blank cells indicate fields that are not applicable to a particular command, and therefore can be left blank or empty. Forward slashes are used to separate alternate values: only one of them must appear (without the slash) in an actual script command. Most of the values correspond directly to equivalent buttons on the tabs, as described elsewhere in this user guide. The one non-intuitive value is probably the Filter values for the andor object: True sets &#8220;and&#8221; logic on, while False sets &#8220;or&#8221; logic on.

Note that file names may begin with the literal &#8220;PATH&#8221; surrounded by &#8220;#&#8221; symbols. When recording a script, the program will automatically replace the path containing the script file with this literal. In addition, upwards references from the location of the script file will be indicated by two consecutive periods for each level in the folder hierarchy. On playback, the reversing decoding will occur. In effect this means that files within the same path structure as the script file, or a sub-folder, will have their locations identified relative to the location of the script file. Files on a completely different path will have their locations identified with absolute drive and path information. The overall effect of this is to make a script file, along with the input files referenced by the script file, portable packages that can be moved from one location to another, or executed with different drive identifiers, and still execute correctly. Normally all of this will be transparent to the user.

Similarly, the literal &#8220;\#TEMPLATES\#&#8221; will be used as a placeholder for the path to the current template library, as set with the Set Template Library button on the Template tab.

The &#8220;epubin&#8221; and &#8220;epubout&#8221; actions require some additional description, since they have no correlates on the Script tab just described. The former identifies a directory containing the contents of an e-book in the EPUB format; the latter identifies the &#8220;.epub&#8221; file to be created using that directory as input.

<table class="shaded" border="0" cellspacing="2" cellpadding="4">
    <tr class="shaded">
        <th class="shaded" width="70" align="center">module</th>

        <th class="shaded" width="70" align="center">action</th>

        <th class="shaded" width="210" align="center">modifier</th>

        <th class="shaded" width="70" align="center">object</th>

        <th class="shaded" width="140" align="center">value<br /></th>
    </tr>

    <tr class="shaded">
        <td class="shaded" align="center">input</td>

        <td class="shaded" align="center">open</td>

        <td class="shaded" align="center">url</td>

        <td class="shaded" align="center">merge/blank</td>

        <td class="var" align="center">url name</td>
    </tr>

    <tr class="shaded">
        <td class="shaded" align="center">input</td>

        <td class="shaded" align="center">open</td>

        <td class="shaded" align="center">file</td>

        <td class="shaded" align="center">merge/blank</td>

        <td class="var" align="center">file name</td>
    </tr>

    <tr class="shaded">
        <td class="shaded" align="center">input</td>

        <td class="shaded" align="center">open</td>

        <td class="shaded" align="center">dir</td>

        <td class="shaded" align="center">merge/blank</td>

        <td class="var" align="center">directory name</td>
    </tr>

    <tr class="shaded">
        <td class="shaded" align="center">input</td>

        <td class="shaded" align="center">open</td>

        <td class="shaded" align="center">html1</td>

        <td class="shaded" align="center">merge/blank</td>

        <td class="var" align="center">file name</td>
    </tr>

    <tr class="shaded">
        <td class="shaded" align="center">input</td>

        <td class="shaded" align="center">open</td>

        <td class="shaded" align="center">html2</td>

        <td class="shaded" align="center">merge/blank</td>

        <td class="var" align="center">file name</td>
    </tr>

    <tr class="shaded">
        <td class="shaded" align="center">input</td>

        <td class="shaded" align="center">open</td>

        <td class="shaded" align="center">html3</td>

        <td class="shaded" align="center">merge/blank</td>

        <td class="var" align="center">file name</td>
    </tr>

    <tr class="shaded">
        <td class="shaded" align="center">input</td>

        <td class="shaded" align="center">open</td>

        <td class="shaded" align="center">xml</td>

        <td class="shaded" align="center">merge/blank</td>

        <td class="var" align="center">file name</td>
    </tr>

    <tr class="shaded">
        <td class="shaded" align="center">input</td>

        <td class="shaded" align="center">open</td>

        <td class="shaded" align="center">xls</td>

        <td class="shaded" align="center">merge/blank</td>

        <td class="var" align="center">file name</td>
    </tr>

    <tr class="shaded">
        <td class="shaded" align="center">input</td>

        <td class="shaded" align="center">epubin</td>

        <td class="shaded" align="center">dir</td>

        <td class="shaded" align="center">blank</td>

        <td class="var" align="center">directory name</td>
    </tr>

    <tr class="shaded">
        <td class="shaded" align="center">input</td>

        <td class="shaded" align="center">epubout</td>

        <td class="shaded" align="center">file</td>

        <td class="shaded" align="center">blank</td>

        <td class="var" align="center">file name</td>
    </tr>

    <tr class="shaded">
        <td class="shaded" align="center">sort</td>

        <td class="shaded" align="center">add</td>

        <td class="shaded" align="center">Ascending/ Descending</td>

        <td class="var" align="center">field name</td>

        <td class="shaded" align="center">&nbsp;</td>
    </tr>

    <tr class="shaded">
        <td class="shaded" align="center">sort</td>

        <td class="shaded" align="center">clear</td>

        <td class="shaded" align="center">&nbsp;</td>

        <td class="shaded" align="center">&nbsp;</td>

        <td class="shaded" align="center">&nbsp;</td>
    </tr>

    <tr class="shaded">
        <td class="shaded" align="center">sort</td>

        <td class="shaded" align="center">set</td>

        <td class="shaded" align="center">&nbsp;</td>

        <td class="shaded" align="center">params</td>

        <td class="shaded" align="center">&nbsp;</td>
    </tr>

    <tr class="shaded">
        <td class="shaded" align="center">combine</td>

        <td class="shaded" align="center">add</td>

        <td class="shaded" align="center">&nbsp;</td>

        <td class="shaded" align="center">dataloss</td>

        <td class="var" align="center">integer</td>
    </tr>

    <tr class="shaded">
        <td colspan="5" align="right">0 = no data loss, 1 = one record overrides, 2 = allow concatenation</td>
    </tr>

    <tr class="shaded">
        <td class="shaded" align="center">combine</td>

        <td class="shaded" align="center">add</td>

        <td class="shaded" align="center">&nbsp;</td>

        <td class="shaded" align="center">precedence</td>

        <td class="var" align="center">integer</td>
    </tr>

    <tr class="shaded">
        <td colspan="5" align="right">+1 = later overrides earlier, -1 = earlier overrides later</td>
    </tr>

    <tr class="shaded">
        <td class="shaded" align="center">combine</td>

        <td class="shaded" align="center">add</td>

        <td class="shaded" align="center">&nbsp;</td>

        <td class="shaded" align="center">minnoloss</td>

        <td class="var" align="center">integer</td>
    </tr>

    <tr class="shaded">
        <td class="shaded" align="center">combine</td>

        <td class="shaded" align="center">set</td>

        <td class="shaded" align="center">&nbsp;</td>

        <td class="shaded" align="center">params</td>

        <td class="shaded" align="center">&nbsp;</td>
    </tr>

    <tr class="shaded">
        <td class="shaded" align="center">filter</td>

        <td class="shaded" align="center">set</td>

        <td class="shaded" align="center">&nbsp;</td>

        <td class="shaded" align="center">andor</td>

        <td class="shaded" align="center">True/ False</td>
    </tr>

    <tr class="shaded">
        <td class="shaded" align="center">filter</td>

        <td class="shaded" align="center">add</td>

        <td class="shaded" align="center">operator</td>

        <td class="var" align="center">field name</td>

        <td class="var" align="center">comparison value</td>
    </tr>

    <tr class="shaded">
        <td class="shaded" align="center">filter</td>

        <td class="shaded" align="center">clear</td>

        <td class="shaded" align="center">&nbsp;</td>

        <td class="shaded" align="center">&nbsp;</td>

        <td class="shaded" align="center">&nbsp;</td>
    </tr>

    <tr class="shaded">
        <td class="shaded" align="center">filter</td>

        <td class="shaded" align="center">set</td>

        <td class="shaded" align="center">&nbsp;</td>

        <td class="shaded" align="center">params</td>

        <td class="shaded" align="center">&nbsp;</td>
    </tr>

    <tr class="shaded">
        <td class="shaded" align="center">output</td>

        <td class="shaded" align="center">set</td>

        <td class="shaded" align="center">&nbsp;</td>

        <td class="shaded" align="center">usedict</td>

        <td class="shaded" align="center">True/ False</td>
    </tr>

    <tr class="shaded">
        <td class="shaded" align="center">output</td>

        <td class="shaded" align="center">open</td>

        <td class="shaded" align="center">&nbsp;</td>

        <td class="shaded" align="center">&nbsp;</td>

        <td class="var" align="center">file name</td>
    </tr>

    <tr class="shaded">
        <td class="shaded" align="center">template</td>

        <td class="shaded" align="center">open</td>

        <td class="shaded" align="center">file</td>

        <td class="shaded" align="center">&nbsp;</td>

        <td class="var" align="center">file name</td>
    </tr>

    <tr class="shaded">
        <td class="shaded" align="center">template</td>

        <td class="shaded" align="center">generate</td>

        <td class="shaded" align="center">&nbsp;</td>

        <td class="shaded" align="center">&nbsp;</td>

        <td class="shaded" align="center">&nbsp;</td>
    </tr>
</table>



[java]:       http://www.java.com/
[pspub]:      http://www.powersurgepub.com/
[downloads]:  http://www.powersurgepub.com/downloads.html
[osd]:		  http://opensource.org/osd
[gnu]:        http://www.gnu.org/licenses/
[apache]:	     http://www.apache.org/licenses/LICENSE-2.0.html
[markdown]:		http://daringfireball.net/projects/markdown/
[multimarkdown]:  http://fletcher.github.com/peg-multimarkdown/

[wikiq]:     http://www.wikiquote.org
[support]:   mailto:support@powersurgepub.com
[fortune]:   http://en.wikipedia.org/wiki/Fortune_(Unix)
[opml]:      http://en.wikipedia.org/wiki/OPML
[textile]:   http://en.wikipedia.org/wiki/Textile_(markup_language)
[pw]:        http://www.portablewisdom.org

[store]:     http://www.powersurgepub.com/store.html

[pegdown]:   https://github.com/sirthias/pegdown/blob/master/LICENSE
[parboiled]: https://github.com/sirthias/parboiled/blob/master/LICENSE
[Mathias]:   https://github.com/sirthias

[club]:         clubplanner.html
[filedir]:      filedir.html
[metamarkdown]: metamarkdown.html
[template]:     template.html

[mozilla]:    http://www.mozilla.org/MPL/2.0/


