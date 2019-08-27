# IOF Data Standard, version 1.0b1, December 2000.

> ⚠️ **WARNING:** this page refers to an outdated version of the data standard. [Find here](https://github.com/international-orienteering-federation/datastandard-v3) the latest version

PROPOSED IOF EVENT INFORMATION EXCHANGE STANDARD

Proposal version 1.6 Sept 13, 2000 replaces previous versions 1.0, 1.1, 1.2, 1.3, 1.4, 1.5 (April-July, 2000).

This beta version addresses several important issues, most notably revised iofCourseList, revised iofRaceClass and a simplified iofCourse. Input from Hans Steinegger have been very helpful in coming to grips with the relay model and more efficient iofCourse model together with helpful comments from Finn Arildsen. James Baker provided input on ISO date formats.

### Courses
In order to help keep file size to a minimum and simplify the model we have removed the control info from the course and replaced it with a control Element with a control num (sequential order 1,2,3,4) and code (eg 32, 34,56 which appears on the control perhaps) , thereby requiring the event to first import a list of controlInfos (with matching controlCodes).
iofCourseList now includes a iofCourse element. This will save the user from having to import a lot of separate course files. A course list now links to an iofRaceClass such that a class can have 1 or more courses linked to it. For looped courses then a class might have several different courses. Therefore a course does not have to have a startpoint or a finishControl. It can simply be a list of Control(s). The Control definition should not be confused with iofControlInfo. Control is locally defined in the iofCourse.dtd

#### Individual (straight course)
An individual event in which courses are straight can utilize the iofCourseList by creating/importing a courseList for each RaceClass in which the list contains only one course. All entries(competitors) for that class run the same course. Each competitor has no course assigned to them so they all run the course assigned to the RaceClass contained in the courseList (consisting of one course).
#### Individual (with looping course)
An individual event in which courses are made up of loops is sometimes known as a one person relay. This event can utilize the iofCourseList by creating/importing a courseList for each RaceClass with a course variant as a unique course (unique id and or name, if you have 3 factorial combinations, you have 6 courses). An iofEntry for example can be an individual competitor. The entry's competitor is assigned their own individual course (via courseId) from the list of courses given in the list of courses for their particular class (ie 1 of the 6 courses).
#### Team (pairs event)
A Team event can utilize the iofCourseList by creating/importing a courseList for each RaceClass in which the list contains only one course. All teams for that class run the same course. An iofEntry for example can be a team with more than one competitor. Each competitor has no course assigned to them so they all run the course assigned to the RaceClass contained in the courseList (of one course).
#### Relay (with splitting)
A Relay can utilize the iofCourseList by creating/importing a courseList for each RaceClass with a course variant as a unique course (unique id and or name, if you have 50 variations, you have 50 courses). An iofEntry for example can be a team with more than one competitor. Each competitor is assigned their own individual course (via courseId) from the list of courses given in the list of courses for their particular class.

### ISO Date/Time
All dates shall use the ISO standard as set out in the dtd files. (ISO-8859-1) Dates are of the form yyyy-mm-dd or yyyymmdd. The xml examples provided here have been changed to the format "2000-02-23" or "yyyy-mm-dd" (hopefully I found all of them) See http://www.bbsinc.com/iso8859.html for details and other interesting links.
### Organisations
Organisations can now recurse such that an organisation can be a member of another organisation.
### XML Schemes
There has been a request to translate/transform these dtd models into the more robust XML Scheme format. (ie define the xml standard in xml itself). While this is desirable, I do not have the time to do this. If someone out there is willing and has the time for this work, please contact me or just do it and send them to me at which time I will include them in this documentation and promise to maintain them.

Ted de St. Croix 

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
## COURSE LIST / COURSE 
```
iofCourseList.dtd/xml
    iofCourse.dtd/xml 
```
In order to keep file size to a minimum we have removed the control info from the course and replaced it with control codes, thereby requiring the event to first import a list of controlInfos (with matching controlCodes).

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