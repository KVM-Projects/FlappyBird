# FlappyBird

## Introduction
Flappy Bird is a game application. The game was designed and built by Dong Nguyen, a developer who lives in Vietnam. Flappy bird is a side-scroller game where the player controls a bird, attempting to fly between columns of green pipes. The bird will be flying until it collisions with a pipe or it fall on ground. It’s a simple game of infinite level type.

## Scope
At the end of January 2014, it was the most downloaded free game in the App Store for iOS. During this period, its developer said that Flappy Bird was earning $50,000 a day from in-app advertisements as well as sales.

## Objectives
The goal of this game would be to control the bird, dodging and passing it through as many obstacles as possible. This will run endlessly until the bird hits the obstacle, ground or ceiling.

## Problem Statement
To create a fully functional application that runs a 2d game called flappy bird which should successfully manage the following objectives:
* Moving Wall
* Score Counting
* Objective selection
* Collision detection

## Details of Hardware & Software
### Software specifications
• Windows 64/32 bit.
• IDE: An IDE (Integrated Development Environment) contains a
code editor, a compiler or interpreter, and a debugger, accessed
through a single graphical user interchange (GUI). Our IDE is Processing.
### Hardware specifications(minimum)
• Pentium 3 processor.
• Processor speed of 300 MHZ and above.

## Implementation
a) Algorithm to display pictures correctly on monitor at first, how to
transfer images to correct coordinate and display on the monitor will be
our first challenge. We need an efficient way to convert our image into
coordinate in frame buffer.
b) Algorithm for image moving in our game, the image moving is the
most important function we need to implement. Besides the background
horizontal moving, the vertical jumping combining keyboard input is our
second challenge.
c) Game over condition setting in the process of the game, how to detect
if the object satisfies the game over condition and the condition setting is
our third problem.
d) Adding and fixing some function We will revise our project and
improving some details, for example: adding more interesting function
and more complicating contents in our game.
2D Animation:
Animation is a complex subject in game programming. Animation is
rapid display of sequence of images which creates an illusion of
movement. Java games are expected to run on multiple operating
systems with different hardware specifications.
Objective Selection:
We create a bird object which is flying until any collision occurred and
the bird is flying in the wall objectives which are begin from top and
bottom of the screen.
Moving Wall:
The wall moving on and it will come randomly in size and distances.
The bird is flying in the middle of the wall.
Collision Detection:
When the bird touches the anywhere of a wall it causes a collision.
Collision detection is one of important task of the game. If the bird
touches any wall (pipes) the game will end.
Score Counting
Score counting is the interesting for user. By the score the player knows
his/her performance. If the bird crosses a pipe without collision or not
fall in ground his/her score increment one.
