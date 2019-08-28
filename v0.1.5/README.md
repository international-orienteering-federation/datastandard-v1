# IOF Data Standard, version 0.1.5 July 22, 2000.

> ⚠️ **WARNING:** this page refers to an outdated version of the data standard. [Find here](https://github.com/international-orienteering-federation/datastandard-v3) the latest version

> ⚠️**Renumbered versions:** As work in progress the standard was numbered 1.0 to 1.5. But to mark these as unfinished an extra 0 has been added. So now they are numbered 0.1.0 to 0.1.5. The official standard (proposal version 1.6) is numbered 1.0. This new numbering has not been enforced in the text below, only in the main headline.


PROPOSED IOF EVENT INFORMATION EXCHANGE STANDARD 

*Proposal version 1.5 July 22, 2000 replaces previous versions 1.0, 1.1, 1.2, 1.3 (April-May, 2000)*

 

* [Previous Introduction for version 1.4](https://github.com/international-orienteering-federation/datastandard-v1/tree/master/v0.1.4): This version contains some minor changes from 1.3 requested from Finn Arildsen and changes we made after working with the dtd and xml files in applications.


* [Previous Introduction for version 1.3](https://github.com/international-orienteering-federation/datastandard-v1/tree/master/v0.1.3): This version contains some changes from 1.2 requested from Finn Arildsen and Kell Soennichsen.


* [Previous Introduction for version 1.2](https://github.com/international-orienteering-federation/datastandard-v1/tree/master/v0.1.2): This version has implemented suggestions for improvement from Peter Löfås, Finn Arildsen, Olav Nedrelid, Pekka Pirilä received May 5, 2000.


* [Previous Introduction for version 1.1](https://github.com/international-orienteering-federation/datastandard-v1/tree/master/v0.1.1): This version has implemented suggestions for improvement from Finn Arildsen, Kell Soennichsen received April 5 and 10, 2000. 


* [Previous Introduction for version 1.0](https://github.com/international-orienteering-federation/datastandard-v1/tree/master/v0.1.0): This proposal for the IOF Standard Information Exchange using Extensible Markup Language(XML) assumes that users of these standards will want some flexibility depending on their situation.  In order to achieve this I have created DataTypeDefinitions (DTD) for single Entities as much as possible.  A standard set or collection of data such as Results is then created using a complex DTD which simply includes the necessary DTDs for each entity it needs to support.  It has been my goal to reduce the amount of local information parsing.  For example my Times.dtd splits hours, mins and secs which frees the user from having to parse something like "10.05.34".  This adds extra space to the file but I consider the ease of use of greater importance.


 

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
 

   