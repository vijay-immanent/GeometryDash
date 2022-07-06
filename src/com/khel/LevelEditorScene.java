package com.khel;

import java.awt.Color;
import java.awt.Graphics2D;

import com.component.CameraControls;
import com.component.Grid;
import com.component.Ground;
import com.component.Player;
import com.component.SnapToGrid;
import com.component.Sprite;
import com.component.Spritesheet;
import com.dataStructures.Transform;
import com.util.Constants;
import com.util.Vector2;

public class LevelEditorScene extends Scene {

  public GameObject player;
  GameObject ground;
  GameObject mouseCursor;
  Grid grid;
  CameraControls cameraControls;

  public LevelEditorScene(String name) {
    super(name);
  }

  @Override
  public void init() {
    grid = new Grid();
    cameraControls = new CameraControls();
    ground = new GameObject("Ground", new Transform(new Vector2(0, Constants.GROUND_Y)));
    ground.addComponent(new Ground());
    addGameObject(ground);

    Spritesheet objects = new Spritesheet("assets/groundSprites.png", 42, 42, 2, 6, 2);
    Sprite mouseSprite = objects.sprites.get(0);
    mouseCursor = new GameObject("Mouse Cursor", new Transform(new Vector2()));
    mouseCursor.addComponent(new SnapToGrid(Constants.TILE_WIDTH, Constants.TILE_HEIGHT));
    mouseCursor.addComponent(mouseSprite);

    player = new GameObject("Test Game Ojbect", new Transform(new Vector2(500.0f, 350.0f)));

    int tileWidth, tileHeight, spacing, columns, rows;
    tileWidth = tileHeight = 42;
    spacing = 2;
    columns = 13;
    rows = 5;

    Spritesheet layerOne = new Spritesheet("assets/player/layerOne.png", tileWidth, tileHeight, spacing, columns, rows);
    Spritesheet layerTwo = new Spritesheet("assets/player/layerTwo.png", tileWidth, tileHeight, spacing, columns, rows);
    Spritesheet layerThree = new Spritesheet("assets/player/layerThree.png", tileWidth, tileHeight, spacing, columns,
        rows);

    Player playerComp = new Player(layerOne.sprites.get(0), layerTwo.sprites.get(0), layerThree.sprites.get(0),
        Color.RED, Color.GREEN);

    player.addComponent(playerComp);
    addGameObject(player);
  }

  @Override
  public void draw(Graphics2D g2) {
    g2.setColor(new Color(1.0f, 1.0f, 1.0f));
    g2.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);

    renderer.render(g2);

    grid.draw(g2);
    mouseCursor.draw(g2);
  }

  @Override
  public void update(double dt) {
    if (camera.position.y > Constants.CAMERA_OFFSET_GROUND_Y) {
      camera.position.y = Constants.CAMERA_OFFSET_GROUND_Y;
    }

    for (GameObject g : gameObjects) {
      g.update(dt);
    }

    cameraControls.update(dt);
    grid.update(dt);
    mouseCursor.update(dt);
  }

}
