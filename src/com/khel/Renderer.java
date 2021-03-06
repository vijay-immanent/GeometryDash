package com.khel;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import com.dataStructures.Transform;
import com.util.Vector2;

public class Renderer {
  List<GameObject> gameObjects;
  Camera camera;

  public Renderer(Camera camera) {
    this.camera = camera;
    this.gameObjects = new ArrayList<>();
  }

  public void submit(GameObject gameObject) {
    this.gameObjects.add(gameObject);
  }

  public void render(Graphics2D g2) {
    for (GameObject g: gameObjects) {
      Transform oldTransform = new Transform(g.transform);
      g.transform.position = new Vector2(g.transform.position.x - camera.position.x, g.transform.position.y - camera.position.y);
      g.draw(g2);

      g.transform = oldTransform;
    }
  }
}
