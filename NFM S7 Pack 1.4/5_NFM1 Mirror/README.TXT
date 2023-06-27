Thank you for downloading my version of Need For Madness! (made by Omar Waly)
The aim of this version is to update and maintain the game so that it remains
playable despite being written on old java.

RESETTING PROGRESS
If you have completed the game (or even if you haven't) and you would like to
start from scratch again, just delete the cookies folder (it will automatically recreate itself).

CHANGING KEY BINDINGS
You can change the key bindings by creating a file with the name KeySettings.txt
Inside it, you write 1 binding per 1 line, in the form

ACTION(CODE)

CODE is the ascii code of the letter/number/symbol for most buttons.
For buttons such as enter or tab, visit https://docs.oracle.com/javase/7/docs/api/java/awt/Event.html
or try to figure out the codes from the default key settings file provided below

ACTION is the name of the action that is performed when the given button is pressed.
Multiple buttons can be binded to the same action.
Also, multiple actions can share the same button (can be used to create macros).

KeySettings.txt
up(1004)
down(1005)
right(1007)
left(1006)
handb(32)
enter(10)
enter(80)
enter(112)
enter(27)
arrace(65)
arrace(97)
mutem(77)
mutem(109)
mutes(78)
mutes(110)
view(86)
view(118)