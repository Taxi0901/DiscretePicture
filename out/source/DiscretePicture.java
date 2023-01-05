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

public class DiscretePicture extends PApplet {




//画像データのデータタイプ
PImage img;

int pxSize; //pixcel size

public void setup(){
   //画像サイズと一緒にしている  
  img = loadImage("seaScape.jpeg"); //画像をロードする
  
  pxSize = 10; //10
  
  rectMode(CENTER); //default:CORNER
  
  //noLoop(); //静止画の際はnoLoopを基本的に入れる
}


public void draw(){
  
  background(255);
  
  /*
  image(img, 0, 0); //画像を描く, 座標の指定（画像の左上を指定）
  
  //local座標系
  //local origin原点
  //translate(200, 300);    //原点の平行移動
  
  //rotate 原点を中心にして回転（今はローカルの原点を中心にしている）  
  //rotate(PI / 4);
  
  //image(img, 0, 0);

  
  //scaling 拡大縮小
  //scale(0.1);
  //scale(0.5, 0.0ß5);
  
  image(img, 0, 0);
  
  */
  
  //image(img, 160, 90);
  
  //image(img, 640, 360);
  
  for(int j = 0; j < height; j += pxSize){
  
      for(int i = 0; i < width; i += pxSize){    
  
      float rectSize = pxSize;
        
      //square
      //noFill();
      //stroke(10);
      //strokeWeight(0.1);
      //fill(255, 0, 0);
      //int randomRed = round(random(255));
      //fill(randomRed, 0, 0);
      //noStroke();
      //rect(x, y , 1, 1);
      
      //ピクセルID
      int id = i + j * width; //行数分降りていく
      
      int c = img.pixels[id]; //pixels[]  []の中は何番目か

      pushMatrix();    //push pop  //pushMatrix:translate前の座標の原点を覚える

      //原点の移動
      translate(i + 0.5f * rectSize , j + 0.5f * rectSize);
      
      //回転
      //float rotAngle = PI * 0.1;
      float rotAngle = map(red(c), 0, 255, 0, 0.8f*TWO_PI);
      
      rotate(rotAngle);
      
      //Scaling
      //float scaleFactorX = 0.3;
      //float scaleFactorY = 1.2;
      float scaleFactorX = map(green(c), 0, 255, 0.8f, 3);
      float scaleFactorY = map(green(c), 0, 255, 2, 17);
      
      scale(scaleFactorX, scaleFactorY);
      
      //rectSizeを変化させる
      
      //波の周期
      float minPeriod = 8000;
      float maxPeriod = 80000;
      
      float omega = map(blue(c), 0 ,255, TWO_PI/minPeriod, TWO_PI/maxPeriod);
      
      rectSize = pxSize * sin(omega * millis()); //millis():実行してからの時間(ms)  ω：角速度　A:Amplitude振幅
      
      
      //写真の色で正方形を書く
      //noStroke();
      
      //fill(c);
      //fill(c, 150);
      
      stroke(10, 160);
      strokeWeight(0.7f);
      
      noFill();
      
      //rect(x, y, 1, 1);
      rect(0, 0, rectSize, rectSize);
      
      //ellipse(x, y, pxSize, pxSize);
      //line(x, y, x + pxSize, y + pxSize);
      //line(x + pxSize, y , x, y + pxSize);
      
      //pushMatrixで覚えた原点を呼び戻す
      popMatrix();
      
    }
  }

  saveFrame("frames/20230105/####.png");

   if (frameCount >= 50) { // 50コマアニメーションした時
    exit();
  }
  
}
  public void settings() {  size(1280, 720); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "DiscretePicture" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
