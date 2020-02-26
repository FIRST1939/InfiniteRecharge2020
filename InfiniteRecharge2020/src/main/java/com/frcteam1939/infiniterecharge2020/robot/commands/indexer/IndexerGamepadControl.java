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
    double verticalValue = -Robot.oi.xboxController.getRightStickY()/2;
    double horizontalValue = Robot.oi.xboxController.getRightStickX()/2;
    Robot.indexer.setVertical(verticalValue);
    Robot.indexer.setHorizontal(horizontalValue);

    Robot.oi.xboxController.leftButton.whenPressed(new Index());

    if (Robot.shooter.close){
      Robot.oi.xboxController.rightButton.whenHeld(new ShootClose());
    }
    else if (Robot.shooter.far){
      Robot.oi.xboxController.rightButton.whenHeld(new ShootFar());
    }
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
