/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.commands.auto;

import com.frcteam1939.infiniterecharge2020.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TurnRightTime extends CommandBase {
  /**
   * Creates a new TurnRightTime.
   */
  double time = 0;
  double initialTime;
  public TurnRightTime(double wait) {
    time = wait;
   addRequirements(Robot.drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    initialTime = Timer.getFPGATimestamp();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.drivetrain.setPercentOutput(.5, -5);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.drivetrain.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (Timer.getFPGATimestamp()>initialTime+time);
  }
}
