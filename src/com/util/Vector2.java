package com.util;

public class Vector2 {
  public float x, y;
  
  public Vector2(float x, float y) {
    this.x = x;
    this.y = y;
  }

  public Vector2() {
    this.x = 1.0f;
    this.y = 1.0f;
  }

  @Override
  public String toString() {
    return "(" + this.x + ", " + this.y + ")";
  }
}
