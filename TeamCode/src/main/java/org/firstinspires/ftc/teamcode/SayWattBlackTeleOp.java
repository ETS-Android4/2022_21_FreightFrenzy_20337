package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "SayWattOrangeBot")
public class SayWattBlackTeleOp extends LinearOpMode {
    private DcMotor frontRight;
    private DcMotor frontLeft;
    private DcMotor backRight;
    private DcMotor backLeft;
    private DcMotor duckWheelLeft;
    private DcMotor duckWheelRight;

    @Override
    public void runOpMode() {
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        duckWheelLeft = hardwareMap.get(DcMotor.class, "duckWheelRight");
        duckWheelRight = hardwareMap.get(DcMotor.class, "duckWheelRight");

        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        frontLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();
        while (opModeIsActive()) {
            double SpeedOfRobotUpDown = 0.8;
            double SpeedOfRobotLeftRight = 0.8;
            double SpeedOfRobotArm = 1;
            if (gamepad1.right_bumper) {
                telemetry.addLine("Drive: Fast Speed");
                SpeedOfRobotLeftRight = 100;
                SpeedOfRobotUpDown = 100;
            } else {
                telemetry.addLine("Drive: Default Speed");
                SpeedOfRobotLeftRight = 0.8;
                SpeedOfRobotUpDown = 0.8;
            }
            telemetry.update();

            if (gamepad1.a) {
                duckWheelRight.setPower(0.9);
                duckWheelLeft.setPower(0.9);
            } else if (gamepad1.a && gamepad1.x)  {
                duckWheelRight.setPower(-0.9);
                duckWheelLeft.setPower(-0.9);
            } else {
                duckWheelRight.setPower(0);
                duckWheelLeft.setPower(0);
            }

            if (gamepad1.x && gamepad1.dpad_up) {
                frontLeft.setPower(0.6);
                frontRight.setPower(0.6);
                backLeft.setPower(0.6);
                backRight.setPower(0.6);
            } else {
                if (gamepad1.dpad_up) {
                    frontLeft.setPower(SpeedOfRobotUpDown);
                    frontRight.setPower(SpeedOfRobotUpDown);
                    backLeft.setPower(SpeedOfRobotUpDown);
                    backRight.setPower(SpeedOfRobotUpDown);
                } else if (gamepad1.x && gamepad1.dpad_down) {
                    frontLeft.setPower(-0.6);
                    frontRight.setPower(-0.6);
                    backLeft.setPower(-0.6);
                    backRight.setPower(-0.6);
                } else {
                    if (gamepad1.dpad_down) {
                        frontLeft.setPower(-SpeedOfRobotUpDown);
                        frontRight.setPower(-SpeedOfRobotUpDown);
                        backLeft.setPower(-SpeedOfRobotUpDown);
                        backRight.setPower(-SpeedOfRobotUpDown);
                    } else {
                        if (gamepad1.x && gamepad1.dpad_left) {
                            frontRight.setPower(0.8);
                            frontLeft.setPower(-0.8);
                            backRight.setPower(-0.8);
                            backLeft.setPower(0.8);
                        } else if (gamepad1.x && gamepad1.dpad_right) {
                            frontRight.setPower(-0.8);
                            frontLeft.setPower(0.8);
                            backRight.setPower(0.8);
                            backLeft.setPower(-0.8);
                        } else {
                            if (gamepad1.dpad_left) {
                                frontRight.setPower(-SpeedOfRobotLeftRight);
                                frontLeft.setPower(SpeedOfRobotLeftRight);
                                backRight.setPower(-SpeedOfRobotLeftRight);
                                backLeft.setPower(SpeedOfRobotLeftRight);
                            } else if (gamepad1.dpad_right) {
                                frontRight.setPower(SpeedOfRobotLeftRight);
                                frontLeft.setPower(-SpeedOfRobotLeftRight);
                                backRight.setPower(SpeedOfRobotLeftRight);
                                backLeft.setPower(-SpeedOfRobotLeftRight);
                            } else {
                                frontLeft.setPower(0);
                                frontRight.setPower(0);
                                backLeft.setPower(0);
                                backRight.setPower(0);
                            }
                        }
                    }
                }
            }
            telemetry.update();
        }
    }
}