<?nextrec?>
<?definegroup 1 =$itemclass$=?>
<?ifendgroup 1 ?>
<?ifnewgroup 1 ?>
<?if =$itemtype$= = "Master" ?>
<?set masterItemClass = =$itemclass$= ?>
<?output "../../src/com/powersurgepub/clubplanner/model/=$itemclass$=List.java"?>
/*
 * Copyright 2012 - 2014 Herb Bowie
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

package com.powersurgepub.clubplanner.model;

  import com.powersurgepub.psdatalib.clubplanner.*;
  import com.powersurgepub.psdatalib.psdata.*;
  import com.powersurgepub.psdatalib.pslist.*;
  import com.powersurgepub.psdatalib.pstags.*;
  import com.powersurgepub.psfiles.*;
  import com.powersurgepub.psutils.*;
  import java.io.*;
  import java.util.*;
  import javax.swing.table.*;

/**
 A single class that manages multiple lists of items and keeps the lists
 appropriately synchronized. The first such list is a raw list of all items.
 The second such list is a filtered, sorted list of item proxies that point
 back to the real items in the raw list. <p>
 
    This item master list class generated by PSTextMerge using: <p>
 
     template:  =$templatefilename$= <p>
     data file: =$datafilename$= 

 @author Herb Bowie
 */
public class =$itemclass$=List
    extends
      AbstractTableModel
    implements
      DataSource,
      PSList,
      TaggableList {
 
  private String          title = "=$itemclass&c uul$= List";
  
  private FileSpec        fileSpec = null;
 
  private RecordDefinition recDef = new RecordDefinition();
 
  private List<=$itemclass$=>            list = new ArrayList();
  private List<=$itemclass$=Proxy>       proxyList = new ArrayList();
 
  private Comparator      comparator = new =$itemclass$=DefaultComparator();
  private PSItemFilter    itemFilter = null;
 
  private int             findIndex = -1;
  private boolean         findMatch = false;
 
  private TagsList        tagsList = new TagsList();
  private TagsModel       tagsModel = new TagsModel();
  
  private int             dataSourceIndex = 0;
  
  /** Log used to record events. */
  private    Logger             log;
  
  /** Should all data be logged (or only data preceding significant events(? */
  private    boolean            dataLogging = false;
  
  /** Data to be logged. */
  private    LogData            logData;
  
  /** Debug instance. */
  private		 Debug							debug = new Debug (false);
  
  /** Identifier used to identify this reader in the log. */
  private    String             fileId;
  
  /** Path to the original source file (if any). */
  private		 String							dataParent;
  
<?include "../includes/=$itemclass$=-master-list-columns.java"?>
 
  /**
   List constructor with no arguments.
   */
  public =$itemclass$=List () {
    tagsList.registerValue("");
    for (int i = 0; i < getColumnCount(); i++) {
      recDef.addColumn(getColumnName(getC(i)));
    }
    log = Logger.getShared();
  }
  
  /**
   Initialize the list with no items in the list. 
  */
  public void initialize() {
    list = new ArrayList();
    proxyList = new ArrayList();
    tagsList = new TagsList();
    tagsModel = new TagsModel();
    tagsList.registerValue("");
    comparator = new =$itemclass$=DefaultComparator();
    itemFilter = null;
  }
 
  public void setComparator (Comparator comparator) {
    if (comparator == null) {
      this.comparator = new =$itemclass$=DefaultComparator();
    } 
    else
    if (comparator instanceof PSItemComparator) {
      PSItemComparator itemComparator = (PSItemComparator)comparator;
      if (itemComparator.getNumberOfFields() == 0) {
        this.comparator = new =$itemclass$=DefaultComparator();
      } else {
        this.comparator = comparator;
      }
    } else {
      this.comparator = new =$itemclass$=DefaultComparator();
    }
    reloadProxyList();
    fireTableDataChanged();
  }
 
  public Comparator getComparator() {
    return comparator;
  }
 
  public TagsList getTagsList () {
    return tagsList;
  }

  public TagsModel getTagsModel () {
    return tagsModel;
  }
 
  /**
   Sets a data filter to be used to select desired output records.
 
   @param inputFilter Desired output filter.
   */
  public void setInputFilter (PSItemFilter inputFilter) {
    this.itemFilter = inputFilter;
    reloadProxyList();
    fireTableDataChanged();
  }
  
  public void reloadProxyList() {
    proxyList = new ArrayList();
    for (int i = 0; i < list.size(); i++) {
      addToProxyList(i);
    }
  }
 
  /**
   Set the data source, stored in the root node of the TagsModel tree.
 
   @param source The file or folder from which the data is taken.
  */
  public void setSource (FileSpec fileSpec) {
    this.fileSpec = fileSpec;
    tagsModel.setSource(fileSpec.getFile());
  }
 
  /**
   Get the data source, stored in the root node of the TagsModel tree.
 
   @return The file or folder from which the data is taken.
  */
  public FileSpec getSource () {
    return fileSpec;
  }
 
  public void setTitle (String title) {
    this.title = title;
  }

  public String getTitle () {
    return title;
  }
 
  /**
   Return the number of columns.
   */
  public int getColumnCount () {
    return =$itemclass$=.getColumnCount();
  }
 
  public String getColumnName (int columnIndex) {
    return =$itemclass$=.getColumnName (getC(columnIndex));
  }

  public Class getColumnClass (int columnIndex) {
    return =$itemclass$=.getColumnClass (getC(columnIndex));
  }
 
  /**
   Get the column number assigned to a particular field name. 
  
   @param columnName The name of the column. Case and word separation are
                     not significant. 
  
   @return The column number (with the first starting at zero), or -1
           if the field name could not be found.
  */
  public int getColumnNumber (String columnName) {
    String commonName = StringUtils.commonName(columnName);
    boolean found = false;
    int i = 0;
    while (i < getColumnCount() && (! found)) {
      found = commonName.equals(=$itemclass$=.getCommonName(getC(i)));
      if (! found) {
        i++;
      }
    }
    if (! found) {
      return -1;
    } else {
      return i;
    }
  }
 
  /**
   Return the record definition for this list 
   
   @return The record definition, or null if no record defined yet. 
   */
  public RecordDefinition getRecDef() {
    return recDef;
  }
 
  /**
	 Returns a List containing the names of all the fields
	 stored in the data set.
	
	 @return Proper names of all the fields.
   */
  public List getNames() {
    ArrayList names = new ArrayList();
    for (int i = 0; i < getColumnCount(); i++) {
      names.add(getColumnName(getC(i)));
    }
    return names;
  }
 
  /**
   Return the size of the total list, without any filtering.
   */
  public int totalSize() {
    return list.size();
  }
 
  /**
   Return the size of the filtered list.
 
   @return The size of the filtered list.
  */
  public int size() {
    return proxyList.size();
  }

  /**
   Return the number of rows in the table.
   */
  public int getRowCount() {
    return size();
  }
 
  /**
   Return the column value of the item at the specified index.
   */
  public String getValueAt (int rowIndex, int columnIndex) {
    =$itemclass$= item = get(rowIndex);
    if (item == null) {
      return "";
    } else {
      Object columnValue = item.getColumnValue(getC(columnIndex));
      if (columnValue == null) {
        return "";
      } else {
        return columnValue.toString();
      }
    }
  } // end method getValueAt
  
  public int getColumnWidth (int columnIndex) {
    return =$itemclass$=.getColumnWidth(getC(columnIndex));
  }
  
  /**
   Translate the column index used in the table model to the column index
   used in the master record definition. 
   */
  private int getC (int columnIndex) {
    if (columnIndex < 0 || columnIndex >= columns.length) {
      return -1;
    } else {
      return columns[columnIndex];
    }
  }
 
  /**
   Get the item at the specified index in the sorted, filtered list.
 
   @param index Indicates the desired position within the sorted, filtered list.
 
   @return The item at the desired index, or null if the index is out
           of bounds.
  */
  public =$itemclass$= get (int index) {
    if (index >= 0 && index < size()) {
      return proxyList.get(index).getItem(list);
    } else {
      return null;
    }
  } // end method get (int)
  
  /**
   Get the item at the specified index in the raw, unfiltered list.
 
   @param index Indicates the desired position within the raw, unfiltered list.
 
   @return The item at the desired index, or null if the index is out
           of bounds.
  */
  public =$itemclass$= getUnfiltered (int index) {
    if (index >= 0 && index < totalSize()) {
      return list.get(index);
    } else {
      return null;
    }
  } // end method getUnfiltered (int)
 
  public =$itemclass$=Positioned positionUsingNode (TagsNode node) {
    =$itemclass$=Positioned position = new =$itemclass$=Positioned();
    position.set=$itemclass$= ((=$itemclass$=)node.getTaggable());
    position.setTagsNode (node);
    findInternalBySortKey (position.get=$itemclass$=());
    position.setIndex (findIndex);
    position.setNavigator (=$itemclass$=Positioned.NAVIGATE_USING_TREE);
    return position;
  }
 
  /**
   Add a new =$itemclass$= to the list. Maintain the list in ascending sequence
   by the =$itemclass$= key.
 
   @param new=$itemclass$=
   @return A positioned =$itemclass$= composed of the resulting =$itemclass$= and an index
           pointing to its resulting position in the list.
   */
  public =$itemclass$=Positioned add (=$itemclass$= new=$itemclass$=) {
 
    int listIndex = list.size();
    list.add(new=$itemclass$=);
    addToProxyList(listIndex);
    tagsList.add  (new=$itemclass$=);
    tagsModel.add (new=$itemclass$=);
    return new =$itemclass$=Positioned (new=$itemclass$=, findIndex);
  } // end add method
  
  private void addToProxyList (int i) {
    =$itemclass$= =$itemclass&clul$= = list.get(i);
    /* System.out.println (
        "=$itemclass$=List.addToProxyList " 
        + " # "
        + String.valueOf(i)
        + " : "
        + =$itemclass&clul$=.toString()); */
    if (itemSelected(=$itemclass&clul$=)) {
      /* System.out.println("  item selected");
      System.out.println("  size of proxy list = " + String.valueOf(size()));
      if (size() > 0) {
        System.out.println ("  item at end of list = " + get(size() - 1).toString());
      } */
      =$itemclass$=Proxy =$itemclass&clul$=Proxy = new =$itemclass$=Proxy(i);
      findIndex = size();
      if (size() == 0) {
        // If this is the first =$itemclass$= being added to the proxy list,
        // simply add the proxy to the list
        proxyList.add(=$itemclass&clul$=Proxy);
      }
      else
      if (comparator.compare (get(size() - 1), =$itemclass&clul$=) < 0) {
        // If the new item has a key higher than the highest item in the
        // collection, simply add the new item to the end
        // (more efficient if an input file happens to be pre-sorted).
        proxyList.add (=$itemclass&clul$=Proxy);
      } else {
        findInternalBySortKey (=$itemclass&clul$=);
        proxyList.add (findIndex, =$itemclass&clul$=Proxy);
      }
    }
  }
  
  public boolean itemSelected (=$itemclass$= =$itemclass&clul$=) {
    if (itemFilter == null) {
      return true;
    } else {
      return itemFilter.selects(=$itemclass&clul$=);
    }
  }

  public =$itemclass$=Positioned modify (=$itemclass$=Positioned mod=$itemclass$=) {
    tagsList.modify(mod=$itemclass$=.get=$itemclass$=());
    tagsModel.modify(mod=$itemclass$=.get=$itemclass$=());
    return mod=$itemclass$=;
  }

  /**
   Removes the passed =$itemclass$=, if it exists in the collection.

   @param position A position containing the =$itemclass$= to be removed.
 
   @return A position for the next URL following the one just removed.
   */
  public =$itemclass$=Positioned remove (=$itemclass$=Positioned position) {
    int oldIndex = findBySortKey (position.get=$itemclass$=());
    =$itemclass$=Positioned newPosition = position;
    if (findMatch) {
      newPosition = next (position);
      tagsModel.remove (position.get=$itemclass$=());
      tagsList.remove (position.get=$itemclass$=());
      =$itemclass$=Proxy proxyRemoved = proxyList.remove(oldIndex);
      =$itemclass$=Proxy =$itemclass&clul$=Proxy = proxyList.get(oldIndex);
      int listIndex = proxyRemoved.getItemIndex();
      int newIndex = newPosition.getIndex();
      if (newIndex >= oldIndex) {
        newPosition.setIndex(newIndex - 1);
      }
      list.remove(listIndex);
      for (int i = 0; i < proxyList.size(); i++) {
        =$itemclass&clul$=Proxy = proxyList.get(i);
        int itemIndex = =$itemclass&clul$=Proxy.getItemIndex();
        if (itemIndex > listIndex) {
          itemIndex--;
          =$itemclass&clul$=Proxy.setItemIndex(itemIndex);
        } // end if item index needs to be adjusted
      } // end for each proxy
    } // end if we found item to be removed
    return newPosition;
  }

  public int findBySortKey (=$itemclass$= find=$itemclass$=) {
    findInternalBySortKey (find=$itemclass$=);
    if (findMatch) {
      return findIndex;
    } else {
      return -1;
    }
  }

  /**
   Find the appropriate insertion point or match point in the =$itemclass$= list,
   and use findIndex and findMatch to return the results.

   @param find=$itemclass$= URL we are looking for.
   */
  private void findInternalBySortKey (=$itemclass$= find=$itemclass$=) {
    int low = 0;
    int high = size() - 1;
    findIndex = 0;
    findMatch = false;
    while (high >= low
        && findMatch == false
        && findIndex < size()) {
      int diff = high - low;
      int split = diff / 2;
      findIndex = low + split;
      int compare = comparator.compare (get(findIndex), find=$itemclass$=);
      if (compare == 0) {
        // found an exact match
        findMatch = true;
      }
      else
      if (compare < 0) {
        // =$itemclass$= from list is less than the one we're looking for
        findIndex++;
        low = findIndex;
      } else {
        // =$itemclass$= from list is greater than the one we're looking for
        if (high > findIndex) {
          high = findIndex;
        } else {
          high = findIndex - 1;
        }
      }
    } // end while looking for right position
  } // end findBySortKey method
  
<?include "../includes/=$itemclass$=-master-list-findByUniqueKey.java"?>
 
  public =$itemclass$=Positioned first (=$itemclass$=Positioned position) {
    if (position.navigateUsingList()) {
      return firstUsingList ();
    } else {
      return firstUsingTree ();
    }
  }
 
  public =$itemclass$=Positioned last (=$itemclass$=Positioned position) {
    if (position.navigateUsingList()) {
      return lastUsingList ();
    } else {
      return lastUsingTree ();
    }
  }

  public =$itemclass$=Positioned next (=$itemclass$=Positioned position) {
    if (position.navigateUsingList()) {
      return nextUsingList (position);
    } else {
      return nextUsingTree (position);
    }
  }

  public =$itemclass$=Positioned prior (=$itemclass$=Positioned position) {
    if (position.navigateUsingList()) {
      return priorUsingList (position);
    } else {
      return priorUsingTree (position);
    }
  }

  public =$itemclass$=Positioned firstUsingList () {
    return positionUsingListIndex (0);
  }

  public =$itemclass$=Positioned lastUsingList () {
    return positionUsingListIndex (size() - 1);
  }

  public =$itemclass$=Positioned nextUsingList (=$itemclass$=Positioned position) {
    return (positionUsingListIndex (position.getIndex() + 1));
  }

  public =$itemclass$=Positioned priorUsingList (=$itemclass$=Positioned position) {
    return (positionUsingListIndex (position.getIndex() - 1));
  }

  public =$itemclass$=Positioned positionUsingListIndex (int index) {
    if (index < 0) {
      index = 0;
    }
    if (index >= size()) {
      index = size() - 1;
    }
    =$itemclass$=Positioned position = new =$itemclass$=Positioned();
    position.setIndex (index);
    position.setNavigator (=$itemclass$=Positioned.NAVIGATE_USING_LIST);
    if (index >= 0) {
      position.set=$itemclass$= (get (index));
      position.setTagsNode (position.get=$itemclass$=().getTagsNode());
    }
    return position;
  }

  public =$itemclass$=Positioned firstUsingTree () {
    return positionUsingNode (tagsModel.firstItemNode());
  }

  public =$itemclass$=Positioned lastUsingTree () {
    return positionUsingNode (tagsModel.lastItemNode());
  }

  public =$itemclass$=Positioned nextUsingTree (=$itemclass$=Positioned position) {
    if (position.getTagsNode() == null) {
      return null;
    } else {
      return positionUsingNode
          (tagsModel.nextItemNode(position.getTagsNode()));
    }
  }

  public =$itemclass$=Positioned priorUsingTree (=$itemclass$=Positioned position) {
    if (position.getTagsNode() == null) {
      return null;
    } else {
      return positionUsingNode
          (tagsModel.priorItemNode(position.getTagsNode()));
    }
  }
  
  /**
     Opens the reader for input.
    
     @param inDict A data dictionary to use.
    
     @throws IOException If there is trouble opening a disk file.
   */
  public void openForInput (DataDictionary inDict)
      throws IOException {
    dataSourceIndex = 0;
  }
      
  /**
     Opens the reader for input.
    
     @param inRecDef A record definition to use.
    
     @throws IOException If there is trouble opening a disk file.
   */
  public void openForInput (RecordDefinition inRecDef)
      throws IOException {
    dataSourceIndex = 0;
  }
  
  /**
     Opens the reader for input.
    
     @throws IOException If there is trouble opening a disk file.
   */
  public void openForInput ()
      throws IOException {
    dataSourceIndex = 0;
  }
  
  /**
     Returns the next input data record.
    
     @return Next data record.
    
     @throws IOException If reading from a source that might generate
                         these.
   */
  public DataRecord nextRecordIn ()
      throws IOException {
    if (isAtEnd()) {
      return null;
    } else {
      =$itemclass$= =$itemclass&clul$= = get(dataSourceIndex);
      dataSourceIndex++;
      return =$itemclass&clul$=.getDataRec();
    }
  }
  
  /**
     Indicates whether there are more records to return.
    
     @return True if no more records to return.
   */
  public boolean isAtEnd() {
    return (dataSourceIndex >= size());
  }
  
  /**
     Returns the sequential record number of the last record returned.
    
     @return Sequential record number of the last record returned via 
             nextRecordIn, where 1 identifies the first record.
   */
  public int getRecordNumber () {
    return dataSourceIndex;
  }
  
  /**
     Closes the reader.
    
     @throws IOException If there is trouble closing the file.
   */
  public void close () 
      throws IOException {
    
  }
    
  /**
     Sets a log to be used by the reader to record events.
    
     @param  log A logger object to use.
   */
  public void setLog (Logger log) {
    this.log = log;
  }
  
  /**
     Sets the debug instance to the passed value.
    
     @param debug Debug instance. 
   */
  public void setDebug (Debug debug) {
    this.debug = debug;
  }
  
  /**
     Indicates whether all data records are to be logged.
    
     @param  dataLogging True if all data records are to be logged.
   */
  public void setDataLogging (boolean dataLogging) {
    this.dataLogging = dataLogging;
  }
  
  /**
     Sets a file ID to be used to identify this reader in the log.
    
     @param  fileId An identifier for this reader.
   */
  public void setFileId (String fileId) {
    this.fileId = fileId;
    logData.setSourceId (fileId);
  }
  
  /**
     Sets the maximum directory explosion depth.
    
     @param maxDepth Desired directory/sub-directory explosion depth.
   */
  public void setMaxDepth (int maxDepth) {
    
  }
  
  /**
     Retrieves the path to the original source file (if any).
    
     @return Path to the original source file (if any).
   */
  public String getDataParent () {
    return dataParent;
  }
  
  /**
     Returns the reader as some kind of string.
    
     @return String identification of the reader.
   */
  public String toString () {
    return title;
  }

}
<?endif?>
<?endif?>
<?loop?>
