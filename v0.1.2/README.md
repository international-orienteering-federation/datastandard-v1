# IOF Data Standard, version 0.1.2, May 10, 2000.

> ⚠️ **WARNING:** this page refers to an outdated version of the data standard. [Find here](https://github.com/international-orienteering-federation/datastandard-v3) the latest version

> ⚠️**Renumbered versions:** As work in progress the standard was numbered 1.0 to 1.5. But to mark these as unfinished an extra 0 has been added. So now they are numbered 0.1.0 to 0.1.5. The official standard (proposal version 1.6) is numbered 1.0. This new numbering has not been enforced in the text below, only in the main headline.

PROPOSED IOF EVENT INFORMATION EXCHANGE STANDARD 

*Proposal version 1.2 May 10, 2000 replaces previous versions 1.0 and 1.1 (April, 2000)*

 
## Introduction version 1.2

This version has implemented suggestions for improvement from Peter Löfås, Finn Arildsen, Olav Nedrelid, Pekka Pirilä received May 5, 2000.

To iofEntry we have made it possible to enter a Person Element in case a Person list is not accompanying the export.  There has been some discussion surrounding the id of a person and this should alleviate the problem somewhat.

 

An iofEntries .dtd has been added.  Se examples below for an xml sample.  Entries have been removed from iofEvent due to a conflict with transaction.


Question :  What is the purpose for both an ID and a name for a course.

Answer:   The ID can be used for internal identity of the course in the database.  This becomes important when exchanging data on a "diskette" network whereas the name is the name given to the course by the user. See courses below.

Added to iofCourse .  Estimate of number of competitors before entries are finished.  This is useful for estimating control load.

Changed in iofControlInfo.  Changed the structure completely in order accomodate 2 codes for a single box.  It also supports a diagonal option.

A Finish control has a description of the finish run in.  For electronic punching systems, the finish control is used for the control on the finish line, when used for timing so therefore I have left in a ControlInfo element.

The PunchPattern has been left as a string for the moment.

To BaseClass , I have added:
```
allowedMinAge CDATA #IMPLIED
allowedMaxAge CDATA #IMPLIED
```
These are for use when runners run outside their normal class.

Added a new dtd:

iofIdentity.dtd for use if several id codes are needed (for example storing owner ids in an eCard).  This has affected some of the xml examples and hopefully I have updated all of them.

 

## Courses :

I have added a CourseID to iofCompetitor so that competitors in the same class can run different courses (eg. looping or relays).

### Previous Introduction for version 1.1

This version has implemented suggestions for improvement from Finn Arildsen, Kell Soennichsen received April 5 and 10, 2000. 

  The most change has occured in controlInfo and course.  Otherwise the changes were corrections, relaxing the REQUIRED restriction or adding some important detail. 

Results and start lists have been improved to include support for showing multi day information in the same XML file. 
Split times has been improved to specify split time order and control code.  This will help identify problems with electronic punching systems that have their timers out of sync (it has happened that a time between controls was negative if the split times were compared). 
ModifyDate has become IMPLIED for all modules.  Occasionally a module includes another module both of which have ModifyDates.  With this version, one only needs to include the top most ModifyDate if deemed necessary.
Clarifications:

iofCompetitor.dtd -> ELEMENT Competitor -> ATTLIST EntClass

Question: What is EntClass when Person (included in Competitor) also has a Class.

Answer:  The Class for a Person is based on their age and the local rules for that person.  My Class when in Sweden is H40 while in Great Britain it is M40?

When I compete in Sweden I may occasionally run H40Lång or even H21 for short distance races.  EntClass is the class I entered when I became a competitor for the event.

The Person table may be a national database table which is centrally based while the competitor table is temporary to the event itself.

 

iofCompetitor.dtd -> ELEMENT Competitor -> ATTLIST StartNumber

Question: Is it necessary to make this REQUIRED if there is a REQUIRED ID in Person?

Answer:  The Person's ID is not always the Bib number.  The Person database file is different from the Competitor database file.  The StartNumber in this proposal is the same for all races in an event (as in a multi day event).  This is not always the case and a more flexible proposal is required.

 

Question: Relays?

Answer:  I have not included any special requirements for Relays as yet.  Some day...

 

Question: iofRaceClass.dtd -> ELEMENT RaceClass -> ATTLIST finishchute.  Is this the chute they enter at the finish?

Answer: Yes.

 

Question: iofRaceClass.dtd -> ELEMENT RaceClass -> ATTLIST administrationLineCode.  What is this?

Answer: This is to help the administration of the event.  One code might be used to represent the line of activity that checks normal control cards from the timing section, to the calculation section to the code verification section.  Another code might represent abnormal route, such as finishers who have abandoned the course, or need to talk with race administrators re: problems on course.

 

General Comments:

Please look closely at ControlInfo and Course as this has changed drastically.  I think I had partly confused elements between the two when I first drafted the proposal.

Does anyone have a good suggestion for storing a paper punch pattern efficiently?  Finn uses a 9X9 matrix of Boolean flags which as a binary string of length 81 looks like: 
```
1111111111000000011000000011000000011000000011000000011000000011000000011111111111
```
 representation of a square box.  I left it as a CDATA so it is up to the users I suppose.

 

TODO list:

* Press support shall be completed shortly.  A complete Event also needs some work.

 

## Previous Introduction for version 1.0

This proposal for the IOF Standard Information Exchange using Extensible Markup Language(XML) assumes that users of these standards will want some flexibility depending on their situation.  In order to achieve this I have created DataTypeDefinitions (DTD) for single Entities as much as possible.  A standard set or collection of data such as Results is then created using a complex DTD which simply includes the necessary DTDs for each entity it needs to support.  It has been my goal to reduce the amount of local information parsing.  For example my Times.dtd splits hours, mins and secs which frees the user from having to parse something like "10.05.34".  This adds extra space to the file but I consider the ease of use of greater importance.

 

I have created so called standalone complex dtds such as for Results and StartList which are not valid as such in, for example an Event.  Results as specified below contains all competitor information while an event keeps a PersonList separate from things such as EntryList where an Entry contains an Id to a Person instead of including all the information for the person in the entry.

 

I do not expect the proposal below to handle all cases, nor do I consider it a finished proposal.  Over the next few months while we undertake development of the Swedish Orienteering Federation's new Competition Administration System (expected delivery date October), there shall most likely be changes required.  In the mean time I welcome your comments on this proposal.

 

This proposal extends the work done by the IOF Standards Committee and specifically the proposal to use XML provided by Mr. Ian Watson of GBR.  In most cases the proposal supports a business object model developed for the SOFT project by Stefan Nordmark.

 

I look forward to hearing from you even if you only have time to look at a very small portion such as Results or StartList.  I have sent this proposal to members of the IOF Technical Standards Committee mailing list and a few interested individuals.

 
The following artifacts make up this proposal:

(Indentation means recursive inclusion of another entity's type definition)

NOTES: The links to the dtd's actually reference a txt extended file because I do not know how to display a dtd extended file without IExplorer 5.0 trying to parse it as XML.  Anybody know how other than rewriting them as XML schemas?  IExplorer 5.0 will show a parsed xml tree while previous versions will only show text.

I have used `encoding="ISO-8859-1"` which supports Scandinavian letters (the Swedish variety at least).
 

## STANDALONE ENTRIES
```
iofEntries.dtd/xml
    iofEntry.dtd/xml 
        iofCCard.dtd/xml
        iofPerson.dtd/xml
             iofServiceRequest.dtd/xml
                 iofTransaction.dtd/xml
             iofAddress.dtd/xml
             iofTele.dtd/xml
```

## STANDALONE RESULTS
```
iofResults.dtd/xml
    iofCompetitor.dtd/xml
        iofPerson.dtd/xml
           iofServiceRequest.dtd/xml
               iofTransaction.dtd/xml
           iofAddress.dtd/xml
           iofTele.dtd/xml
    iofCCard.dtd/xml
    iofSplitTimes.dtd/xml
    iofTimes.dtd/xml
```
 

A ServiceRequest is an object used to detail requests for such things as tent sites, result hard copies etc.  The sort of non standard items that each event offers to participants.

A Transaction is an object for storing financial records with.


## STANDALONE STARTLIST
```
iofStartList.dtd/xml
    iofCompetitor.dtd/xml
        iofPerson.dtd/xml
           iofServiceRequest.dtd/xml
               iofTransaction.dtd/xml
           iofAddress.dtd/xml
            iofTele.dtd/xml
    iofCCard.dtd/xml
    iofTimes.dtd/xml
```
Tele is short for telecommunication.

 

## STANDALONE COURSES/COURSE LIST
```
iofCourseList.dtd/xml
    iofCourse.dtd/xml
        iofControlInfo.dtd/xml
```
ControlInfo is another word for ControlDescription with some e info added.

 

## STANDALONE LIST OF CONTROLS
```
iofControlList.dtd/xml
    iofControlInfo.dtd/xml
```
 

## AN EVENT CLASS
```
iofEventClass.dtd/xml
    iofBaseClass.dtd/xml
        iofBadgeGroup.dtd/xml
        iofBadgeLimit.dtd/xml
    iofRaceClass.dtd/xml
    iofPunchingUnitType.dtd/xml
```
Badge refers to awards which many nations offer for reaching certain standards (percent behind winner for example).

 

## ORGANISATION
```
iofOrganisation.dtd/xml
    iofOrganisationType.dtd/xml
    iofPerson.dtd/xml
       iofIdentity.dtd/xml
       iofServiceRequest.dtd/xml
           iofTransaction.dtd/xml
       iofAddress.dtd/xml
       iofTele.dtd/xml
    iofCountry.dtd/xml
```
A Club is a sub class of an organisation for example.  Media, sponsors, can be considered organisations for example.

 

## AN EVENT 
No entries, results or startlists as they conflict with things like iofClub in the same xml file.  Startlists, entries and results should be created as separate documents.  I would like to add such things as sponsors and media collections at a later date. 

```
iofEvent.dtd/xml
    iofEventForm.dtd/xml
    iofEventClassification.dtd/xml
     iofClub.dtd/xml 
         iofPerson.dtd/xml
            iofServiceRequest.dtd/xml
                iofTransaction.dtd/xml
            iofAddress.dtd/xml
            iofTele.dtd/xml
        iofCountry.dtd/xml
   iofEventClass.dtd/xml
        iofBaseClass.dtd/xml
             iofBadgeGroup.dtd/xml
            iofBadgeLimit.dtd/xml
        iofRaceClass.dtd/xml
        iofPunchingUnitType.dtd/xml
   iofEventRace.dtd/xml
   iofService.dtd/xml
```
 

   