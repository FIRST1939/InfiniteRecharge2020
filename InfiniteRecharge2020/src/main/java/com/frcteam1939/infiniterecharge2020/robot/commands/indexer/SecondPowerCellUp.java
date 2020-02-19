/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.commands.indexer;

import com.frcteam1939.infiniterecharge2020.robot.Robot;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class SecondPowerCellUp extends CommandBase {

  public SecondPowerCellUp() {
    addRequirements(Robot.indexer);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    Robot.indexer.setVertical(Robot.indexer.INDEXER_VERTICAL_SPEED);
  }

  @Override
  public void end(boolean interrupted) {
    Robot.indexer.stop();
  }

  @Override
  public boolean isFinished() {
    return ((Robot.indexer.getDistanceBottom() != Robot.indexer.DIST_ONE_BALL) && (Robot.indexer.getDistanceTop() == Robot.indexer.DIST_ONE_BALL));
  }
}
