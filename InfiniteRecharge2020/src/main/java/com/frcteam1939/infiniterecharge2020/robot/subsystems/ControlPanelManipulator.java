/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.subsystems;
import com.frcteam1939.infiniterecharge2020.robot.RobotMap;
import com.frcteam1939.infiniterecharge2020.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.util.Color;



public class ControlPanelManipulator extends Subsystem {

  private VictorSPX victor = new VictorSPX(RobotMap.controlPanelManipulator);
  private DutyCycleEncoder encoder = new DutyCycleEncoder(RobotMap.controlPanelEncoder);

  private final I2C.Port i2cPort = I2C.Port.kOnboard;
  private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);

  private final ColorMatch m_colorMatcher = new ColorMatch();

  private final Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
  private final Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
  private final Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
  private final Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);

  double spinP = 0;
  double spinI = 0;
  double spinD = 0;
  
  String gameData;

  PIDController spinPID = new PIDController(spinP, spinI, spinD);

  public ControlPanelManipulator(){
    //spinPID.enableContinuousInput(minimumInput, maximumInput);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new ControlPanelManipulatorGamepadControl());
  }

  public void set(double value){
    victor.set(ControlMode.PercentOutput, value);
  }

  public double getRotations(){
    return encoder.get();
  }

  public double getDistance(){
    return encoder.getDistance();
  }

  public double getOffset(){
    return encoder.getPositionOffset();
  }
  
  public void enableBrakeMode(){
    controlPanelRedline.setNeutralMode(NeutralMode.Brake);
  }

  public void disableBrakeMode(){
    controlPanelRedline.setNeutralMode(NeutralMode.Coast);
  }

  public String getColor(){

    m_colorMatcher.addColorMatch(kBlueTarget);
    m_colorMatcher.addColorMatch(kGreenTarget);
    m_colorMatcher.addColorMatch(kRedTarget);
    m_colorMatcher.addColorMatch(kYellowTarget);    
    
    Color detectedColor = m_colorSensor.getColor();

    String colorString;

    ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);

    if (match.color == kBlueTarget) {
      colorString = "Blue";
    } else if (match.color == kRedTarget) {
      colorString = "Red";
    } else if (match.color == kGreenTarget) {
      colorString = "Green";
    } else if (match.color == kYellowTarget) {
      colorString = "Yellow";
    } else {
      colorString = "Unknown";
    }

    return colorString;
  }

  public boolean colorIsAligned(String color){
    if (Robot.controlPanelManipulator.getColor() == color){
      return true;
    }
    else{
      return false;
    }
  }

  public String colorFromFMS(){
    gameData = DriverStation.getInstance().getGameSpecificMessage();
    if(gameData.length() > 0){
      switch (gameData.charAt(0)){
        case 'B' :
          return "Red";
        case 'G' :
          return "Yellow";
        case 'R' :
          return "Blue";
        case 'Y' :
          return "Green";
        default :
          return "Corrupt";
    }
  }   else {
      return "Unknown";
    }
  }
}
