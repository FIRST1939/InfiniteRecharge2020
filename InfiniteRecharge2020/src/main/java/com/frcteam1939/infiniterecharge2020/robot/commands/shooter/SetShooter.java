/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.commands.shooter;

import com.frcteam1939.infiniterecharge2020.robot.Robot;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class SetShooter extends CommandBase {

  double rpm;

  public SetShooter(double rpm) {
    this.rpm = rpm;
    addRequirements(Robot.shooter);
  }

  @Override
  public void initialize() {
    Robot.shooter.setRPM(rpm);
  }

  @Override
  public void execute() {
    
  }

  @Override
  public void end(boolean interrupted) {
    Robot.shooter.stop();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
