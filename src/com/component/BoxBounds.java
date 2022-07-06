package com.component;

import com.khel.Component;

public class BoxBounds extends Component {

  public float width, height;

  public BoxBounds(float width, float height) {
    this.width = width;
    this.height = height;
  }
  
  @Override
  public void update(double dt) {
  }
}
