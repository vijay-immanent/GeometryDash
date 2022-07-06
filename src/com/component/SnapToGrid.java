package com.component;

import java.awt.Graphics2D;
import java.awt.AlphaComposite;

import com.khel.Camera;
import com.khel.Component;
import com.khel.ML;
import com.khel.Window;

public class SnapToGrid extends Component {
  
  private float debounceTime = 0.2f;
  private float debounceLeft = 0.0f;

  int gridWidth, gridHeight;

  public SnapToGrid(int gridWidth, int gridHeight) {
    this.gridWidth = gridWidth;
    this.gridHeight = gridHeight;
  }

  @Override
  public void update(double dt) {
    if (this.gameObject.getComponent(Sprite.class) != null) {
      ML ml = Window.getWindow().mouseListener;
      Camera sceneCamera = Window.getWindow().getCurrentScene().camera;
      float x = (float) Math.floor((ml.x + ml.dx + sceneCamera.position.x) / gridWidth);
      float y = (float) Math.floor((ml.y + ml.dy + sceneCamera.position.y) / gridHeight);

      this.gameObject.transform.position.x = (x * gridWidth) - sceneCamera.position.x;
      this.gameObject.transform.position.y = (y * gridHeight) - sceneCamera.position.y;
    }
  }

  @Override
  public void draw(Graphics2D g2) {
    Sprite sprite = gameObject.getComponent(Sprite.class);
    if (sprite != null) {
      float alpha = 0.5f;
      AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
      g2.setComposite(ac);
      g2.drawImage(sprite.image, (int) gameObject.transform.position.x, (int) gameObject.transform.position.y, (int) sprite.width, (int) sprite.height, null);
      alpha = 1.0f;
      ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
      g2.setComposite(ac);
    }

  }
}
