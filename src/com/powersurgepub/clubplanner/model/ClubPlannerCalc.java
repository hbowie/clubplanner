package com.powersurgepub.clubplanner.model;

  import com.powersurgepub.psutils.*;
  import java.math.*;
  import org.pegdown.*;

/**
 Performs various calculations and transformations on club planner data. 

 @author Herb Bowie
 */
public class ClubPlannerCalc {
  
  private    StringDate         strDate = new StringDate();
  private    PegDownProcessor   pegDown;
  
  public ClubPlannerCalc () {
    int pegDownOptions = 0;
    pegDownOptions = pegDownOptions + Extensions.SMARTYPANTS;
    pegDown = new PegDownProcessor(pegDownOptions);
  }
  
  public void setStringDate (StringDate strDate) {
    this.strDate = strDate;
  }
  
  public StringDate getStringDate() {
    return strDate;
  }
  
  /**
   If the status of an item is "Future", then adjust the year to be a future 
   year. 
  
   @param futureStr The status of an item. If it says "Future", then 
                    adjust the year to be a future year. 
  */
  public void setFuture(String futureStr) {
    strDate.setFuture(futureStr);
  }
  
  /**
   Parse a field containing an operating year.
  
   @param years This could be a single year, or a range containing two
                consecutive years. If a range, months of July or later
                will be assumed to belong to the earlier year, with months
                of June or earlier will be assumed to belong to the 
                later year. 
  
   @return True if an operating year was found in the passed String.
  */
  public boolean parseOpYear (String years) {
    return strDate.parseOpYear(years);
  }
  
  /**
   Calculate fields that are not stored in the text files, but derived from
   other fields. 
   */
  public void calcAll (ClubEvent clubEvent) {
    
    calcType (clubEvent);
    calcBlurbAsHtml (clubEvent);
    calcNotesAsHtml (clubEvent);
    calcFinanceProjection (clubEvent);
    calcOverUnder (clubEvent);
    calcSeq (clubEvent);
    calcYmd (clubEvent);
    calcShortDate (clubEvent);

  }
  
  public void calcType (ClubEvent clubEvent) {

    StringBuilder type = new StringBuilder (clubEvent.getType().toString());
    int pipeIndex = type.indexOf("|");
    if (pipeIndex >= 0) {
      pipeIndex++;
      while (pipeIndex < type.length()
          && Character.isWhitespace(type.charAt(pipeIndex))) {
        pipeIndex++;
      }
      type.delete(0, pipeIndex);
    }
    clubEvent.setType (type.toString());
  }
  
  public void calcBlurbAsHtml (ClubEvent clubEvent) {

    if (clubEvent.getBlurb() != null
        && clubEvent.getBlurb().length() > 0) {
      clubEvent.setBlurbAsHtml(pegDown.markdownToHtml(clubEvent.getBlurb()));
    }
  }
  
  public void calcNotesAsHtml (ClubEvent clubEvent) {
    if (clubEvent.getNotes() != null
        && clubEvent.getNotes().length() > 0) {
      clubEvent.setNotesAsHtml(pegDown.markdownToHtml(clubEvent.getNotes()));
    }
  }
  
  public void calcFinanceProjection (ClubEvent clubEvent) {

    BigDecimal financeProjection = BigDecimal.ZERO;

    boolean anyFinances = false;
    if (clubEvent.getActualIncome() != null
        && clubEvent.getActualIncome().length() > 0) {
      financeProjection = clubEvent.getActualIncomeAsBigDecimal();
      anyFinances = true;
    }
    else
    if (clubEvent.getPlannedIncome() != null
        && clubEvent.getPlannedIncome().length() > 0) {
      financeProjection = clubEvent.getPlannedIncomeAsBigDecimal();
      anyFinances = true;
    }

    if (clubEvent.getActualExpense() != null
        && clubEvent.getActualExpense().length() > 0) {
      financeProjection = financeProjection.subtract
          (clubEvent.getActualExpenseAsBigDecimal());
      anyFinances = true;
    }
    else
    if (clubEvent.getPlannedExpense() != null
        && clubEvent.getPlannedExpense().length() > 0) {
      financeProjection = financeProjection.subtract
          (clubEvent.getPlannedExpenseAsBigDecimal());
      anyFinances = true;
    }

    if (anyFinances) {
      clubEvent.setFinanceProjection(financeProjection.toPlainString());
    } else {
      clubEvent.setFinanceProjection("");
    }
  }
  
  public void calcOverUnder (ClubEvent clubEvent) {

    BigDecimal overUnder = BigDecimal.ZERO;
    
    boolean anyActuals = false;
    if (clubEvent.getActualIncome() != null
        && clubEvent.getActualIncome().length() > 0) {
      overUnder = clubEvent.getActualIncomeAsBigDecimal();
      anyActuals = true;
    }

    if (clubEvent.getPlannedIncome() != null
        && clubEvent.getPlannedIncome().length() > 0) {
      overUnder = overUnder.subtract
          (clubEvent.getPlannedIncomeAsBigDecimal());
    }

    if (clubEvent.getActualExpense() != null
        && clubEvent.getActualExpense().length() > 0) {
      overUnder = overUnder.subtract
          (clubEvent.getActualExpenseAsBigDecimal());
      anyActuals = true;
    }

    if (clubEvent.getPlannedExpense() != null
        && clubEvent.getPlannedExpense().length() > 0) {
      overUnder = overUnder.add
          (clubEvent.getPlannedExpenseAsBigDecimal());
    }

    if (anyActuals) {
      clubEvent.setOverUnder (overUnder.toPlainString());
    }
  }
  
  public void calcSeq (ClubEvent clubEvent) {
    String typeLower = clubEvent.getType().toString().toLowerCase();
    if (typeLower.indexOf("open meeting") >= 0) {
      clubEvent.setSeq("1");
    }
    else
    if (typeLower.indexOf("finance") >= 0) {
      clubEvent.setSeq("2");
    }
    else
    if (typeLower.indexOf("communication") >= 0) {
      clubEvent.setSeq("8");
    }
    else
    if (typeLower.indexOf("close meeting") >= 0) {
      clubEvent.setSeq("9");
    } else {
      clubEvent.setSeq("5");
    }
  }
  
  public void calcYmd (ClubEvent clubEvent) {
    
    // Now get the date in a predictable year-month-date format
    if (clubEvent.hasWhen()) {
      strDate.setFuture(clubEvent.getStatus());
      strDate.parse(clubEvent.getWhen());
      clubEvent.setYmd(strDate.getYMD());
    }
  }
  
  public void calcShortDate (ClubEvent clubEvent) {
    
    // Now set a short, human readable date
    if (clubEvent.hasWhen()) {
      strDate.setFuture(clubEvent.getStatus());
      strDate.parse(clubEvent.getWhen());
      clubEvent.setShortDate(strDate.getShort());
    }
    
  }
  
  public void calcAll (EventNote eventNote) {
    calcNoteAsHtml (eventNote);
  }
  
  public void calcNoteAsHtml (EventNote eventNote) {
    if (eventNote.getNote() != null
        && eventNote.getNote().length() > 0) {
      eventNote.setNoteAsHtml(pegDown.markdownToHtml(eventNote.getNote()));
    }
  }

}
