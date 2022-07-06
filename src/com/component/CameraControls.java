package com.component;

import java.awt.event.MouseEvent;

import com.khel.Camera;
import com.khel.Component;
import com.khel.ML;
import com.khel.Window;

public class CameraControls extends Component {
  
  private float prevMx, prevMy;

  public CameraControls() {
    prevMx = 0.0f;
    prevMy = 0.0f;
  }
  
  
  @Override
  public void update(double dt) {
    ML ml = Window.getWindow().mouseListener;
    if (ml.mousePressed && ml.mouseButton == MouseEvent.BUTTON1) {
      float dx = (ml.x + ml.dx - prevMx);
      float dy = (ml.y + ml.dy - prevMy);

      Camera sceneCamera = Window.getWindow().getCurrentScene().camera;
      sceneCamera.position.x -= dx;
      sceneCamera.position.y -= dy;
    }

    prevMx = ml.x + ml.dx;
    prevMy = ml.y + ml.dy;
  }
}
