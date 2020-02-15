/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.commands.shooter;

import com.frcteam1939.infiniterecharge2020.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
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
    double speedShooter = Robot.shooter.getSpeed();
    double temperatureShooter = Robot.shooter.getTemperature();
 
    if(Robot.oi.gamepad.a.get()){
      //Robot.shooter.set(1);
      Robot.shooter.hoodDown();;
    }
    if(Robot.oi.gamepad.b.get()){
     //Robot.shooter.set(.98);
     Robot.shooter.hoodMiddleHigh();;
   }
   if(Robot.oi.gamepad.y.get()){
     //Robot.shooter.set(.95);
     Robot.shooter.hoodUp();
   }
   if(Robot.oi.gamepad.x.get()){
     //Robot.shooter.set(.90);
     Robot.shooter.hoodMiddleLow();
   }

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

/* SHORT - 10 FEET
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
 }*/ 

 /*MEDIUM - 20 FEET
 if (Robot.oi.gamepad.rightButton.get()){
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
else {
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