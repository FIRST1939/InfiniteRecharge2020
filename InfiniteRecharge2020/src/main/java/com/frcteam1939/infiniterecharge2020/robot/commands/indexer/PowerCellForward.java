/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.commands.indexer;

import com.frcteam1939.infiniterecharge2020.robot.Robot;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class PowerCellForward extends CommandBase {

  private final double DIST_ONE_BALL = .1;

  private boolean end = false;
  private double currentDistance;

  public PowerCellForward() {
    addRequirements(Robot.indexer);
  }

  @Override
  public void initialize() {
    currentDistance = Robot.indexer.getDistanceHorizontal();
  }

  @Override
  public void execute() {
    if(Robot.indexer.getDistanceHorizontal()< currentDistance + DIST_ONE_BALL){
      Robot.indexer.set(1);
    }
    else{
      Robot.indexer.stop();
      end = true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return end;
  }
}
