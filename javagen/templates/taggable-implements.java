<?nextrec?>
<?definegroup 1 =$itemclass$=?>
<?ifendgroup 1 ?>
<?if =$tagsField$= == "none" ?>
      // No taggable fields
<?endif?>
<?if =$tagsField$= != "none" ?>
      Taggable,
<?endif?>
<?ifnewgroup 1 ?>
<?output "../includes/=$itemclass$=-taggable-implements.java"?>
      // Generated by PSTextMerge using template =$templatefilename$=.
<?set tagsField = "none" ?>
<?set interfaces = 0 ?>
<?endif?>
<?if "=$fieldclass$=" == "Tags" ?>
<?set tagsField = =$field$= ?>
<?endif?>
<?loop?>
