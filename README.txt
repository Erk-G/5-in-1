Calculator.java-
is basically just me trying out swings, and it'll turn into part of my future plan to create one of those crappy x in 1 programs.
Like those shady mall emulators that are a million games in one, but mine will probably be 5 in 1.
Basically this is an excuse to get practice in with swing, but not actually create a stable or good program.
If a bug bothers me too much I'll fix it. For example pressing = first crashes and pushing it twice after any other input crashes and I fixed it.
There won't be mcuh rhyme or reason to me fixing bugs though.

A couple of improvements I could make:
1. Improve GUI, add colors give the output something to differentiate it from the backround. Move the buttons closer together because it is a little too far apart.
2. Not use int and use floats. I only used int because I didn't know a way to parse float existed.
3. Removing redundent code. I'm pretty sure "exp" could just be axed. The default button printing "Hello world" is pointless and I could just have the default
be one of the other buttons. One thing I really want to fix is it bothers me how many class files there are for just inputting numbers, and I feel like
there is a way to streamline it. My ideal would be the default button does the numbers and it basically checks the name of the button and uses that, since
all the number's actions are identical except for "0".

Some obvious bugs:
1. Solving an equation with equals and pushing an operation breaks the program. Ex. 2+2=+2= is supposed to work out to 6 but it breaks on the second "+"
2. Pushing an operation first breaks it, much like pushing "=" used too.
3. Pushing "0" multiple times if the original number is 0 makes zero bigger, which doesn't break anything but looks dumb.
4. I did not at all include what to do in case of  mathmatical exceptions. Ex. dividing by zero

The first two I'm pretty sure the problem is immediatly adding "x" to the equation arraylist without checking if it is a number, probably.
The command window says index out of range, so it's probably something else.
For the "0" problem, I could add a check to the button and if the first number is "0" than don't add 0.
The last would just be adding exceptions as I remember them.


MainMenu.java-
Something to connect my 5-in-1. I wanted to make it more seamless by repainting the JFrame, but I'm satisfied with how it works currently.
Another thing I was considering while trying to make it seamless is to just have the other programs be extensions of this code, but that is minor.


MineSweep.java-
My second out of five swing "games", unfinished for now. Definitely coming back after I learn to place images properly.

Minor issue-
It tells you how many mines are around even if you picked one with a mine on it.
Easy to fix just check for the mine first.

Things to add-
A winning state
Actual visuals. A number appearing instead of a pop up window. Showing where all the bombs are when you lose.
Difficulties, where chossing a higher one makes a bigger square so instead of a 4x4 its a 11x11 for medium or something.
Being able to mark mines.

