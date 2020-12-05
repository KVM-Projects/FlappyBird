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

## Implementation
### Algorithm
* Algorithm to display pictures correctly on monitor at first, how to transfer images to correct coordinate and display on the monitor will be our first challenge. We need an efficient way to convert our image into coordinate in frame buffer.
* Algorithm for image moving in our game, the image moving is the most important function we need to implement. Besides the background horizontal moving, the vertical jumping combining keyboard input is our second challenge.
* Game over condition setting in the process of the game, how to detect if the object satisfies the game over condition and the condition setting is our third problem.
* Adding and fixing some function We will revise our project and improving some details, for example: adding more interesting function and more complicating contents in our game.
### 2D Animation:
Animation is a complex subject in game programming. Animation is rapid display of sequence of images which creates an illusion of movement. Java games are expected to run on multiple operating systems with different hardware specifications.
### Objective Selection:
We create a bird object which is flying until any collision occurred and the bird is flying in the wall objectives which are begin from top and bottom of the screen.
### Moving Wall:
The wall moving on and it will come randomly in size and distances. The bird is flying in the middle of the wall.
### Collision Detection:
When the bird touches the anywhere of a wall it causes a collision. Collision detection is one of important task of the game. If the bird touches any wall (pipes) the game will end.
### Score Counting:
Score counting is the interesting for user. By the score the player knows his/her performance. If the bird crosses a pipe without collision or not fall in ground his/her score increment one.

## Details of Hardware & Software
### Software specifications
* Windows 64/32 bit.
* [PROCESSING](https://processing.org/): IDE (Integrated Development Environment) contains a code editor, a compiler or interpreter, and a debugger, accessed through a single graphical user interchange (GUI).
* You can download it [here](https://download.processing.org/processing-3.5.4-windows64.zip).

### Hardware specifications(minimum)
* Pentium 3 processor.
* Processor speed of 300 MHZ and above.

## Screenshots
### background:
![](https://github.com/KVM-Projects/FlappyBird/blob/main/data/background.jpeg)
### bird:
![](https://github.com/KVM-Projects/FlappyBird/blob/main/data/bird.png)
### preview:
![](https://github.com/KVM-Projects/FlappyBird/blob/main/data/video.gif)

## Conclusion
We choose the project to gain proper knowledge to make desktop application. It increased our knowledge for Object Oriented Language (JAVA) and getting experience in GUI through embedded JAVA. After the completion of this project we came to know how to work with Processing. With the completion of this project we have achieved a sense of happiness and we want to thank all those who helped us directly or indirectly to make this idea come true.

## Future Work
* Splash Screen.
* Bird skins and Background Textures will change according to Levels and User choice.
* The status and the history will be saved and will be dynamically shown in a graph where user can see his total performance.

## References
* https://en.wikipedia.org/wiki/Flappy_Bird
* https://processing.org/
* https://flappybird.io/

# License
## MIT License

Copyright (c) 2020 KVM

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
