<?nextrec?>
<?definegroup 1 =$itemclass$= ?>
<?definegroup 2 =$panelno$= ?>
<?ifendgroup 2 ?>
<?ifendgroup 1 ?>
<?ifnewgroup 1 ?>
<?ifnewgroup 2 ?>
<?if =$panelno$= ?>
<?output "../includes/=$itemclass$=Panel=$panelno$=-panel-definitions.java"?>

  /* 
   Following code generated by PSTextMerge using: 
   
     template:  =$templatefilename$=
     data file: =$datafilename$=
   */
   
<?endif?>
<?endif?>
<?if =$panelno$= ?>

  private JLabel    =$field&clul$=Label    = new JLabel("=$field$=:", JLabel.LEFT);
<?if =$panelclass$= == "JTextField" ?>  
  private =$panelclass$= =$field&clul$==$panelclass$= = new =$panelclass$=();
<?endif?>
<?if =$panelclass$= == "JLabel" ?>  
  private =$panelclass$= =$field&clul$==$panelclass$= = new =$panelclass$=();
<?endif?>
<?if =$panelclass$= == "TextSelector" ?>  
  private =$panelclass$= =$field&clul$==$panelclass$= = new =$panelclass$=();
<?endif?>
<?if =$panelclass$= == "JTextArea" ?>  
  private JScrollPane =$field&clul$=ScrollPane = new javax.swing.JScrollPane();
  private =$panelclass$= =$field&clul$==$panelclass$= = new =$panelclass$=();
<?endif?>
<?endif?>
<?loop?>
