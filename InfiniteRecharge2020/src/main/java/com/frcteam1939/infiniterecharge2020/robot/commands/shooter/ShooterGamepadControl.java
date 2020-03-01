/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.commands.shooter;

import com.frcteam1939.infiniterecharge2020.robot.Robot;
import com.frcteam1939.infiniterecharge2020.robot.commands.indexer.ShootClose;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ShooterGamepadControl extends CommandBase {
  
  public ShooterGamepadControl() {
    addRequirements(Robot.shooter);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
  
   /*Robot.oi.xboxController.y.whenPressed(new InitiationLineShooterSetup());
   Robot.oi.xboxController.a.whenPressed(new LongShooterSetup());
   Robot.oi.xboxController.b.whenPressed(new FrontTrenchShooterSetup());
   */


    /*if(Robot.oi.xboxController.y.get()){
      Robot.shooter.hoodUp();
    }
    if(Robot.oi.xboxController.b.get()){
      Robot.shooter.hoodMiddleHigh();//mid low
    }
    if(Robot.oi.xboxController.a.get()){//mid high
      Robot.shooter.hoodMiddleLow();
    }
    if(Robot.oi.xboxController.x.get()){
      Robot.shooter.hoodDown();
    }
    */
    // LONG - 36 FEET
  /*if (Robot.oi.gamepad.rightButton.get()){
    if (speedShooter < 21000){
      Robot.shooter.set(1);
    } 
    else if(speedShooter > 21000 && speedShooter < 22000){
      Robot.shooter.set(0.97);
    }
    else {
      Robot.shooter.set(0.85);
    } 
  }
 else {
    Robot.shooter.set(0);
 }*/

// SHORT - 10 FEET
/*
if (Robot.oi.gamepad.rightButton.get()){
    if (speedShooter < 9000){
      Robot.shooter.set(1);
    } 
    else if (speedShooter > 9000 && speedShooter < 11000){
      Robot.shooter.set(0.5);
    }
    else {
      Robot.shooter.set(0.4);
    } 
  }
 else {
    Robot.shooter.set(0);
 }

 /// MEDIUM - 20 FEET
 */

 /*if (Robot.oi.xboxController.getLeftTriggerButton()){
   Robot.shooter.set(0.5);
 }

 if (Robot.oi.xboxController.rightButton.get()){
  if (speedShooter < 13500){
    Robot.shooter.set(1);
  } 
  else if (speedShooter > 13500 && speedShooter < 15500){
    Robot.shooter.set(0.67);
  }
  else {
    Robot.shooter.set(0.5);
  }
}
else{
  Robot.shooter.set(0);
}*/

  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}