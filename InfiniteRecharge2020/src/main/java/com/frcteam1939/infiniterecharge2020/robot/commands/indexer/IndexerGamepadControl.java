/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.commands.indexer;

import com.frcteam1939.infiniterecharge2020.robot.Robot;
import com.frcteam1939.infiniterecharge2020.robot.commands.indexer.Index;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class IndexerGamepadControl extends CommandBase {

  public IndexerGamepadControl() {
    addRequirements(Robot.indexer);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    double verticalValue = -Robot.oi.gamepad.getRightY();
    double horizontalValue = Robot.oi.gamepad.getRightX();
    Robot.indexer.setVertical(verticalValue);
    Robot.indexer.setHorizontal(horizontalValue);

    Robot.oi.gamepad.a.whenPressed(new Index());
    SmartDashboard.putNumber("Top Distance Sensor", Robot.indexer.getDistanceTop());
    SmartDashboard.putNumber("Bottom Distance Sensor", Robot.indexer.getDistanceBottom());
    SmartDashboard.putNumber("Indexer Encoder", Robot.indexer.getPosition());
    SmartDashboard.putNumber("Number of Power Cells", Robot.indexer.getBalls());
    SmartDashboard.putBoolean("Banner Sensor", Robot.indexer.getBanner());

    SmartDashboard.putNumber("Intake Current", Robot.intake.getCurrent());
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
