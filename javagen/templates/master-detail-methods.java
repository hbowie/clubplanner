<?nextrec?>
<?definegroup 1 =$itemclass$=?>
<?ifendgroup 1 ?>
<?ifnewgroup 1 ?>
<?if =$itemtype$= = "Master" ?>
<?set masterItemClass = =$itemclass$= ?>
<?output "../includes/=$itemclass$=-master-detail-methods.java"?>

  /* 
   Following code generated by PSTextMerge using: 
   
     template:  =$templatefilename$=
     data file: =$datafilename$=
   */
 
<?endif?>
<?if =$itemtype$= = "Detail" ?>
  /**
   Adds a new =$itemclass&cuul$= to the end of the internal detail list. 
  
   @param =$itemclass&clul$= The =$itemclass&cuul$= to be added. 
  
   @return True if the list was modified. 
  */
  public boolean add=$itemclass&cuul$= (=$itemclass&cuul$= =$itemclass&clul$=) {
    return =$itemclass&clul$=List.add(=$itemclass&clul$=);
  }
  
  /**
   Adds a new =$itemclass&cuul$= at the specified location.
  
   @param index The index position at which the =$itemclass&cuul$= should be added. 
  
   @param =$itemclass&clul$= The =$itemclass&cuul$= to be added. 
  */
  public void add=$itemclass&cuul$= (int index, =$itemclass&cuul$= =$itemclass&clul$=) {
    =$itemclass&clul$=List.add(index, =$itemclass&clul$=);
  }
  
  /**
   Gets the =$itemclass&cuul$= at the specified location. 
  
   @param index The desired location. 
  
   @return The =$itemclass&cuul$= stored at that location.
  */
  public =$itemclass&cuul$= get=$itemclass&cuul$= (int index) {
    return =$itemclass&clul$=List.get(index);
  }
  
  /**
   Sets a new =$itemclass&cuul$= at the specified list location. 
  
   @param index The index location in the internal table.
  
   @param =$itemclass&clul$= The new =$itemclass&cuul$= to be placed there. 
  
   @return The =$itemclass&cuul$= previously stored at that location. 
  */
  public =$itemclass&cuul$= set=$itemclass&cuul$= (int index, =$itemclass&cuul$= =$itemclass&clul$=) {
    return =$itemclass&clul$=List.set(index, =$itemclass&clul$=);
  }
  
  /**
   Returns the size of the internal =$itemclass&cuul$= list. 
  
   @return The size of the internal list of details.
  */
  public int size=$itemclass&cuul$=List () {
    return =$itemclass&clul$=List.size();
  }
<?endif?>
<?endif?>
<?loop?>
