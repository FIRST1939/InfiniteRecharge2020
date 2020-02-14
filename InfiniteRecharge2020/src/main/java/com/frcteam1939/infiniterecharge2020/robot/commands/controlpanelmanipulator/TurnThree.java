/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.commands.controlpanelmanipulator;

import com.frcteam1939.infiniterecharge2020.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TurnThree extends Command {
  
  public TurnThree() {
    requires(Robot.controlpanelmanipulator);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    Robot.controlpanelmanipulator.set(.5);
  }

  @Override
  protected boolean isFinished() {
    return (Robot.controlpanelmanipulator.getRotations() == 3.5);
  }

  @Override
  protected void end() {
    Robot.controlpanelmanipulator.set(0);
  }

  @Override
  protected void interrupted() {
  }
}
