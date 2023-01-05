
//画像データのデータタイプ
PImage img;

void setup(){
  size(1280, 720); //画像サイズと一緒にしている  
  img = loadImage("seaScape.jpeg"); //画像をロードする
  
  noLoop(); //静止画の際はnoLoopを基本的に入れる
}


void draw(){
  image(img, 0, 0); //画像を描く, 座標の指定（画像の左上を指定）
  
  image(img, 160, 90);

  
  image(img, 640, 360);
}
