/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.commands.indexer;

import com.frcteam1939.infiniterecharge2020.robot.Robot;
import com.frcteam1939.infiniterecharge2020.robot.commands.indexer.Index;

import edu.wpi.first.wpilibj.Timer;
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
   /* boolean clearIndexer = Robot.oi.right.getRawButton(2);
    if(clearIndexer){
      Robot.intake.extendIntake();
      Robot.indexer.set(-1);
      Timer.delay(.2);
      Robot.shooter.set(-1);
    }
    if(!clearIndexer){
      Robot.intake.retractIntake();
      Robot.indexer.set(0);
      Robot.shooter.set(0);
    }*/

    double verticalValue = -Robot.oi.xboxController.getRightStickY()/2;
    double horizontalValue = Robot.oi.xboxController.getRightStickX()/2;
    Robot.indexer.setVertical(verticalValue);
    Robot.indexer.setHorizontal(horizontalValue);

    Robot.oi.xboxController.leftButton.whenPressed(new Index());

    Robot.oi.xboxController.back.cancelWhenPressed(new Index());

    if (Robot.shooter.close){
      Robot.oi.xboxController.rightButton.whenHeld(new ShootClose());
    }
    else if (Robot.shooter.far){
      Robot.oi.xboxController.rightButton.whenHeld(new ShootFar3());
    }
    else if(Robot.shooter.mid){
      Robot.oi .xboxController.rightButton.whenHeld(new ShootMid());
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
