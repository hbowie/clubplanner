<?nextrec?>
<?definegroup 1 =$itemclass$= ?>
<?definegroup 2 =$panelno$= ?>
<?ifendgroup 2 ?>
<?if =$currpanelno$= ?>
  }
<?endif?>
<?ifendgroup 1 ?>
<?ifnewgroup 1 ?>
<?ifnewgroup 2 ?>
<?set currpanelno = =$panelno$= ?>
<?if =$panelno$= ?>
<?output "../includes/=$itemclass$=Panel=$panelno$=-panel-tweak.java"?>

  /**
   Set a link field to a new value after it has been tweaked. 
   
   This method generated by PSTextMerge using: 
   
     template:  =$templatefilename$=
     data file: =$datafilename$=
  
   @param tweakedLink The link after it has been tweaked. 
   @param linkID      A string identifying the link, in case there are more
                      than one. This would be the text used in the label
                      for the link. 
  */
  public void setTweakedLink (String tweakedLink, String linkID) {
<?endif?>
<?endif?>
<?if =$panelno$= ?>
<?if =$panelclass$= == "Link" ?>
    if (linkID.equals(=$field&clul$=Label.getLabelText())) {
      =$field&clul$=JTextArea.setText (tweakedLink);
    }
<?endif?>
<?endif?>
<?loop?>
