package com.component;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import com.khel.Component;
import com.util.Constants;

public class Player extends Component {

  Sprite layerOne, layerTwo, layerThree;
  public int width, height;

  public Player(Sprite layerOne, Sprite layerTwo, Sprite layerThree, Color colorOne, Color colorTwo) {
    this.layerOne = layerOne;
    this.layerTwo = layerTwo;
    this.layerThree = layerThree;

    this.width = Constants.PLAYER_WIDTH;
    this.height = Constants.PLAYER_HEIGHT;

    int threshold = 200;
    for (int y = 0; y < layerOne.image.getWidth(); y++) {
      for (int x = 0; x < layerOne.image.getHeight(); x++) {
        Color color = new Color(layerOne.image.getRGB(x, y));
        if (color.getRed() > threshold && color.getGreen() > threshold && color.getBlue() > threshold) {
          layerOne.image.setRGB(x, y, colorOne.getRGB());
        }
      }
    }
    for (int y = 0; y < layerTwo.image.getWidth(); y++) {
      for (int x = 0; x < layerTwo.image.getHeight(); x++) {
        Color color = new Color(layerTwo.image.getRGB(x, y));
        if (color.getRed() > threshold && color.getGreen() > threshold && color.getBlue() > threshold) {
          layerTwo.image.setRGB(x, y, colorTwo.getRGB());
        }
      }
    }
  }

  @Override
  public void update(double dt) {
    gameObject.transform.position.x += dt * 10f;
  }

  @Override
  public void draw(Graphics2D g2) {
    AffineTransform transform = new AffineTransform();
    transform.setToIdentity();
    transform.translate(gameObject.transform.position.x, gameObject.transform.position.y);
    transform.rotate(gameObject.transform.rotation, width * gameObject.getScale().x / 2.0f,
        height * gameObject.getScale().y / 2.0f);
    transform.scale(gameObject.transform.scale.x, gameObject.transform.scale.y);
    g2.drawImage(layerOne.image, transform, null);
    g2.drawImage(layerTwo.image, transform, null);
    g2.drawImage(layerThree.image, transform, null);
  }
}
