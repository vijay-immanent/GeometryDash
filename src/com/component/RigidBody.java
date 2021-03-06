package com.component;

import com.khel.Component;
import com.util.Constants;
import com.util.Vector2;

public class RigidBody extends Component {
  
  public Vector2 velocity;

  public RigidBody(Vector2 vel) {
    this.velocity = vel;
  }

  @Override
  public void update(double dt) {
    gameObject.transform.position.y += velocity.y * dt;
    gameObject.transform.position.x += velocity.x * dt;
  
    velocity.y += Constants.GRAVITY * dt;

    if (Math.abs(velocity.y) > Constants.TERMINAL_VELOCITY) {
      velocity.y = Math.signum(velocity.y) * Constants.TERMINAL_VELOCITY;
    }
  }
}
