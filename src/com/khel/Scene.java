package com.khel;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import com.util.Vector2;

public abstract class Scene {
  String name;
  public Camera camera;
  List<GameObject> gameObjects;
  Renderer renderer;

  public Scene(String name) {
    this.name = name;
    this.camera = new Camera(new Vector2());
    this.gameObjects = new ArrayList<>();
    this.renderer = new Renderer(this.camera); 
  }

  public void init() {
    
  };

  public void addGameObject(GameObject gameObject) {
    gameObjects.add(gameObject);
    renderer.submit(gameObject);
  }

  public abstract void update(double dt);

  public abstract void draw(Graphics2D g2);
}
