# Club Information Management

by Herb Bowie

## About the Author

I became involved with the board of the [University of Michigan Club of Seattle][umseattle] in 2007, initially as the club's webmaster, and later as its president. 

As a software developer and Information Technology professional, I gradually became interested in the information management challenges associated with the club's operations. Over time, I developed the approach to these challenges that I shall describe in this document. 

## Digital Records

Digital records of our club's operations are increasingly desirable. It is easier to exchange, store and archive information digitally, rather than using paper. This is especially true for a volunteer organization such as ours that has no shared physical workspace.

## Storing Club Information in the "Cloud"

[Cloud storage][cloud] is an especially attractive option for a virtual organization such as ours. [Dropbox][] is a popular service offering this form of storage. Dropbox also offers the ability to share a folder among a number of users. This is an easy and free way to store club information and share it among board members. 

## Organizing Information by Operating Year

Since many of our club's operations recur on a regular basis from one year to the next, storing club records by operating year offers an easy and natural way to store and ultimately archive our club's records. 

## Communicating via the Web

One of our chief challenges as a board is the communication of events and activities to our club members. In this day and age, we do this primarily via email and posting to various Web sites. In all of these cases, the most useful means of formatting this information is via HyperText Markup Language, or [HTML][], the native language of the Web. 

Although basic HTML is not hard to learn, it probably unreasonable to expect most board members to master this language, and it is not a particularly easy language in which to write. 

Fortunately, [Markdown][] offers an alternative that can be easily converted to HTML when needed, using a syntax that can be easily learned, and providing an easy and lightweight syntax for authors. 

## Information about Events

In almost all of our club communications, the things about which we are communicating are events of some kind. So it seems natural that most of the information we maintain will be information about events. In order to minimize wasted effort, and maximize accuracy and consistency, it makes sense to maintain a single central repository containing information about each of our events, and then to select, filter, sort, format and publish that information as needed in order to create web pages, emails, meeting agendas, minutes and other forms of communication. 

## Text Editors Rather Than Word Processors

When asked to create a document of some kind, many people think first of Microsoft Word as their tool of choice. Unfortunately, for our purposes, MS-Word has many disadvantages:

* Documents are needlessly bulky. 
* Documents are difficult to convert to HTML.
* Documents produced on Windows PCs often display strange characters when viewed on a Mac or other operating system or device. 
* Expensive and proprietary software is needed to edit and to read such documents. 
* Text written for one purpose (such as a meeting agenda) cannot easily be repurposed for a new need (such as an email newsletter). 

Fortunately, better alternatives are readily available, in the form of text editors. A text editor produces plain text documents that use some visible syntax for formatting, rather than the WYSIWYG (What You See Is What You Get) style used by word processors. Any of a number of such text editors, many of them available for free, can be used to produce documents formatted using Markdown or HTML. 

When saving text documents, the preferred encoding to be used is UTF-8, rather than a format peculiar to Windows or the Mac OS, since UTF-8 makes use of a universal scheme for text encoding.

## The Club Planner App 

Club Planner is a software application that I have written to help implement all of the principles and practices recommended above. 

## Use of Club Planner

I've released Club Planner as [Open Source Software][oss], under the terms of the Apache License, Version 2.0. There is no cost to use the software. It can be freely downloaded from [PowerSurgePub.com][pspub], and the source code is available from GitHub. For the U-M Club of Seattle, the latest build of the software will also be available from the Apps section of our shared Dropbox folder. 

Club Planner is written in the [Java][] programming language, which means that it can run on either a Windows PC or a Mac. If Java is not already available on your computer, you will need to install it in order to use Club Planner. 

In order to launch Club Planner, you will need to double-click on the file named clubplanner.jar. 

## Club Planner Data

The Club Planner app operates on a folder of data. Such a folder will contain information about all the potential and actual events pertaining to a single club operating year. The folder opened by Club Planner should be named "Events". The Events folder should exist within a parent folder containing the club operating year (either a single year or a range of two years). The Events folder will contain a number of sub-folders, one for each category of events. Finally, within each category folder, one plain text file will be maintained for each event. 

By storing all of this data in a shared Dropbox folder, any updates made by one board member will be automatically synchronized with updates made by other board members. 

## Event Updates

Use of Club Planner to update information about events should be fairly intuitive. 

[java]:  http://www.java.com/
[html]:  http://???

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

[cloud]:     http://en.wikipedia.org/wiki/Cloud_storage
[dropbox]:   http://www.dropbox.com/
[html]:      http://en.wikipedia.org/wiki/HTML
[jedit]:     http://www.jedit.org/
[markdown]:  http://daringfireball.net/projects/markdown/
[notepad++]: http://notepad-plus-plus.org/
[textedit]:  http://en.wikipedia.org/wiki/TextEdit
[textwrangler]: http://www.barebones.com/products/textwrangler/
[umseattle]: http://www.umseattle.com
[zip]:       http://en.wikipedia.org/wiki/Zip_(file_format)




