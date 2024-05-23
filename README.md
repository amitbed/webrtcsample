
# Symmetriun WebRTC app

An android application which uses WebRTC and Firestore as signaling server to support real time media communication.

---

## Pre-requisites
 :heavy_check_mark: Android studio installed in your system.<br/>
 :heavy_check_mark: Android Device or Emulator to run your app.<br/>

---

## Setup instructions

---

# Assignment
1. There's a bug in the code. Video stream from the camera should work, but due to a bug, the video stream is not working. Find the bug and fix it.
2. Create a new button named "touch" that will:
 1. Open a new white and empty screen
 2. Capture the user's touch on that screen (x and y coordinates only)
 3. Coordinates will be sent to the other peer using a data channel from webrtc protocol
 4. Only if the other peer will press on the "touch" button on his phone, that will open the white screen, a small red circle will be drawn on the screen every time it gets a new <x,y> coordinates. The drawn circle will be proportionally to the peer’s screen size.
 5. Of course, both peers will be able to touch their screens and see the touches of the other peer
 6. Make sure that the solution applies on a real device (not only on an emulator)
 7. Make sure you support different types touches (swipe/ scroll / multi-touch/ point)