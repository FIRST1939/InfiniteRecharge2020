/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.commands.indexer;

import com.frcteam1939.infiniterecharge2020.robot.Robot;
import com.frcteam1939.infiniterecharge2020.util.DistanceConstants;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class PowerCellShoot extends CommandBase {

  private final double FIRE_SPEED = 1;
  
  public PowerCellShoot() {
    addRequirements(Robot.indexer);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.indexer.set(FIRE_SPEED);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Robot.indexer.getDistanceVertical() >= DistanceConstants.DEFUALT_VERT_DISTANCE;
  }
}
