


//画像データのデータタイプ
PImage img;

int pxSize; //pixcel size

void setup(){
  size(1280, 720); //画像サイズと一緒にしている  
  img = loadImage("seaScape.jpeg"); //画像をロードする
  
  pxSize = 10; //10
  
  noLoop(); //静止画の際はnoLoopを基本的に入れる
}


void draw(){
  background(255);
  //image(img, 0, 0); //画像を描く, 座標の指定（画像の左上を指定）
  //image(img, 160, 90);
  //image(img, 640, 360);
  for(int j = 0; j < height; j += pxSize){
    for(int i = 0; i < width; i += pxSize){    

  //for(int j = 0; j < height; j++){
  //  for(int i = 0; i < width; i++){    
      int x = i * 1;
      int y = j * 1;
      
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
      
      color c = img.pixels[id]; //pixels[]  []の中は何番目か
      
      //写真の色で正方形を書く
      stroke(c);
      //fill(c);
      noFill();
      //rect(x, y, 1, 1);
      rect(x, y, pxSize, pxSize);
      //ellipse(x, y, pxSize, pxSize);
      //line(x, y, x + pxSize, y + pxSize);
      //line(x + pxSize, y , x, y + pxSize);

    }
  }
  
}
