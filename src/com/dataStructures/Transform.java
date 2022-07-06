package com.dataStructures;

import com.util.Vector2;

public class Transform {
  public Vector2 position;
  public Vector2 scale;
  public float rotation;

  public Transform(Vector2 position) {
    this.position = position;
    this.scale = new Vector2();
    this.rotation = 0.0f;
  }

  public Transform(Transform transform) {
    this.position = transform.position;
    this.rotation = transform.rotation;
    this.scale = transform.scale;

  }

  @Override
  public String toString() {
    return "Position " + this.position;
  }
}
