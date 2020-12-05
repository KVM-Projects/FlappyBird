import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Birds extends PApplet {


class Bird {
  float x;
  float y;
  float size = 80;
  float vy = 0;
  float ay = 0.2f;
  PImage bird;

  Bird(float initialX, float initialY) {
    x = initialX;
    y = initialY;
    bird = loadImage("bird.png");
  }


  public void draw() {
    pushStyle();

    imageMode(CENTER);
    image(bird, x, y, size, size);

    popStyle();

    y += vy;
    vy += ay;
  }

  public void reset() {
    y = 0;
    vy = 0;
  }

  public void jump() {
    vy = -4;
  }
}

Bird bird;
Obstacle[] obstacles = new Obstacle[2];
Score score;
PImage backgroundImage;
// Stanje igre
boolean gameStarted = false;
boolean gameOver = false;
public void settings() {
  //size(500, 500, P3D);
  fullScreen();
}
public void setup() {
  //orientation(LANDSCAPE);    
  bird = new Bird(width/2, 0);
  obstacles[0] = new Obstacle(width, random(100, height-100));
  obstacles[1] = new Obstacle(width*1.5f+25, random(100, height-100));
  score = new Score();
  backgroundImage = loadImage("background.jpeg");
  backgroundImage.resize(width, height);
}

public void draw() {
  background(backgroundImage);

  if (gameOver) {
    drawGameOver();
  } else if (!gameStarted) {
    drawStartScreen();
  } else {
    bird.draw();
    for (Obstacle o : obstacles) { 
      o.draw();
    }
    score.draw();
    detectCollision();
  }
}



public void mousePressed() {
  action();
}

public void keyPressed() {
  action();
}

public void action() {
  if (gameOver) {
    gameOver = false;
    bird.reset();
    for (Obstacle o : obstacles) { 
      o.reset();
    }
    score.reset();
  } else if (!gameStarted) {
    gameStarted = true;
  } else {
    bird.jump();
  }
}


public void drawGameOver() {
  rectMode(CENTER);
  textSize(32);
  textAlign(CENTER, CENTER);
  fill(0);
  text("Game over!", 
    width/2, height/2, 
    width, 100);
}

public void drawStartScreen() {
  rectMode(CENTER);
  textSize(32);
  textAlign(CENTER, CENTER);
  fill(0);
  text("Click to start", 
    width/2, height/2, 
    width, 100);
}


public void detectCollision() {
  // Da li je ptica izašla iz ekrana?
  if (bird.y > height || bird.y < 0) {
    gameOver = true;
  }

  for (Obstacle obstacle : obstacles) {
    if (bird.x - bird.size/2.0f > obstacle.topX + obstacle.w) {
      score.increase();
    }

    if (obstacle.topX + obstacle.w < 0) {
      obstacle.reposition();
      score.allowScoreIncrease();
    }

    if (obstacle.detectCollision(bird)) {
      gameOver = true;
    }
  }
}
class Obstacle {
  float initX;
  float topX;
  float topY;
  float w = 50;

  Obstacle(float initialTopX, float initialTopY) {
    initX = initialTopX;
    topX = initialTopX;
    topY = initialTopY;
  }

  public void draw() {
    pushStyle();

    rectMode(CORNERS);
    fill(0xff49D37A);
    rect(topX, topY, topX+w, height-1);
    rect(topX, 0, topX+w, topY - 200);

    popStyle();

    topX -= 3;
  }

  public void reset() {
    topX = initX;
    topY = random(100, height-200);
  }

  public void reposition() {
    topX = width;
    topY = random(100, height-200);
  }

  public boolean detectCollision(Bird b) {
    boolean result = false;

    if (rectsCollide(b.x, b.y, b.size, b.size, topX, topY, topX+w, height-1) ||
        rectsCollide(b.x, b.y, b.size, b.size, topX, 0, topX+w, topY - 200)) {
      result = true;
    }

    return result;
  }

  public boolean rectsCollide(float firstX, float firstY, float firstWidth, float firstHeight,
                       float secondULX, float secondULY, float secondBRX, float secondBRY) {
    float hh = firstHeight/2;
    float hw = firstWidth/2;
    return isInside(firstX - hw, firstY - hh, secondULX, secondULY, secondBRX, secondBRY) ||
           isInside(firstX + hw, firstY - hh, secondULX, secondULY, secondBRX, secondBRY) ||
           isInside(firstX + hw, firstY + hh, secondULX, secondULY, secondBRX, secondBRY) ||
           isInside(firstX - hw, firstY + hh, secondULX, secondULY, secondBRX, secondBRY);
  }

  public boolean isInside(float x, float y, float ulX, float ulY, float brX, float brY) {
    return (x >= ulX && x <= brX && y >= ulY && y <= brY);
  }

}
class Score {
  private int score = 0;
  private boolean scoreIncreased = false;

  public void increase() {
    if (!scoreIncreased) {
      score += 1;
      scoreIncreased = true;
    }
  }

  public void reset() {
    score = 0;
    scoreIncreased = false;
  }

  public void allowScoreIncrease() {
    scoreIncreased = false;
  }

  public void draw() {
    pushStyle();

    rectMode(CORNER);
    textAlign(LEFT);
    fill(255);
    textSize(25);
    text("Score: " + score, 10, 10, width, 40);

    popStyle();
  }
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "Birds" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
