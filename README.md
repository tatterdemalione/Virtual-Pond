# Virtual-Pond

  Virtual pond is an android application intended to encourage young kids with autism spectrum disorder develop their skating skills through the use of themed visual content and interactive gameplay. The application is still in "pilot" mode and as such not all of the features have been developed as of yet.
  
  The ideology underlying the app is the notion that children with autism spectrum disorder are not easily enticed to learn certain skills, but can become extremely motivated if the learning process is presented as a game, preferably one where they get to interact and which contains themes which they are interested in. These themes are often child-specific, as certain children get extremely invested in a certain area of interest. The themes we chose in the pilot version are specific interests of 3 of the children we worked along with to develop the app. The themes in question are space, dinosaurs, and minions.  
  
  The way the game works is as follows: The child, or "player" as we will refer to them henceforth, makes an account with a 4-digit PIN and username associated with their real name and picks a theme from the 3 presets. Then, they go through a sequence of 6 levels (current amount) in which they learn a specific skating skill. The levels have scenarios which are themed accordingly which encourage the players to exercise their creativity. The "levels" are instructional videos which show the player how to perform the skill associated with the level. Following the video, the player has the choice to quit, rematch or notify the coach that they watched the video. The coach, who has his own separate interface which allows him to view a list of the players and his notifications, gets the notification that a level has been completed, and sets up the ice to allow the player to attempt the skill they have learned in real life. The coach then either confirms or denies whether the player has learned the skill. If he confirms then the player gets points, which allow them to play more levels and update their themed avatar. 
  
  This is the main functionality which works in the pilot version, although the kinks are still being worked out, mainly the level progression, coach interface and points systems.  The other functionality, which you will see on the menu but won't work properly and may very well crash the app, is the "game creation" part. The player goes to the menu and can has 2 options: (1) watch one of the default "games", which are preset courses which have had videos taken of them that the player can then go complete on the ice, or (2) piece together the skills which they have completed to form their own "course". They watch concatenated skill videos in the order they picked, and the coach custom-makes a "game" for them. There is also an aspect where the players can notify others that they made a level and encourage them to try it to encourage social interaction and friendship building, but this has not even begun to be integrated.  The player is also capable of viewing their level progress, avatar, information and points on a profile page.  
  
  Remember when using this app that it is a very rudimentary "pilot" of an app which will be further developed in the future. There is a lot of debugging, testing and integration of systems which need to be done and as such the only things that work in any capacity are the account creation, login, skill videos and profile view. These may not work in some instances either.  Enjoy the app and happy skating!

## Installation
- Using a command line create a folder called Virtual-Pond
- Assuming you have installed [git](https://git-scm.com/downloads) run the command:
git clone https://github.com/tatterdemalione/Virtual-Pond.git
- Open Android SDK and choose import gradle project.  From here you can see all the source code.  In order to run the application you either need to use one of the emulators built in to the Android SDK or using the Android Debug Bridge and connect to an android phone via USB.  

# User Manual

1. Registration: To make a new user or coach, start by opening the app and tap on register. You will be prompted to create a user or coach. The distinction is very important, selecting coach will create an account for you where you are able to approve user attempts to pass skill levels and perform other administrative tasks. The player option prompts you to select a username to login with, a real name to identify yourself as, and a numerical PIN to secure access to the account. Players pick a theme, one of "space", "minions" or "dinosaurs". This cannot be changed afterwards. 

2. Login: Pick coach or player login. You will be prompted for your username and pin and taken to either the user or the player menu if you entered the correct information. A little information for the technically inclined: Login works by using POST to send the data to the .php files on the cse.stfx.ca web server. These php files access the database locally and run queries on the database. If a username/PIN match then you will login with that username!

3. Logout: There is no logout button, just close the app and you will be logged out automatically. 

## Player Menu Options:

3. Level: There are 6 levels are provided for the players, which consist of stride, stop, recover, turn, crossover, and backward. Players will not be allowed to pass to the next level until finish the previous one (if the app had full functionality - in the pilot this should be manually managed). And the levels are ordered from easy to hard. The player is coached on the skill with a themed storyline and then watches the video. After watching the video, you can replay the video, return to the level screen or notify the coach of skill completion. Notifying the coach is the cue for the coach to make the corresponding course on the ice and check if the player knows the skill.

4. Profile: The user views their profile, which contains their information, avatar and the points they have accumulated. Points don't work properly, so they won't have any in this version of the app.

5. Game: The user should be able to make their own course or view presets and then "play their games". This functionality does not work in this version.

## Coach Menu Options:

6. View Players: This should allow you to view a list of all the players, view their information and give them points. It does not work in this version.

7. View Notifications: This should allow you to view a list of all the level completion notifications and game creation notifications and ratify them. It does not work in this version.




