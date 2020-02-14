/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.commands.controlpanelmanipulator;

import com.frcteam1939.infiniterecharge2020.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TurnToColor extends Command {

  String desiredColor;

  public TurnToColor() {
    requires(Robot.controlPanelManipulator);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    //desiredColor = new ControlPanelManipulator.colorFromFMS(); // Input from FMS
    Robot.controlPanelManipulator.set(0.3);
  }

  @Override
  protected boolean isFinished() {
    return Robot.controlPanelManipulator.colorIsAligned(desiredColor);
  }

  @Override
  protected void end() {
    Robot.controlPanelManipulator.set(0);
  }

  @Override
  protected void interrupted() {
    Robot.controlPanelManipulator.set(0);
  }
}
