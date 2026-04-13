Conference Management System Compilation Instructions:

Description 
------------
This is a conference management system written in Java. The system allows for 
a user to use a menu to manage speakers, attendees, organziers, rooms, schedules,
and registrations. 


What each class does 
--------------------
Main - runs program 
ConferenceSystemMenu - contains menu user can interact with 
Person - parent class for attendee and speaker
Speaker - represents a speaker 
Organizer - represents an organizer
SpeakerManager - handles adding, removing, and viewing speakers
OrganizerManager - handles orgazanizer related actions
Venue - represents the conference location
VenueManager - manages the venue
Room - represents the rooms inside a venue
RoomManager- handles room operations
Schedule - represents sceduled events
ScheduleManager - manages schedules
Registration- represents attendee registrations
RegistrationManager - handles registration logic 
Reservation- represents room reservations
ReservationManager- Handles reservations
TestData - Adds sample data to make testing easier 


How to Run program
--------------------
1) Compile all Java files with: javac *.java
2) Run the program java Main



Authors
--------
Maya Garcia Schafer and Jillian Stork 
