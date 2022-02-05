package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;


public class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(1200);


        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 10.5)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-36, -66.75, Math.toRadians(180)))
                                .lineTo(new Vector2d(-61.5, -66.75))
                                .addTemporalMarker(1.4, () ->{
                                    //run carousel for duck
                                    //sleep(1000);
                                })
//                                //TODO: add stop
//                                .addTemporalMarker(2, () ->{
//                                    //run carousel for duck off
//                                })
                                .lineToSplineHeading(new Pose2d(-24, -36, Math.toRadians(45)))
                                //TODO: add stop
                                .addTemporalMarker(3.44/*plus whatever the time for stop is*/, () ->{
                                    //lift pre loaded block into goal
                                })

                                .lineToSplineHeading(new Pose2d(12, -66.75, Math.toRadians(0)))
                                .lineTo(new Vector2d(43.5, -66.75))
                                .addTemporalMarker(6.78/*plus whatever the time for stop is*/, () ->{
                                    //intake block
                                })
                                .lineTo(new Vector2d(12, -66.75))
//                                .lineToSplineHeading(new Pose2d(0, -36, Math.toRadians(135)))
                                .addTemporalMarker(8.23/*plus whatever the time for stop is*/, () ->{
                                    //lift block into high goal
                                })
////                                .lineToSplineHeading(new Pose2d(12, -66.75, Math.toRadians(0)))
                                .lineTo(new Vector2d(43.5, -66.75))
                                .addTemporalMarker(9.68/*plus whatever the time for stop is*/, () ->{
                                    //intake block
                                })
                                .lineTo(new Vector2d(12, -66.75))
////                                .lineToSplineHeading(new Pose2d(0, -36, Math.toRadians(135)))
                                .addTemporalMarker(11.13/*plus whatever the time for stop is*/, () ->{
                                    //lift block into high goal
                                })
////                                .lineToSplineHeading(new Pose2d(12, -66.75, Math.toRadians(0)))

                                .lineTo(new Vector2d(40, -66.75))
                                .lineTo(new Vector2d(40, -38))
                                .build()
                );

        meepMeep.setBackground(MeepMeep.Background.FIELD_FREIGHTFRENZY_OFFICIAL)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}