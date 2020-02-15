/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.commands.controlpanelmanipulator;

import com.frcteam1939.infiniterecharge2020.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TurnToColor extends CommandBase {

  String desiredColor;

  public TurnToColor() {
    // addRequirements(Robot.controlPanelManipulator);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    //desiredColor = new ControlPanelManipulator.colorFromFMS(); // Input from FMS
    Robot.controlPanelManipulator.set(0.3);
  }

  @Override
  public void end(boolean interrupted) {
    Robot.controlPanelManipulator.stop();
  }

  @Override
  public boolean isFinished() {
    return false; //(Robot.controlPanelManipulator.colorIsAligned(desiredColor));
  }
}
