# IOF Data Standard, version 1.0b2, May 2001.

> ⚠️ **WARNING:** this page refers to an outdated version of the data standard. [Find here](https://github.com/international-orienteering-federation/datastandard-v3) the latest version

PROPOSED IOF EVENT INFORMATION EXCHANGE STANDARD

Again the iofCourseList, iofControlList and iofCourse have been revised. This is because it is mostly in the field of interfacing between course, event and especially result software that current development is taking place. Finn Arildsen has made an export mechanism in Condes.

### Courses and CourseLists
The RaceClass has been merged into Course making a CourseList simply ... a list of Courses. This is done by renaming the 1.0b1 Course to CourseVariant and make a new aggregation, Course, that consists of a list of RaceClasses and one or more CourseVariants.
### ControlList and ControlInfo
The position of a control is now seperated into a independent element, ControlPoint holding a single Coordinate element. This is added to the ControlInfo. In the same process the Description element of ControlInfo is no longer mandatory. This makes it easier to make a low footprint exchange of the control positions only.
### CourseData
In order to aggregate all information about controls and courses a CourseData element have been invented. This makes it possible to exchange all data about courses and controls in a single file.

/Kell Sønnichsen (kell@soenniksen.dk)

## STANDALONE ENTRIES 
```
iofEntries.dtd/ xml 
    iofEntry.dtd/ xml  
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
iofStartList.dtd/xml     iofCompetitor.dtd/xml
        iofPerson.dtd/xml
           iofServiceRequest.dtd/xml
               iofTransaction.dtd/xml
           iofAddress.dtd/xml
            iofTele.dtd/xml
    iofCCard.dtd/xml
    iofTimes.dtd/xml
```
Tele is short for telecommunication.

## COURSE DATA 
```
iofCourseData.dtd/xml
```
iofCourseData is putting together all information about courses and controls. This means that it can all be exchanged in a single XML file.

## COURSE LIST / COURSE 
```
iofCourseList.dtd/xml
    iofCourse.dtd/xml 
```
## CONTROLLIST / CONTROLINFO
```
iofControlList.dtd/xml
    iofControlInfo.dtd/xml
```
## RACECLASS / EVENTCLASS / BASECLASS
```
iofEventClass.dtd/xml
    iofBaseClass.dtd/xml 
        iofBadgeGroup.dtd/xml 
        iofBadgeLimit.dtd/xml 
    iofRaceClass.dtd/xml 
    iofPunchingUnitType.dtd/xml 
```
An orienteering event requires the use of two class/category information objects. An EventClass contains general information about a given age category for example H40. For a single day individual event, the event also requires a RaceClass which contains detailed information pertaining directly to the event (start time, awards time etc for that class) A MultiDay event would have one EventClass and multi RaceClasses (one for each race day). A BaseClass is a template of classes from which EventClasses can be created. BaseClasses are not necessary if one wants to recreate EventClasses for each event they organise. Badge refers to awards which many nations offer for reaching certain standards (percent behind winner for example)

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
(No entries, results or startlists as they conflict with things like iofClub in the same xml file.  Startlists, entries and results should be created as separate documents.  I would like to add such things as sponsors and media collections at a later date.) 
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