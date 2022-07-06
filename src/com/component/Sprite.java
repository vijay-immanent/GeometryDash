package com.component;

import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.io.File;

import javax.imageio.ImageIO;

import com.dataStructures.AssetPool;
import com.khel.Component;

public class Sprite extends Component {

  public BufferedImage image;
  public String pictureFile;
  public int width, height;

  public Sprite(String pictureFile) {
    this.pictureFile = pictureFile;

    try {
      File file = new File(pictureFile);
      if (AssetPool.hasSprite(file.getAbsolutePath())) {
        throw new Exception("Asset pool already contains the asset: " + pictureFile);
      }
      this.image = ImageIO.read(file);
      System.out.println(image);
      this.height = image.getHeight();
      this.width = image.getWidth();
    } catch (Exception e) {
      e.printStackTrace();
      System.exit(-1);
    }
  }

  public Sprite(BufferedImage image) {
    this.image = image;
    this.width = image.getWidth();
    this.height = image.getHeight();
  }

  @Override
  public void draw(Graphics2D g2) {
    g2.drawImage(image, (int) gameObject.transform.position.x, (int) gameObject.transform.position.x, width, height,
        null);
  }
}
