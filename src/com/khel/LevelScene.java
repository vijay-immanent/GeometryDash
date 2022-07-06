package com.khel;

import java.awt.Color;
import java.awt.Graphics2D;

import com.component.BoxBounds;
import com.component.Ground;
import com.component.Player;
import com.component.RigidBody;
import com.component.Spritesheet;
import com.dataStructures.Transform;
import com.util.Constants;
import com.util.Vector2;

public class LevelScene extends Scene {
  static LevelScene currentScene = null;

  public GameObject player;

  public LevelScene(String name) {
    super(name);
  }

  @Override
  public void draw(Graphics2D g2) {
    g2.setColor(new Color(1.0f, 1.0f, 1.0f));
    g2.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);

    renderer.render(g2);
  }

  @Override
  public void init() {
    GameObject ground;
    ground = new GameObject("Ground", new Transform(new Vector2(0, Constants.GROUND_Y)));
    ground.addComponent(new Ground());
    addGameObject(ground);

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
    player.addComponent(new RigidBody(new Vector2(395, 0)));
    player.addComponent(new BoxBounds(Constants.PLAYER_WIDTH, Constants.PLAYER_HEIGHT));
    addGameObject(player);
  }

  @Override
  public void update(double dt) {
    if (player.transform.position.x - camera.position.x > Constants.CAMERA_OFFSET_X) {
      camera.position.x = player.transform.position.x - Constants.CAMERA_OFFSET_X;
    }
    if (player.transform.position.y - camera.position.y > Constants.CAMERA_OFFSET_Y) {
      camera.position.y = player.transform.position.y - Constants.CAMERA_OFFSET_Y;
    }
    if (camera.position.y > Constants.CAMERA_OFFSET_GROUND_Y) {
      camera.position.y = Constants.CAMERA_OFFSET_GROUND_Y;
    }

    for (GameObject g : gameObjects) {
      g.update(dt);
    }
  }

}
