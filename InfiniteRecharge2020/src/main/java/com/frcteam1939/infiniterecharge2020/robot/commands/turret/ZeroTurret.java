/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.commands.turret;

import com.frcteam1939.infiniterecharge2020.robot.Robot;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ZeroTurret extends CommandBase {
  /**
   * Creates a new ZeroTurret.
   */
  boolean done;
  public ZeroTurret() {
    addRequirements(Robot.turret);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(!Robot.turret.isAtClockwiseLimit()&& !Robot.turret.isAtClimberPosition() && !Robot.turret.isAtCounterClockwiseLimit()){
      Robot.turret.setInitial(.5);
      done = false;
    }
  
    if(Robot.turret.isAtClockwiseLimit()){
      if(!Robot.turret.isAtClimberPosition()){
          Robot.turret.setInitial(-.5);
      }
        else{
          done = true;
          Robot.turret.zeroEncoder();
        }
    }

    if(Robot.turret.isAtCounterClockwiseLimit()){
      if(!Robot.turret.isAtClimberPosition()){
        Robot.turret.setInitial(.5);
      }
      else{
       done = true;
        Robot.turret.zeroEncoder();
      }
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.turret.set(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return done;
  }
}
