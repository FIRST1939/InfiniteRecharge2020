/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.commands.indexer;

import com.frcteam1939.infiniterecharge2020.robot.Robot;
import com.frcteam1939.infiniterecharge2020.util.DoNothing;

import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class Index extends SequentialCommandGroup {

  public Index() {
    if (Robot.indexer.getBalls() == 0){
      addCommands(new PowerCellForward());
      addCommands(new SetIndexer(0));
      addCommands(new PowerCellUp());
      Robot.indexer.addOneBall();
    }

    else if (Robot.indexer.getBalls() == 1){
      addCommands(new PowerCellForward());
      addCommands(new SetIndexer(0));
      addCommands(new SecondPowerCellUp());
      Robot.indexer.addOneBall();
    }

    else if (Robot.indexer.getBalls() == 2){
      addCommands(new PowerCellForward());
      addCommands(new SetIndexer(0));
      addCommands(new ThirdPowerCellUp());
      Robot.indexer.addOneBall();
    }

    else if (Robot.indexer.getBalls() == 3){
      addCommands(new RunIndexerUntilBanner());
      Robot.indexer.addOneBall();
    }
  }
}
