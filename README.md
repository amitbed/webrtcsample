
# Symmetriun WebRTC app

An android application which uses WebRTC and Firestore as signaling server to support real time media communication.

---

## Pre-requisites
 1. Android studio installed in your system.<br/>
 2. Android Device or Emulator to run your app.<br/>

---

## Setup instructions

1. Run the app on 2 android phones
2. On the 1st app enter a meeting ID as you wish, and click on "start call"
3. On the 2nd app enter the same meeting ID, and click on "join call"
4. Meeting ID will only be valid a single time

---

# Assignment
1. There's a bug in the code. Video stream from the camera should work, but due to a bug, the video stream is not working. Find the bug and fix it.
2. replace the switchCameraButton in the activity_main with a new button named "touchPaneButton" that will: 
   - Open a new white and empty fragment
   - Capture the user's touch on that screen (x and y coordinates only)
   - Coordinates will be sent to the other peer using a data channel from webrtc protocol 
   - Only if the other peer will press on the "touchPaneButton" button on his phone, that will open the white fragment, a small red circle will be drawn on the screen every time it gets a new <x,y> coordinates. The drawn circle will be proportionally to the peer’s screen size. 
   - Of course, both peers will be able to touch their screens and see the touches of the other peer 
   - Make sure that the solution applies on a real device (not only on an emulator)
   - Make sure you support different types touches (swipe/ scroll / multi-touch/ point)