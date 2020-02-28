/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.commands.lights;

import com.frcteam1939.infiniterecharge2020.robot.Robot;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class LightsUpdater extends CommandBase {
  /**
   * Creates a new lightsUpdater.
   */
  public LightsUpdater() {
    addRequirements(Robot.lights);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(Robot.shooter.isReady() && Robot.limelightTurret.getHorizontalAngleError()>1){
      Robot.lights.runningLights();
    }
    else if(Robot.indexer.isIndexing){
      Robot.lights.yellow();
    }
    else if(Robot.indexer.isDoneIndexing){
      Robot.lights.green();
    }
    else if(Robot.climber.isClimbing){
      Robot.lights.theaterCase();
    }
    else if(Robot.getAllianceColor()){
      Robot.lights.fireRed();
    }
    else if(!Robot.getAllianceColor()){
      Robot.lights.fireBlue();
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
