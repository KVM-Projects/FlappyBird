
Bird bird;
Obstacle[] obstacles = new Obstacle[2];
Score score;
PImage backgroundImage;
// Stanje igre
boolean gameStarted = false;
boolean gameOver = false;
void settings(){
  //size(500,500,P3D);
  fullScreen();
}
void setup() {
  orientation(LANDSCAPE);    
  bird = new Bird(width/2, 0);
  obstacles[0] = new Obstacle(width, random(100, height-100));
  obstacles[1] = new Obstacle(width*1.5+25, random(100, height-100));
  score = new Score();
  backgroundImage = loadImage("background.jpg");
  backgroundImage.resize(width,height);

}

void draw() {
  background(backgroundImage);

  if (gameOver) {
    drawGameOver();
  } else if (!gameStarted) {
    drawStartScreen();
  } else {
    bird.draw();
    for(Obstacle o : obstacles) { o.draw(); }
    score.draw();
    detectCollision();
  }
}


void mousePressed() {
  action();
}

void keyPressed() {
  action();
}

void action() {
  if (gameOver) {
    gameOver = false;
    bird.reset();
    for(Obstacle o : obstacles) { o.reset(); }
    score.reset();
  } else if (!gameStarted) {
    gameStarted = true;
  } else {
    bird.jump();
  }
}


void drawGameOver() {
  rectMode(CENTER);
  textSize(32);
  textAlign(CENTER, CENTER);
  fill(0);
  text("Game over!",
       width/2, height/2,
       width, 100);
}

void drawStartScreen() {
  rectMode(CENTER);
  textSize(32);
  textAlign(CENTER, CENTER);
  fill(0);
  text("Click to start",
       width/2, height/2,
       width, 100);
}


void detectCollision() {
  if (bird.y > height || bird.y < 0) {
    gameOver = true;
  }

  for(Obstacle obstacle : obstacles) {
    if (bird.x - bird.size/2.0 > obstacle.topX + obstacle.w) {
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
