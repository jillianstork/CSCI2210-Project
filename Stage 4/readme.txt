Instructions for Running the Conference Management System

Description
-----------------------------------------------------------------------
This is a conference management system written in Java. The system 
allows for a user to use a menu to manage speakers,
attendees, organizers, rooms, schedules, and registrations.

Class Descriptions
-----------------------------------------------------------------------
Attendee - represents a conference attendee
AttendeeManager - manages information about attendee
AttendeePanel - GUI for attendee
BasePanel- helps support other panel classes
Conference - represents conference entity 
ConferenceManager - manages conference
DataPersistence - stores data locally
Main - runs the program
Menu - is the menu for the program
Organizer - represents a conference organizer
Organizer Manager - manages information about organizer
OrganizerPanel - GUI for organizer
Person - superclass for organizer, speaker, and attendee classes
PersonFormHelper - helps format person information for GUI
Registration - represents a conference registration
RegistrationManager - manages registration information
ReservationPanel -  GUI for registrations
Room - represents a conference room
RoomManager - manages room information
RoomPanel - GUI for rooms
Schedule - represents a conference schedule
ScheduleManager - manages schedule information
SchedulePanel - GUI for schedules
Speaker - represents a conference speaker
Speaker Manager - manages speaker information
SpeakerPanel - GUI for speakers
TestData - creates dummy data to support persistence data
Venue - represents a conference venue
VenueManager - manages venue information
VenuePanel - GUI for venues
 
How to Run program
-----------------------------------------------------------------------
1) Before attempting to run the program, you need to make sure you have 
    Java 25 or higher installed
2) You can check whether you have Java downloaded and what version it
    is by running the following in the command prompt:
      java -version
3) First method to run program:
    a. Find the following JAR file: stage4project.jar
    b. Download or copy the JAR file to your computer
    c. Open the folder containing the file
    d. Double-click the JAR file
4) If double-clicking does not work, try this:
    a. Open command prompt in the folder containing the JAR file.
    b. In the command prompt, run the following input:
          java -jar stage4project.jar
 
Authors
--------
Maya Garcia Schafer and Jillian Stork
