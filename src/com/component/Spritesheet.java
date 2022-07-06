package com.component;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import com.dataStructures.AssetPool;

public class Spritesheet {
  
  public List<Sprite> sprites;
  public int tileHeight;
  public int tileWidth;
  public int spacing;
  
  public Spritesheet(String pictureFile, int tileWidth, int tileHeight, int spacing, int columns, int rows) {
    this.tileWidth = tileWidth;
    this.tileHeight = tileHeight;
    this.spacing = spacing;

    Sprite parent = AssetPool.getSprite(pictureFile);
    sprites = new ArrayList<>();
    int row = 0;
    int count = 0;
    int size = rows * columns;
    while (count < size) {
      for (int column = 0; column < columns; column++) {
        int imgX = (column * tileWidth) + (column * spacing);
        int imgY = (row * tileWidth) + (row * spacing);
        
        BufferedImage subImage = parent.image.getSubimage(imgX, imgY, tileWidth, tileHeight);
        sprites.add(new Sprite(subImage));

        count++;
        if (count > size - 1) {
          break;
        }
      }
      row++;
    }
  }
}