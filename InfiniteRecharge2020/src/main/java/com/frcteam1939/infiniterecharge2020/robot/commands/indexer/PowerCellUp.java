/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.commands.indexer;

import com.frcteam1939.infiniterecharge2020.robot.Robot;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class PowerCellUp extends CommandBase {
  double currentPos;

  public PowerCellUp() {
    addRequirements(Robot.indexer);
  }

  @Override
  public void initialize() {
   currentPos = Robot.indexer.getPosition();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.indexer.setVertical(Robot.indexer.INDEXER_VERTICAL_SPEED);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.indexer.stop();
    //Robot.indexer.addOneBall();

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() { //< >
    return (((Robot.indexer.getDistanceTop() < Robot.indexer.DIST_ONE_BALL + 60) && (Robot.indexer.getDistanceTop() > Robot.indexer.DIST_ONE_BALL - 60)) || Robot.indexer.getPosition()>currentPos+1.35);
  }
}
