// n - meeting rooms
// diff capacity

flow:

1) user who wants to book meeting rooms
user calls -- Meeting schedular and gives (Start time, end time, capacityNeeded)
2) search for meetingRoom - display available ones 
        2.1) Get call -- return list of available meeting rooms
        check all available rooms for start and end time and capacity
        2.2) Book the room 
        2.3) mark unavilability of meeting room
3) send notification - to all invited people
    send notification()
    



User
    Profile

MeetingRoom
    MeetingCalendar

MeetingSchdular
    takes (start time, end Time, capcity)
    show available meeting rooms -- from MeetingRoom entity




