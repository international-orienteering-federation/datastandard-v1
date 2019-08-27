# IOF Data Standard, version 0 and 1

As work in progress the standard was numbered 1.0 to 1.5. But to mark these as unfinished an extra 0 has been added. So now they are numbered 0.1.0 to 0.1.5. The official standard (proposal version 1.6) is numbered 1.0.
This new numbering has not been enforced in the text below, only in the headlines.

## Version 1.0
Proposal version 1.6 Sept 13, 2000 replaces previous versions 1.0, 1.1, 1.2, 1.3, 1.4, 1.5 (April-July, 2000).
Adopted as IOF Data Standard, version 1.0, December 2000.

This version addresses several important issues, most notably revised iofCourseList, revised iofRaceClass and a simplified iofCourse. Input from Hans Steinegger have been very helpful in coming to grips with the relay model and more efficient iofCourse model together with helpful comments from Finn Arildsen. James Baker provided input on ISO date formats.

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

All dates shall use the ISO standard as set out in the dtd files. (ISO-8859-1) Dates are of the form yyyy-mm-dd or yyyymmdd. The xml examples provided here have been changed to the format "2000-02-23" or "yyyy-mm-dd" (hopefully I found all of them).

### Organisations

Organisations can now recurse such that an organisation can be a member of another organisation.

### XML Schemes

There has been a request to translate/transform these dtd models into the more robust XML Scheme format. (ie define the xml standard in xml itself). While this is desirable, I do not have the time to do this. If someone out there is willing and has the time for this work, please contact me or just do it and send them to me at which time I will include them in this documentation and promise to maintain them.

Ted de St. Croix (email: tcr@ebyran.com)

## Version 0.1.5
Proposal version 1.5, July 22, 2000
This proposal replaces previous versions 1.0, 1.1, 1.2, 1.3 (April-May, 2000)

## Version 0.1.4
This version contains some changes from 1.2 requested from Finn Arildsen and changes we made after working with the dtd and xml files in applications.
iofControlInfo.dtd -> removed order attribute.  The sequence of controls is given by their position in the file.

iofEntry.dtd -> Moved clubId and clubName to attribute status of the the Entry itself.  clubShortName has been added as an ATTRIBUTE as well although it is also not required.  Made the class better suited to handle both individual and team entries.  A competitor element handles zero or more competitors. A Person in the entry could be used as a team leader while each competitor contains a Person (which in turn contains an Identity).

iofBaseClass.dtd -> NotQualifiedSubstituteClass, SubstituteClass have been given classId as an attribute instead of containing ClassId as an element.

## Version 0.1.3
This version contains some changes from 1.2 requested from Finn Arildsen and Kell Soennichsen.
iofIdentity.dtd -> ELEMENT Identity : 
This change was introduced in version 1.2 and is now made more general so as to not lock us down to INT,NAT,LOCAL etc.  I've added Identity to Persons and Clubs.

iofCompetitor.dtd -> ELEMENT Competitor -> ATTLIST StartNumber :
Changed to IMPLIED from REQUIRED as not all runners have a startNumber necessarily.

iofAddress.dtd -> ELEMENT Address -> ATTLIST Country :
No longer REQUIRED iofRaceClass.dtd -> ELEMENT RaceClass -> ATTLIST administrationLineCode :
Changed to AdministrationCode for more general use.

iofControlInfo.dtd -> ELEMENT Box -> ATTLIST hasDiagonal :
Changed to Y/N with N as the default.

iofControlInfo.dtd -> ELEMENT Box -> ATTLIST column :
Changed to an enumeration as per the IOF columns A-F in a control description. eg. column (A|B|C|D|E|F|G|H) #REQUIRED

Kell wrote...
> "There is still one problem left regarding multiday events: the start number and class of the competitor is situated in the Competitor element. That means that the competitor should use the same start number all days and run in the same class. A possible solution is to move the start number and class information from the Competitor to the Startlist and Resultlist respectively:
```
<!ELEMENT Competitor (Person)>
<!ATTLIST Competitor
  Status CDATA #IMPLIED
  CourseID CDATA #IMPLIED
  ModifyDate CDATA #IMPLIED
>

<!ELEMENT Result (Competitor,((CCard,SplitTimes,Times)+ | Day+))>
<!ATTLIST Result
  EntClass CDATA #REQUIRED
  StartNumber CDATA #REQUIRED
  ModifyDate CDATA #IMPLIED
>

<!ELEMENT StartList (Starter)*>
<!ELEMENT Starter (Competitor,((CCard?,Times) | Day+))>
<!ATTLIST StartList
  EntClass CDATA #REQUIRED
  StartNumber CDATA #REQUIRED
  ModifyDate CDATA #IMPLIED
>
```
> Possibly the StartNumber attribute is not needed in the Result entity."

I would like to keep the start number and class with the competitor so will return with a solution that solves Kell's concerns above at a later time.

Ted de St. Croix

## Version 0.1.2
This version has implemented suggestions for improvement from Peter Löfås, Finn Arildsen, Olav Nedrelid, Pekka Pirilä received May 5, 2000.
To iofEntry we have made it possible to enter a Person Element in case a Person list is not accompanying the export.  There has been some discussion surrounding the id of a person and this should alleviate the problem somewhat.

An iofEntries.dtd has been added.  Se examples below for an xml sample.  Entries have been removed from iofEvent due to a conflict with transaction.

Question: What is the purpose for both an ID and a name for a course?
Answer:   The ID can be used for internal identity of the course in the database.  This becomes important when exchanging data on a "diskette" network whereas the name is the name given to the course by the user. See courses below.

Added to iofCourse :
.  Estimate of number of competitors before entries are finished.  This is useful for estimating control load.

Changed in iofControlInfo.  :
Changed the structure completely in order accomodate 2 codes for a single box.  It also supports a diagonal option. A Finish control has a description of the finish run in.  For electronic punching systems, the finish control is used for the control on the finish line, when used for timing so therefore I have left in a ControlInfo element. The PunchPattern has been left as a string for the moment.

To BaseClass , I have added:
```
         allowedMinAge CDATA #IMPLIED 
         allowedMaxAge CDATA #IMPLIED 
```
These are for use when runners run outside their normal class.
Added a new dtd: 
iofIdentity.dtd : for use if several id codes are needed (for example storing owner ids in an eCard).  This has affected some of the xml examples and hopefully I have updated all of them.

Courses : 
I have added a CourseID to iofCompetitor so that competitors in the same class can run different courses (eg. looping or relays).

## Version 0.1.1
This version has implemented suggestions for improvement from Kell Soennichsen and Finn Arildsen received April 5 and 10, 2000.    The most change has occured in controlInfo and course.  Otherwise the changes were corrections, relaxing the REQUIRED restriction or adding some important detail. 
* Results and start lists have been improved to include support for showing multi day information in the same XML file. 
* Split times has been improved to specify split time order and control code.  This will help identify problems with electronic punching systems that have their timers out of sync (it has happened that a time between controls was negative if the split times were compared). 
* ModifyDate has become IMPLIED for all modules.  Occasionally a module includes another module both of which have ModifyDates.  With this version, one only needs to include the top most ModifyDate if deemed necessary.

## Clarifications
iofCompetitor.dtd -> ELEMENT Competitor -> ATTLIST EntClass
Question: What is EntClass when Person (included in Competitor) also has a Class.
Answer:  The Class for a Person is based on their age and the local rules for that person.  My Class when in Sweden is H40 while in Great Britain it is M40? When I compete in Sweden I may occasionally run H40Lång or even H21 for short distance races.  EntClass is the class I entered when I became a competitor for the event. The Person table may be a national database table which is centrally based while the competitor table is temporary to the event itself.  

iofCompetitor.dtd -> ELEMENT Competitor -> ATTLIST StartNumber :
Question: Is it necessary to make this REQUIRED if there is a REQUIRED ID in Person?
Answer:  The Person's ID is not always the Bib number.  The Person database file is different from the Competitor database file.  The StartNumber in this proposal is the same for all races in an event (as in a multi day event).  This is not always the case and a more flexible proposal is required.

Question: Relays?
Answer:  I have not included any special requirements for Relays as yet.  Some day...

iofRaceClass.dtd -> ELEMENT RaceClass -> ATTLIST finishchute
Question: Is this the chute they enter at the finish? Answer: Yes.

iofRaceClass.dtd -> ELEMENT RaceClass -> ATTLIST administrationLineCode
Question:.  What is this?
Answer: This is to help the administration of the event.  One code might be used to represent the line of activity that checks normal control cards from the timing section, to the calculation section to the code verification section.  Another code might represent abnormal route, such as finishers who have abandoned the course, or need to talk with race administrators re: problems on course.

## General Comments
Please look closely at ControlInfo and Course as this has changed drastically.  I think I had partly confused elements between the two when I first drafted the proposal. Does anyone have a good suggestion for storing a paper punch pattern efficiently?  Finn uses a 9X9 matrix of Boolean flags which as a binary string of length 81 looks like: 
```
1111111111000000011000000011000000011000000011000000011000000011000000011111111111
```
 representation of a square box.  I left it as a CDATA so it is up to the users I suppose.