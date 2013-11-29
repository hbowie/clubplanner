<?nextrec?>
<?definegroup 1 =$itemclass$=?>
<?ifendgroup 1 ?>

  /**
   Return the number of columns. 
   */
  public static int getColumnCount() {
    return COLUMN_COUNT;
  }
<?ifnewgroup 1 ?>
<?output "../includes/=$itemclass$=-variable-methods.java"?>

  /* 
   Following code generated by PSTextMerge using: 
   
     template:  =$templatefilename$=
     data file: =$datafilename$=
   */
 
<?endif?>
  
  /**
     Sets the =$field&c lll$= for this =$itemclass&c lll$=.
 
     @param  =$field&clul$= The =$field&c lll$= for this =$itemclass&c lll$=.
   */
  public void set=$field&cuul$= (=$fieldclass$= =$field&clul$=) {
    this.=$field&clul$= = =$field&clul$=;
    setModified (true);
  }
<?if =$fieldclass$= = "Tags" ?>

  /**
     Sets the =$field&c lll$= for this =$itemclass&c lll$=.
 
     @param  =$field&clul$= The =$field&c lll$= for this =$itemclass&c lll$=.
   */
  public void set=$field&cuul$= (String =$field&clul$=) {
    this.=$field&clul$= = new Tags(=$field&clul$=);
    setModified (true);
  }
<?endif?>
<?if =$fieldclass$= = "Boolean" ?>

  /**
     Sets the =$field&c lll$= for this =$itemclass&c lll$=.
 
     @param  =$field&clul$= The =$field&c lll$= for this =$itemclass&c lll$=.
   */
  public void set=$field&cuul$= (String =$field&clul$=) {
    this.=$field&clul$= = new Boolean(=$field&clul$=);
    setModified (true);
  }
<?endif?>

  /**
    Returns the =$field&c lll$= for this =$itemclass&c lll$= as a string.
   
    @return The =$field&c lll$= for this =$itemclass&c lll$= as a string.
   */
  public String get=$field&cuul$=AsString () {
    if (has=$field&cuul$=()) {
      return get=$field&cuul$=().toString();
    } else {
      return "";
    }
  }

  /**
    Determines if the =$field&c lll$= for this =$itemclass&c lll$= is null.
   
    @return True if the =$field&c lll$= for this =$itemclass&c lll$= is not null.
   */
  public boolean has=$field&cuul$= () {
    return (=$field&clul$= != null);
  }
<?if =$fieldclass$= = "Tags" ?>

  /**
    Determines if the =$field&c lll$= for this =$itemclass&c lll$= 
    is null or is empty.
   
    @return True if the =$field&c lll$= for this =$itemclass&c lll$= 
    is not null and not empty.
   */
  public boolean has=$field&cuul$=WithData () {
    return (=$field&clul$= != null && =$field&clul$=.length() > 0);
  }
<?endif?>
<?if =$fieldclass$= = "String" ?>

  /**
    Determines if the =$field&c lll$= for this =$itemclass&c lll$= 
    is null or is empty.
   
    @return True if the =$field&c lll$= for this =$itemclass&c lll$= 
    is not null and not empty.
   */
  public boolean has=$field&cuul$=WithData () {
    return (=$field&clul$= != null && =$field&clul$=.length() > 0);
  }
<?endif?>

  /**
    Returns the =$field&c lll$= for this =$itemclass&c lll$=.
   
    @return The =$field&c lll$= for this =$itemclass&c lll$=.
   */
  public =$fieldclass$= get=$field&cuul$= () {
    return =$field&clul$=;
  }
<?if =$asclass$= eq BigDecimal?>
  /**
    Returns the =$field&c lll$= as a =$asclass$= object.
   
    @return The =$field&c lll$= for this =$itemclass&c lll$= as a =$asclass$=.
   */
  public =$asclass$= get=$field&cuul$=As=$asclass$= () {
    CalcParser parser = new CalcParser(=$field&clul$=);
    return parser.getResult();
  }
<?endif?>
<?loop?>
