//package org.firstinspires.ftc.teamcode;
//import com.qualcomm.robotcore.eventloop.opmode.OpMode;
//import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.DcMotorEx;
//import com.qualcomm.robotcore.hardware.Servo;
//import com.qualcomm.robotcore.util.Range;
//
//
//@TeleOp(name="Robot: TeleOp Tank", group="Robot")
//public class RobotTeleOpTankJR extends OpMode{
//
//    public DcMotorEx arm = null;
//    public DcMotor leftDrive = null;
//    public DcMotor rightDrive = null;
//    public Servo leftServo = null;
//    public Servo rightServo = null;
//    double clawOffset = 0;
//
//    public static final double MID_SERVO   =  0.5 ;
//    public static final double CLAW_SPEED  = 0.02 ;        // sets rate to move servo
//    public static final double ARM_UP_POWER    =  0.50 ;   // Run arm motor up at 50% power
//    public static final double ARM_DOWN_POWER  = -0.25 ;   // Run arm motor down at -25% power
//
//    @Override
//    public void init() {
//        leftDrive  = hardwareMap.get(DcMotor.class, "left_drive");
//        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");
//        arm    = hardwareMap.get(DcMotorEx.class, "arm");
//
//
//        leftDrive.setDirection(DcMotor.Direction.REVERSE);
//        rightDrive.setDirection(DcMotor.Direction.FORWARD);
//
//        leftServo  = hardwareMap.get(Servo.class, "leftServo");
//        rightServo = hardwareMap.get(Servo.class, "rightServo");
//        leftServo.setPosition(MID_SERVO);
//        rightServo.setPosition(MID_SERVO);
//
//        telemetry.addData(">", "Robot Ready.  Press Play.");
//    }
//
//
//    @Override
//    public void init_loop() {
//    }
//
//
//    @Override
//    public void start() {
//    }
//
//    @Override
//    public void loop() {
//        double left;
//        double right;
//
//
//        left = -gamepad1.left_stick_y;
//        right = -gamepad1.right_stick_y;
//
//        leftDrive.setPower(left);
//        rightDrive.setPower(right);
//
//        if (gamepad1.right_bumper)
//            clawOffset += CLAW_SPEED;
//        else if (gamepad1.left_bumper)
//            clawOffset -= CLAW_SPEED;
//
//        clawOffset = Range.clip(clawOffset, -0.5, 0.5);
//        leftServo.setPosition(MID_SERVO + clawOffset);
//        rightServo.setPosition(MID_SERVO - clawOffset);
//
//        if (gamepad1.y)
//            arm.setPower(ARM_UP_POWER);
//        else if (gamepad1.a)
//            arm.setPower(ARM_DOWN_POWER);
//        else
//            arm.setPower(0.0);
//
//        telemetry.addData("claw",  "Offset = %.2f", clawOffset);
//        telemetry.addData("left",  "%.2f", left);
//        telemetry.addData("right", "%.2f", right);
//    }
//
//
//    @Override
//    public void stop() {
//    }
//}
