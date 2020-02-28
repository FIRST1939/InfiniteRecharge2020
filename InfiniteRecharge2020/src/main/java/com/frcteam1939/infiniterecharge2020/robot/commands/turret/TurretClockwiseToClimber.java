/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.commands.turret;

import com.frcteam1939.infiniterecharge2020.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TurretClockwiseToClimber extends CommandBase {
  /**
   * Creates a new TurretClockwiseToClimber.
   */
  public TurretClockwiseToClimber() {
    addRequirements(Robot.turret);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.turret.set(0.3);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.turret.set(.1);
    Timer.delay(.5);
    Robot.turret.set(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Robot.turret.isAtClimberPosition();
  }
}